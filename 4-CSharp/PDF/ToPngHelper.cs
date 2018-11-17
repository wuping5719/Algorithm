using System;
using System.Collections;
using System.Linq;
using System.IO;
using System.Drawing;
using System.Threading;
using System.Windows.Forms;
using System.Web;
using System.Reflection;
using log4net;
using OUC.KYC.BLL.Report;
using OUC.KYC.Model.Report;

namespace CMBChina.KYC.Web.Util
{
    // 网页生成Png图片工具类
    // AddBy WuPing 2018-11-06
    public class ToPngHelper
    {
        private static readonly ILog Log = LogManager.GetLogger(MethodBase.GetCurrentMethod().DeclaringType);

        // 生成PNG图片并上传到对象桶，同时更新报告实例表附件信息
        public static void RptToPNG(string parReportID)
        {
            try
            {
                // 生成PNG并上传到对象桶
                string resFileUrl = GeneratePNG(parReportID);

                // 更新报告实例表附件信息
                RptInstance rptInstance = new RptInstance();
                rptInstance.ReportID = parReportID;
                rptInstance.Attachment = resFileUrl;
                rptInstance.LastModifyId = CMBChina.WSS.Utility.SessionHelper.UserId;  // "098423";

                ReportMgr.UpdateRptInsAttachment(rptInstance);
            }
            catch (Exception ex)
            {
                Log.Error("[生成PNG图片并上传到对象桶，同时更新报告实例表附件信息]失败：" + ex.ToString());
                throw ex;
            }
        }
        
        /// <summary>
        /// 生成PNG图片
        /// </summary>
        /// <param name="parReportID"></param>
        /// <returns>Image</returns>
        public static string GeneratePNG(string parReportID)
        {
            // 需要生成图片的 URL 路径
            string templateUrl = CMBChina.KYC.Common.Config.SectionHelper.SystemConfig.GetValueWithKey("TemplateUrl") 
                + "?&ParReportID=" + parReportID;

            // 生成图片的默认宽度
            int pngDefaultWidth = Convert.ToInt32(CMBChina.KYC.Common.Config.SectionHelper.SystemConfig.GetValueWithKey("PngDefaultWidth"));

            // 生成图片的默认高度
            int pngDefaultHeight = ReportMgr.QueryRptInstance(parReportID).RptScrollHeight;
            
            Bitmap m_Bitmap = WebSiteThumbnail.GetWebSiteThumbnail(templateUrl,
                pngDefaultWidth, pngDefaultHeight, pngDefaultWidth, pngDefaultHeight);

            MemoryStream ms = new MemoryStream();
            m_Bitmap.Save(ms, System.Drawing.Imaging.ImageFormat.Png);  // JPG、GIF、PNG等均可
            byte[] buff = ms.ToArray();
            // Response.BinaryWrite(buff);

            System.Drawing.Image img = byteArrayToImage(buff);
            string ext = ".png";
            string folder = "pngs";
            // string filename = Guid.NewGuid().ToString();

            string filename = parReportID;

            string pngPath = "/AutoGen/" + folder + "/" + filename + ext;
            
            var tempPngPath = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\" + folder + @"\" + filename + ext;
            
            // img.Save(HttpContext.Current.Server.MapPath(pngPath));
            img.Save(tempPngPath);

            // 图片文件上传到对象桶
            // 方式一：传文件流
            // FileStream pngFs = new FileStream(HttpContext.Current.Server.MapPath(pngPath), FileMode.Open);
            FileStream pngFs = new FileStream(tempPngPath, FileMode.Open);
            long fileRes = CMBChina.KycDD.Common.FileTransferCommon.Upload(pngFs, (filename + ext), ext, true);
            
            // 方式二：传实体文件
            // long fileRes = CMBChina.KycDD.Common.FileTransferCommon.Upload(HttpContext.Current.Server.MapPath(pngPath), true);

            string resFileUrl = CMBChina.KycDD.Common.FileTransferCommon.GetDownLoadURL(fileRes);
            
            // 上传后将服务器上的缓存文件清除
            // if (File.Exists(HttpContext.Current.Server.MapPath(pngPath)) == true)
            if (File.Exists(tempPngPath) == true)
            {
                File.Delete(tempPngPath);
            }

            return resFileUrl;
        }

        /// <summary>
        /// byte[] 转换成 Image
        /// </summary>
        /// <param name="byteArrayIn">二进制图片流</param>
        /// <returns>Image</returns>
        public static System.Drawing.Image byteArrayToImage(byte[] byteArrayIn)
        {
            if (byteArrayIn == null)
                return null;
            using (System.IO.MemoryStream ms = new System.IO.MemoryStream(byteArrayIn))
            {
                System.Drawing.Image returnImage = System.Drawing.Image.FromStream(ms);
                ms.Flush();
                return returnImage;
            }
        }
    }
}

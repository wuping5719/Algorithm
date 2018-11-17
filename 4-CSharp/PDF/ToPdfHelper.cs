using System;
using System.Collections;
using System.Linq;
using System.IO;
using System.Text;
using System.Drawing;
using System.Threading;
using System.Windows.Forms;
using System.Web;
using System.Reflection;
using log4net;
using Pechkin;
using Pechkin.Synchronized;
using OUC.KYC.BLL.Report;
using OUC.KYC.Model.Report;

namespace OUC.KYC.Web.Util
{
    // 网页生成Pdf工具类
    // AddBy WuPing 2018-11-06
    public class ToPdfHelper
    {
        private static readonly ILog Log = LogManager.GetLogger(MethodBase.GetCurrentMethod().DeclaringType);

        // 生成PDF并上传到对象桶，同时更新报告实例表附件信息
        public static void RptToPDF(string parReportID)
        {
            try
            {
                // 生成PDF并上传到对象桶
                // string resFileUrl = WkHtmlToPDF(parReportID);
                string resFileUrl = PechkinHtmlToPDF(parReportID);
                
                // 更新报告实例表附件信息
                RptInstance rptInstance = new RptInstance();
                rptInstance.ReportID = parReportID;
                rptInstance.Attachment = resFileUrl;
                rptInstance.LastModifyId = CMBChina.WSS.Utility.SessionHelper.UserId;  // "098423";

                ReportMgr.UpdateRptInsAttachment(rptInstance);
            }
            catch (Exception ex)
            {
                Log.Error("[生成PDF并上传到对象桶，同时更新报告实例表附件信息]失败：" + ex.ToString());
                throw ex;
            }
        }
        
        /// <summary>
        /// 调用wkhtmltopdf插件生成PDF
        /// </summary>
        /// <param name="parReportID"></param>
        /// <returns>PDF</returns>
        public static string WkHtmlToPDF(string parReportID)
        {
            string ext = ".pdf";
            string folder = "pdfs";
            string genExe = "wkhtmltopdf.exe";

            var rootUrl = System.AppDomain.CurrentDomain.BaseDirectory; 
            // HttpContext.Current.Server.MapPath("/");

            var pdfUtil = rootUrl + @"AutoGen\wkhtmltopdf\32\" + genExe;
            Log.Debug("PdfUtil: " + pdfUtil);
            
            string filename = parReportID;

            string pdfPath = "/AutoGen/" + folder + "/" + filename + ext;
            Log.Debug("PdfPath: " + pdfPath); 

            string templateUrl = CMBChina.KYC.Common.Config.SectionHelper.SystemConfig.GetValueWithKey("TemplateUrl") 
                                      + "?&ParReportID=" + parReportID;
            
            System.Diagnostics.ProcessStartInfo pStartInfo = new System.Diagnostics.ProcessStartInfo();
            pStartInfo.FileName = pdfUtil;
            
            // var arguments = pStartInfo.Arguments = templateUrl + " \"" + HttpContext.Current.Server.MapPath(pdfPath) + "\"";
            var tempPdfPath = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\" + folder + @"\" + filename + ext;
            var arguments = templateUrl + " \"" + tempPdfPath + "\"";
            pStartInfo.Arguments = arguments;
            Log.Debug("Arguments: " + arguments); 

            pStartInfo.CreateNoWindow = true;
            pStartInfo.WindowStyle = System.Diagnostics.ProcessWindowStyle.Hidden;

            var p = System.Diagnostics.Process.Start(pStartInfo);
            p.WaitForExit();
            p.Close();

            // PDF文件上传到对象桶
            // 方式一：传文件流
            // FileStream pdfFs = new FileStream(HttpContext.Current.Server.MapPath(pdfPath), FileMode.Open);
            FileStream pdfFs = new FileStream(tempPdfPath, FileMode.Open);
            long fileRes = CMBChina.KycDD.Common.FileTransferCommon.Upload(pdfFs, (filename + ext), ext, true);
            
            // 方式二：传实体文件
            // long fileRes = CMBChina.KycDD.Common.FileTransferCommon.Upload(HttpContext.Current.Server.MapPath(pdfPath), true);

            string resFileUrl = CMBChina.KycDD.Common.FileTransferCommon.GetDownLoadURL(fileRes);

            // 上传后将服务器上的缓存文件清除
            // if (File.Exists(HttpContext.Current.Server.MapPath(pdfPath)) == true)
            if (File.Exists(tempPdfPath) == true)
            {
                File.Delete(tempPdfPath);
            }

            return resFileUrl;
        }

        /// <summary>
        /// 调用Pechkin插件生成PDF
        /// </summary>
        /// <param name="parReportID"></param>
        /// <returns>PDF</returns>
        public static string PechkinHtmlToPDF(string parReportID)
        {
            string ext = ".pdf";
            string folder = "pdfs";
            string templateUrl = CMBChina.KYC.Common.Config.SectionHelper.SystemConfig.GetValueWithKey("TemplateUrl")
                                      + "?&ParReportID=" + parReportID;
            
            var config = new GlobalConfig();
            config.SetMargins(new System.Drawing.Printing.Margins(20, 20, 20, 20));  // .SetPaperOrientation(true) // 设置纸张方向为横向

            ObjectConfig oc = new ObjectConfig();
            oc.SetPrintBackground(true)
                .SetLoadImages(true)
                .SetPageUri(templateUrl)
                .SetRunJavascript(true)   // 允许javaScript
                .SetScreenMediaType(true); 
            
            // SetRenderDelay(2000)    // 延时2秒;

            // 同步方式
            // var pechkin = new SimplePechkin(config); 
            // byte[] pdf = pechkin.Convert(oc);

            // 异步方式
            var synchronizedPechkin = new SynchronizedPechkin(config);  
            byte[] pdf = synchronizedPechkin.Convert(oc);

            string filename = parReportID;
            var tempPdfPath = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\" + folder + @"\" + filename + ext;
            Log.Debug("TempPdfPath: " + tempPdfPath);
 
            File.WriteAllBytes(tempPdfPath, pdf);

            // PDF文件上传到对象桶
            // 方式一：传文件流
            FileStream pdf_FS = new FileStream(tempPdfPath, FileMode.Open);
            long fileRes = CMBChina.KycDD.Common.FileTransferCommon.Upload(pdf_FS, (filename + ext), ext, true);

            // 方式二：传实体文件
            // long fileRes = CMBChina.KycDD.Common.FileTransferCommon.Upload(tempPdfPath, true);

            string resFileUrl = CMBChina.KycDD.Common.FileTransferCommon.GetDownLoadURL(fileRes);

            // 上传后将服务器上的缓存文件清除
            if (File.Exists(tempPdfPath) == true)
            {
                File.Delete(tempPdfPath);
            }

            return resFileUrl;
        }
    }
}

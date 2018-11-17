using System;
using System.Collections;
using System.Linq;
using System.IO;
using System.Web;
using System.Text;
using System.Reflection;
using System.Collections.Generic;
using log4net;
using Newtonsoft.Json;
using iTextSharp.text;
using iTextSharp.text.pdf;
using OUC.KYC.BLL.Report;
using OUC.KYC.Model.Report;
using OUC.KYC.Model.Report.Template1;
using OUC.KYC.BLL.WorkFlow;
using OUC.KYC.Model.WorkFlow;
using OUC.KYC.Common.Constants;

namespace OUC.KYC.Web.Util
{
    // 手动生成Pdf工具类
    // AddBy WuPing 2018-11-13
    public class ExportPDFHelper
    {
        private static readonly ILog Log = LogManager.GetLogger(MethodBase.GetCurrentMethod().DeclaringType);

        // 生成PDF并上传到对象桶，同时更新报告实例表附件信息
        public static void RptToPDF(string parReportID)
        {
            try
            {
                // 生成PDF并上传到对象桶
                string resFileUrl = ExportDetailToPDF(parReportID);

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
        /// 手动生成PDF
        /// </summary>
        /// <param name="parReportID"></param>
        public static string ExportDetailToPDF(string parReportID)
        {
            string ext = ".pdf";
            string folder = "pdfs";
            string filename = parReportID;

            RptInstance rptInstance = ReportMgr.QueryRptInstance(parReportID);
            ReportInfo reportInfo = JsonConvert.DeserializeObject<ReportInfo>(rptInstance.ReportData);

            // 字体
            Font fontTitle = GetFont(0); // 标题
            Font fontCol = GetFont(1);  // 表头
            Font fontContent = GetFont(2);  // 内容
            Document docPDF = new Document(PageSize.A4, 0, 0, 0, 0);
            
            var tempPdfPath = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\" + folder + @"\" + filename + ext;
            
            FileStream pdfFs = new FileStream(tempPdfPath, FileMode.OpenOrCreate, FileAccess.Write);
            PdfWriter writer = PdfWriter.GetInstance(docPDF, pdfFs);
            docPDF.Open();

            // 添加标题
            Paragraph pgrph = new Paragraph("招商银行单位客户开户加强型尽职调查表", fontTitle);
            pgrph.Alignment = Element.ALIGN_CENTER;
            docPDF.Add(pgrph);
            docPDF.Add(new Paragraph("  "));

            PdfPTable pdfTable = new PdfPTable(
                new float[] 
                {
                    60, 60, 60, 60, 60, 60, 60, 60,
                    60, 60, 60, 60, 60, 60, 60, 60,
                    60, 60, 60, 60, 60, 60, 60, 60
                }
            );  // 后面的参数表示表格的列宽为60，列数为16列);
            //pdfTable.PaddingTop = 1;    // 单元格边界和内容间距
            //pdfTable.SpacingAfter = 1;  // 单元格和表格边界
            //pdfTable.SpacingBefore = 2;

            #region （一）基本信息
            var lblBaseInfo = GetCell("（一）基本信息", fontCol, 1);
            lblBaseInfo.Colspan = 24;
            pdfTable.AddCell(lblBaseInfo);

            if (null != reportInfo.rptBase)
            {
                RptBaseInfo rptBase = reportInfo.rptBase;

                // 尽职调查ID
                var lblReportID = GetCell("尽职调查ID", fontContent, 0);
                lblReportID.Colspan = 3;
                pdfTable.AddCell(lblReportID);
                var reportIDCell = GetCell(parReportID, fontContent, 0);
                reportIDCell.Colspan = 21;
                pdfTable.AddCell(reportIDCell);

                // 客户经理  例："邝以彬/204662"
                string initiatorStr = rptBase.InitiatorName + "/" + rptBase.Initiator;
                var lblInitiator = GetCell("客户经理", fontContent, 0);
                lblInitiator.Colspan = 3;
                pdfTable.AddCell(lblInitiator);
                var initiatorCell = GetCell(initiatorStr, fontContent, 0);
                initiatorCell.Colspan = 9;
                pdfTable.AddCell(initiatorCell);

                // 所属机构  例："总行/法律合规部/120773"
                string initOrgStr = CMBChina.KYC.BLL.CommonBLL.GetOrgNameByOrgId(rptBase.InitOrg) + "/"
                    + rptBase.InitOrg;
                var lblInitOrg = GetCell("所属机构", fontContent, 0);
                lblInitOrg.Colspan = 3;
                pdfTable.AddCell(lblInitOrg);
                var initOrgCell = GetCell(initOrgStr, fontContent, 0);
                initOrgCell.Colspan = 9;
                pdfTable.AddCell(initOrgCell);

                // 联系方式
                string initPhoneStr = rptBase.InitPhone;
                var lblInitPhone = GetCell("联系电话", fontContent, 0);
                lblInitPhone.Colspan = 3;
                pdfTable.AddCell(lblInitPhone);
                var initPhoneCell = GetCell(initPhoneStr, fontContent, 0);
                initPhoneCell.Colspan = 9;
                pdfTable.AddCell(initPhoneCell);

                // 发起时间
                string initDateStr = DateTimeConverter.DateTimeToFormat((DateTime)rptBase.InitDate);
                var lblInitDate = GetCell("发起时间", fontContent, 0);
                lblInitDate.Colspan = 3;
                pdfTable.AddCell(lblInitDate);
                var initDateCell = GetCell(initDateStr, fontContent, 0);
                initDateCell.Colspan = 9;
                pdfTable.AddCell(initDateCell);
            }
            #endregion

            #region （二）客户身份信息
            var lblCustomerInfo = GetCell("（二）客户身份信息", fontCol, 1);
            lblCustomerInfo.Colspan = 24;
            pdfTable.AddCell(lblCustomerInfo);
            if (null != reportInfo.rptCustomer)
            {
                RptCustomerInfo rptCustomer = reportInfo.rptCustomer;

                // 客户名称
                string customerNameStr = rptCustomer.CustomerName;
                var lblCustomerName = GetCell("客户名称", fontContent, 0);
                lblCustomerName.Colspan = 3;
                lblCustomerName.Rowspan = 3;
                pdfTable.AddCell(lblCustomerName);
                var customerNameCell = GetCell(customerNameStr, fontContent, 0);
                customerNameCell.Colspan = 9;
                customerNameCell.Rowspan = 3;
                pdfTable.AddCell(customerNameCell);

                //【账户类型】非空
                var lblAccountType = GetCell("账户类型", fontContent, 0);
                lblAccountType.Colspan = 3;
                lblAccountType.Rowspan = 3;
                pdfTable.AddCell(lblAccountType);
                PdfPCell accountTypeCell = new PdfPCell();
                accountTypeCell.Colspan = 9;
                accountTypeCell.Rowspan = 3;
                accountTypeCell.Table = GetAccountTypeTab(rptCustomer.AccountType, fontContent);
                pdfTable.AddCell(accountTypeCell);

                // 公司经营范围
                string busScopeStr = rptCustomer.BusScope;
                var lblBusScope = GetCell("公司经营范围", fontContent, 0);
                lblBusScope.Colspan = 3;
                pdfTable.AddCell(lblBusScope);
                var busScopeCell = GetCell(busScopeStr, fontContent, 0);
                busScopeCell.Colspan = 21;
                pdfTable.AddCell(busScopeCell);

                //【成立时间】
                string foundingTimeStr = DateTimeConverter.StringToFormat(rptCustomer.FoundingTime);
                var lblFoundingTime = GetCell("成立时间", fontContent, 0);
                lblFoundingTime.Colspan = 3;
                pdfTable.AddCell(lblFoundingTime);
                var foundingTimeCell = GetCell(foundingTimeStr, fontContent, 0);
                foundingTimeCell.Colspan = 9;
                pdfTable.AddCell(foundingTimeCell);

                //【注册资本（万元）】非空
                string registeredCapitalStr = string.Empty;
                if (rptCustomer.RegisteredCapital.HasValue)
                {
                    registeredCapitalStr = String.Format("{0:N}", rptCustomer.RegisteredCapital);
                }
                var lblRegisteredCapital = GetCell("注册资本（万元）", fontContent, 0);
                lblRegisteredCapital.Colspan = 3;
                pdfTable.AddCell(lblRegisteredCapital);
                var registeredCapitalCell = GetCell(registeredCapitalStr, fontContent, 0);
                registeredCapitalCell.Colspan = 9;
                pdfTable.AddCell(registeredCapitalCell);

                // 员工人数
                string staffsNumberStr = rptCustomer.StaffsNumber.ToString();
                var lblStaffsNumber = GetCell("员工人数", fontContent, 0);
                lblStaffsNumber.Colspan = 3;
                pdfTable.AddCell(lblStaffsNumber);
                var staffsNumberCell = GetCell(staffsNumberStr, fontContent, 0);
                staffsNumberCell.Colspan = 9;
                pdfTable.AddCell(staffsNumberCell);

                // 年销售收入（万元）
                string salesIncomeStr = String.Format("{0:N}", rptCustomer.SalesIncome);
                var lblSalesIncome = GetCell("年销售收入（万元）", fontContent, 0);
                lblSalesIncome.Colspan = 3;
                pdfTable.AddCell(lblSalesIncome);
                var salesIncomeCell = GetCell(salesIncomeStr, fontContent, 0);
                salesIncomeCell.Colspan = 9;
                pdfTable.AddCell(salesIncomeCell);
            }

            #endregion

            #region （三）受益所有人身份信息
            var lblOwnerInfo = GetCell("（三）受益所有人身份信息", fontCol, 1);
            lblOwnerInfo.Colspan = 24;
            pdfTable.AddCell(lblOwnerInfo);

            var lblNotice1 = GetCell("一个客户有多个受益所有人的，应当记录所有受益所有人信息", fontContent, 0);
            lblNotice1.Colspan = 24;
            pdfTable.AddCell(lblNotice1);

            // 受益所有人身份信息列表
            var lblName = GetCell("姓名", fontContent, 0);
            lblName.Colspan = 3;
            pdfTable.AddCell(lblName);
            var lblNationality = GetCell("国籍", fontContent, 0);
            lblNationality.Colspan = 3;
            pdfTable.AddCell(lblNationality);
            var lblCertificateType = GetCell("证件类型", fontContent, 0);
            lblCertificateType.Colspan = 3;
            pdfTable.AddCell(lblCertificateType);
            var lblCertificateNo = GetCell("证件号码", fontContent, 0);
            lblCertificateNo.Colspan = 3;
            pdfTable.AddCell(lblCertificateNo);
            var lblCertificatePeriod = GetCell("证件有效期", fontContent, 0);
            lblCertificatePeriod.Colspan = 3;
            pdfTable.AddCell(lblCertificatePeriod);
            var lblAddress = GetCell("地址", fontContent, 0);
            lblAddress.Colspan = 3;
            pdfTable.AddCell(lblAddress);
            var lblBenefitMode = GetCell("控制/受益方式", fontContent, 0);
            lblBenefitMode.Colspan = 3;
            pdfTable.AddCell(lblBenefitMode);
            var lblRatio = GetCell("比例", fontContent, 0);
            lblRatio.Colspan = 3;
            pdfTable.AddCell(lblRatio);

            if (null != reportInfo.rptOwnerList)
            {
                foreach (var rptOwner in reportInfo.rptOwnerList)
                {
                    var nameCell = GetCell(rptOwner.Name, fontContent, 0);
                    nameCell.Colspan = 3;
                    pdfTable.AddCell(nameCell);

                    var nationalityCell = GetCell(CMBChina.KYC.Web.Code.Dict.DictHelper.GetTreeTermNameByOtherCode(
                             CMBChina.KYC.Common.Constants.DictConst.WSS_Nation, rptOwner.Nationality), 
                             fontContent, 0);
                    nationalityCell.Colspan = 3;
                    pdfTable.AddCell(nationalityCell);

                    var certificateTypeCell = GetCell(CMBChina.KYC.Web.Code.Dict.DictHelper.GetTreeTermNameByCode(
                             CMBChina.KYC.Common.Constants.DictConst.WSS_CMBIDType, rptOwner.CertificateType), 
                             fontContent, 0);
                    certificateTypeCell.Colspan = 3;
                    pdfTable.AddCell(certificateTypeCell);

                    var certificateNoCell = GetCell(rptOwner.CertificateNo, fontContent, 0);
                    certificateNoCell.Colspan = 3;
                    pdfTable.AddCell(certificateNoCell);

                    var certificatePeriodCell = GetCell(CMBChina.KYC.Web.Util.DateTimeConverter.StringToFormat(rptOwner.CertificatePeriod), 
                             fontContent, 0);
                    certificatePeriodCell.Colspan = 3;
                    pdfTable.AddCell(certificatePeriodCell);

                    var addressCell = GetCell(rptOwner.Address, fontContent, 0);
                    addressCell.Colspan = 3;
                    pdfTable.AddCell(addressCell);

                    var benefitModeCell = GetCell(CMBChina.KYC.Web.Code.Dict.DictHelper.GetTreeTermNameByCode(
                             CMBChina.KYC.Common.Constants.DictConst.KYC_BenefitMode, rptOwner.BenefitMode), 
                             fontContent, 0);
                    benefitModeCell.Colspan = 3;
                    pdfTable.AddCell(benefitModeCell);

                    var ratioCell = GetCell(String.Format("{0:F2}%", rptOwner.Ratio), fontContent, 0);
                    ratioCell.Colspan = 3;
                    pdfTable.AddCell(ratioCell);
                }
            }

            var briefDesCell = GetCell("简要说明： " + reportInfo.rptAttach.BriefDes, fontContent, 0);
            briefDesCell.Colspan = 24;
            pdfTable.AddCell(briefDesCell);
            #endregion

            #region （四）开户主要目的
            var lblPurpose = GetCell("（四）开户主要目的", fontCol, 1);
            lblPurpose.Colspan = 24;
            pdfTable.AddCell(lblPurpose);

            // 主营业务或主营产品
            var lblMainBus = GetCell("主营业务或主营产品", fontContent, 0);
            lblMainBus.Colspan = 5;
            pdfTable.AddCell(lblMainBus);
            string mainBusStr = string.Empty;
            if (!string.IsNullOrEmpty(reportInfo.rptCustomer.MainBus))
            {
                mainBusStr = reportInfo.rptCustomer.MainBus;
            }
            var mainBusCell = GetCell(mainBusStr, fontContent, 0);
            mainBusCell.Colspan = 19;
            pdfTable.AddCell(mainBusCell);

            RptPurpose rptPurpose = reportInfo.rptPurpose;
            // 开户主要目的
            PdfPCell mainPurposeCell = new PdfPCell();
            mainPurposeCell.Colspan = 24;
            mainPurposeCell.Rowspan = 2;
            mainPurposeCell.Table = GetPurposeTab(rptPurpose.MainPurpose, rptPurpose.Remarks, fontContent);
            pdfTable.AddCell(mainPurposeCell);

            // 账户交易模式
            PdfPCell tradingModeCell = new PdfPCell();
            tradingModeCell.Colspan = 5;
            tradingModeCell.Rowspan = 2;
            tradingModeCell.Table = GetTradingModeTab(rptPurpose.TradingMode, fontContent);
            pdfTable.AddCell(tradingModeCell);

            // 规模（万元）
            string comScaleStr = string.Empty;
            if (rptPurpose.ComScale.HasValue)
            {
               comScaleStr = String.Format("{0:N}", rptPurpose.ComScale);
            }
            var lblScale = GetCell("规模（万元）", fontContent, 0);
            lblScale.Colspan = 4;
            pdfTable.AddCell(lblScale);
            var scaleCell = GetCell(comScaleStr, fontContent, 0);
            scaleCell.Colspan = 15;
            pdfTable.AddCell(scaleCell);
                
            // 频次（次/年）
            string frequencyStr = rptPurpose.Frequency.ToString();
            var lblFrequency = GetCell("频次（次/年）", fontContent, 0);
            lblFrequency.Colspan = 4;
            pdfTable.AddCell(lblFrequency);
            var frequencyCell = GetCell(frequencyStr, fontContent, 0);
            frequencyCell.Colspan = 15;
            pdfTable.AddCell(frequencyCell);

            RptAttachInfo rptAttach = reportInfo.rptAttach;
            // 执行加强型尽职调查的原因

            SetReasonTab(rptAttach.SurveyReason, rptAttach.Reason1Remark, 
                rptAttach.ReasonRemark, reportInfo.rptRosterList,
                pdfTable, fontContent);

            // 本次尽职调查方式
            var lblSurveyMethod = GetCell("本次尽职调查方式", fontContent, 0);
            lblSurveyMethod.Colspan = 3;
            lblSurveyMethod.Rowspan = 7;
            pdfTable.AddCell(lblSurveyMethod);
            PdfPCell methodCell = new PdfPCell();
            methodCell.Colspan = 21;
            methodCell.Rowspan = 7;
            methodCell.Table = GetMethodTab(rptAttach.SurveyMethod,
                rptAttach.VisitAddress, rptAttach.MethodRemark, fontContent);
            pdfTable.AddCell(methodCell);

            // 尽调内容
            SetContentToTab(rptAttach.SurveyContent, pdfTable, fontContent);
            #endregion

            #region （五）交易背景
            var lblBackground = GetCell("（五）交易背景", fontCol, 1);
            lblBackground.Colspan = 24;
            pdfTable.AddCell(lblBackground);

            // 交易背景
            SetBackgroundToTab(rptAttach.TradingBackground, rptAttach.BackgroundRemark, pdfTable, fontContent);
            #endregion

            #region （六）尽调结论及建议风控措施
            var lblCon_Sugs = GetCell("（六）尽调结论及建议风控措施", fontCol, 1);
            lblCon_Sugs.Colspan = 24;
            pdfTable.AddCell(lblCon_Sugs);

            // 尽调结论
            PdfPCell conclusionCell = new PdfPCell();
            conclusionCell.Colspan = 24;
            conclusionCell.Table = GetConclusionTab(rptAttach.Conclusion, rptAttach.ConclusionRemark, fontContent);
            pdfTable.AddCell(conclusionCell);

            // 建议风控措施
            var lblSuggestion = GetCell("建议采取的措施", fontContent, 0);
            lblSuggestion.Colspan = 3;
            lblSuggestion.Rowspan = 6;
            pdfTable.AddCell(lblSuggestion);
            PdfPCell sugCell = new PdfPCell();
            sugCell.Colspan = 21;
            sugCell.Rowspan = 6;
            sugCell.Table = GetSuggestionTab(rptAttach.Suggestion, 
                (String.Format("{0:N}", rptAttach.Sug5Remark)), 
                rptAttach.SuggestionRemark, fontContent);
            pdfTable.AddCell(sugCell);
            #endregion

            #region （七）审批记录
            var lblRecords = GetCell("（七）审批记录", fontCol, 1);
            lblRecords.Colspan = 24;
            pdfTable.AddCell(lblRecords);

            // 审批记录
            var lblApprover = GetCell("审批人", fontContent, 0);
            lblApprover.Colspan = 6;
            pdfTable.AddCell(lblApprover);
            var lblOpinion = GetCell("审批意见", fontContent, 0);
            lblOpinion.Colspan = 6;
            pdfTable.AddCell(lblOpinion);
            var lblDetails = GetCell("审批详情", fontContent, 0);
            lblDetails.Colspan = 6;
            pdfTable.AddCell(lblDetails);
            var lblFinishTime = GetCell("完成时间", fontContent, 0);
            lblFinishTime.Colspan = 6;
            pdfTable.AddCell(lblFinishTime);

            List<WFApprInfo> apprInfoList = WorkFlowMgr.QueryApprInfoByRefBizID(parReportID);

            if (null != apprInfoList)
            {
                foreach (var apprInfo in apprInfoList)
                {
                    var approverCell = GetCell(CMBChina.KYC.Web.Code.Dict.DictHelper.GetUserNameByID(apprInfo.ModifyID),
                             fontContent, 0);
                    approverCell.Colspan = 6;
                    pdfTable.AddCell(approverCell);

                    var apprCodeCell = GetCell(CMBChina.KYC.Web.Code.Dict.DictHelper.GetTreeTermNameByCode(
                             CMBChina.KYC.Common.Constants.DictConst.KYC_ApprCode, apprInfo.ApprCode), 
                             fontContent, 0);
                    apprCodeCell.Colspan = 6;
                    pdfTable.AddCell(apprCodeCell);

                    var detailsCell = GetCell(apprInfo.Remark, fontContent, 0);
                    detailsCell.Colspan = 6;
                    pdfTable.AddCell(detailsCell);

                    var finishTimeCell = GetCell(apprInfo.ModifyTime.ToString(), fontContent, 0);
                    finishTimeCell.Colspan = 6;
                    pdfTable.AddCell(finishTimeCell);
                }
            }
            #endregion

            docPDF.Add(pdfTable);

            docPDF.Close();
            writer.Close();

            FileStream tempPdfFs = new FileStream(tempPdfPath, FileMode.Open);
            // PDF文件上传到对象桶: 传文件流
            long fileRes = CMBChina.KycDD.Common.FileTransferCommon.Upload(tempPdfFs, filename + ext, ext, true);

            string resFileUrl = string.Empty;
            resFileUrl = CMBChina.KycDD.Common.FileTransferCommon.GetDownLoadURL(fileRes);
            
            // 关闭流
            // tempPdfFs.Close();
            // pdfFs.Close();

            // 上传后将服务器上的缓存文件清除
            if (File.Exists(tempPdfPath) == true)
            {
                File.Delete(tempPdfPath);
            }

            return resFileUrl;
        }

        /// <summary>
        /// 创建【账户类型】表格
        /// </summary>
        /// <param name="accountType"></param>
        /// <param name="font"></param>
        /// <returns>PdfPTable</returns>
        public static PdfPTable GetAccountTypeTab(string accountType, Font fontContent)
        {
            #region 处理 CheckBox 图标
            string chk_F_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\CheckBox_False.bmp";
            string chk_T_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\CheckBox_True.bmp";

            var imgCell_AccType1 = new PdfPCell();
            imgCell_AccType1.BorderWidth = 0;
            var imgCell_AccType2 = new PdfPCell();
            imgCell_AccType2.BorderWidth = 0;
            var imgCell_AccType3 = new PdfPCell();
            imgCell_AccType3.BorderWidth = 0;
            var imgCell_AccType4 = new PdfPCell();
            imgCell_AccType4.BorderWidth = 0;
            var imgCell_AccType5 = new PdfPCell();
            imgCell_AccType5.BorderWidth = 0;
            var imgCell_AccType6 = new PdfPCell();
            imgCell_AccType6.BorderWidth = 0;

            var img_T = iTextSharp.text.Image.GetInstance(chk_T_Url);
            img_T.ScaleToFit(8f, 8f);
            var img_F = iTextSharp.text.Image.GetInstance(chk_F_Url);
            img_F.ScaleToFit(8f, 8f);

            if (!string.IsNullOrEmpty(accountType))
            {
                if (ReportDict.AccType_1.Equals(accountType)) // 基本存款户: 1
                {
                    imgCell_AccType1.AddElement(img_T);
                }
                else
                {
                    imgCell_AccType1.AddElement(img_F);
                }
                if (ReportDict.AccType_2.Equals(accountType)) // 一般存款户: 2
                {
                    imgCell_AccType2.AddElement(img_T);
                }
                else
                {
                    imgCell_AccType2.AddElement(img_F);
                }
                if (ReportDict.AccType_3.Equals(accountType)) // 预算单位专用存款户: 3
                {
                    imgCell_AccType3.AddElement(img_T);
                }
                else
                {
                    imgCell_AccType3.AddElement(img_F);
                }
                if (ReportDict.AccType_4.Equals(accountType)) // 临时存款户: 4
                {
                    imgCell_AccType4.AddElement(img_T);
                }
                else
                {
                    imgCell_AccType4.AddElement(img_F);
                }
                if (ReportDict.AccType_5.Equals(accountType)) // 临时存款(验资户): 5
                {
                    imgCell_AccType5.AddElement(img_T);
                }
                else
                {
                    imgCell_AccType5.AddElement(img_F);
                }
                if (ReportDict.AccType_6.Equals(accountType)) // 其它专用存款户: 6
                {
                    imgCell_AccType6.AddElement(img_T);
                }
                else
                {
                    imgCell_AccType6.AddElement(img_F);
                }
            }
            else
            {
                imgCell_AccType1.AddElement(img_F);
                imgCell_AccType2.AddElement(img_F);
                imgCell_AccType3.AddElement(img_F);
                imgCell_AccType4.AddElement(img_F);
                imgCell_AccType5.AddElement(img_F);
                imgCell_AccType6.AddElement(img_F);
            }
            #endregion

            #region 生成【账户类型】表格
            PdfPTable accountTypeTab = new PdfPTable(
                 new float[] { 16, 184, 16, 144 }
            );

            var lblAccType1 = GetCell("基本存款户", fontContent, 0);
            lblAccType1.BorderWidth = 0;
            var lblAccType2 = GetCell("一般存款户", fontContent, 0);
            lblAccType2.BorderWidth = 0;
            var lblAccType3 = GetCell("预算单位专用存款户", fontContent, 0);
            lblAccType3.BorderWidth = 0;
            var lblAccType4 = GetCell("临时存款户", fontContent, 0);
            lblAccType4.BorderWidth = 0;
            var lblAccType5 = GetCell("临时存款(验资户)", fontContent, 0);
            lblAccType5.BorderWidth = 0;
            var lblAccType6 = GetCell("其它专用存款户", fontContent, 0);
            lblAccType6.BorderWidth = 0;

            accountTypeTab.AddCell(imgCell_AccType1);
            accountTypeTab.AddCell(lblAccType1);
            accountTypeTab.AddCell(imgCell_AccType2);
            accountTypeTab.AddCell(lblAccType2);
            accountTypeTab.AddCell(imgCell_AccType3);
            accountTypeTab.AddCell(lblAccType3);
            accountTypeTab.AddCell(imgCell_AccType4);
            accountTypeTab.AddCell(lblAccType4);
            accountTypeTab.AddCell(imgCell_AccType5);
            accountTypeTab.AddCell(lblAccType5);
            accountTypeTab.AddCell(imgCell_AccType6);
            accountTypeTab.AddCell(lblAccType6);
            #endregion

            return accountTypeTab;
        }

        /// <summary>
        /// 创建【开户主要目的】表格
        /// </summary>
        /// <param name="mainPurpose"></param>
        /// <param name="remarks"></param>
        /// <param name="font"></param>
        /// <returns>PdfPTable</returns>
        public static PdfPTable GetPurposeTab(string mainPurpose, string remarks, Font fontContent)
        {
            #region 处理 CheckBox 图标
            string chk_F_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\CheckBox_False.bmp";
            string chk_T_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\CheckBox_True.bmp";

            var imgCell_Purpose01 = new PdfPCell();
            imgCell_Purpose01.BorderWidth = 0;
            imgCell_Purpose01.HorizontalAlignment = 2;
            var imgCell_Purpose02 = new PdfPCell();
            imgCell_Purpose02.BorderWidth = 0;
            imgCell_Purpose02.HorizontalAlignment = 2;
            var imgCell_Purpose03 = new PdfPCell();
            imgCell_Purpose03.BorderWidth = 0;
            imgCell_Purpose03.HorizontalAlignment = 2;
            var imgCell_Purpose04 = new PdfPCell();
            imgCell_Purpose04.BorderWidth = 0;
            imgCell_Purpose04.HorizontalAlignment = 2;
            var imgCell_Purpose05 = new PdfPCell();
            imgCell_Purpose05.BorderWidth = 0;
            imgCell_Purpose05.HorizontalAlignment = 2;
            var imgCell_Purpose06 = new PdfPCell();
            imgCell_Purpose06.BorderWidth = 0;
            imgCell_Purpose06.HorizontalAlignment = 2;
            var imgCell_Purpose07 = new PdfPCell();
            imgCell_Purpose07.BorderWidth = 0;
            imgCell_Purpose07.HorizontalAlignment = 2;
            var imgCell_Purpose08 = new PdfPCell();
            imgCell_Purpose08.BorderWidth = 0;
            imgCell_Purpose08.HorizontalAlignment = 2;

            var img_T = iTextSharp.text.Image.GetInstance(chk_T_Url);
            img_T.ScaleToFit(8f, 8f);
            var img_F = iTextSharp.text.Image.GetInstance(chk_F_Url);
            img_F.ScaleToFit(8f, 8f);

            //【开户主要目的】非空
            // 01：经营性收支, 02：代发业务, 03：缴纳税费, 03：缴纳税费
            // 04：投资, 05：存款或理财, 06：贷款, 07：现金管理, 08：其他（请注明）
            if (!string.IsNullOrEmpty(mainPurpose))
            {
                string[] arrayPurpose = mainPurpose.Split(',');
                if (arrayPurpose.Contains(ReportDict.Purpose_01))
                {
                    imgCell_Purpose01.AddElement(img_T);
                }
                else
                {
                    imgCell_Purpose01.AddElement(img_F);
                }
                if (arrayPurpose.Contains(ReportDict.Purpose_02))
                {
                    imgCell_Purpose02.AddElement(img_T);
                }
                else
                {
                    imgCell_Purpose02.AddElement(img_F);
                }
                if (arrayPurpose.Contains(ReportDict.Purpose_03))
                {
                    imgCell_Purpose03.AddElement(img_T);
                }
                else
                {
                    imgCell_Purpose03.AddElement(img_F);
                }
                if (arrayPurpose.Contains(ReportDict.Purpose_04))
                {
                    imgCell_Purpose04.AddElement(img_T);
                }
                else
                {
                    imgCell_Purpose04.AddElement(img_F);
                }
                if (arrayPurpose.Contains(ReportDict.Purpose_05))
                {
                    imgCell_Purpose05.AddElement(img_T);
                }
                else
                {
                    imgCell_Purpose05.AddElement(img_F);
                }
                if (arrayPurpose.Contains(ReportDict.Purpose_06))
                {
                    imgCell_Purpose06.AddElement(img_T);
                }
                else
                {
                    imgCell_Purpose06.AddElement(img_F);
                }
                if (arrayPurpose.Contains(ReportDict.Purpose_07))
                {
                    imgCell_Purpose07.AddElement(img_T);
                }
                else
                {
                    imgCell_Purpose07.AddElement(img_F);
                }
                if (arrayPurpose.Contains(ReportDict.Purpose_08))
                {
                    imgCell_Purpose08.AddElement(img_T);
                }
                else
                {
                    imgCell_Purpose08.AddElement(img_F);
                }
            }
            else
            {
                imgCell_Purpose01.AddElement(img_F);
                imgCell_Purpose02.AddElement(img_F);
                imgCell_Purpose03.AddElement(img_F);
                imgCell_Purpose04.AddElement(img_F);
                imgCell_Purpose05.AddElement(img_F);
                imgCell_Purpose06.AddElement(img_F);
                imgCell_Purpose07.AddElement(img_F);
                imgCell_Purpose08.AddElement(img_F);
            }
            #endregion

            #region 生成【开户主要目的】表格
            PdfPTable purposeTab = new PdfPTable(
                 new float[] { 16, 100, 16, 120, 16, 100, 16, 100, 16, 100, 16, 100, 160 }
            );

            var lblPurpose01 = GetCell("经营性收支", fontContent, 0);
            lblPurpose01.BorderWidth = 0;
            var lblPurpose02 = GetCell("代发业务", fontContent, 0);
            lblPurpose02.BorderWidth = 0;
            var lblPurpose03 = GetCell("缴纳税费", fontContent, 0);
            lblPurpose03.BorderWidth = 0;
            var lblPurpose04 = GetCell("投资", fontContent, 0);
            lblPurpose04.BorderWidth = 0;
            var lblPurpose05 = GetCell("存款或理财", fontContent, 0);
            lblPurpose05.BorderWidth = 0;
            var lblPurpose06 = GetCell("贷款", fontContent, 0);
            lblPurpose06.BorderWidth = 0;
            var lblPurpose07 = GetCell("现金管理", fontContent, 0);
            lblPurpose07.BorderWidth = 0;
            var lblPurpose08 = GetCell("其他（请注明）：" + remarks, fontContent, 0);
            lblPurpose08.BorderWidth = 0;
            lblPurpose08.Colspan = 10;

            var temp1Cell = GetCell(string.Empty, fontContent, 0);
            temp1Cell.BorderWidth = 0;

            purposeTab.AddCell(imgCell_Purpose01);
            purposeTab.AddCell(lblPurpose01);
            purposeTab.AddCell(imgCell_Purpose02);
            purposeTab.AddCell(lblPurpose02);
            purposeTab.AddCell(imgCell_Purpose03);
            purposeTab.AddCell(lblPurpose03);
            purposeTab.AddCell(imgCell_Purpose04);
            purposeTab.AddCell(lblPurpose04);
            purposeTab.AddCell(imgCell_Purpose05);
            purposeTab.AddCell(lblPurpose05);
            purposeTab.AddCell(imgCell_Purpose06);
            purposeTab.AddCell(lblPurpose06);
            purposeTab.AddCell(temp1Cell);

            purposeTab.AddCell(imgCell_Purpose07);
            purposeTab.AddCell(lblPurpose07);
            purposeTab.AddCell(imgCell_Purpose08);
            purposeTab.AddCell(lblPurpose08);
            #endregion

            return purposeTab;
        }

        /// <summary>
        /// 创建【账户交易模式】表格
        /// </summary>
        /// <param name="tradingMode"></param>
        /// <param name="font"></param>
        /// <returns>PdfPTable</returns>
        public static PdfPTable GetTradingModeTab(string tradingMode, Font fontContent)
        {
            #region 处理 CheckBox 图标
            string chk_F_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\CheckBox_False.bmp";
            string chk_T_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\CheckBox_True.bmp";

            var imgCell_TradingMode01 = new PdfPCell();
            imgCell_TradingMode01.BorderWidth = 0;
            imgCell_TradingMode01.HorizontalAlignment = 2;
            var imgCell_TradingMode02 = new PdfPCell();
            imgCell_TradingMode02.BorderWidth = 0;
            imgCell_TradingMode02.HorizontalAlignment = 2;

            var img_T = iTextSharp.text.Image.GetInstance(chk_T_Url);
            img_T.ScaleToFit(8f, 8f);
            var img_F = iTextSharp.text.Image.GetInstance(chk_F_Url);
            img_F.ScaleToFit(8f, 8f);

            //【账户交易模式】非空 
            // 01：预估, 02：已发生
            if (string.IsNullOrEmpty(tradingMode))
            {
                // 默认: 01：预估;
                imgCell_TradingMode01.AddElement(img_T);
                imgCell_TradingMode02.AddElement(img_F);
            }
            else
            {
                string[] arrayTradingMode = tradingMode.Split(',');
                if (arrayTradingMode.Contains(ReportDict.TradingMode_02))
                {
                    imgCell_TradingMode01.AddElement(img_F);
                    imgCell_TradingMode02.AddElement(img_T);
                }
                else  // 默认: 01：预估
                {
                    imgCell_TradingMode01.AddElement(img_T);
                    imgCell_TradingMode02.AddElement(img_F);
                }
            }
            #endregion

            #region 生成【账户交易模式】表格
            PdfPTable tradingModeTab = new PdfPTable(
                new float[] { 16, 80, 16, 80 }
            );

            var mode01Cell = GetCell("预估", fontContent, 0);
            mode01Cell.BorderWidth = 0;
            var mode02Cell = GetCell("已发生", fontContent, 0);
            mode02Cell.BorderWidth = 0;

            var lblModeCell = GetCell("账户交易模式", fontContent, 1);
            lblModeCell.BorderWidth = 0;
            lblModeCell.Colspan = 4;

            tradingModeTab.AddCell(lblModeCell);

            tradingModeTab.AddCell(imgCell_TradingMode01);
            tradingModeTab.AddCell(mode01Cell);
            tradingModeTab.AddCell(imgCell_TradingMode02);
            tradingModeTab.AddCell(mode02Cell);
            #endregion

            return tradingModeTab;
        }

        /// <summary>
        /// 生成【尽调原因(规则)】表格
        /// </summary>
        /// <param name="surveyReason"></param>
        /// <param name="reason1Remark"></param>
        /// <param name="reasonRemark"></param>
        /// <param name="rptRosterList"></param>
        /// <param name="font"></param>
        /// <returns>PdfPTable</returns>
        public static void SetReasonTab(string surveyReason, string reason1Remark, 
            string reasonRemark, List<RptRoster> rptRosterList, 
            PdfPTable pdfTable, Font fontContent)
        {
            #region 处理 CheckBox 图标
            string chk_F_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\CheckBox_False.bmp";
            string chk_T_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\CheckBox_True.bmp";
            
            var img_T = iTextSharp.text.Image.GetInstance(chk_T_Url);
            img_T.ScaleToFit(8f, 8f);
            var img_F = iTextSharp.text.Image.GetInstance(chk_F_Url);
            img_F.ScaleToFit(8f, 8f);

            var imgCell_ReasonC001 = new PdfPCell();
            imgCell_ReasonC001.BorderWidth = 0;
            imgCell_ReasonC001.Colspan = 1;
            imgCell_ReasonC001.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonC002 = new PdfPCell();
            imgCell_ReasonC002.BorderWidth = 0;
            imgCell_ReasonC002.Colspan = 1;
            imgCell_ReasonC002.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonC003 = new PdfPCell();
            imgCell_ReasonC003.BorderWidth = 0;
            imgCell_ReasonC003.Colspan = 1;
            imgCell_ReasonC003.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonC004 = new PdfPCell();
            imgCell_ReasonC004.BorderWidth = 0;
            imgCell_ReasonC004.Colspan = 1;
            imgCell_ReasonC004.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonC005 = new PdfPCell();
            imgCell_ReasonC005.BorderWidth = 0;
            imgCell_ReasonC005.Colspan = 1;
            imgCell_ReasonC005.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonC006 = new PdfPCell();
            imgCell_ReasonC006.BorderWidth = 0;
            imgCell_ReasonC006.Colspan = 1;
            imgCell_ReasonC006.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW001 = new PdfPCell();
            imgCell_ReasonW001.BorderWidth = 0;
            imgCell_ReasonW001.Colspan = 1;
            imgCell_ReasonW001.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW002 = new PdfPCell();
            imgCell_ReasonW002.BorderWidth = 0;
            imgCell_ReasonW002.Colspan = 1;
            imgCell_ReasonW002.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW003 = new PdfPCell();
            imgCell_ReasonW003.BorderWidth = 0;
            imgCell_ReasonW003.Colspan = 1;
            imgCell_ReasonW003.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW004 = new PdfPCell();
            imgCell_ReasonW004.BorderWidth = 0;
            imgCell_ReasonW004.Colspan = 1;
            imgCell_ReasonW004.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW005 = new PdfPCell();
            imgCell_ReasonW005.Colspan = 1;
            imgCell_ReasonW005.BorderWidth = 0;
            imgCell_ReasonW005.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW006 = new PdfPCell();
            imgCell_ReasonW006.BorderWidth = 0;
            imgCell_ReasonW006.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW007 = new PdfPCell();
            imgCell_ReasonW007.BorderWidth = 0;
            imgCell_ReasonW007.Colspan = 1;
            imgCell_ReasonW007.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW008 = new PdfPCell();
            imgCell_ReasonW008.Colspan = 1;
            imgCell_ReasonW008.BorderWidth = 0;
            imgCell_ReasonW008.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW009 = new PdfPCell();
            imgCell_ReasonW009.BorderWidth = 0;
            imgCell_ReasonW009.Colspan = 1;
            imgCell_ReasonW009.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW010 = new PdfPCell();
            imgCell_ReasonW010.BorderWidth = 0;
            imgCell_ReasonW010.Colspan = 1;
            imgCell_ReasonW010.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW011 = new PdfPCell();
            imgCell_ReasonW011.BorderWidth = 0;
            imgCell_ReasonW011.Colspan = 1;
            imgCell_ReasonW011.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW012 = new PdfPCell();
            imgCell_ReasonW012.BorderWidth = 0;
            imgCell_ReasonW012.Colspan = 1;
            imgCell_ReasonW012.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW013 = new PdfPCell();
            imgCell_ReasonW013.BorderWidth = 0;
            imgCell_ReasonW013.Colspan = 1;
            imgCell_ReasonW013.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW014 = new PdfPCell();
            imgCell_ReasonW014.BorderWidth = 0;
            imgCell_ReasonW014.Colspan = 1;
            imgCell_ReasonW014.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW015 = new PdfPCell();
            imgCell_ReasonW015.BorderWidth = 0;
            imgCell_ReasonW015.Colspan = 1;
            imgCell_ReasonW015.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW016 = new PdfPCell();
            imgCell_ReasonW016.BorderWidth = 0;
            imgCell_ReasonW016.Colspan = 1;
            imgCell_ReasonW016.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonW017 = new PdfPCell();
            imgCell_ReasonW017.BorderWidth = 0;
            imgCell_ReasonW017.Colspan = 1;
            imgCell_ReasonW017.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_ReasonT999 = new PdfPCell();
            imgCell_ReasonT999.BorderWidthTop = 0;
            imgCell_ReasonT999.BorderWidthLeft = 0;
            imgCell_ReasonT999.BorderWidthRight = 0;
            imgCell_ReasonT999.Colspan = 1;
            imgCell_ReasonT999.HorizontalAlignment = Element.ALIGN_RIGHT;

            if (!string.IsNullOrEmpty(surveyReason))
            {
                // 尽调原因(规则)
                // 以逗号","分隔的尽调规则编码序列：C001,C002,C006,W001,W012
                string[] arrayReason = surveyReason.Split(',');
                if (arrayReason.Contains(ReportDict.Reason_C001))
                {
                    imgCell_ReasonC001.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonC001.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_C002))
                {
                    imgCell_ReasonC002.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonC002.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_C003))
                {
                    imgCell_ReasonC003.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonC003.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_C004))
                {
                    imgCell_ReasonC004.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonC004.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_C005))
                {
                    imgCell_ReasonC005.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonC005.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_C006))
                {
                    imgCell_ReasonC006.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonC006.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W001))
                {
                    imgCell_ReasonW001.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW001.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W002))
                {
                    imgCell_ReasonW002.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW002.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W003))
                {
                    imgCell_ReasonW003.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW003.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W004))
                {
                    imgCell_ReasonW004.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW004.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W005))
                {
                    imgCell_ReasonW005.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW005.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W006))
                {
                    imgCell_ReasonW006.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW006.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W007))
                {
                    imgCell_ReasonW007.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW007.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W008))
                {
                    imgCell_ReasonW008.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW008.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W009))
                {
                    imgCell_ReasonW009.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW009.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W010))
                {
                    imgCell_ReasonW010.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW010.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W011))
                {
                    imgCell_ReasonW011.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW011.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W012))
                {
                    imgCell_ReasonW012.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW012.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W013))
                {
                    imgCell_ReasonW013.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW013.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W014))
                {
                    imgCell_ReasonW014.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW014.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W015))
                {
                    imgCell_ReasonW015.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW015.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W016))
                {
                    imgCell_ReasonW016.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW016.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_W017))
                {
                    imgCell_ReasonW017.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonW017.AddElement(img_F);
                }
                if (arrayReason.Contains(ReportDict.Reason_T999))
                {
                    imgCell_ReasonT999.AddElement(img_T);
                }
                else
                {
                    imgCell_ReasonT999.AddElement(img_F);
                }
            }
            else
            {
                imgCell_ReasonC001.AddElement(img_F);
                imgCell_ReasonC002.AddElement(img_F);
                imgCell_ReasonC003.AddElement(img_F);
                imgCell_ReasonC004.AddElement(img_F);
                imgCell_ReasonC005.AddElement(img_F);
                imgCell_ReasonC006.AddElement(img_F);
                imgCell_ReasonW001.AddElement(img_F);
                imgCell_ReasonW002.AddElement(img_F);
                imgCell_ReasonW003.AddElement(img_F);
                imgCell_ReasonW004.AddElement(img_F);
                imgCell_ReasonW005.AddElement(img_F);
                imgCell_ReasonW006.AddElement(img_F);
                imgCell_ReasonW007.AddElement(img_F);
                imgCell_ReasonW008.AddElement(img_F);
                imgCell_ReasonW009.AddElement(img_F);
                imgCell_ReasonW010.AddElement(img_F);
                imgCell_ReasonW011.AddElement(img_F);
                imgCell_ReasonW012.AddElement(img_F);
                imgCell_ReasonW013.AddElement(img_F);
                imgCell_ReasonW014.AddElement(img_F);
                imgCell_ReasonW015.AddElement(img_F);
                imgCell_ReasonW016.AddElement(img_F);
                imgCell_ReasonW017.AddElement(img_F);
                imgCell_ReasonT999.AddElement(img_F);
            }
            #endregion

            #region 处理 尽调原因(规则) 描述
            string ruleC001 = string.Empty;
            string ruleC002 = string.Empty;
            string ruleC003 = string.Empty;
            string ruleC004 = string.Empty;
            string ruleC005 = string.Empty;
            string ruleC006 = string.Empty;
            string ruleW001 = string.Empty;
            string ruleW002 = string.Empty;
            string ruleW003 = string.Empty;
            string ruleW004 = string.Empty;
            string ruleW005 = string.Empty;
            string ruleW006 = string.Empty;
            string ruleW007 = string.Empty;
            string ruleW008 = string.Empty;
            string ruleW009 = string.Empty;
            string ruleW010 = string.Empty;
            string ruleW011 = string.Empty;
            string ruleW012 = string.Empty;
            string ruleW013 = string.Empty;
            string ruleW014 = string.Empty;
            string ruleW015 = string.Empty;
            string ruleW016 = string.Empty;
            string ruleW017 = string.Empty;

            List<DiligenceRule> allRuleList = DiligenceRuleMgr.GetAllRuleList();
            foreach (DiligenceRule rule in allRuleList)
            {
                if (ReportDict.Reason_C001.Equals(rule.RuleCode))
                {
                    ruleC001 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_C002.Equals(rule.RuleCode))
                {
                    ruleC002 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_C003.Equals(rule.RuleCode))
                {
                    ruleC003 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_C004.Equals(rule.RuleCode))
                {
                    ruleC004 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_C005.Equals(rule.RuleCode))
                {
                    ruleC005 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_C006.Equals(rule.RuleCode))
                {
                    ruleC006 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W001.Equals(rule.RuleCode))
                {
                    ruleW001 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W002.Equals(rule.RuleCode))
                {
                    ruleW002 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W003.Equals(rule.RuleCode))
                {
                    ruleW003 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W004.Equals(rule.RuleCode))
                {
                    ruleW004 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W005.Equals(rule.RuleCode))
                {
                    ruleW005 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W006.Equals(rule.RuleCode))
                {
                    ruleW006 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W007.Equals(rule.RuleCode))
                {
                    ruleW007 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W008.Equals(rule.RuleCode))
                {
                    ruleW008 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W009.Equals(rule.RuleCode))
                {
                    ruleW009 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W010.Equals(rule.RuleCode))
                {
                    ruleW010 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W011.Equals(rule.RuleCode))
                {
                    ruleW011 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W012.Equals(rule.RuleCode))
                {
                    ruleW012 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W013.Equals(rule.RuleCode))
                {
                    ruleW013 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W014.Equals(rule.RuleCode))
                {
                    ruleW014 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W015.Equals(rule.RuleCode))
                {
                    ruleW015 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W016.Equals(rule.RuleCode))
                {
                    ruleW016 = rule.RuleDescribe;
                }
                if (ReportDict.Reason_W017.Equals(rule.RuleCode))
                {
                    ruleW017 = rule.RuleDescribe;
                }
            }

            var ruleC001Cell = GetCell(ruleC001, fontContent, 0);
            ruleC001Cell.BorderWidthTop = 0;
            ruleC001Cell.BorderWidthLeft = 0;
            ruleC001Cell.BorderWidthBottom = 0;
            ruleC001Cell.Colspan = 20;
            var ruleC002Cell = GetCell(ruleC002, fontContent, 0);
            ruleC002Cell.BorderWidthTop = 0;
            ruleC002Cell.BorderWidthLeft = 0;
            ruleC002Cell.BorderWidthBottom = 0;
            ruleC002Cell.Colspan = 20;
            var ruleC003Cell = GetCell(ruleC003, fontContent, 0);
            ruleC003Cell.BorderWidthTop = 0;
            ruleC003Cell.BorderWidthLeft = 0;
            ruleC003Cell.BorderWidthBottom = 0;
            ruleC003Cell.Colspan = 20;
            var ruleC004Cell = GetCell(ruleC004, fontContent, 0);
            ruleC004Cell.BorderWidthTop = 0;
            ruleC004Cell.BorderWidthLeft = 0;
            ruleC004Cell.BorderWidthBottom = 0;
            ruleC004Cell.Colspan = 20;
            var ruleC005Cell = GetCell(ruleC005, fontContent, 0);
            ruleC005Cell.BorderWidthTop = 0;
            ruleC005Cell.BorderWidthLeft = 0;
            ruleC005Cell.BorderWidthBottom = 0;
            ruleC005Cell.Colspan = 20;
            var ruleC006Cell = GetCell(ruleC006, fontContent, 0);
            ruleC006Cell.BorderWidthTop = 0;
            ruleC006Cell.BorderWidthLeft = 0;
            ruleC006Cell.BorderWidthBottom = 0;
            ruleC006Cell.Colspan = 20;
            var ruleW001Cell = GetCell(ruleW001, fontContent, 0);
            ruleW001Cell.BorderWidthTop = 0;
            ruleW001Cell.BorderWidthLeft = 0;
            ruleW001Cell.BorderWidthBottom = 0;
            ruleW001Cell.Colspan = 20;
            var ruleW002Cell = GetCell(ruleW002, fontContent, 0);
            ruleW002Cell.BorderWidthTop = 0;
            ruleW002Cell.BorderWidthLeft = 0;
            ruleW002Cell.BorderWidthBottom = 0;
            ruleW002Cell.Colspan = 20;
            var ruleW003Cell = GetCell(ruleW003, fontContent, 0);
            ruleW003Cell.BorderWidthTop = 0;
            ruleW003Cell.BorderWidthLeft = 0;
            ruleW003Cell.BorderWidthBottom = 0;
            ruleW003Cell.Colspan = 20;
            var ruleW004Cell = GetCell(ruleW004, fontContent, 0);
            ruleW004Cell.BorderWidthTop = 0;
            ruleW004Cell.BorderWidthLeft = 0;
            ruleW004Cell.BorderWidthBottom = 0;
            ruleW004Cell.Colspan = 20;
            var ruleW005Cell = GetCell(ruleW005, fontContent, 0);
            ruleW005Cell.BorderWidthTop = 0;
            ruleW005Cell.BorderWidthLeft = 0;
            ruleW005Cell.BorderWidthBottom = 0;
            ruleW005Cell.Colspan = 20;
            var ruleW006Cell = GetCell(ruleW006, fontContent, 0);
            ruleW006Cell.BorderWidthTop = 0;
            ruleW006Cell.BorderWidthLeft = 0;
            ruleW006Cell.BorderWidthBottom = 0;
            ruleW006Cell.Colspan = 20;
            var ruleW007Cell = GetCell(ruleW007, fontContent, 0);
            ruleW007Cell.BorderWidthTop = 0;
            ruleW007Cell.BorderWidthLeft = 0;
            ruleW007Cell.BorderWidthBottom = 0;
            ruleW007Cell.Colspan = 20;
            var ruleW008Cell = GetCell(ruleW008, fontContent, 0);
            ruleW008Cell.BorderWidthTop = 0;
            ruleW008Cell.BorderWidthLeft = 0;
            ruleW008Cell.BorderWidthBottom = 0;
            ruleW008Cell.Colspan = 20;
            var ruleW009Cell = GetCell(ruleW009, fontContent, 0);
            ruleW009Cell.BorderWidthTop = 0;
            ruleW009Cell.BorderWidthLeft = 0;
            ruleW009Cell.BorderWidthBottom = 0;
            ruleW009Cell.Colspan = 20;
            var ruleW010Cell = GetCell(ruleW010, fontContent, 0);
            ruleW010Cell.BorderWidthTop = 0;
            ruleW010Cell.BorderWidthLeft = 0;
            ruleW010Cell.BorderWidthBottom = 0;
            ruleW010Cell.Colspan = 20;
            var ruleW011Cell = GetCell(ruleW011, fontContent, 0);
            ruleW011Cell.BorderWidthTop = 0;
            ruleW011Cell.BorderWidthLeft = 0;
            ruleW011Cell.BorderWidthBottom = 0;
            ruleW011Cell.Colspan = 20;
            var ruleW012Cell = GetCell(ruleW012, fontContent, 0);
            ruleW012Cell.BorderWidthTop = 0;
            ruleW012Cell.BorderWidthLeft = 0;
            ruleW012Cell.BorderWidthBottom = 0;
            ruleW012Cell.Colspan = 20;
            var ruleW013Cell = GetCell(ruleW013, fontContent, 0);
            ruleW013Cell.BorderWidthTop = 0;
            ruleW013Cell.BorderWidthLeft = 0;
            ruleW013Cell.BorderWidthBottom = 0;
            ruleW013Cell.Colspan = 20;
            var ruleW014Cell = GetCell(ruleW014, fontContent, 0);
            ruleW014Cell.BorderWidthTop = 0;
            ruleW014Cell.BorderWidthLeft = 0;
            ruleW014Cell.BorderWidthBottom = 0;
            ruleW014Cell.Colspan = 20;
            var ruleW015Cell = GetCell(ruleW015, fontContent, 0);
            ruleW015Cell.BorderWidthTop = 0;
            ruleW015Cell.BorderWidthLeft = 0;
            ruleW015Cell.BorderWidthBottom = 0;
            ruleW015Cell.Colspan = 20;
            var ruleW016Cell = GetCell(ruleW016, fontContent, 0);
            ruleW016Cell.BorderWidthTop = 0;
            ruleW016Cell.BorderWidthLeft = 0;
            ruleW016Cell.BorderWidthBottom = 0;
            ruleW016Cell.Colspan = 20;
            var ruleW017Cell = GetCell(ruleW017, fontContent, 0);
            ruleW017Cell.BorderWidthTop = 0;
            ruleW017Cell.BorderWidthLeft = 0;
            ruleW017Cell.BorderWidthBottom = 0;
            ruleW017Cell.Colspan = 20;

            var ruleT999Cell = GetCell("其他(请注明)：" + reasonRemark, fontContent, 0);
            ruleT999Cell.BorderWidthTop = 0;
            ruleT999Cell.BorderWidthLeft = 0;
            ruleT999Cell.Colspan = 20;
            #endregion

            #region 生成【尽调原因(规则)】表格
            List<RptRoster> rptRoster1List = new List<RptRoster>();  // 风险提示类反洗钱名单
            List<RptRoster> rptRoster2List = new List<RptRoster>();  // 业务限制类反洗钱名单
            List<RptRoster> rptRoster3List = new List<RptRoster>();  // 政要名单
            foreach (var rptRoster in rptRosterList)
            {
                if (!string.IsNullOrEmpty(rptRoster.RosterType))
                {
                    if (rptRoster.RosterType.Contains(ReportDict.RptRosterType_01))
                    {
                        rptRoster1List.Add(rptRoster);
                    }
                    if (rptRoster.RosterType.Contains(ReportDict.RptRosterType_02))
                    {
                        rptRoster2List.Add(rptRoster);
                    }
                    if (rptRoster.RosterType.Contains(ReportDict.RptRosterType_06))
                    {
                        rptRoster3List.Add(rptRoster);
                    }
                }
            }

            var labReason = GetCell("执行加强型尽职调查的原因", fontContent, 0);
            labReason.Colspan = 3;
            labReason.Rowspan = 28;
            pdfTable.AddCell(labReason);

            pdfTable.AddCell(imgCell_ReasonC001);
            pdfTable.AddCell(ruleC001Cell);

            var reason1RemarkCell = GetCell("缺失或无法核实信息如下： " + reasonRemark, fontContent, 0);
            reason1RemarkCell.Colspan = 21;
            reason1RemarkCell.BorderWidthTop = 0;
            reason1RemarkCell.BorderWidthLeft = 0;
            reason1RemarkCell.BorderWidthBottom = 0;
            pdfTable.AddCell(reason1RemarkCell);

            pdfTable.AddCell(imgCell_ReasonC002);
            pdfTable.AddCell(ruleC002Cell);
            pdfTable.AddCell(imgCell_ReasonC003);
            pdfTable.AddCell(ruleC003Cell);
            pdfTable.AddCell(imgCell_ReasonC004);
            pdfTable.AddCell(ruleC004Cell);
            pdfTable.AddCell(imgCell_ReasonC005);
            pdfTable.AddCell(ruleC005Cell);
            pdfTable.AddCell(imgCell_ReasonC006);
            pdfTable.AddCell(ruleC006Cell);
            pdfTable.AddCell(imgCell_ReasonW001);
            pdfTable.AddCell(ruleW001Cell);
            pdfTable.AddCell(imgCell_ReasonW002);
            pdfTable.AddCell(ruleW002Cell);

            pdfTable.AddCell(imgCell_ReasonW003);
            pdfTable.AddCell(ruleW003Cell);
            // 风险提示类反洗钱名单
            PdfPCell rptRoster01Cell = new PdfPCell();
            rptRoster01Cell.Colspan = 21;
            rptRoster01Cell.BorderWidthTop = 0;
            rptRoster01Cell.BorderWidthLeft = 0;
            rptRoster01Cell.BorderWidthBottom = 0;
            rptRoster01Cell.Table = GetRptRosterList(rptRoster1List, ReportDict.RptRosterType_01, fontContent);
            pdfTable.AddCell(rptRoster01Cell);

            pdfTable.AddCell(imgCell_ReasonW004);
            pdfTable.AddCell(ruleW004Cell);

            pdfTable.AddCell(imgCell_ReasonW005);
            pdfTable.AddCell(ruleW005Cell);
            // 业务限制类反洗钱名单
            PdfPCell rptRoster02Cell = new PdfPCell();
            rptRoster02Cell.Colspan = 21;
            rptRoster02Cell.BorderWidthTop = 0;
            rptRoster02Cell.BorderWidthLeft = 0;
            rptRoster02Cell.BorderWidthBottom = 0;
            rptRoster02Cell.Table = GetRptRosterList(rptRoster2List, ReportDict.RptRosterType_02, fontContent);
            pdfTable.AddCell(rptRoster02Cell);

            pdfTable.AddCell(imgCell_ReasonW006);
            pdfTable.AddCell(ruleW006Cell);
            pdfTable.AddCell(imgCell_ReasonW007);
            pdfTable.AddCell(ruleW007Cell);
            pdfTable.AddCell(imgCell_ReasonW008);
            pdfTable.AddCell(ruleW008Cell);
            pdfTable.AddCell(imgCell_ReasonW009);
            pdfTable.AddCell(ruleW009Cell);
            pdfTable.AddCell(imgCell_ReasonW010);
            pdfTable.AddCell(ruleW010Cell);
            pdfTable.AddCell(imgCell_ReasonW011);
            pdfTable.AddCell(ruleW011Cell);
            pdfTable.AddCell(imgCell_ReasonW012);
            pdfTable.AddCell(ruleW012Cell);
            pdfTable.AddCell(imgCell_ReasonW013);
            pdfTable.AddCell(ruleW013Cell);
            pdfTable.AddCell(imgCell_ReasonW014);
            pdfTable.AddCell(ruleW014Cell);

            pdfTable.AddCell(imgCell_ReasonW015);
            pdfTable.AddCell(ruleW015Cell);
            // 政要名单
            PdfPCell rptRoster03Cell = new PdfPCell();
            rptRoster03Cell.Colspan = 21;
            rptRoster03Cell.BorderWidthTop = 0;
            rptRoster03Cell.BorderWidthLeft = 0;
            rptRoster03Cell.BorderWidthBottom = 0;
            rptRoster03Cell.Table = GetRptRosterList(rptRoster3List, ReportDict.RptRosterType_06, fontContent);
            pdfTable.AddCell(rptRoster03Cell);

            pdfTable.AddCell(imgCell_ReasonW016);
            pdfTable.AddCell(ruleW016Cell);
            pdfTable.AddCell(imgCell_ReasonW017);
            pdfTable.AddCell(ruleW017Cell);
            pdfTable.AddCell(imgCell_ReasonT999);
            pdfTable.AddCell(ruleT999Cell);
            #endregion
        }

        /// <summary>
        /// 创建【反洗钱名单】表格
        /// </summary>
        /// <param name="surveyReason"></param>
        /// <param name="reasonRemark"></param>
        /// <param name="font"></param>
        /// <returns>PdfPTable</returns>
        public static PdfPTable GetRptRosterList(List<RptRoster> rptRosterList, 
            string rosterType, Font fontContent)
        {
            PdfPTable rptRosterTab;

            #region 生成【反洗钱名单】表格
            if (rosterType.Equals(ReportDict.RptRosterType_06))  // 政要名单
            {
                rptRosterTab = new PdfPTable(4);   // 表格有 4 列 
                //rptRosterTab.PaddingTop = 0;    // 单元格边界和内容间距
                //rptRosterTab.SpacingAfter = 0;  // 单元格和表格边界
                //rptRosterTab.SpacingBefore = 0;
                // rptRosterTab.SetWidths(new int[] { 4, 4, 4, 4 });

                PdfPCell lblName = GetCell("姓名", fontContent, 1);
                PdfPCell lblNationality = GetCell("国籍", fontContent, 1);
                PdfPCell lblPoliticalPosition = GetCell("政治职务", fontContent, 1);
                PdfPCell lblHitType = GetCell("疑似/真实命中", fontContent, 1);

                rptRosterTab.AddCell(lblName);
                rptRosterTab.AddCell(lblNationality);
                rptRosterTab.AddCell(lblPoliticalPosition);
                rptRosterTab.AddCell(lblHitType);
                // 该行是表头，页数大于 1 时会自动加上表头
                // rptRosterTab.HeaderRows = 1;

                foreach (var rptRoster in rptRosterList)
                {
                    PdfPCell nameCell = GetCell(rptRoster.Name, fontContent, 1);
                    PdfPCell nationalityCell = GetCell(CMBChina.KYC.Web.Code.Dict.DictHelper.GetTreeTermNameByOtherCode(
                                    CMBChina.KYC.Common.Constants.DictConst.WSS_Nation, rptRoster.Nationality),
                                    fontContent, 1);
                    PdfPCell politicalPositionCell = GetCell(rptRoster.PoliticalPosition, fontContent, 1);
                    PdfPCell hitTypeCell = GetCell((ReportDict.HitType_01.Equals(rptRoster.HitType) ? "疑似命中" : "真实命中"), fontContent, 1);

                    rptRosterTab.AddCell(nameCell);
                    rptRosterTab.AddCell(nationalityCell);
                    rptRosterTab.AddCell(politicalPositionCell);
                    rptRosterTab.AddCell(hitTypeCell);
                }
                return rptRosterTab;
            }
            else
            {
                rptRosterTab = new PdfPTable(5);   // 表格有 5 列 
                // rptRosterTab.SetWidths(new int[] { 4, 3, 3, 4, 4 });
                PdfPCell lblName = GetCell("姓名", fontContent, 1);
                PdfPCell lblIDType = GetCell("与客户关系", fontContent, 1);
                PdfPCell lblHitType = GetCell("疑似/真实命中", fontContent, 1);
                PdfPCell lblListName = GetCell("名单列表", fontContent, 1);
                PdfPCell lblEntryName = GetCell("名单名称", fontContent, 1);
                rptRosterTab.AddCell(lblName);
                rptRosterTab.AddCell(lblIDType);
                rptRosterTab.AddCell(lblHitType);
                rptRosterTab.AddCell(lblListName);
                rptRosterTab.AddCell(lblEntryName);
                // 该行是表头，页数大于 1 时会自动加上表头
                // rptRosterTab.HeaderRows = 1;

                foreach (var rptRoster in rptRosterList)
                {
                    PdfPCell nameCell = GetCell(rptRoster.Name, fontContent, 1);
                    PdfPCell idTypeCell = GetCell((ReportDict.IDType_01.Equals(rptRoster.IDType) ? "客户主体" : "受益所有人"), fontContent, 1);
                    PdfPCell hitTypeCell = GetCell((ReportDict.HitType_01.Equals(rptRoster.HitType) ? "疑似命中" : "真实命中"), fontContent, 1);
                    PdfPCell listNameCell = GetCell(rptRoster.ListName, fontContent, 1);
                    PdfPCell entryNameCell = GetCell(rptRoster.EntryName, fontContent, 1);

                    rptRosterTab.AddCell(nameCell);
                    rptRosterTab.AddCell(idTypeCell);
                    rptRosterTab.AddCell(hitTypeCell);
                    rptRosterTab.AddCell(listNameCell);
                    rptRosterTab.AddCell(entryNameCell);
                }

                return rptRosterTab;
            }
            #endregion
        }

        /// <summary>
        /// 创建【尽调方式】表格
        /// </summary>
        /// <param name="surveyMethod"></param>
        /// <param name="visitAddress"></param>
        /// <param name="methodRemark"></param>
        /// <param name="font"></param>
        /// <returns>PdfPTable</returns>
        public static PdfPTable GetMethodTab(string surveyMethod, string visitAddress,
             string methodRemark, Font fontContent)
        {
            #region 处理 CheckBox 图标
            string chk_F_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\CheckBox_False.bmp";
            string chk_T_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\CheckBox_True.bmp";

            var imgCell_Method1 = new PdfPCell();
            imgCell_Method1.BorderWidth = 0;
            imgCell_Method1.HorizontalAlignment = 2;
            var imgCell_Method2 = new PdfPCell();
            imgCell_Method2.BorderWidth = 0;
            imgCell_Method2.HorizontalAlignment = 2;
            var imgCell_Method3 = new PdfPCell();
            imgCell_Method3.BorderWidth = 0;
            imgCell_Method3.HorizontalAlignment = 2;
            var imgCell_Method4 = new PdfPCell();
            imgCell_Method4.BorderWidth = 0;
            imgCell_Method4.HorizontalAlignment = 2;
            var imgCell_Method5 = new PdfPCell();
            imgCell_Method5.BorderWidth = 0;
            imgCell_Method5.HorizontalAlignment = 2;
            var imgCell_Method6 = new PdfPCell();
            imgCell_Method6.BorderWidth = 0;
            imgCell_Method6.HorizontalAlignment = 2;
            var imgCell_Method7 = new PdfPCell();
            imgCell_Method7.BorderWidth = 0;
            imgCell_Method7.HorizontalAlignment = 2;

            var img_T = iTextSharp.text.Image.GetInstance(chk_T_Url);
            img_T.ScaleToFit(8f, 8f);
            var img_F = iTextSharp.text.Image.GetInstance(chk_F_Url);
            img_F.ScaleToFit(8f, 8f);

            if (!string.IsNullOrEmpty(surveyMethod))
            {
                string[] arrayMethod = surveyMethod.Split(',');
                if (arrayMethod.Contains(ReportDict.SurveyMethod_01))
                {
                    imgCell_Method1.AddElement(img_T);
                }
                else
                {
                    imgCell_Method1.AddElement(img_F);
                }
                if (arrayMethod.Contains(ReportDict.SurveyMethod_02))
                {
                    imgCell_Method2.AddElement(img_T);
                }
                else
                {
                    imgCell_Method2.AddElement(img_F);
                }
                if (arrayMethod.Contains(ReportDict.SurveyMethod_03))
                {
                    imgCell_Method3.AddElement(img_T);
                }
                else
                {
                    imgCell_Method3.AddElement(img_F);
                }
                if (arrayMethod.Contains(ReportDict.SurveyMethod_04))
                {
                    imgCell_Method4.AddElement(img_T);
                }
                else
                {
                    imgCell_Method4.AddElement(img_F);
                }
                if (arrayMethod.Contains(ReportDict.SurveyMethod_05))
                {
                    imgCell_Method5.AddElement(img_T);
                }
                else
                {
                    imgCell_Method5.AddElement(img_F);
                }
                if (arrayMethod.Contains(ReportDict.SurveyMethod_06))
                {
                    imgCell_Method6.AddElement(img_T);
                }
                else
                {
                    imgCell_Method6.AddElement(img_F);
                }
                if (arrayMethod.Contains(ReportDict.SurveyMethod_07))
                {
                    imgCell_Method7.AddElement(img_T);
                }
                else
                {
                    imgCell_Method7.AddElement(img_F);
                }
            }
            else
            {
                imgCell_Method1.AddElement(img_F);
                imgCell_Method2.AddElement(img_F);
                imgCell_Method3.AddElement(img_F);
                imgCell_Method4.AddElement(img_F);
                imgCell_Method5.AddElement(img_F);
                imgCell_Method6.AddElement(img_F);
                imgCell_Method7.AddElement(img_F);
            }
            #endregion

            #region 创建【尽调方式】表格
            var method1Cell = GetCell("上门核实（请注明地址）：" + visitAddress, fontContent, 0);
            method1Cell.BorderWidth = 0;
            var method2Cell = GetCell("补充工商查询、查册资料或公司章程等文档资料", fontContent, 0);
            method2Cell.BorderWidth = 0;
            var method3Cell = GetCell("补充客户经营性资料", fontContent, 0);
            method3Cell.BorderWidth = 0;
            var method4Cell = GetCell("网络查询", fontContent, 0);
            method4Cell.BorderWidth = 0;
            var method5Cell = GetCell("电话回访", fontContent, 0);
            method5Cell.BorderWidth = 0;
            var method6Cell = GetCell("邮寄方式核实", fontContent, 0);
            method6Cell.BorderWidth = 0;
            var method7Cell = GetCell("其他（请注明）：" + methodRemark, fontContent, 0);
            method7Cell.BorderWidth = 0;

            PdfPTable methodTab = new PdfPTable(
                 new float[] { 20, 600 }
            );

            methodTab.AddCell(imgCell_Method1);
            methodTab.AddCell(method1Cell);
            methodTab.AddCell(imgCell_Method2);
            methodTab.AddCell(method2Cell);
            methodTab.AddCell(imgCell_Method3);
            methodTab.AddCell(method3Cell);
            methodTab.AddCell(imgCell_Method4);
            methodTab.AddCell(method4Cell);
            methodTab.AddCell(imgCell_Method5);
            methodTab.AddCell(method5Cell);
            methodTab.AddCell(imgCell_Method6);
            methodTab.AddCell(method6Cell);
            methodTab.AddCell(imgCell_Method7);
            methodTab.AddCell(method7Cell);
            #endregion

            return methodTab;
        }

        /// <summary>
        /// 创建【尽调内容】
        /// </summary>
        /// <param name="surveyContent"></param>
        /// <param name="pdfTable"></param>
        /// <param name="font"></param>
        public static void SetContentToTab(string surveyContent, PdfPTable pdfTable, Font fontContent)
        {
            #region 处理 RadioButton 图标
            string radio_Y_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\RadioButton_Y.bmp";
            string radio_N_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\RadioButton_N.bmp";

            var img_Y = iTextSharp.text.Image.GetInstance(radio_Y_Url);
            img_Y.ScaleToFit(8f, 8f);
            var img_N = iTextSharp.text.Image.GetInstance(radio_N_Url);
            img_N.ScaleToFit(8f, 8f);

            var imgCell_Con1Yes = new PdfPCell();
            imgCell_Con1Yes.BorderWidth = 0;
            imgCell_Con1Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Con1No = new PdfPCell();
            imgCell_Con1No.BorderWidth = 0;
            imgCell_Con1No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Con2Yes = new PdfPCell();
            imgCell_Con2Yes.BorderWidth = 0;
            imgCell_Con2Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Con2No = new PdfPCell();
            imgCell_Con2No.BorderWidth = 0;
            imgCell_Con2No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Con3_1Yes = new PdfPCell();
            imgCell_Con3_1Yes.BorderWidth = 0;
            imgCell_Con3_1Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Con3_1No = new PdfPCell();
            imgCell_Con3_1No.BorderWidth = 0;
            imgCell_Con3_1No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Con3_2Yes = new PdfPCell();
            imgCell_Con3_2Yes.BorderWidth = 0;
            imgCell_Con3_2Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Con3_2No = new PdfPCell();
            imgCell_Con3_2No.BorderWidth = 0;
            imgCell_Con3_2No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Con3_3Yes = new PdfPCell();
            imgCell_Con3_3Yes.BorderWidth = 0;
            imgCell_Con3_3Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Con3_3No = new PdfPCell();
            imgCell_Con3_3No.BorderWidth = 0;
            imgCell_Con3_3No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Con3_4Yes = new PdfPCell();
            imgCell_Con3_4Yes.BorderWidth = 0;
            imgCell_Con3_4Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Con3_4No = new PdfPCell();
            imgCell_Con3_4No.BorderWidth = 0;
            imgCell_Con3_4No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Con4_1Yes = new PdfPCell();
            imgCell_Con4_1Yes.BorderWidth = 0;
            imgCell_Con4_1Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Con4_1No = new PdfPCell();
            imgCell_Con4_1No.BorderWidth = 0;
            imgCell_Con4_1No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Con4_2Yes = new PdfPCell();
            imgCell_Con4_2Yes.BorderWidth = 0;
            imgCell_Con4_2Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Con4_2No = new PdfPCell();
            imgCell_Con4_2No.BorderWidth = 0;
            imgCell_Con4_2No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Con4_3Yes = new PdfPCell();
            imgCell_Con4_3Yes.BorderWidth = 0;
            imgCell_Con4_3Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Con4_3No = new PdfPCell();
            imgCell_Con4_3No.BorderWidth = 0;
            imgCell_Con4_3No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Con4_4Yes = new PdfPCell();
            imgCell_Con4_4Yes.BorderWidth = 0;
            imgCell_Con4_4Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Con4_4No = new PdfPCell();
            imgCell_Con4_4No.BorderWidth = 0;
            imgCell_Con4_4No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Con4_5Yes = new PdfPCell();
            imgCell_Con4_5Yes.BorderWidth = 0;
            imgCell_Con4_5Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Con4_5No = new PdfPCell();
            imgCell_Con4_5No.BorderWidth = 0;
            imgCell_Con4_5No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Con4_6Yes = new PdfPCell();
            imgCell_Con4_6Yes.BorderWidth = 0;
            imgCell_Con4_6Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Con4_6No = new PdfPCell();
            imgCell_Con4_6No.BorderWidth = 0;
            imgCell_Con4_6No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Con5_1Yes = new PdfPCell();
            imgCell_Con5_1Yes.BorderWidth = 0;
            imgCell_Con5_1Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Con5_1No = new PdfPCell();
            imgCell_Con5_1No.BorderWidth = 0;
            imgCell_Con5_1No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Con5_2Yes = new PdfPCell();
            imgCell_Con5_2Yes.BorderWidth = 0;
            imgCell_Con5_2Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Con5_2No = new PdfPCell();
            imgCell_Con5_2No.BorderWidth = 0;
            imgCell_Con5_2No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Con5_4Yes = new PdfPCell();
            imgCell_Con5_4Yes.BorderWidth = 0;
            imgCell_Con5_4Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Con5_4No = new PdfPCell();
            imgCell_Con5_4No.BorderWidth = 0;
            imgCell_Con5_4No.HorizontalAlignment = Element.ALIGN_RIGHT;

            if (!string.IsNullOrEmpty(surveyContent))
            {
                // 尽调内容
                // 总共 15 位字符序列，每一位按顺序代表一个条目，
                // 每个条目有三种取值；Z代表为该条目未选中；Y代表选中“是”，N代表选中“否”。
                // 示例：YZNNYZNYNYZNYNY
                // 条目1：客户或其控股股东、实际控制人或者受益所有人、法定代表人、负责人和授权办理业务人员，
                //        或其交易对手是否来自高风险Ⅰ类国家或地区？
                // 第一位为：Y，代表条目1选中“是”。
                // 条目2：客户或其控股股东、实际控制人或者受益所有人、法定代表人、负责人和授权办理业务人员，
                //        或其交易对手是否属于反洗钱名单政策禁止开户的范围？
                // 第二位为：Z，代表条目2未选中。
                // 以此类推，直到最后一个条目。

                // 条目1
                string strCon1 = surveyContent.Substring(0, 1);
                if (strCon1.Equals("Y"))
                {
                    imgCell_Con1Yes.AddElement(img_Y);
                    imgCell_Con1No.AddElement(img_N);
                }
                else if (strCon1.Equals("N"))
                {
                    imgCell_Con1Yes.AddElement(img_N);
                    imgCell_Con1No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Con1Yes.AddElement(img_N);
                    imgCell_Con1No.AddElement(img_N);
                }

                // 条目2
                string strCon2 = surveyContent.Substring(1, 1);
                if (strCon2.Equals("Y"))
                {
                    imgCell_Con2Yes.AddElement(img_Y);
                    imgCell_Con2No.AddElement(img_N);
                }
                else if (strCon2.Equals("N"))
                {
                    imgCell_Con2Yes.AddElement(img_N);
                    imgCell_Con2No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Con2Yes.AddElement(img_N);
                    imgCell_Con2No.AddElement(img_N);
                }

                // 条目3_1
                string strCon3_1 = surveyContent.Substring(2, 1);
                if (strCon3_1.Equals("Y"))
                {
                    imgCell_Con3_1Yes.AddElement(img_Y);
                    imgCell_Con3_1No.AddElement(img_N);
                }
                else if (strCon3_1.Equals("N"))
                {
                    imgCell_Con3_1Yes.AddElement(img_N);
                    imgCell_Con3_1No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Con3_1Yes.AddElement(img_N);
                    imgCell_Con3_1No.AddElement(img_N);
                }

                // 条目3_2
                string strCon3_2 = surveyContent.Substring(3, 1);
                if (strCon3_2.Equals("Y"))
                {
                    imgCell_Con3_2Yes.AddElement(img_Y);
                    imgCell_Con3_2No.AddElement(img_N);
                }
                else if (strCon3_2.Equals("N"))
                {
                    imgCell_Con3_2Yes.AddElement(img_N);
                    imgCell_Con3_2No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Con3_2Yes.AddElement(img_N);
                    imgCell_Con3_2No.AddElement(img_N);
                }

                // 条目3_3
                string strCon3_3 = surveyContent.Substring(4, 1);
                if (strCon3_3.Equals("Y"))
                {
                    imgCell_Con3_3Yes.AddElement(img_Y);
                    imgCell_Con3_3No.AddElement(img_N);
                }
                else if (strCon3_3.Equals("N"))
                {
                    imgCell_Con3_3Yes.AddElement(img_N);
                    imgCell_Con3_3No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Con3_3Yes.AddElement(img_N);
                    imgCell_Con3_3No.AddElement(img_N);
                }

                // 条目3_4
                string strCon3_4 = surveyContent.Substring(5, 1);
                if (strCon3_4.Equals("Y"))
                {
                    imgCell_Con3_4Yes.AddElement(img_Y);
                    imgCell_Con3_4No.AddElement(img_N);
                }
                else if (strCon3_4.Equals("N"))
                {
                    imgCell_Con3_4Yes.AddElement(img_N);
                    imgCell_Con3_4No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Con3_4Yes.AddElement(img_N);
                    imgCell_Con3_4No.AddElement(img_N);
                }

                // 条目4_1
                string strCon4_1 = surveyContent.Substring(6, 1);
                if (strCon4_1.Equals("Y"))
                {
                    imgCell_Con4_1Yes.AddElement(img_Y);
                    imgCell_Con4_1No.AddElement(img_N);
                }
                else if (strCon4_1.Equals("N"))
                {
                    imgCell_Con4_1Yes.AddElement(img_N);
                    imgCell_Con4_1No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Con4_1Yes.AddElement(img_N);
                    imgCell_Con4_1No.AddElement(img_N);
                }

                // 条目4_2
                string strCon4_2 = surveyContent.Substring(7, 1);
                if (strCon4_2.Equals("Y"))
                {
                    imgCell_Con4_2Yes.AddElement(img_Y);
                    imgCell_Con4_2No.AddElement(img_N);
                }
                else if (strCon4_2.Equals("N"))
                {
                    imgCell_Con4_2Yes.AddElement(img_N);
                    imgCell_Con4_2No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Con4_2Yes.AddElement(img_N);
                    imgCell_Con4_2No.AddElement(img_N);
                }

                // 条目4_3
                string strCon4_3 = surveyContent.Substring(8, 1);
                if (strCon4_3.Equals("Y"))
                {
                    imgCell_Con4_3Yes.AddElement(img_Y);
                    imgCell_Con4_3No.AddElement(img_N);
                }
                else if (strCon4_3.Equals("N"))
                {
                    imgCell_Con4_3Yes.AddElement(img_N);
                    imgCell_Con4_3No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Con4_3Yes.AddElement(img_N);
                    imgCell_Con4_3No.AddElement(img_N);
                }

                // 条目4_4
                string strCon4_4 = surveyContent.Substring(9, 1);
                if (strCon4_4.Equals("Y"))
                {
                    imgCell_Con4_4Yes.AddElement(img_Y);
                    imgCell_Con4_4No.AddElement(img_N);
                }
                else if (strCon4_4.Equals("N"))
                {
                    imgCell_Con4_4Yes.AddElement(img_N);
                    imgCell_Con4_4No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Con4_4Yes.AddElement(img_N);
                    imgCell_Con4_4No.AddElement(img_N);
                }

                // 条目4_5
                string strCon4_5 = surveyContent.Substring(10, 1);
                if (strCon4_5.Equals("Y"))
                {
                    imgCell_Con4_5Yes.AddElement(img_Y);
                    imgCell_Con4_5No.AddElement(img_N);
                }
                else if (strCon4_5.Equals("N"))
                {
                    imgCell_Con4_5Yes.AddElement(img_N);
                    imgCell_Con4_5No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Con4_5Yes.AddElement(img_N);
                    imgCell_Con4_5No.AddElement(img_N);
                }

                // 条目4_6
                string strCon4_6 = surveyContent.Substring(11, 1);
                if (strCon4_6.Equals("Y"))
                {
                    imgCell_Con4_6Yes.AddElement(img_Y);
                    imgCell_Con4_6No.AddElement(img_N);
                }
                else if (strCon4_6.Equals("N"))
                {
                    imgCell_Con4_6Yes.AddElement(img_N);
                    imgCell_Con4_6No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Con4_6Yes.AddElement(img_N);
                    imgCell_Con4_6No.AddElement(img_N);
                }

                // 条目5_1
                string strCon5_1 = surveyContent.Substring(12, 1);
                if (strCon5_1.Equals("Y"))
                {
                    imgCell_Con5_1Yes.AddElement(img_Y);
                    imgCell_Con5_1No.AddElement(img_N);
                }
                else if (strCon5_1.Equals("N"))
                {
                    imgCell_Con5_1Yes.AddElement(img_N);
                    imgCell_Con5_1No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Con5_1Yes.AddElement(img_N);
                    imgCell_Con5_1No.AddElement(img_N);
                }

                // 条目5_2
                string strCon5_2 = surveyContent.Substring(13, 1);
                if (strCon5_2.Equals("Y"))
                {
                    imgCell_Con5_2Yes.AddElement(img_Y);
                    imgCell_Con5_2No.AddElement(img_N);
                }
                else if (strCon5_2.Equals("N"))
                {
                    imgCell_Con5_2Yes.AddElement(img_N);
                    imgCell_Con5_2No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Con5_2Yes.AddElement(img_N);
                    imgCell_Con5_2No.AddElement(img_N);
                }

                // 条目5_4
                string strCon5_4 = surveyContent.Substring(14, 1);
                if (strCon5_4.Equals("Y"))
                {
                    imgCell_Con5_4Yes.AddElement(img_Y);
                    imgCell_Con5_4No.AddElement(img_N);
                }
                else if (strCon5_4.Equals("N"))
                {
                    imgCell_Con5_4Yes.AddElement(img_N);
                    imgCell_Con5_4No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Con5_4Yes.AddElement(img_N);
                    imgCell_Con5_4No.AddElement(img_N);
                }
            }
            else
            {
                imgCell_Con1Yes.AddElement(img_N);
                imgCell_Con1No.AddElement(img_N);
                imgCell_Con2Yes.AddElement(img_N);
                imgCell_Con2No.AddElement(img_N);
                imgCell_Con3_1Yes.AddElement(img_N);
                imgCell_Con3_1No.AddElement(img_N);
                imgCell_Con3_2Yes.AddElement(img_N);
                imgCell_Con3_2No.AddElement(img_N);
                imgCell_Con3_3Yes.AddElement(img_N);
                imgCell_Con3_3No.AddElement(img_N);
                imgCell_Con3_4Yes.AddElement(img_N);
                imgCell_Con3_4No.AddElement(img_N);
                imgCell_Con4_1Yes.AddElement(img_N);
                imgCell_Con4_1No.AddElement(img_N);
                imgCell_Con4_2Yes.AddElement(img_N);
                imgCell_Con4_2No.AddElement(img_N);
                imgCell_Con4_3Yes.AddElement(img_N);
                imgCell_Con4_3No.AddElement(img_N);
                imgCell_Con4_4Yes.AddElement(img_N);
                imgCell_Con4_4No.AddElement(img_N);
                imgCell_Con4_5Yes.AddElement(img_N);
                imgCell_Con4_5No.AddElement(img_N);
                imgCell_Con4_6Yes.AddElement(img_N);
                imgCell_Con4_6No.AddElement(img_N);
                imgCell_Con5_1Yes.AddElement(img_N);
                imgCell_Con5_1No.AddElement(img_N);
                imgCell_Con5_2Yes.AddElement(img_N);
                imgCell_Con5_2No.AddElement(img_N);
                imgCell_Con5_4Yes.AddElement(img_N);
                imgCell_Con5_4No.AddElement(img_N);
            }
            #endregion

            #region 生成【尽调内容】
            var lblContent1 = GetCell("1", fontContent, 0);
            lblContent1.Rowspan = 2;
            lblContent1.Colspan = 2;
            var lblContent2 = GetCell("2", fontContent, 0);
            lblContent2.Rowspan = 2;
            lblContent2.Colspan = 2;
            var lblContent3 = GetCell("3", fontContent, 0);
            lblContent3.Rowspan = 5;
            lblContent3.Colspan = 2;
            var lblContent4 = GetCell("4", fontContent, 0);
            lblContent4.Rowspan = 7;
            lblContent4.Colspan = 2;
            var lblContent5 = GetCell("5", fontContent, 0);
            lblContent5.Rowspan = 4;
            lblContent5.Colspan = 2;

            var content1Cell = GetCell("客户或其控股股东、实际控制人或者受益所有人、法定代表人、负责人和授权办理业务人员，或其交易对手是否来自高风险Ⅰ类国家或地区？", fontContent, 0);
            content1Cell.Colspan = 18;
            var content1_NoticeCell = GetCell("如答案为“是”，除非高级管理层批准，本行不提供开户或其他金融服务。", fontContent, 0);
            content1_NoticeCell.Colspan = 22;
            var content2Cell = GetCell("客户或其控股股东、实际控制人或者受益所有人、法定代表人、负责人和授权办理业务人员，或其交易对手是否属于反洗钱名单政策禁止开户的范围？", fontContent, 0);
            content2Cell.Colspan = 18;
            var content2_NoticeCell = GetCell("如答案为“是”，则本行不提供开户或其他金融服务。", fontContent, 0);
            content2_NoticeCell.Colspan = 22;
            var content3_1Cell = GetCell("客户或其控股股东、实际控制人或者受益所有人、法定代表人、负责人和授权办理业务人员，或其交易对手是否来自高风险Ⅱ类、Ⅲ类国家或地区，毒品犯罪/恐怖融资/跨境诈骗高发、金融透明度低的国家或地区？", fontContent, 0);
            content3_1Cell.Colspan = 18;
            var content3_2Cell = GetCell("3.1客户是否违反我行有关高风险国家或地区业务政策规定，办理涉及高风险I类国家或地区结算业务、涉及高风险II类国家或地区的美元结算业务等，或利用我行结算渠道规避联合国制裁等？", fontContent, 0);
            content3_2Cell.Colspan = 18;
            var content3_3Cell = GetCell("3.2交易的物项是否属于大规模杀伤性武器及相关材料，是否属于联合国的禁运物项等？", fontContent, 0);
            content3_3Cell.Colspan = 18;
            var content3_4Cell = GetCell("3.3与高风险国家或地区的交易，是否存在经济制裁合规风险（包括交易的产品属禁运物资、交易对手或对方银行被制裁、被清算行禁止金融交易等）？", fontContent, 0);
            content3_4Cell.Colspan = 18;
            var content3_5Cell = GetCell("3.1-3.3中任一项答案为“是”，则不予办理开户等各项金融业务。", fontContent, 0);
            content3_5Cell.Colspan = 22;
            var content4_1Cell = GetCell("客户或其控股股东、实际控制人或者受益所有人、法定代表人、负责人和授权办理业务人员，或其交易对手等是否属于外国政要或国际组织的高级管理人员，或其特定关系人？", fontContent, 0);
            content4_1Cell.Colspan = 18;
            var content4_2Cell = GetCell("如答案为“是”，其开户应经客户管理机构高级管理层批准或授权，同时报经分行法律合规部审批，并回答如下问题（4.1-4.5）：", fontContent, 0);
            content4_2Cell.Colspan = 18;
            var content4_3Cell = GetCell("4.1公司从事的业务是否与该政要人物公权力相关？", fontContent, 0);
            content4_3Cell.Colspan = 18;
            var content4_4Cell = GetCell("4.2公司是否收取与政府合约相关的佣金？", fontContent, 0);
            content4_4Cell.Colspan = 18;
            var content4_5Cell = GetCell("4.3预计公司是否会收取政府机构或国有企业的汇款？", fontContent, 0);
            content4_5Cell.Colspan = 18;
            var content4_6Cell = GetCell("4.4是否有涉嫌刑事犯罪等负面新闻报道？", fontContent, 0);
            content4_6Cell.Colspan = 18;
            var content4_7Cell = GetCell("如4.1-4.4中任一项答案为“是”，则不予办理开户等各项金融业务。", fontContent, 0);
            content4_7Cell.Colspan = 22;
            var content5_1Cell = GetCell("5.1国家企业信用公示系统核查是否正常存续？", fontContent, 0);
            content5_1Cell.Colspan = 18;
            var content5_2Cell = GetCell("5.2客户是否被列入严重违法失信企业名单？", fontContent, 0);
            content5_2Cell.Colspan = 18;
            var content5_3Cell = GetCell("如答案为“是”，则本行不提供开户或其他金融服务。", fontContent, 0);
            content5_3Cell.Colspan = 22;
            var content5_4Cell = GetCell("5.3客户是否被列入经营异常名录？", fontContent, 0);
            content5_4Cell.Colspan = 18;

            var lblYes = GetCell("是", fontContent, 0);
            lblYes.BorderWidth = 0;
            lblYes.HorizontalAlignment = Element.ALIGN_RIGHT; 
            var lblNo = GetCell("否", fontContent, 0);
            lblNo.BorderWidth = 0;
            lblNo.HorizontalAlignment = Element.ALIGN_RIGHT; 

            PdfPTable radioCon1Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioCon1Tab.AddCell(imgCell_Con1Yes);
            radioCon1Tab.AddCell(lblYes);
            radioCon1Tab.AddCell(imgCell_Con1No);
            radioCon1Tab.AddCell(lblNo);
            PdfPCell radioCon1Cell = new PdfPCell();
            radioCon1Cell.Table = radioCon1Tab;
            radioCon1Cell.Colspan = 4;

            PdfPTable radioCon2Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioCon2Tab.AddCell(imgCell_Con2Yes);
            radioCon2Tab.AddCell(lblYes);
            radioCon2Tab.AddCell(imgCell_Con2No);
            radioCon2Tab.AddCell(lblNo);
            PdfPCell radioCon2Cell = new PdfPCell();
            radioCon2Cell.Table = radioCon2Tab;
            radioCon2Cell.Colspan = 4;

            PdfPTable radioCon3_1Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioCon3_1Tab.AddCell(imgCell_Con3_1Yes);
            radioCon3_1Tab.AddCell(lblYes);
            radioCon3_1Tab.AddCell(imgCell_Con3_1No);
            radioCon3_1Tab.AddCell(lblNo);
            PdfPCell radioCon3_1Cell = new PdfPCell();
            radioCon3_1Cell.Table = radioCon3_1Tab;
            radioCon3_1Cell.Colspan = 4;

            PdfPTable radioCon3_2Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioCon3_2Tab.AddCell(imgCell_Con3_2Yes);
            radioCon3_2Tab.AddCell(lblYes);
            radioCon3_2Tab.AddCell(imgCell_Con3_2No);
            radioCon3_2Tab.AddCell(lblNo);
            PdfPCell radioCon3_2Cell = new PdfPCell();
            radioCon3_2Cell.Table = radioCon3_2Tab;
            radioCon3_2Cell.Colspan = 4;

            PdfPTable radioCon3_3Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioCon3_3Tab.AddCell(imgCell_Con3_3Yes);
            radioCon3_3Tab.AddCell(lblYes);
            radioCon3_3Tab.AddCell(imgCell_Con3_3No);
            radioCon3_3Tab.AddCell(lblNo);
            PdfPCell radioCon3_3Cell = new PdfPCell();
            radioCon3_3Cell.Table = radioCon3_3Tab;
            radioCon3_3Cell.Colspan = 4;

            PdfPTable radioCon3_4Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioCon3_4Tab.AddCell(imgCell_Con3_4Yes);
            radioCon3_4Tab.AddCell(lblYes);
            radioCon3_4Tab.AddCell(imgCell_Con3_4No);
            radioCon3_4Tab.AddCell(lblNo);
            PdfPCell radioCon3_4Cell = new PdfPCell();
            radioCon3_4Cell.Table = radioCon3_4Tab;
            radioCon3_4Cell.Colspan = 4;

            PdfPTable radioCon4_1Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioCon4_1Tab.AddCell(imgCell_Con4_1Yes);
            radioCon4_1Tab.AddCell(lblYes);
            radioCon4_1Tab.AddCell(imgCell_Con4_1No);
            radioCon4_1Tab.AddCell(lblNo);
            PdfPCell radioCon4_1Cell = new PdfPCell();
            radioCon4_1Cell.Table = radioCon4_1Tab;
            radioCon4_1Cell.Colspan = 4;

            PdfPTable radioCon4_2Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioCon4_2Tab.AddCell(imgCell_Con4_2Yes);
            radioCon4_2Tab.AddCell(lblYes);
            radioCon4_2Tab.AddCell(imgCell_Con4_2No);
            radioCon4_2Tab.AddCell(lblNo);
            PdfPCell radioCon4_2Cell = new PdfPCell();
            radioCon4_2Cell.Table = radioCon4_2Tab;
            radioCon4_2Cell.Colspan = 4;

            PdfPTable radioCon4_3Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioCon4_3Tab.AddCell(imgCell_Con4_3Yes);
            radioCon4_3Tab.AddCell(lblYes);
            radioCon4_3Tab.AddCell(imgCell_Con4_3No);
            radioCon4_3Tab.AddCell(lblNo);
            PdfPCell radioCon4_3Cell = new PdfPCell();
            radioCon4_3Cell.Table = radioCon4_3Tab;
            radioCon4_3Cell.Colspan = 4;

            PdfPTable radioCon4_4Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioCon4_4Tab.AddCell(imgCell_Con4_4Yes);
            radioCon4_4Tab.AddCell(lblYes);
            radioCon4_4Tab.AddCell(imgCell_Con4_4No);
            radioCon4_4Tab.AddCell(lblNo);
            PdfPCell radioCon4_4Cell = new PdfPCell();
            radioCon4_4Cell.Table = radioCon4_4Tab;
            radioCon4_4Cell.Colspan = 4;

            PdfPTable radioCon4_5Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioCon4_5Tab.AddCell(imgCell_Con4_5Yes);
            radioCon4_5Tab.AddCell(lblYes);
            radioCon4_5Tab.AddCell(imgCell_Con4_5No);
            radioCon4_5Tab.AddCell(lblNo);
            PdfPCell radioCon4_5Cell = new PdfPCell();
            radioCon4_5Cell.Table = radioCon4_5Tab;
            radioCon4_5Cell.Colspan = 4;

            PdfPTable radioCon4_6Tab = new PdfPTable(
               new float[] { 12, 18, 12, 18 }
            );
            radioCon4_6Tab.AddCell(imgCell_Con4_6Yes);
            radioCon4_6Tab.AddCell(lblYes);
            radioCon4_6Tab.AddCell(imgCell_Con4_6No);
            radioCon4_6Tab.AddCell(lblNo);
            PdfPCell radioCon4_6Cell = new PdfPCell();
            radioCon4_6Cell.Table = radioCon4_6Tab;
            radioCon4_6Cell.Colspan = 4;

            PdfPTable radioCon5_1Tab = new PdfPTable(
               new float[] { 12, 18, 12, 18 }
            );
            radioCon5_1Tab.AddCell(imgCell_Con5_1Yes);
            radioCon5_1Tab.AddCell(lblYes);
            radioCon5_1Tab.AddCell(imgCell_Con5_1No);
            radioCon5_1Tab.AddCell(lblNo);
            PdfPCell radioCon5_1Cell = new PdfPCell();
            radioCon5_1Cell.Table = radioCon5_1Tab;
            radioCon5_1Cell.Colspan = 4;

            PdfPTable radioCon5_2Tab = new PdfPTable(
               new float[] { 12, 18, 12, 18 }
            );
            radioCon5_2Tab.AddCell(imgCell_Con5_2Yes);
            radioCon5_2Tab.AddCell(lblYes);
            radioCon5_2Tab.AddCell(imgCell_Con5_2No);
            radioCon5_2Tab.AddCell(lblNo);
            PdfPCell radioCon5_2Cell = new PdfPCell();
            radioCon5_2Cell.Table = radioCon5_2Tab;
            radioCon5_2Cell.Colspan = 4;

            PdfPTable radioCon5_4Tab = new PdfPTable(
               new float[] { 12, 18, 12, 18 }
            );
            radioCon5_4Tab.AddCell(imgCell_Con5_4Yes);
            radioCon5_4Tab.AddCell(lblYes);
            radioCon5_4Tab.AddCell(imgCell_Con5_4No);
            radioCon5_4Tab.AddCell(lblNo);
            PdfPCell radioCon5_4Cell = new PdfPCell();
            radioCon5_4Cell.Table = radioCon5_4Tab;
            radioCon5_4Cell.Colspan = 4;

            pdfTable.AddCell(lblContent1);
            pdfTable.AddCell(content1Cell);
            pdfTable.AddCell(radioCon1Cell);
            pdfTable.AddCell(content1_NoticeCell);

            pdfTable.AddCell(lblContent2);
            pdfTable.AddCell(content2Cell);
            pdfTable.AddCell(radioCon2Cell);
            pdfTable.AddCell(content2_NoticeCell);

            pdfTable.AddCell(lblContent3);
            pdfTable.AddCell(content3_1Cell);
            pdfTable.AddCell(radioCon3_1Cell);
            pdfTable.AddCell(content3_2Cell);
            pdfTable.AddCell(radioCon3_2Cell);
            pdfTable.AddCell(content3_3Cell);
            pdfTable.AddCell(radioCon3_3Cell);
            pdfTable.AddCell(content3_4Cell);
            pdfTable.AddCell(radioCon3_4Cell);
            pdfTable.AddCell(content3_5Cell);

            pdfTable.AddCell(lblContent4);
            pdfTable.AddCell(content4_1Cell);
            pdfTable.AddCell(radioCon4_1Cell);
            pdfTable.AddCell(content4_2Cell);
            pdfTable.AddCell(radioCon4_2Cell);
            pdfTable.AddCell(content4_3Cell);
            pdfTable.AddCell(radioCon4_3Cell);
            pdfTable.AddCell(content4_4Cell);
            pdfTable.AddCell(radioCon4_4Cell);
            pdfTable.AddCell(content4_5Cell);
            pdfTable.AddCell(radioCon4_5Cell);
            pdfTable.AddCell(content4_6Cell);
            pdfTable.AddCell(radioCon4_6Cell);
            pdfTable.AddCell(content4_7Cell);

            pdfTable.AddCell(lblContent5);
            pdfTable.AddCell(content5_1Cell);
            pdfTable.AddCell(radioCon5_1Cell);
            pdfTable.AddCell(content5_2Cell);
            pdfTable.AddCell(radioCon5_2Cell);
            pdfTable.AddCell(content5_3Cell);
            pdfTable.AddCell(content5_4Cell);
            pdfTable.AddCell(radioCon5_4Cell);
            #endregion
        }

        /// <summary>
        /// 创建【交易背景】
        /// </summary>
        /// <param name="tradingBackground"></param>
        /// <param name="backgroundRemark"></param>
        /// <param name="pdfTable"></param>
        /// <param name="font"></param>
        public static void SetBackgroundToTab(string tradingBackground, 
              string backgroundRemark, PdfPTable pdfTable, Font fontContent)
        {
            #region 处理 RadioButton 图标
            string radio_Y_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\RadioButton_Y.bmp";
            string radio_N_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\RadioButton_N.bmp";

            var img_Y = iTextSharp.text.Image.GetInstance(radio_Y_Url);
            img_Y.ScaleToFit(8f, 8f);
            var img_N = iTextSharp.text.Image.GetInstance(radio_N_Url);
            img_N.ScaleToFit(8f, 8f);

            var imgCell_Background1Yes = new PdfPCell();
            imgCell_Background1Yes.BorderWidth = 0;
            imgCell_Background1Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Background1No = new PdfPCell();
            imgCell_Background1No.BorderWidth = 0;
            imgCell_Background1No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Background2Yes = new PdfPCell();
            imgCell_Background2Yes.BorderWidth = 0;
            imgCell_Background2Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Background2No = new PdfPCell();
            imgCell_Background2No.BorderWidth = 0;
            imgCell_Background2No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Background3Yes = new PdfPCell();
            imgCell_Background3Yes.BorderWidth = 0;
            imgCell_Background3Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Background3No = new PdfPCell();
            imgCell_Background3No.BorderWidth = 0;
            imgCell_Background3No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Background4Yes = new PdfPCell();
            imgCell_Background4Yes.BorderWidth = 0;
            imgCell_Background4Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Background4No = new PdfPCell();
            imgCell_Background4No.BorderWidth = 0;
            imgCell_Background4No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Background5Yes = new PdfPCell();
            imgCell_Background5Yes.BorderWidth = 0;
            imgCell_Background5Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Background5No = new PdfPCell();
            imgCell_Background5No.BorderWidth = 0;
            imgCell_Background5No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Background6Yes = new PdfPCell();
            imgCell_Background6Yes.BorderWidth = 0;
            imgCell_Background6Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Background6No = new PdfPCell();
            imgCell_Background6No.BorderWidth = 0;
            imgCell_Background6No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Background7Yes = new PdfPCell();
            imgCell_Background7Yes.BorderWidth = 0;
            imgCell_Background7Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Background7No = new PdfPCell();
            imgCell_Background7No.BorderWidth = 0;
            imgCell_Background7No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Background8Yes = new PdfPCell();
            imgCell_Background8Yes.BorderWidth = 0;
            imgCell_Background8Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Background8No = new PdfPCell();
            imgCell_Background8No.BorderWidth = 0;
            imgCell_Background8No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Background9Yes = new PdfPCell();
            imgCell_Background9Yes.BorderWidth = 0;
            imgCell_Background9Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Background9No = new PdfPCell();
            imgCell_Background9No.BorderWidth = 0;
            imgCell_Background9No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Background10Yes = new PdfPCell();
            imgCell_Background10Yes.BorderWidth = 0;
            imgCell_Background10Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Background10No = new PdfPCell();
            imgCell_Background10No.BorderWidth = 0;
            imgCell_Background10No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Background11Yes = new PdfPCell();
            imgCell_Background11Yes.BorderWidth = 0;
            imgCell_Background11Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Background11No = new PdfPCell();
            imgCell_Background11No.BorderWidth = 0;
            imgCell_Background11No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Background12Yes = new PdfPCell();
            imgCell_Background12Yes.BorderWidth = 0;
            imgCell_Background12Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Background12No = new PdfPCell();
            imgCell_Background12No.BorderWidth = 0;
            imgCell_Background12No.HorizontalAlignment = Element.ALIGN_RIGHT;

            var imgCell_Background13Yes = new PdfPCell();
            imgCell_Background13Yes.BorderWidth = 0;
            imgCell_Background13Yes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var imgCell_Background13No = new PdfPCell();
            imgCell_Background13No.BorderWidth = 0;
            imgCell_Background13No.HorizontalAlignment = Element.ALIGN_RIGHT;

            if (!string.IsNullOrEmpty(tradingBackground))
            {
                // 交易背景
                // 总共 13 位字符序列，每一位按顺序代表一个条目，
                // 每个条目有三种取值；Z代表为该条目未选中；Y代表选中“是”，N代表选中“否”。
                // 示例：YZNNYZNYNNNNN
                // 条目1：是否特种行业客户（如：珠宝、古董、贵金属、艺术品、拍卖、典当行或当铺、娱乐场所、慈善团体、非盈利机构、跨国捐款团队、
                //        货币兑换、汇款商或汇款代理、网贷平台、不受监管的金融机构、咨询或中介机构、与武器相关的行业、高科技行业），是否没有取得经营许可证？
                // 第一位为：Y，代表条目1选中“是”。
                // 条目2：客户是否属于空壳公司，并无实质业务？
                // 第二位为：Z，代表条目2未选中。
                // 以此类推，直到最后一个条目。

                // 条目1
                string strBackground1 = tradingBackground.Substring(0, 1);
                if (strBackground1.Equals("Y"))
                {
                    imgCell_Background1Yes.AddElement(img_Y);
                    imgCell_Background1No.AddElement(img_N);
                }
                else if (strBackground1.Equals("N"))
                {
                    imgCell_Background1Yes.AddElement(img_N);
                    imgCell_Background1No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Background1Yes.AddElement(img_N);
                    imgCell_Background1No.AddElement(img_N);
                }

                // 条目2
                string strBackground2 = tradingBackground.Substring(1, 1);
                if (strBackground2.Equals("Y"))
                {
                    imgCell_Background2Yes.AddElement(img_Y);
                    imgCell_Background2No.AddElement(img_N);
                }
                else if (strBackground2.Equals("N"))
                {
                    imgCell_Background2Yes.AddElement(img_N);
                    imgCell_Background2No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Background2Yes.AddElement(img_N);
                    imgCell_Background2No.AddElement(img_N);
                }

                // 条目3
                string strBackground3 = tradingBackground.Substring(2, 1);
                if (strBackground3.Equals("Y"))
                {
                    imgCell_Background3Yes.AddElement(img_Y);
                    imgCell_Background3No.AddElement(img_N);
                }
                else if (strBackground3.Equals("N"))
                {
                    imgCell_Background3Yes.AddElement(img_N);
                    imgCell_Background3No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Background3Yes.AddElement(img_N);
                    imgCell_Background3No.AddElement(img_N);
                }

                // 条目4
                string strBackground4 = tradingBackground.Substring(3, 1);
                if (strBackground4.Equals("Y"))
                {
                    imgCell_Background4Yes.AddElement(img_Y);
                    imgCell_Background4No.AddElement(img_N);
                }
                else if (strBackground4.Equals("N"))
                {
                    imgCell_Background4Yes.AddElement(img_N);
                    imgCell_Background4No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Background4Yes.AddElement(img_N);
                    imgCell_Background4No.AddElement(img_N);
                }

                // 条目5
                string strBackground5 = tradingBackground.Substring(4, 1);
                if (strBackground5.Equals("Y"))
                {
                    imgCell_Background5Yes.AddElement(img_Y);
                    imgCell_Background5No.AddElement(img_N);
                }
                else if (strBackground5.Equals("N"))
                {
                    imgCell_Background5Yes.AddElement(img_N);
                    imgCell_Background5No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Background5Yes.AddElement(img_N);
                    imgCell_Background5No.AddElement(img_N);
                }

                // 条目6
                string strBackground6 = tradingBackground.Substring(5, 1);
                if (strBackground6.Equals("Y"))
                {
                    imgCell_Background6Yes.AddElement(img_Y);
                    imgCell_Background6No.AddElement(img_N);
                }
                else if (strBackground6.Equals("N"))
                {
                    imgCell_Background6Yes.AddElement(img_N);
                    imgCell_Background6No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Background6Yes.AddElement(img_N);
                    imgCell_Background6No.AddElement(img_N);
                }

                // 条目7
                string strBackground7 = tradingBackground.Substring(6, 1);
                if (strBackground7.Equals("Y"))
                {
                    imgCell_Background7Yes.AddElement(img_Y);
                    imgCell_Background7No.AddElement(img_N);
                }
                else if (strBackground7.Equals("N"))
                {
                    imgCell_Background7Yes.AddElement(img_N);
                    imgCell_Background7No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Background7Yes.AddElement(img_N);
                    imgCell_Background7No.AddElement(img_N);
                }

                // 条目8
                string strBackground8 = tradingBackground.Substring(7, 1);
                if (strBackground8.Equals("Y"))
                {
                    imgCell_Background8Yes.AddElement(img_Y);
                    imgCell_Background8No.AddElement(img_N);
                }
                else if (strBackground8.Equals("N"))
                {
                    imgCell_Background8Yes.AddElement(img_N);
                    imgCell_Background8No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Background8Yes.AddElement(img_N);
                    imgCell_Background8No.AddElement(img_N);
                }

                // 条目9
                string strBackground9 = tradingBackground.Substring(8, 1);
                if (strBackground9.Equals("Y"))
                {
                    imgCell_Background9Yes.AddElement(img_Y);
                    imgCell_Background9No.AddElement(img_N);
                }
                else if (strBackground9.Equals("N"))
                {
                    imgCell_Background9Yes.AddElement(img_N);
                    imgCell_Background9No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Background9Yes.AddElement(img_N);
                    imgCell_Background9No.AddElement(img_N);
                }

                // 条目10
                string strBackground10 = tradingBackground.Substring(9, 1);
                if (strBackground10.Equals("Y"))
                {
                    imgCell_Background10Yes.AddElement(img_Y);
                    imgCell_Background10No.AddElement(img_N);
                }
                else if (strBackground10.Equals("N"))
                {
                    imgCell_Background10Yes.AddElement(img_N);
                    imgCell_Background10No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Background10Yes.AddElement(img_N);
                    imgCell_Background10No.AddElement(img_N);
                }

                // 条目11
                string strBackground11 = tradingBackground.Substring(10, 1);
                if (strBackground11.Equals("Y"))
                {
                    imgCell_Background11Yes.AddElement(img_Y);
                    imgCell_Background11No.AddElement(img_N);
                }
                else if (strBackground11.Equals("N"))
                {
                    imgCell_Background11Yes.AddElement(img_N);
                    imgCell_Background11No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Background11Yes.AddElement(img_N);
                    imgCell_Background11No.AddElement(img_N);
                }

                // 条目12
                string strBackground12 = tradingBackground.Substring(11, 1);
                if (strBackground12.Equals("Y"))
                {
                    imgCell_Background12Yes.AddElement(img_Y);
                    imgCell_Background12No.AddElement(img_N);
                }
                else if (strBackground12.Equals("N"))
                {
                    imgCell_Background12Yes.AddElement(img_N);
                    imgCell_Background12No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Background12Yes.AddElement(img_N);
                    imgCell_Background12No.AddElement(img_N);
                }

                // 条目13
                string strBackground13 = tradingBackground.Substring(12, 1);
                if (strBackground13.Equals("Y"))
                {
                    imgCell_Background13Yes.AddElement(img_Y);
                    imgCell_Background13No.AddElement(img_N);
                }
                else if (strBackground13.Equals("N"))
                {
                    imgCell_Background13Yes.AddElement(img_N);
                    imgCell_Background13No.AddElement(img_Y);
                }
                else
                {
                    imgCell_Background13Yes.AddElement(img_N);
                    imgCell_Background13No.AddElement(img_N);
                }
            }
            else
            {
                imgCell_Background1Yes.AddElement(img_N);
                imgCell_Background1No.AddElement(img_N);
                imgCell_Background2Yes.AddElement(img_N);
                imgCell_Background2No.AddElement(img_N);
                imgCell_Background3Yes.AddElement(img_N);
                imgCell_Background3No.AddElement(img_N);
                imgCell_Background4Yes.AddElement(img_N);
                imgCell_Background4No.AddElement(img_N);
                imgCell_Background5Yes.AddElement(img_N);
                imgCell_Background5No.AddElement(img_N);
                imgCell_Background6Yes.AddElement(img_N);
                imgCell_Background6No.AddElement(img_N);
                imgCell_Background7Yes.AddElement(img_N);
                imgCell_Background7No.AddElement(img_N);
                imgCell_Background8Yes.AddElement(img_N);
                imgCell_Background8No.AddElement(img_N);
                imgCell_Background9Yes.AddElement(img_N);
                imgCell_Background9No.AddElement(img_N);
                imgCell_Background10Yes.AddElement(img_N);
                imgCell_Background10No.AddElement(img_N);
                imgCell_Background11Yes.AddElement(img_N);
                imgCell_Background11No.AddElement(img_N);
                imgCell_Background12Yes.AddElement(img_N);
                imgCell_Background12No.AddElement(img_N);
                imgCell_Background13Yes.AddElement(img_N);
                imgCell_Background13No.AddElement(img_N);
            }
            #endregion

            #region 生成【交易背景】
            var lblBackground1 = GetCell("1", fontContent, 0);
            lblBackground1.Colspan = 2;
            var lblBackground2 = GetCell("2", fontContent, 0);
            lblBackground2.Colspan = 2;
            var lblBackground3 = GetCell("3", fontContent, 0);
            lblBackground3.Colspan = 2;
            var lblBackground4 = GetCell("4", fontContent, 0);
            lblBackground4.Colspan = 2;
            var lblBackground5 = GetCell("5", fontContent, 0);
            lblBackground5.Colspan = 2;
            var lblBackground6 = GetCell("6", fontContent, 0);
            lblBackground6.Colspan = 2;
            var lblBackground7 = GetCell("7", fontContent, 0);
            lblBackground7.Colspan = 2;
            var lblBackground8 = GetCell("8", fontContent, 0);
            lblBackground8.Colspan = 2;
            var lblBackground9 = GetCell("9", fontContent, 0);
            lblBackground9.Colspan = 2;
            var lblBackground10 = GetCell("10", fontContent, 0);
            lblBackground10.Colspan = 2;
            var lblBackground11 = GetCell("11", fontContent, 0);
            lblBackground11.Colspan = 2;
            var lblBackground12 = GetCell("12", fontContent, 0);
            lblBackground12.Colspan = 2;
            var lblBackground13 = GetCell("13", fontContent, 0);
            lblBackground13.Colspan = 2;
            var lblBackground14 = GetCell("14", fontContent, 0);
            lblBackground14.Colspan = 2;

            var background1Cell = GetCell("是否特种行业客户（如：珠宝、古董、贵金属、艺术品、拍卖、典当行或当铺、娱乐场所、慈善团体、非盈利机构、跨国捐款团队、货币兑换、汇款商或汇款代理、网贷平台、不受监管的金融机构、咨询或中介机构、与武器相关的行业、高科技行业），是否没有取得经营许可证？", fontContent, 0);
            background1Cell.Colspan = 18;
            var background2Cell = GetCell("客户是否属于空壳公司，并无实质业务？", fontContent, 0);
            background2Cell.Colspan = 18;
            var background3Cell = GetCell("客户是否与其他公司公用经营地址，或经营地址存疑？", fontContent, 0);
            background3Cell.Colspan = 18;
            var background4Cell = GetCell("公司股东层级在3个以上，或同一自然人是2个以上单位法定代表人或负责人，或同一办公场所、同一班人马开立2家以上公司的？", fontContent, 0);
            background4Cell.Colspan = 18;
            var background5Cell = GetCell("客户是否经营比特币等虚拟货币交易", fontContent, 0);
            background5Cell.Colspan = 18;
            var background6Cell = GetCell("客户是否被列入“严重违法失信企业名单“？", fontContent, 0);
            background6Cell.Colspan = 18;
            var background7Cell = GetCell("客户或其控股股东、实际控制人或者受益所有人、法定代表人、负责人和授权办理业务人员，或其交易对手是否涉嫌赌博、高息借贷、非法集资、地下钱庄、走私、逃避缴纳税款、非法经营等非法或异常情形？", fontContent, 0);
            background7Cell.Colspan = 18;
            var background8Cell = GetCell("客户账户预期的交易规模、交易模式、交易金额、交易频率、资金的来源和去向，与客户的身份是否明显不符？", fontContent, 0);
            background8Cell.Colspan = 18;
            var background9Cell = GetCell("客户账户预期发生的交易是否与账户开户目的一致？", fontContent, 0);
            background9Cell.Colspan = 18;
            var background10Cell = GetCell("客户的上下游主要交易对手是否为非供应链上的客户？", fontContent, 0);
            background10Cell.Colspan = 18;
            var background11Cell = GetCell("是否存在客户以合法的交易形式掩盖非法目的？", fontContent, 0);
            background11Cell.Colspan = 18;
            var background12Cell = GetCell("客户主要交易对手（如有），是否来自高风险地区，命中或疑似命中反洗钱名单，或者命中或者疑似命中政要名单。", fontContent, 0);
            background12Cell.Colspan = 18;
            var background13Cell = GetCell("客户授权的业务办理人（如有），是否来自高风险地区，命中或疑似命中反洗钱名单，或者命中或者疑似命中政要名单。", fontContent, 0);
            background13Cell.Colspan = 18;
            var background14Cell = GetCell("其他风险因素：" + backgroundRemark, fontContent, 0);
            background14Cell.Colspan = 22;

            var lblYes = GetCell("是", fontContent, 0);
            lblYes.BorderWidth = 0;
            lblYes.HorizontalAlignment = Element.ALIGN_RIGHT;
            var lblNo = GetCell("否", fontContent, 0);
            lblNo.BorderWidth = 0;
            lblNo.HorizontalAlignment = Element.ALIGN_RIGHT;

            PdfPTable radioBackground1Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioBackground1Tab.AddCell(imgCell_Background1Yes);
            radioBackground1Tab.AddCell(lblYes);
            radioBackground1Tab.AddCell(imgCell_Background1No);
            radioBackground1Tab.AddCell(lblNo);
            PdfPCell radioBackground1Cell = new PdfPCell();
            radioBackground1Cell.Table = radioBackground1Tab;
            radioBackground1Cell.Colspan = 4;

            PdfPTable radioBackground2Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioBackground2Tab.AddCell(imgCell_Background2Yes);
            radioBackground2Tab.AddCell(lblYes);
            radioBackground2Tab.AddCell(imgCell_Background2No);
            radioBackground2Tab.AddCell(lblNo);
            PdfPCell radioBackground2Cell = new PdfPCell();
            radioBackground2Cell.Table = radioBackground2Tab;
            radioBackground2Cell.Colspan = 4;

            PdfPTable radioBackground3Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioBackground3Tab.AddCell(imgCell_Background3Yes);
            radioBackground3Tab.AddCell(lblYes);
            radioBackground3Tab.AddCell(imgCell_Background3No);
            radioBackground3Tab.AddCell(lblNo);
            PdfPCell radioBackground3Cell = new PdfPCell();
            radioBackground3Cell.Table = radioBackground3Tab;
            radioBackground3Cell.Colspan = 4;

            PdfPTable radioBackground4Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioBackground4Tab.AddCell(imgCell_Background4Yes);
            radioBackground4Tab.AddCell(lblYes);
            radioBackground4Tab.AddCell(imgCell_Background4No);
            radioBackground4Tab.AddCell(lblNo);
            PdfPCell radioBackground4Cell = new PdfPCell();
            radioBackground4Cell.Table = radioBackground4Tab;
            radioBackground4Cell.Colspan = 4;

            PdfPTable radioBackground5Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioBackground5Tab.AddCell(imgCell_Background5Yes);
            radioBackground5Tab.AddCell(lblYes);
            radioBackground5Tab.AddCell(imgCell_Background5No);
            radioBackground5Tab.AddCell(lblNo);
            PdfPCell radioBackground5Cell = new PdfPCell();
            radioBackground5Cell.Table = radioBackground5Tab;
            radioBackground5Cell.Colspan = 4;

            PdfPTable radioBackground6Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioBackground6Tab.AddCell(imgCell_Background6Yes);
            radioBackground6Tab.AddCell(lblYes);
            radioBackground6Tab.AddCell(imgCell_Background6No);
            radioBackground6Tab.AddCell(lblNo);
            PdfPCell radioBackground6Cell = new PdfPCell();
            radioBackground6Cell.Table = radioBackground6Tab;
            radioBackground6Cell.Colspan = 4;

            PdfPTable radioBackground7Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioBackground7Tab.AddCell(imgCell_Background7Yes);
            radioBackground7Tab.AddCell(lblYes);
            radioBackground7Tab.AddCell(imgCell_Background7No);
            radioBackground7Tab.AddCell(lblNo);
            PdfPCell radioBackground7Cell = new PdfPCell();
            radioBackground7Cell.Table = radioBackground7Tab;
            radioBackground7Cell.Colspan = 4;

            PdfPTable radioBackground8Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioBackground8Tab.AddCell(imgCell_Background8Yes);
            radioBackground8Tab.AddCell(lblYes);
            radioBackground8Tab.AddCell(imgCell_Background8No);
            radioBackground8Tab.AddCell(lblNo);
            PdfPCell radioBackground8Cell = new PdfPCell();
            radioBackground8Cell.Table = radioBackground8Tab;
            radioBackground8Cell.Colspan = 4;

            PdfPTable radioBackground9Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioBackground9Tab.AddCell(imgCell_Background9Yes);
            radioBackground9Tab.AddCell(lblYes);
            radioBackground9Tab.AddCell(imgCell_Background9No);
            radioBackground9Tab.AddCell(lblNo);
            PdfPCell radioBackground9Cell = new PdfPCell();
            radioBackground9Cell.Table = radioBackground9Tab;
            radioBackground9Cell.Colspan = 4;

            PdfPTable radioBackground10Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioBackground10Tab.AddCell(imgCell_Background10Yes);
            radioBackground10Tab.AddCell(lblYes);
            radioBackground10Tab.AddCell(imgCell_Background10No);
            radioBackground10Tab.AddCell(lblNo);
            PdfPCell radioBackground10Cell = new PdfPCell();
            radioBackground10Cell.Table = radioBackground10Tab;
            radioBackground10Cell.Colspan = 4;

            PdfPTable radioBackground11Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioBackground11Tab.AddCell(imgCell_Background11Yes);
            radioBackground11Tab.AddCell(lblYes);
            radioBackground11Tab.AddCell(imgCell_Background11No);
            radioBackground11Tab.AddCell(lblNo);
            PdfPCell radioBackground11Cell = new PdfPCell();
            radioBackground11Cell.Table = radioBackground11Tab;
            radioBackground11Cell.Colspan = 4;

            PdfPTable radioBackground12Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioBackground12Tab.AddCell(imgCell_Background12Yes);
            radioBackground12Tab.AddCell(lblYes);
            radioBackground12Tab.AddCell(imgCell_Background12No);
            radioBackground12Tab.AddCell(lblNo);
            PdfPCell radioBackground12Cell = new PdfPCell();
            radioBackground12Cell.Table = radioBackground12Tab;
            radioBackground12Cell.Colspan = 4;

            PdfPTable radioBackground13Tab = new PdfPTable(
                new float[] { 12, 18, 12, 18 }
            );
            radioBackground13Tab.AddCell(imgCell_Background13Yes);
            radioBackground13Tab.AddCell(lblYes);
            radioBackground13Tab.AddCell(imgCell_Background13No);
            radioBackground13Tab.AddCell(lblNo);
            PdfPCell radioBackground13Cell = new PdfPCell();
            radioBackground13Cell.Table = radioBackground13Tab;
            radioBackground13Cell.Colspan = 4;

            pdfTable.AddCell(lblBackground1);
            pdfTable.AddCell(background1Cell);
            pdfTable.AddCell(radioBackground1Cell);

            pdfTable.AddCell(lblBackground2);
            pdfTable.AddCell(background2Cell);
            pdfTable.AddCell(radioBackground2Cell);

            pdfTable.AddCell(lblBackground3);
            pdfTable.AddCell(background3Cell);
            pdfTable.AddCell(radioBackground3Cell);

            pdfTable.AddCell(lblBackground4);
            pdfTable.AddCell(background4Cell);
            pdfTable.AddCell(radioBackground4Cell);

            pdfTable.AddCell(lblBackground5);
            pdfTable.AddCell(background5Cell);
            pdfTable.AddCell(radioBackground5Cell);

            pdfTable.AddCell(lblBackground6);
            pdfTable.AddCell(background6Cell);
            pdfTable.AddCell(radioBackground6Cell);

            pdfTable.AddCell(lblBackground7);
            pdfTable.AddCell(background7Cell);
            pdfTable.AddCell(radioBackground1Cell);

            pdfTable.AddCell(lblBackground8);
            pdfTable.AddCell(background8Cell);
            pdfTable.AddCell(radioBackground8Cell);

            pdfTable.AddCell(lblBackground9);
            pdfTable.AddCell(background9Cell);
            pdfTable.AddCell(radioBackground9Cell);

            pdfTable.AddCell(lblBackground10);
            pdfTable.AddCell(background10Cell);
            pdfTable.AddCell(radioBackground10Cell);

            pdfTable.AddCell(lblBackground11);
            pdfTable.AddCell(background11Cell);
            pdfTable.AddCell(radioBackground11Cell);

            pdfTable.AddCell(lblBackground12);
            pdfTable.AddCell(background12Cell);
            pdfTable.AddCell(radioBackground12Cell);

            pdfTable.AddCell(lblBackground13);
            pdfTable.AddCell(background13Cell);
            pdfTable.AddCell(radioBackground13Cell);

            pdfTable.AddCell(lblBackground14);
            pdfTable.AddCell(background14Cell);
            #endregion
        }

        /// <summary>
        /// 创建【尽调结论】表格
        /// </summary>
        /// <param name="conclusion"></param>
        /// <param name="conclusionRemark"></param>
        /// <param name="font"></param>
        /// <returns>PdfPTable</returns>
        public static PdfPTable GetConclusionTab(string conclusion, string conclusionRemark, Font fontContent)
        {
            #region 处理 RadioButton 图标
            string radio_Y_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\RadioButton_Y.bmp";
            string radio_N_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\RadioButton_N.bmp";

            var img_Y = iTextSharp.text.Image.GetInstance(radio_Y_Url);
            img_Y.ScaleToFit(8f, 8f);
            var img_N = iTextSharp.text.Image.GetInstance(radio_N_Url);
            img_N.ScaleToFit(8f, 8f);

            var imgCell_Pass = new PdfPCell();
            imgCell_Pass.BorderWidth = 0;
            imgCell_Pass.HorizontalAlignment = 2;
            var imgCell_CondPass = new PdfPCell();
            imgCell_CondPass.BorderWidth = 0;
            imgCell_CondPass.HorizontalAlignment = 2;
            var imgCell_NoPass = new PdfPCell();
            imgCell_NoPass.BorderWidth = 0;
            imgCell_NoPass.HorizontalAlignment = 2;

            if (ReportDict.Conclusion_Pass.Equals(conclusion))
            {
                imgCell_Pass.AddElement(img_Y);
                imgCell_CondPass.AddElement(img_N);
                imgCell_NoPass.AddElement(img_N);
            }
            else if (ReportDict.Conclusion_CondPass.Equals(conclusion))
            {
                imgCell_Pass.AddElement(img_N);
                imgCell_CondPass.AddElement(img_Y);
                imgCell_NoPass.AddElement(img_N);
            }
            else if (ReportDict.Conclusion_NoPass.Equals(conclusion))
            {
                imgCell_Pass.AddElement(img_N);
                imgCell_CondPass.AddElement(img_N);
                imgCell_NoPass.AddElement(img_Y);
            }
            else
            {
                imgCell_Pass.AddElement(img_N);
                imgCell_CondPass.AddElement(img_N);
                imgCell_NoPass.AddElement(img_N);
            }
            #endregion

            #region 生成【尽调结论】表格
            var passCell = GetCell("通过", fontContent, 0);
            passCell.BorderWidth = 0;
            var condPassCell = GetCell("有条件通过", fontContent, 0);
            condPassCell.BorderWidth = 0;
            var noPassCell = GetCell("不通过", fontContent, 0);
            noPassCell.BorderWidth = 0;

            PdfPTable conclusionTab = new PdfPTable(
               new float[] { 16, 60, 16, 60, 16, 60, 300 }
            );

            var lblConclusion = GetCell("尽职调查结论（请依据开户目的、客户身份、交易背景等综合分析客户的风险状况）：", fontContent, 0);
            lblConclusion.Colspan = 7;
            lblConclusion.BorderWidth = 0;

            var conclusionRemarkCell = GetCell(conclusionRemark, fontContent, 0);
            conclusionRemarkCell.Colspan = 7;
            conclusionRemarkCell.BorderWidth = 0;

            // 空格，优化显示
            var tempCell = new PdfPCell();
            tempCell.BorderWidth = 0;
            
            // 空行，优化显示
            var tempCol = new PdfPCell();
            tempCol.Colspan = 7;
            tempCol.BorderWidth = 0;

            conclusionTab.AddCell(lblConclusion);
            conclusionTab.AddCell(conclusionRemarkCell);

            conclusionTab.AddCell(tempCol);

            conclusionTab.AddCell(imgCell_Pass);
            conclusionTab.AddCell(passCell);
            conclusionTab.AddCell(imgCell_CondPass);
            conclusionTab.AddCell(condPassCell);
            conclusionTab.AddCell(imgCell_NoPass);
            conclusionTab.AddCell(noPassCell);

            conclusionTab.AddCell(tempCell);
            #endregion

            return conclusionTab;
        }

        /// <summary>
        /// 创建【建议风控措施】表格
        /// </summary>
        /// <param name="suggestion"></param>
        /// <param name="sug5Remark"></param>
        /// <param name="suggestionRemark"></param>
        /// <param name="font"></param>
        /// <returns>PdfPTable</returns>
        public static PdfPTable GetSuggestionTab(string suggestion, string sug5Remark,
             string suggestionRemark, Font fontContent)
        {
            #region 处理 CheckBox 图标
            string chk_F_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\CheckBox_False.bmp";
            string chk_T_Url = System.AppDomain.CurrentDomain.BaseDirectory + @"AutoGen\imgs\CheckBox_True.bmp";
            
            var img_T = iTextSharp.text.Image.GetInstance(chk_T_Url);
            img_T.ScaleToFit(8f, 8f);
            var img_F = iTextSharp.text.Image.GetInstance(chk_F_Url);
            img_F.ScaleToFit(8f, 8f);

            var imgCell_Sug01 = new PdfPCell();
            imgCell_Sug01.BorderWidth = 0;
            imgCell_Sug01.HorizontalAlignment = 2;
            var imgCell_Sug02 = new PdfPCell();
            imgCell_Sug02.BorderWidth = 0;
            imgCell_Sug02.HorizontalAlignment = 2;
            var imgCell_Sug03 = new PdfPCell();
            imgCell_Sug03.BorderWidth = 0;
            imgCell_Sug03.HorizontalAlignment = 2;
            var imgCell_Sug04 = new PdfPCell();
            imgCell_Sug04.BorderWidth = 0;
            imgCell_Sug04.HorizontalAlignment = 2;
            var imgCell_Sug05 = new PdfPCell();
            imgCell_Sug05.BorderWidth = 0;
            imgCell_Sug05.HorizontalAlignment = 2;
            var imgCell_Sug09 = new PdfPCell();
            imgCell_Sug09.BorderWidth = 0;
            imgCell_Sug09.HorizontalAlignment = 2;

            if (!string.IsNullOrEmpty(suggestion))
            {
                string[] arraySuggestion = suggestion.Split(',');
                if (arraySuggestion.Contains(ReportDict.Suggestion_01))
                {
                    imgCell_Sug01.AddElement(img_T);
                }
                else
                {
                    imgCell_Sug01.AddElement(img_F);
                }
                if (arraySuggestion.Contains(ReportDict.Suggestion_02))
                {
                    imgCell_Sug02.AddElement(img_T);
                }
                else
                {
                    imgCell_Sug02.AddElement(img_F);
                }
                if (arraySuggestion.Contains(ReportDict.Suggestion_03))
                {
                    imgCell_Sug03.AddElement(img_T);
                }
                else
                {
                    imgCell_Sug03.AddElement(img_F);
                }
                if (arraySuggestion.Contains(ReportDict.Suggestion_04))
                {
                    imgCell_Sug04.AddElement(img_T);
                }
                else
                {
                    imgCell_Sug04.AddElement(img_F);
                }
                if (arraySuggestion.Contains(ReportDict.Suggestion_05))
                {
                    imgCell_Sug05.AddElement(img_T);
                }
                else
                {
                    imgCell_Sug05.AddElement(img_F);
                }
                if (arraySuggestion.Contains(ReportDict.Suggestion_06))
                {
                    imgCell_Sug09.AddElement(img_T);
                }
                else
                {
                    imgCell_Sug09.AddElement(img_F);
                }
            }
            else
            {
                imgCell_Sug01.AddElement(img_F);
                imgCell_Sug02.AddElement(img_F);
                imgCell_Sug03.AddElement(img_F);
                imgCell_Sug04.AddElement(img_F);
                imgCell_Sug05.AddElement(img_F);
                imgCell_Sug09.AddElement(img_F);
            }
            #endregion

            #region 生成【建议风控措施】表格
            var sug01Cell = GetCell("报告可疑交易；", fontContent, 0);
            sug01Cell.BorderWidth = 0;
            var sug02Cell = GetCell("禁止开展授信业务（增加黑名单标识）；", fontContent, 0);
            sug02Cell.BorderWidth = 0;
            var sug03Cell = GetCell("禁止开立外币账户（增加黑名单标识）；", fontContent, 0);
            sug03Cell.BorderWidth = 0;
            var sug04Cell = GetCell("禁止开通所有非面对面业务渠道（企业网银增加标识，可参考监管账户）；", fontContent, 0);
            sug04Cell.BorderWidth = 0;
            var sug05Cell = GetCell("限制网银、柜面公转私超过 " + sug5Remark + " 元（或外币等值）；", fontContent, 0);
            sug05Cell.BorderWidth = 0;
            var sug09Cell = GetCell("其他：" + suggestionRemark + "（请描述）。", fontContent, 0);
            sug09Cell.BorderWidth = 0;

            PdfPTable suggestionTab = new PdfPTable(
                 new float[] { 20, 600 }
            );

            suggestionTab.AddCell(imgCell_Sug01);
            suggestionTab.AddCell(sug01Cell);
            suggestionTab.AddCell(imgCell_Sug02);
            suggestionTab.AddCell(sug02Cell);
            suggestionTab.AddCell(imgCell_Sug03);
            suggestionTab.AddCell(sug03Cell);
            suggestionTab.AddCell(imgCell_Sug04);
            suggestionTab.AddCell(sug04Cell);
            suggestionTab.AddCell(imgCell_Sug05);
            suggestionTab.AddCell(sug05Cell);
            suggestionTab.AddCell(imgCell_Sug09);
            suggestionTab.AddCell(sug09Cell);
            #endregion

            return suggestionTab;
        }

        #region PDF 格式字体
        /// <summary>
        /// 创建单元格（内容，样式）
        /// </summary>
        /// <param name="value"></param>
        /// <param name="font"></param>
        /// <param name="alignment"></param>
        /// <returns></returns>
        public static PdfPCell GetCell(string value, Font font, int alignment)
        {
            PdfPCell cell = new PdfPCell(new Phrase(value, font));
            cell.BorderWidth = 0.5f;
            cell.HorizontalAlignment = alignment; // 单元格对齐方式 0=Left, 1=Centre, 2=Right
            return cell;
        }

        /// <summary>
        /// 定义字体
        /// </summary>
        /// <param name="type">0 标题 1 表头 2 内容</param>
        /// <returns></returns>
        public static Font GetFont(int type)
        {
            // PDF中使用的字体
            // SIMSUN.TTC：宋体和新宋体
            // SIMKAI.TTF：楷体
            // SIMHEI.TTF：黑体
            // SIMFANG.TTF：仿宋体            
            // 标题字体
            BaseFont basefont_Title = BaseFont.CreateFont(HttpContext.Current.Server.MapPath("~/") + "Content\\SIMSUN.TTC,1", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            Font font_Title = new Font(basefont_Title, 18, Font.BOLD);
            // 表格字体
            Font font_Col = new Font(basefont_Title, 10, Font.BOLD);
            // 正文字体
            Font font_Context = new Font(basefont_Title, 9);

            if (type == 0)
                return font_Title;
            else
            {
                if (type == 1)
                    return font_Col;
                else
                    return font_Context;
            }
        }
        #endregion
    }
}

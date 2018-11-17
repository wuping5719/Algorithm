using System;
using System.Collections;
using System.Linq;
using System.IO;
using System.Drawing;
using System.Threading;
using System.Windows.Forms;
using System.Web;

namespace OUC.KYC.Web.Util
{
    // 网页生成图片工具类
    // AddBy WuPing 2018-10-16
    public class WebSiteThumbnail
    {
        Bitmap m_Bitmap;
        string m_Url;
        int m_BrowserWidth, m_BrowserHeight, m_ThumbnailWidth, m_ThumbnailHeight;
        public WebSiteThumbnail(string Url, int BrowserWidth, int BrowserHeight, int ThumbnailWidth, int ThumbnailHeight)
        {
            m_Url = Url;
            m_BrowserHeight = BrowserHeight;
            m_BrowserWidth = BrowserWidth;
            m_ThumbnailWidth = ThumbnailWidth;
            m_ThumbnailHeight = ThumbnailHeight;
        }

        public static Bitmap GetWebSiteThumbnail(string Url, int BrowserWidth, int BrowserHeight, int ThumbnailWidth, int ThumbnailHeight)
        {
            WebSiteThumbnail thumbnailGenerator = new WebSiteThumbnail(Url, BrowserWidth, BrowserHeight, ThumbnailWidth, ThumbnailHeight);
            return thumbnailGenerator.GenerateWebSiteThumbnailImage();
        }

        public Bitmap GenerateWebSiteThumbnailImage()
        {
            Thread m_thread = new Thread(new ThreadStart(_GenerateWebSiteThumbnailImage));
            m_thread.SetApartmentState(ApartmentState.STA);
            m_thread.Start();
            m_thread.Join();
            return m_Bitmap;
        }

        private void _GenerateWebSiteThumbnailImage()
        {
            WebBrowser m_WebBrowser = new WebBrowser();
            m_WebBrowser.ScrollBarsEnabled = false;
            m_WebBrowser.Navigate(m_Url);
            m_WebBrowser.DocumentCompleted += new WebBrowserDocumentCompletedEventHandler(WebBrowser_DocumentCompleted);
            while (m_WebBrowser.ReadyState != WebBrowserReadyState.Complete)
                Application.DoEvents();
            m_WebBrowser.Dispose();
        }

        private void WebBrowser_DocumentCompleted(object sender, WebBrowserDocumentCompletedEventArgs e)
        {
            WebBrowser m_WebBrowser = (WebBrowser)sender;
            m_WebBrowser.ClientSize = new Size(this.m_BrowserWidth, this.m_BrowserHeight);
            m_WebBrowser.ScrollBarsEnabled = false;
            m_Bitmap = new Bitmap(m_WebBrowser.Bounds.Width, m_WebBrowser.Bounds.Height);
            m_WebBrowser.BringToFront();
            m_WebBrowser.DrawToBitmap(m_Bitmap, m_WebBrowser.Bounds);
            m_Bitmap = (Bitmap)m_Bitmap.GetThumbnailImage(m_ThumbnailWidth, m_ThumbnailHeight, null, IntPtr.Zero);
        }
    }
}

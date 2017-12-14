<h2> NET 认证问答题 :books: </h2> 

> 微软的认证题还是很有难度的，前路漫漫，革命尚未成功，同志仍需努力！

```C#
1.ASP.NET能在哪些系统中运行？
  答：目前，ASP.NET还只能奔跑在微软的Windows 2000，Windows XP和Windows 2003 的系统中，
    并且需要微软Internet Information Server(IIS)的支持，微软原计划要让Windows NT4.0也支持ASP.NET，
    但可能微软是有些技术问题或市场考虑，还没有实现NT下的ASP.NET的支持。

2.在一个 ASPX 文件中是否可以使用一种以上的语言？
  答：一个ASPX 文件中只能用一种语言，正如你不能在VB.NET中使用C#的语法一样。
    微软提供了公共语言运行环境(CLR, Common Laguage Runtime)，实现了多种编程语言的紧密集成，
    可以允许你从一个VB对象中导出C#所需的对象来。

3.ASPX 文件的服务器端脚本支持哪些语言？
  答：目前，ASPX文件只支持C#，Visual Basic.NET，Jscript.NET 和 J#，
    但是你使用Code-Behind(代码分离)的方法创建一个独立代码文件，
    你就可以使用任何.NET编译器支持的语言来实现功能了。

4.我能否看到 ASPX 文件在ASP.NET中生成的代码？
  答：可以看到，当你的ASPX文件中包含<%@Page Debug=”true” %>命令或
    Web.config中声明了<compilation debug=”true”>时，
    你就可以在系统目录下的Microsoft.NET\Framework\v1.0.nnnn\Temporary ASP.NET Files中
    找到ASPX文件在ASP.NET下生成的文件。

5.在ASPX文件中如何注释?
   答：同ASP文件中的方法一样。
   <%-- 
     response.write “测试!”
   --%>

6.ASPX文件中是否可以存在一个以上服务端Form标记？
  答：不可以。

7.我可以在Web窗体中使用自定义数据类型吗？
  答：可以，你可以把包含自定义数据类型的DLL文件放在程序根目录下的BIN目录中，
    ASP.NET会在数据类型引用时，装载DLL文件。

8.我能在Global.asax文件中触发哪些事件？
  答：Application对象创建和结束时触发的事件有：
        Application_Start
        Application_End
     Session对象创建和结束时触发的事件有：
        Session_Start
        Session_End
     对程序有请求发生时触发的事件有(按发生顺序排列)：
        Application_BeginRequest
        Application_AuthenticateRequest
        Application_AuthorizeRequest
        Application_ResolveRequestCache
        Application_AccquireRequestState
        Application_PreRequestHandlerExecute
        Application_PostRequestHandlerExecute
        Application_ReleaseRequestState
        Application_UpdateRequestCache
        Application_EndRequest
     当程序有错误发生时触发的事件有：
        Application_Error
        Application_Disposed

9.Web 控件是否支持样式表(CSS)？
    答：支持。所有的Web控件都从基类System.Web.UI.WebControls.WebControl 中继承了一个叫CssClass的属性。
    <html>
    <head>
       <style>
          .Input { font: 10pt verdana; color: red; }
       </style>
    </head>
    <body>
    <form runat=”server”>
       <asp:TextBox CssClass=”Input” RunAt=”server” />
    </form>
    </body>
    </html>

10.在 ASPX 文件中默认导入哪些名称空间？
  答：ASPX默认导入的名称空间可以直接引用。
   默认名称空间：
   System;
   System.Collections;
   System.Collections.Specialized;
   System.Configuration;
   System.Text;
   System.Text.RegularExpressions;
   System.Web;
   System.Web.Caching;
   System.Web.Security;
   System.Web.SessionState;
   System.Web.UI;
   System.Web.UI.HtmlControls;
   System.Web.UI.WebControls

11.	是否可以自己创建服务器控件？
   答：可以。定义从System.Web.UI.Control 派生的类并重写它的Render方法。
     Render方法采用System.Web.UI.HtmlTextWriter 类型的参数。
     控件要发送到客户端的HTML作为字符串参数传递到HtmlTextWriter的Write方法。

12.	如何在ASP.NET程序中发送邮件？
  答：在.NET的框架基类的System.Web.Mail名称空间内包含MailMessage和SmtpMail 类可以实现这个功能。
  例如：
     Dim message As new Mail.MailMessage
     message.Form = “web3@163.com”
     message.To = “web3@163.com”
     message.Subject = “测试”
     message.Body = “内容”
     Mail.SmtpMail.SmtpServer = “localhost”
     Mail.SmtpMailSend(message)

13.	ASP.NET状态管理方式？
  答：客户端：ASP.NET提供了Cookie，QueryString(URL)，Hidden field，
    ViewState and Control state(ASP.NET 2.0)，来管理客户端请求。
    服务端：Application，Session。
```

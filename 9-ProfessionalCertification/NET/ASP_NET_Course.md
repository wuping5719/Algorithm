<h2> ASP.NET 教程 -- W3School :books: </h2> 

> ASP.NET 知识点整理。
 
```C#
1.ASP.NET 支持三种开发模式：Web Pages(单页面模型)、MVC(模型视图控制器)、Web Forms(事件驱动模型)。

2.ASP 指 Active Server Pages (动态服务器页面); 
  IIS 指 Internet Information Services (Internet 信息服务)。

3.Request.QueryString 命令用于搜集使用 method="get" 的表单中的值。
使用 GET 方法从表单传送的信息对所有的用户都是可见的(出现在浏览器的地址栏)，并且对所发送信息的量也有限制。

4.Request.Form 命令用于搜集使用 "post" 方法的表单中的值。
使用 POST 方法从表单传送的信息对用户是不可见的，并且对所发送信息的量也没有限制。

5."Response.Cookies" 命令用于创建 cookie / 取回 cookie 的值。

6.从 ASP 文件内部访问数据库的通常途径是：
  (1) 创建至数据库的 ADO (ActiveX Data Objects) 连接(ADO connection);
  (2) 打开数据库连接;
  (3) 创建 ADO 记录集(ADO recordset);
  (4) 打开记录集(recordset);
  (5) 从数据集中提取你所需要的数据;
  (6) 关闭数据集;
  (7) 关闭连接。
 
7.C# 的主要 Razor 语法规则:
  (1) Razor 代码块由 @{ ... } 包围;
  (2) 行内表达式(变量和函数)以 @ 开始;
  (3) 代码语句以分号结束;
  (4) 变量通过 var 关键词进行声明;
  (5) 字符串用引用来包围;
  (6) C# 代码对大小写敏感;
  (7) C# 文件的扩展名是 .cshtml。

8.VB 的主要 Razor 语法规则:
  (1) Razor 代码块由 @Code ... End 包围;
  (2) 行内表达式(变量和函数)以 @ 开始;
  (3) 变量通过 Dim 关键词进行声明;
  (4) 字符串用引用来包围;
  (5) VB 代码对大小写不敏感;
  (6) VB 文件的扩展名是 .vbhtml。

9.ASP.NET 提供三种处理文件夹路径的工具：~ 操作符、Server.MapPath 方法以及 Href 方法。

10.在 ASP.NET 2.0 中，菜单可存储在文件中，这样维护起来更加方便。
这个文件通常名为 web.sitemap，被存放在网站的根目录中。
  创建 sitemap 文件的规则：
  (1) XML 文件必须包含围绕内容的 <siteMap> 标签；
  (2) <siteMap> 标签只能有一个 <siteMapNode> 子节点("home" page)；
  (3) 每个 <siteMapNode> 可以有多个子节点(web pages)；
  (4) 每个 <siteMapNode> 拥有定义页面标题和 URL 的属性。
  示例：
  <?xml version="1.0" encoding="utf-8" ?>
  <siteMap>
    <siteMapNode title="Home" url="/aspnet/home.aspx">
        <siteMapNode title="Services" url="/aspnet/services.aspx">
            <siteMapNode title="Training" url="/aspnet/training.aspx"/>
            <siteMapNode title="Support" url="/aspnet/support.aspx"/>
        </siteMapNode>
    </siteMapNode>
  </siteMap>
```

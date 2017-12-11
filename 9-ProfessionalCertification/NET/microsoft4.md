<h2> NET-Framework 微软认证试题及答案 :books: </h2> 

> 微软的认证题还是很有难度的，前路漫漫，革命尚未成功，同志仍需努力！

```C#
61.你的公司正在使用一个名为 Application1 的，基于.NET Framework version 1.0 的应用。
   这个应用当前运行在一个安装有.NET Framework version 1.0 和 1.1 的共享计算机上。
   现在，你需要移动这个应用到一个新的安装有.NET Framework version 1.1 和 2.0 计算机上。
   已知。这个应用被用.NET Framework version 1.1 进行了重新编译，但是没有用.NET Framework version 2.0 进行编译。
   你需要保证应用能够运行在新的计算机的.NET Framework version 1.1上。你应该如何做？
     A. 在应用配置文件增加如下 XML 元素：
       <configuration>
          <startup>
             <supportedRuntime version=”1.1.322” />
          </startup>
       </configuration>
     B. 在应用配置文件增加如下 XML 元素：
       <configuration>
          <runtime>
             <assemblyBinding xmlns=”urn:shcemas-microsoft-com:asm.v1” />
                <dependentAssembly> 
                   <assemblyIdentity name=”Application1” publicKeyToken=”32abba5e0a69a1” culture=”neutral” />
                   <bindingRedirect oldVersion=”1.0.3075.0” newVersion=”1.1.322.0” />
                </dependentAssembly>
             </assemblyBinding>
          </runtime>
       </configuration>
     C. 在应用配置文件增加如下 XML 元素：
       <configuration>
          <startup>
             <requiredRuntime version=”1.1.322” />
          </startup>
       </configuration>
     D. 在应用配置文件增加如下 XML 元素：
       <configuration>
          <runtime>
             <assemblyBinding xmlns=”urn:shcemas-microsoft-com:asm.v1” />
                <dependentAssembly> 
                   <assemblyIdentity name=”Application1” publicKeyToken=”32abba5e0a69a1” culture=”neutral” />
                   <bindingRedirect oldVersion=”1.0.3075.0” newVersion=”1.1.322.0” />
                </dependentAssembly>
             </assemblyBinding>
          </runtime>
       </configuration>
答案：A

62.你正在为应用装载一个新的程序集。你需要为程序集重载缺省的证据集(Evidence)。
  如果程序集是从本地的 intranet zone 被装载，你需要公共语言运行库(CLR)为程序集许可一个权限集。
  为此，你需要建立一个证据集。你应该使用下面哪一个代码段？
      A. Evidence evidence = new Evidence(Assembly.GetExecutingAssembly().Evidence);
      B. Evidence evidence = new Evidence();
         evidence.AddAssembly(new Zone(SecurityZone.Intranet));
      C. Evidence evidence = new Evidence();
         evidence.AddHost(new Zone(SecurityZone.Intranet));
      D. Evidence evidence = new Evidence(AppDomain.CurrentDomain.Evidence);
答案：C

63.你正在开发一个类库。此类库将打开和网络上其他计算机的网络套接字连接(network socket connsctions)。
   你将部署类库到全局程序集并且许可为完全信任。你写了如下代码去保证 socket 连接是可用的：
     SocketPermission permission = new SocketPermission(PermissionState.Unrestricted);
     Permission.Assert();
   使用这个类库的一些应用并不需要必需的权限去打开网络套接字连接。你需要取消断言(assertion)。
   你应该使用下面哪个代码段：
     A. CodeAccessPermission.RevertAssert();
     B. CodeAccessPermission.RevertDeny();
     C. permission.Deny();
     D. permission.PermitOnly();
答案：A

64.你开发了一个名为 FileService 的服务。你部署这个服务到你的网络上的多个服务器上。你实现了如下代码段:
     01 public void StartService(string serverName) {
     02    ServiceController crtl = new 
     03           ServiceController(“FileService”);
     04    if (crtl.Status == ServiceControllerStatus.Stopped) {
     05    }
     06 } 
  你需要开发一个服务管理程序，如果服务 FileService 停止了，则启动它。服务管理程序启动 FileService 服务，
  要求以 serverName 作为输入参数来标识服务器。你应该增加下面哪两行代码到上面的代码段？
      A. 在03和04行之间插入代码段：crtl.ServiceName = serverName;
      B. 在03和04行之间插入代码段：crtl.MachineName = serverName;
      C. 在03和04行之间插入代码段：crtl.Site.Name = serverName;
      D. 在04和05行之间插入代码段：crtl.Continue();
      E. 在04和05行之间插入代码段：crtl.Start();
      F. 在04和05行之间插入代码段：crtl.ExecuteCommand(0);
答案：B, E

65.你创建了一个使用最终用户身份进行运行的方法。你需要使用 Microsoft Windows 用户组去验证用户。
   你必须增加一个代码段去验证用户是否在本地用户组 Clerk 里面。你应该使用下面哪个代码段？
      A. WindowsIdentity currentUser = WindowsIdentity.GetCurrent();
         foreach (IdentityReference grp in currentUser.Groups) {
            NTAccount grpAccount = (NTAccount) grp.Translate(typeof(NTAccount));
            isAuthorized = grpAccount.Value.Equals(Environment.MachineName + @”\Clerk”);
            if (isAuthorized) 
              break;
            }
         }
      B. WindowsPrincipal currentUser = (WindowsPrincipal)Thread.CurrentPrincipal;
         isAuthorized = currentUser.IsInRole(”Clerk”);
      C. GenericPrincipal currentUser = (GenericPrincipal)Thread.CurrentPrincipal;
         isAuthorized = currentUser.IsInRole(”Clerk”);
      D. WindowsPrincipal currentUser = (WindowsPrincipal)Thread.CurrentPrincipal;
         isAuthorized = currentUser.IsInRole(Environment.MachineName);
答案：B

66.你正在开发一个在字符串中查找子串的方法。这个方法将被本地化为意大利区域。
   你的方法接收如下参数：被查询的字符串 searchList，要查找的字符串 searchValue。你应该使用下面哪个代码段？
      A. return searchList.IndexOf(searchValue);
      B. CompareInfo comparer = new Culture(“it-IT”).CompareInfo;
         reutrn comparer.Comparer(searchList, searchValue);
      C. CultureInfo Comparer = new CultureInfo(“it-IT”);
         if (searchList.IndexOf(searchValue) > 0)
            return true;
         } else {
            return false;
         }
      D. CompareInfo comparer = new Culture(“it-IT”).CompareInfo;
         if (comparer.Comparer(searchList, searchValue) > 0)
            return true;
         } else {
            return false;
         }
答案：D

67.你需要写一个代码段，它使用名为 netStream 的 NetworkStream 对象传输字节数组 dataToSend 的内容。
   你需要使用一个8192 字节的缓冲区。你应该使用下面哪个代码段？
      A. MemoryStream memStream = new MemoryStream(8192);
         memStream.Write(dataToSend, 0, (int) netStream.Length);
      B. MemoryStream memStream = new MemoryStream(8192);
         netStream.Write(dataToSend, 0, (int) memStream.Length);
      C. BufferedStream bufStream = new BufferedStream(netStream, 8192);
         bufStream.Write(dataToSend, 0, dataToSend.Length);
      D. BufferedStream bufStream = new BufferedStream(netStream);
         bufStream.Write(dataToSend, 0, 8192);
答案：C

68.你正在为应用域创建一个新的安全策略。你写了如下代码：
      PolicyLevel policy = PolicyLevel.CreateAppDomainLevel();
      PolicyStatement noTrustStatement = new PolicyStatement(policy.GetNamedPermissionSet(“Nothing”));
      PolicyStatement fullTrustStatement = new PolicyStatement(policy.GetNamedPermissionSet(“FullTrust”));
   你需要为策略安排代码组，以至装载程序集默认为 Nothing 权限集。
   如果程序集从 Trusted Zone 装载，则安全策略必须许可程序集为完全信任。你应该使用哪个代码段？
       A.CodeGroup group1 = new FirstMatchCodeGroup(
               new ZoneMembershipCondition(SecurityZone.Trusted), fullTrustStatement);
         CodeGroup group2 = new UnionCodeGroup(
               new AllMembershipCondition(), noTrustStatement);
         group1.AddChild(group2);
       B.CodeGroup group1 = new FirstMatchCodeGroup(
                 new AllMembershipCondition(), noTrustStatement);
         CodeGroup group2 = new UnionCodeGroup(
                 new ZoneMembershipCondition(SecurityZone.Trusted), fullTrustStatement);         
                 group1.AddChild(group2);
       C.CodeGroup group = new UnionCodeGroup(
                 new ZoneMembershipCondition(SecurityZone.Trusted), fullTrustStatement);
       D.CodeGroup group = new FirstMatchCodeGroup(
                 new AllMembershipCondition(), noTrustStatement);
答案：B

69.你正在开发一个在字符串中查找子串的方法。这个方法将被本地化为意大利区域。
   你的方法接收如下参数：被查询的字符串 searchList，要查找的字符串 searchValue。你应该使用下面哪个代码段？
       A.return searchList.IndexOf(searchValue);
       B.CompareInfo comparer = new CultureInfo(“it-IT”).CompareInfo;
         return comparer.Compare(searchList, searchValue);
       C.CultureInfo Comparer = new CultureInfo(“it-IT”);
         if (searchList.IndexOf(searchValue) > 0) {
            return ture;
         } else {
            Return flase;
         }
       D.CompareInfo comparer = new CultureInfo(“it-IT”).CompareInfo;
         if (comparer.Compare (searchList, searchValue) > 0) {
            return ture;
         } else {
            Return flase;
         }
答案：D

70.你需要开发一个显示任务进度的闪屏。为此，你需要在屏幕上画出一个使用渐变阴影进行填充的矩形，你应该使用下面哪种代码段？
     A.Rectangle rectangle = new Rectangle(10, 10, 40, 2);
       LinearGradientBrush rectangleBrush = new LinearGradientBrush(rectangle, Color.AliceBlue, 
          Color.CornflowerBlue, LinearGradientMode.ForwardDiagonal);
       Pen rectanglePen = new Pen(rectangleBrush);
       Graphics g = this.CreateGraphics();
       g.DrawRectangle(rectanglePen, rectangle);
     B.Rectangle rectangle = new Rectangle(10, 10, 40, 2);
       LinearGradientBrush rectangleBrush = new LinearGradientBrush(rectangle, Color.AliceBlue, 
             Color.CornflowerBlue, LinearGradientMode.ForwardDiagonal);
       Pen rectanglePen = new Pen(rectangleBrush);
       Graphics g = this.CreateGraphics();
       g.FillRectangle(rectangleBrush, rectangle);
     C.RectangleF rectangle = new RectangleF(10f, 10f, 40f, 2f);
       Ponit[] points = new Point[] { new point(0, 0), new Point(110, 14) };
       LinearGradientBrush rectangleBrush = new LinearGradientBrush(rectangle, Color.AliceBlue, 
              Color.CornflowerBlue, LinearGradientMode.ForwardDiagonal);
       Pen rectanglePen = new Pen(rectangleBrush);
       Graphics g = this.CreateGraphics();
       g.DrawPolygon(rectanglePen, points);
     D.RectangleF rectangle = new RectangleF(10f, 10f, 40f, 2f);
       SolidBrush rectangleBrush = new SolidBrush(Color.AliceBlue);  
       Pen rectanglePen = new Pen(rectangleBrush);
       Graphics g = this.CreateGraphics();
       g.DrawRectangle(rectangleBrush, rectangle);
答案：B

71.你正在开发一个在网络上传输敏感信息的服务器应用。
   你创建了一个 X509Certificate 对象 certificate 和一个 TcpClient 对象client。
   你需要创建一个 SslStream 对象，从而通过 Transport Layer Security 1.0 协议(TLS 1.0 安全协议)进行通讯。
   你应该使用哪个代码段？
      A.SslStream ssl = new SslStream(client.GetStream());
        ssl.AuthenticateAsServer(certificate, false, SslProtocols.None, true);
      B.SslStream ssl = new SslStream(client.GetStream());
        ssl.AuthenticateAsServer(certificate, false, SslProtocols.Ssl3, true);
      C.SslStream ssl = new SslStream(client.GetStream());
        ssl.AuthenticateAsServer(certificate, false, SslProtocols.Ssl2, true);
      D.SslStream ssl = new SslStream(client.GetStream());
        ssl.AuthenticateAsServer(certificate, false, SslProtocols.Tls, true);
答案：D
```

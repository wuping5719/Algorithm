<h2> NET-Framework 微软认证考试试题及答案 :books: </h2> 

> 微软的认证题还是很有难度的，前路漫漫，革命尚未成功，同志仍需努力！

```C#
41.你正在写一个接收 DateTime 参数，返回一个 Boolean 值的多路委托，你应该使用下面哪个代码段？
     A. public delegate int PowerDeviceOn(bool, DateTime);
     B. public delegate bool PowerDeviceOn(Object, EventArgs);
     C. public delegate void PowerDeviceOn(DateTime);
     D. public delegate bool PowerDeviceOn(DateTime);
答案：A

42.你正在创建一个存储数据修改的撤销缓冲区(undo buffer)。
   你需要保证撤销功能首先撤销最近的数据修改，而且撤销缓冲区只允许存储字符串。你应该使用下面哪段代码实现？
    A. Stack<string> undoBuffer = new Stack<string>();
    B. Stack undoBuffer = new Stack();
    C. Queue<string> undoBuffer = new Queue<string>();
    D. Queue undoBuffer = new Queue();
答案：A

43.你创建了一个 Vehicle 类的定义如下：
   public class Vehicle {
      [XmlAttribute(AttributeName = “category”)]
      public string vehicleType;
      public string model;
      [XmlIgnore]
      public int year;
      [XmlElement(ElementName = “mileage”)]
      public int miles;
      public ConditionType condition;
      public Vehicle() { }
      public enum ConditionType {
         [XmlEnum(“Poor”)] BelowAverage,
         [XmlEnum(“Good”)] Average,
         [XmlEnum(“Excellent”)] AboveAverage
      }
   }
  你创建了类 Vehicle 的一个实例。你为 Vehicle 类实例的 public 字段指定了如下的值：vehicleType : car; 
  mode : racer;  year : 2002; miles : 15000; condition : AboveAverage.
  你需要识别出下面哪个 XML 段是Vehicle类实例被序列化后的输出？
  A.<?xml version=”1.0” encoding=”utf-8”?>
    <Vehicle xmlns:xsi=”http:///www.w3.org/2001/XMLSchema-instance”
         xmlns:xsd=”http:///www.w3.org/2001/XMLSchema” vehicleType=”car”>
       <model>racer</model>
       <miles>15000</miles>
       <condition>AboveAverage</condition>
    </Vehicle>
  B.<?xml version=”1.0” encoding=”utf-8”?>
    <Vehicle xmlns:xsi=”http:///www.w3.org/2001/XMLSchema-instance”
         xmlns:xsd=”http:///www.w3.org/2001/XMLSchema” vehicleType=”car”>
       <model>racer</model>
       <miles>15000</miles>
       <condition>Excellent</condition>
    </Vehicle>
  C.<?xml version=”1.0” encoding=”utf-8”?>
    <Vehicle xmlns:xsi=”http:///www.w3.org/2001/XMLSchema-instance”
         xmlns:xsd=”http:///www.w3.org/2001/XMLSchema” vehicleType=”car”>
       <model>racer</model>
       <miles>15000</miles>
       <conditionType>Excellent</conditionType>
    </Vehicle>
  D.<?xml version=”1.0” encoding=”utf-8”?>
    <Vehicle xmlns:xsi=”http:///www.w3.org/2001/XMLSchema-instance”
         xmlns:xsd=”http:///www.w3.org/2001/XMLSchema”>
       <category>car</category>
       <model>racer</model>
       <miles>15000</miles>
       <condition>Excellent</condition>
    </Vehicle>
答案：B

44.你正在测试一个组件，它把Meeting类实例序列化后保存到文件系统中。其中Meeting类定义如下:
  public class Meeting {
      private string title;
      public int roomNumber;
      public string[] invitees;
      public Meeting(string t) { title = t; }
   }
   组件中的一个过程包含如下代码：
   Meeting myMeeting = new Meeting(“Goals”);
   myMeeting.roomNumber = 1100;
   string[] attendees = new string[2] { “Company”, “Mary” };
   myMeeting.invitees = attendees;
   XmlSerializer xs = new XmlSerializer(typeof(Meeting));
   StreamWriter writer = new StreamWriter(@”C:\Meeting.xml”);
   xs.Serialize(writer, myMeeting);
   writer.Close();
   你需要识别下面哪个XML块是 C:\Meeting.xml 文件的内容？
   A.<?xml version=”1.0” encoding=”utf-8”?>
     <Meeting xmlns:xsd=”http:///www.w3.org/2001/XMLSchema”
         xmlns:xsi=”http:///www.w3.org/2001/XMLSchema-instance”>
       <title>Goals</title>
       <roomNumber>1100</roomNumber>
       <invitee>Company</invitee>
       <invitee>Mary</invitee>
    </Meeting>
   B.<?xml version=”1.0” encoding=”utf-8”?>
     <Meeting xmlns:xsd=”http:///www.w3.org/2001/XMLSchema”
        xmlns:xsi=”http:///www.w3.org/2001/XMLSchema-instance”>
      <roomNumber>1100</roomNumber>
      <invitees>
         <string>Company</string>
         <string>Mary</string>
      </invitees>
    </Meeting>
   C.<?xml version=”1.0” encoding=”utf-8”?>
     <Meeting xmlns:xsd=”http:///www.w3.org/2001/XMLSchema”
        xmlns:xsi=”http:///www.w3.org/2001/XMLSchema-instance” title=”Goals”>
      <roomNumber>1100</roomNumber>
      <invitees>
         <string>Company</string>
         <string>Mary</string>
      </invitees>
     </Meeting>
   D.<?xml version=”1.0” encoding=”utf-8”?>
     <Meeting xmlns:xsd=”http:///www.w3.org/2001/XMLSchema”
        xmlns:xsi=”http:///www.w3.org/2001/XMLSchema-instance”>
      <roomNumber>1100</roomNumber>
      <invitees>
         <string>Company</string>
      </invitees>
      <invitees>
         <string>Mary</string>
      </invitees>
     </Meeting>
答案：B

45.你正在改变文件 MyData.xml 的安全设置。你需要保留已经继承的访问规则，但是不会通过继承被父对象修改。你应该怎么做？
     A. FileSecurity security = new FileSecurity(“mydata.xml”, AccessControlSections.All);
       Security.SetAccessRuleProtection(true, true);
       File.SetAccessControl(“mydata.xml”, security);
     B. FileSecurity security = new FileSecurity();
       Security.SetAccessRuleProtection(true, true);
       File.SetAccessControl(“mydata.xml”, security);
     C. FileSecurity security = File.GetAccessControl(“mydata.xml”);
       security.SetAccessRuleProtection(true, true);
     D. FileSecurity security = File.GetAccessControl(“mydata.xml”);
       security.SetAuditRuleProtection(true, true);
       File.SetAccessControl(“mydata.xml”, security);
答案：A

46.你正在创建一个类，它用于比较指定格式的字符串。为此，你需要实现 IComparable<string> 接口。你应该使用下面哪个代码段?
     A. public class Person : IComparable<string> {
          public int CompareTo(string other) { }
        }
     B. public class Person : IComparable<string> {
          public int CompareTo(object other) { }
        }
     C. public class Person : IComparable<string> {
          public bool CompareTo(string other) { }
        }
     D. public class Person : IComparable<string> {
          public bool CompareTo(object other) { }
        }
答案：A

47.你正在开发一个去解密数据的方法。已知数据是使用 Triple DES 算法进行加密的。
   你的方法接收如下参数：将被解密的字节数组 cipherMessage，密钥 key，初始化向量 iv。
   你需要使用 TripleDES 类去解密数据，并且把结果放入一个字符串中。你应该使用哪段代码？
     A.TripleDES des = new TripleDESCryptoServiceProvider();
       des.BlockSize = ciperMessage.Length;
       ICryptoTranform crypto = des.CreateDecryptor(key, iv);
       MemoryStream cipherStream = new MemoryStream(ciperMessage);
       CryptoStream cryptoStream = new CryptoStream(cipherStream, crypto, CryptoStreamModel.Read);
       string message;
       message = new StreamReader(cryptoStream).ReadToEnd();
     B.TripleDES des = new TripleDESCryptoServiceProvider();
       des.FeedbackSize = ciperMessage.Length;
       ICryptoTranform crypto = des.CreateDecryptor(key, iv);
       MemoryStream cipherStream = new MemoryStream(ciperMessage);
       CryptoStream cryptoStream = new CryptoStream(cipherStream, crypto, CryptoStreamModel.Read);
       string message;
       message = new StreamReader(cryptoStream).ReadToEnd();
     C.TripleDES des = new TripleDESCryptoServiceProvider();
       ICryptoTranform crypto = des.CreateDecryptor();
       MemoryStream cipherStream = new MemoryStream(ciperMessage);
       CryptoStream cryptoStream = new CryptoStream(cipherStream, crypto, CryptoStreamModel.Read);
       string message;
       message = new StreamReader(cryptoStream).ReadToEnd();
     D.TripleDES des = new TripleDESCryptoServiceProvider();
       ICryptoTranform crypto = des.CreateDecryptor(key, iv);
       MemoryStream cipherStream = new MemoryStream(ciperMessage);
       CryptoStream cryptoStream = new CryptoStream(cipherStream, crypto, CryptoStreamModel.Read);
       string message;
       message = new StreamReader(cryptoStream).ReadToEnd();
答案：D

48.你需要一段代码去创建一个新的应用程序域。你应该使用下面哪段代码？
    A. AppDomainSetup mySetup = AppDomain.CurrentDomain.SetupInformation;
       mySetup.ShadowCopyFiles = “true”;
    B. System.Diagnostics.Process myProcess;
       myProcess = new System.Diagnostics.Process();
    C. AppDomain domain;
       domain = AppDomain.CreateDomain(“CompanyDomain”);
    D. System.ComponentModel.Component myComponent;
       myComponent = new System.ComponentModel.Component();
答案：C

49. 你正在测试一个执行进程检查的方法。这个方法返回一个包含被进程装载的所有模块的名称和完整路径的ArrayList。
    现在，你需要列出被进程C:\TestApps\Process1.exe装载的所有模块，你应该使用下面哪段代码？
     A. ArrayList ar = new ArrayList();
       Process[] procs;
       ProcessModuleCollection modules;
       procs = Process.GetProcess(@”Process1”);
       if (procs.Length > 0) {
          modules = procs[0].Modules;
          foreach(ProcessModule mod in modules) {
             ar.Add(mod.ModuleName);
          }
       }
     B. ArrayList ar = new ArrayList();
       Process[] procs;
       ProcessModuleCollection modules;
       procs = Process.GetProcess(@”C:\TestApps\Process1.exe”);
       if (procs.Length > 0) {
          modules = procs[0].Modules;
          foreach(ProcessModule mod in modules) {
             ar.Add(mod.ModuleName);
          }
       }
     C. ArrayList ar = new ArrayList();
       Process[] procs;
       ProcessModuleCollection modules;
       procs = Process.GetProcessByName(@”Process1”);
       if (procs.Length > 0) {
          modules = procs[0].Modules;
          foreach(ProcessModule mod in modules) {
             ar.Add(mod.FileName);
          }
       }
     D. ArrayList ar = new ArrayList();
       Process[] procs;
       ProcessModuleCollection modules;
       procs = Process.GetProcessByName(@”C:\TestApps\Process1.exe”);
       if (procs.Length > 0) {
          modules = procs[0].Modules;
          foreach(ProcessModule mod in modules) {
             ar.Add(mod.FileName);
          }
       }
答案：C

50.你的应用使用两个名为 threadOne 和 threadTwo 的线程。
   你需要修改代码使其只有 threadTwo 执行完成才开始执行threadOne。你应该如何做？
     A. 设置 threadOne 运行在低优先级。
     B. 设置 threadTwo 运行在高优先级。
     C. 使用 WaitCallback 代理去同步线程。
     D. 调用 threadOne 的 Sleep 方法。
答案：C

51. 你创建了一个发送 e-mail 的应用。一个名称为 smtp.Company.com 的 SMTP 服务器在本地子网是可用的。
    为了测试应用，你使用源地址为 me@Company.com, 目标地址为you@ompany.com。你应该使用下面哪个代码段去发送 e-mail?
     A. MailAddress addrFrom = new MailAddress(me@Company.com, “Me”);
        MailAddress addrTo = new MailAddress(you@Company.com, “You”);
        MailMessage message = new MailMessage(addrFrom, addrTo);
        message.Subject = “Greetings!”;
        message.Body = “Test”;
        message.Dispose();
     B. string strSmtpClient = “mstp.Company.com”;
        string strFrom = “me@Company.com”;
        string strTo = “you@Company.com”;
        string strSubject = “Greetings!”;
        string strBody = “Test”;
        MailMessage msg = new MailMessage(strFrom, strTo, strSmtpClient);
     C. MailAddress addrFrom = new MailAddress(me@Company.com, “Me”);
        MailAddress addrTo = new MailAddress(you@Company.com, “You”);
        MailMessage message = new MailMessage(addrFrom, addrTo);
        message.Subject = “Greetings!”;
        message.Body = “Test”;
        SmtpClient client = SmtpClient(“smtp.Company.com”);
        client.Send(message);
     D. MailAddress addrFrom = new MailAddress(me@Company.com, “Me”);
        MailAddress addrTo = new MailAddress(you@Company.com, “You”);
        MailMessage message = new MailMessage(addrFrom, addrTo);
        message.Subject = “Greetings!”;
        message.Body = “Test”;
        SocketInformation info = new SocketInformation();
        Socket client = new Socket(info);
        System.Text.ASCIIEncoding enc = new System.Text.ASCIIEncoding();
        byte[] msgBytes = enc.Getbytes(message.ToString());
        client.Send(msgBytes);
答案：C

52.你正在开发一个自定义集合类。你需要在你的类里创建一个方法而且能够保证你的方法返回值
   是一个能够适合 foreach 语句使用的类型。
   你应该如何实现你的方法？
     A. 方法必须返回一个 IEnumerator 或 IEnumerable 的类型。
     B. 方法必须返回一个 IComparable 的类型。
     C. 方法必须包含一个集合。
答案：A

53.你正在开发一个执行数学计算的应用。你创建了一个类 CalculationValues，
   并且写了一个操作 CalculationValues 过程 PerformCalculation。你需要保证当计算被执行的时候，
   用户界面能够继续响应。为此，你需要写一个代码段去调用 PerformCalculation 过程去达到目的，
   你应该使用下面哪个代码段？
     A. private void PerformCalculation() { … }
        private void DoWork() {
           CalculationValues myValues = new CalculationValues();
           Thread newThread = new Thread(new ThreadStart(PerformCalculation));
           new Thread.Start(myValues);
        }
     B. private void PerformCalculation() { … }
        private void DoWork() {
          CalculationValues myValues = new CalculationValues();
          ThreadStart delThread = new ThreadStart(PerformCalculation);
          Thread newThread = new Thread(delThread);
          If (newThread.IsAlive) {
             new Thread.Start(myValues);
          }
       }
     C. private void PerformCalculation(CalculationValues values) { … }
        private void DoWork() {
          CalculationValues myValues = new CalculationValues();
          Application.DoEvents();
          PerformCalculation(myValues); 
          Application.DoEvents();
        }
     D. private void PerformCalculation(object values) { … }
        private void DoWork() {
          CalculationValues myValues = new CalculationValues();
          Thread newThread = 
                new Thread(new ParameterizedThreadStart(PerformCalculation);
          newThread.Start(myValues);
        }
答案：D

54.你写了如下代码去实现 CompanyClass。MyMethod 方法:
     public class CompanyClass {
       public int MyMethod(int arg) {
          return arg;
       }
     }
   你需要在你的程序集中使用一个和CompanyClass不相关的类动态的去调用CompanyClass.MyMethod 方法。
   你应该使用下面哪段代码？
     A. CompanyClass myClass = new CompanyClass();
        Type t = typeof(CompanyClass);
        MethodInfo m = t.GetMethod(“MyMethod”);
        int i = (int)m.Invoke(this, new object[] { 1 });
     B. CompanyClass myClass = new CompanyClass();
        Type t = typeof(CompanyClass);
        MethodInfo m = t.GetMethod(“MyMethod”);
        int i = (int)m.Invoke(myClass, new object[] { 1 });
     C. CompanyClass myClass = new CompanyClass();
        Type t = typeof(CompanyClass);
        MethodInfo m = t.GetMethod(“CompanyClass.MyMethod”);
        int i = (int)m.Invoke(myClass, new object[] { 1 });
     D. Type t = typeof(CompanyClass);
        MethodInfo m = t.GetMethod(“MyMethod”);
        int i = (int)m.Invoke(this, new object[] { 1 });
答案：B

55.你创建了一个如下的，包含类层次定义的类库：
      01 public class Group {
      02    public Employee[] Employees;
      03 }
      04 public class Employee {
      05   public string Name;
      06 }
      07 public class Manager : Employee {
      08   public int level;
      09 }
  你创建了一个 Group 类的实例并且为实例的字段进行了赋值。当你使用XmlSerializer 类的 Serialize 
  方法试图去序列化实例的时候，你收到了 InvalidOperationException 异常和错误消息：”在产生 XML文档时有一个错误。”。
  为此，你需要修改上述代码，使 Group 实例能够使用 XmlSerializer 成功的序列化。
  同时你也需要保证，输出的XML包含所有类层次中的public 属性。你应该如何修改？
  A. 在行1和行2之间插入:
    [XmlArrayItem(Type = typeof(Employee))]
    [XmlArrayItem(Type = typeof(Manager))]
  B. 在行1和行2之间插入:
    [XmlElement(Type = typeof(Employees))]
  C. 在行1和行2之间插入:
    [XmlArray (ElementName = ”Employee”)]
  D. 在行3和行4之间插入:
    [XmlElement(Type = typeof(Employee))]
    并且在行6和行7之间插入:
    [XmlElement(Type = typeof(Manager))]
答案：A

56.你正在创建一个列出远程计算机上进程信息的应用。这个应用需要一个方法执行如下的任务：
   1) 以字符串参数 strComputer 接收远程计算机名称。
   2) 返回一个ArrayList 对象，它包含运行在远程计算机上所有进程的名称。
  为此，你需要写一段代码得到运行在远程计算机上所有进程的名称，并且增加名称到 ArrayList 对象中。
  请问，应该使用下面哪段代码？
    A. ArrayList al = new ArrayList();
      Process[] procs = Process.GetProcessesByName(strComputer);
      foreach (Process proc in procs) {
         al.Add(proc);
      }
    B. ArrayList al = new ArrayList();
      Process[] procs = Process.GetProcesses(strComputer);
      foreach (Process proc in procs) {
         al.Add(proc);
      }
    C. ArrayList al = new ArrayList();
      Process[] procs = Process.GetProcessesByName(strComputer);
      foreach (Process proc in procs) {
         al.Add(proc.ProcessName);
      }
     D. ArrayList al = new ArrayList();
      Process[] procs = Process.GetProcesses(strComputer);
      foreach (Process proc in procs) {
         al.Add(proc.ProcessName);
      }
答案：D

57.你正在写一个名为 MyDictionary 的自定义键/值对的集合(dictionary)。你需要保证MyDictionary 是类型安全的。
   你应该下面哪段代码？
     A. Class MyDictionary Implements Dictionary(Of String, String)
     B. Class MyDictionary Inherits HashTable
     C. Class MyDictionary Implements IDictionary
     D. Class MyDictionary 
       End Class
       Dim t As New Dictionary(Of String, String)
       Dim dict As MyDictionary = Ctype(t, MyDictionary)
答案：A

58.你需要写一个代码段，从一个流变量 stream1 截取开始的 80 个字节到一个新的字节数组 byteArray 中。
   你同时也需要保证代码段把截取的字节数保存到一个整型变量 bytesTransfered 中，你应该使用下面哪个代码段？
     A. bytesTransfered = stream1.Read(byteArray, 0, 80);
     B. for (int i = 0; i < 80; i++) {
          stream1.WriteByte(byteArray[i]);
          bytesTransfered = i;
          if (!stream1.CanWrite) {
             break;
          }
        }
     C. while (bytesTransfered < 80) {
          stream1.Seek(1, SeekOrigin.Current);
          byteArray[bytesTransfered++] = Convert.ToByte(stream1.ReadByte());
        }
     D. stream1.Write(byteArray, 0, 80);
       bytesTransfered = byteArray.Length;
答案：A

59.你正在创建一个存储不同地域的客户信息的应用。你为这个应用开发了一个内部的测试版本。
   你需要收集加拿大客户的区域信息，你应该使用哪个代码段？
     A. foreach (CultureInfo culture in CultureInfo.GetCultures(CultureTypes.SpecificCultures)) {
         // Output the region information…
       }
     B. CultureInfo cultureInfo = new CultureInfo(“CA”); // Output the region information
C. RegionInfo regionInfo = new RegionInfo(“CA”); // Output the region information
D. RegionInfo regionInfo = new RegionInfo(“”); 
  if (regionInfo.Name == “CA”) {
// Output the region information
       }
答案：C

60.你正在开发一个使用 DES (Data Encryption Standard) 算法加密敏感数据的方法。
   你的方法接收如下参数：将被加密的字节数组 message, 密钥 key, 初始化向量 iv。
   你需要去加密数据，你也需要把加密数据写入MemoryStream 对象。你应该使用哪段代码？
     A. DES des = new DESCryptoServiceProvider();
       des.BlockSize = message.Length;
       ICryptoTranform crypto = des.CreateDecryptor(key, iv);
       MemoryStream cipherStream = new MemoryStream();
       CryptoStream cryptoStream = new CryptoStream(cipherStream, crypto, CryptoStreamModel.Write);
       cryptoStream.Write(message, 0, message.Length);
     B. DES des = new DESCryptoServiceProvider();
       ICryptoTranform crypto = des.CreateDecryptor(key, iv);
       MemoryStream cipherStream = new MemoryStream();
       CryptoStream cryptoStream = new CryptoStream(cipherStream, crypto, CryptoStreamModel.Write);
       cryptoStream.Write(message, 0, message.Length);
     C. DES des = new DESCryptoServiceProvider();
       ICryptoTranform crypto = des.CreateDecryptor();
       MemoryStream cipherStream = new MemoryStream();
       CryptoStream cryptoStream = new CryptoStream(cipherStream, crypto, CryptoStreamModel.Write);
       cryptoStream.Write(message, 0, message.Length);
     D. DES des = new DESCryptoServiceProvider();
       ICryptoTranform crypto = des.CreateDecryptor(key, iv);
       MemoryStream cipherStream = new MemoryStream();
       CryptoStream cryptoStream = new CryptoStream(cipherStream, crypto, CryptoStreamModel.Write);
       cryptoStream.Write(message, 0, message.Length);
答案：D

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
```

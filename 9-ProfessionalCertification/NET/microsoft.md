<h2> NET-Framework 微软认证考试试题及答案 :books: </h2> 

> 微软的认证题还是很有难度的，前路漫漫，革命尚未成功，同志仍需努力！

```C#
1. 你正在开发一个实现电子问卷的应用。问卷共有25个答案为 true 或 false 的问题。你需要完成以下任务：
   (1) 初始化每个问题的答案为 true；
   (2) 每个问题的答案使用最小内存.
  你应该使用哪种方式存储答案？
    A. BitVector32 answers = new BitVector32(1);
    B. BitVector32 answers = new BitVector32(-1);
    C. BitArray answers = new BitArray(1);
    D. BitArray answers = new BitArray(-1);
答案：B

2. 你写了如下一段代码：
    public delegate void FaxDocs(object sender, FaxArgs args);
   你需要创建一个调用 FaxDocs 的事件，你应该使用哪个代码段？
   A. public static event FaxDocs Fax;
   B. public static event Fax FaxDocs;
   C. public class FaxArgs : EventArgs 
      {
          private string coverPageInfo;
          public FaxArgs(string coverPageInfo)
          {
             this.coverPageInfo = coverPageInfo;
          }
          public string CoverPageInformation
          { 
             get { return this.coverPageInfo; }
          }
       }
    D. public class FaxArgs : EventArgs 
       {
          private string coverPageInfo;
          public string CoverPageInformation
          { 
             get { return this.coverPageInfo; }
          }
       }
答案：A

3. 你写如下的代码段去调用 Win32 Application Programming Interface (API)：
   string personName = “N?el”;
   string msg = “Welcome” + personName + “to club!”;
   bool rc = User32API.MessageBox(0, msg, personName, 0);
   为了实现上面的调用，你需要定义一个方法原型，请问，你会采用哪个代码段进行定义？
    A. [DIIImport(“user32”, CharSet = CharSet.Ansi)]
       public static extern bool MessageBox(int hWnd, string text, string caption, uint type);
    B. [DIIImport(“user32”, EntryPoint = “MessageBoxA”, CharSet = CharSet.Ansi)]
       public static extern bool MessageBox(int hWnd, [MarshalAs(UnmanagedType.LPWStr)]string text, 
       [MarshalAs(UnmanagedType.LPWStr)]string caption, uint type);
    C. [DIIImport(“user32”, CharSet = CharSet.Unicode)]
       public static extern bool MessageBox(int hWnd, string text, string caption, uint type);
    D. [DIIImport(“user32”, EntryPoint = “MessageBoxA”, CharSet = CharSet.Unicode)]
       public static extern bool MessageBox(int hWnd, [MarshalAs(UnmanagedType.LPWStr)]string text, 
       [MarshalAs(UnmanagedType.LPWStr)]string caption, uint type);
答案：C

4. 你需要以字符串形式返回 isolated storage 文件内容，已知，文件名称为 Setting.dat 并且在机器范围内唯一。
   你应该使用下面哪个代码段?
    A. IsolatedStorageFileStream isoStream;
       isoStream = new IsolatedStorageFileStream(“Setting.dat”, FileMode.Open);
       string result = new StreamReader(isoStream).ReadToEnd();
    B. IsolatedStorageFile isoFile;
       isoFile = IsolatedStorageFile. GetMachineStoreForAssembly();
       IsolatedStorageFileStream isoStream;
       isoStream = new IsolatedStorageFileStream(“Setting.dat”, FileMode.Open, isoFile);
       string result = new StreamReader(isoStream).ReadToEnd();
    C. IsolatedStorageFileStream isoStream;
       isoStream = new IsolatedStorageFileStream(“Setting.dat”, FileMode.Open);
       string result = isoStream.ToString();
    D. IsolatedStorageFile isoFile;
       isoFile = IsolatedStorageFile. GetMachineStoreForAssembly();
       IsolatedStorageFileStream isoStream;
       isoStream = new IsolatedStorageFileStream(“Setting.dat”, FileMode.Open, isoFile);
       string result = isoStream.ToString();
答案：B

5. 你正在写一个压缩字节数组的方法。数组被以 document 作为参数名传递到一个方法。
   你需要压缩输入的字节数组并且返回一个字节数组作为结果。你的方法应该使用下面哪个代码段？
    A. MemoryStream strm = new MemoryStream(document);
       DeflateStream deflate = new DeflateStream(strm, CompressionMode.Compress);
       byte[] result = new byte[document.Length];
       deflate.Write(result, 0, result.Length);
       return result;
    B. MemoryStream strm = new MemoryStream(document);
       DeflateStream deflate = new DeflateStream(strm, CompressionMode.Compress);
       deflate.Write(document, 0, document.Length);
       deflate.Cose();
       return strm.ToArray();
    C. MemoryStream strm = new MemoryStream();
       DeflateStream deflate = new DeflateStream(strm, CompressionMode.Compress);
       deflate.Write(document, 0, document.Length);
       flate.Cose();
       return strm.ToArray();
    D. MemoryStream inStream = new MemoryStream(document);
       DeflateStream deflate = new DeflateStream(inStream, CompressionMode.Compress);
       MemoryStream outStream = new MemoryStream();
       int b;
       while((b == deflate.ReadByte()) != -1)
       {
          outStream.WriteByte((byte) b);
       }
       return outStream.ToArray();
答案：C

6. 你需要选择一个类。它基于 Key 实现了小集合和大集合的优化。你应该选择下面哪一个类？
    A. OrderDictionary class
    B. HybridDictionary class
    C. ListDictionary class
    D.Hashtable class
答案：B

7. 你正在写一个应用。它利用 SOAP 去和其他应用交换数据。
   你使用一个从 ArrayList 继承的Department 类作为数据对象发送给另一个应用。
   Department被命名为 dept。为了通过 SOAP进行传送，你需要保证 Department 对象被序列化。
   你应该使用下面哪个代码进行 dept 的序列化？
   A. SoapFormatter formatter = new SoapFormatter();
      byte[] buffer = new byte[dept.Capacity];
      MemoryStream stream = new MemoryStream(buffer);
      foreach(object o in dept)
      {
        formatter.Serilalize(stream, o);
      }
   B. SoapFormatter formatter = new SoapFormatter();
      byte[] buffer = new byte[dept.Capacity];
      MemoryStream stream = new MemoryStream(buffer);
      formatter.Serilalize(stream, o);
   C. SoapFormatter formatter = new SoapFormatter();
      MemoryStream stream = new MemoryStream();
      foreach(object o in dept)
      {
        formatter.Serilalize(stream, o);
      }
   D. SoapFormatter formatter = new SoapFormatter();
      MemoryStream stream = new MemoryStream();
      formatter.Serilalize(stream, dept);
答案：D

8. 你需要写一个完成如下任务的代码段：
  1) 查找所有暂停的服务；
  2) 把服务的显示名称增加到集合中。
  请问, 你应该使用哪个代码段？
  A. Dim searcher Ad ManagementObjectSearcher = new ManagementObjectSearcher(
     “Select * from Win32_Service where State = ‘Paused’”)
     For Each svc As ManagementObject In searcher.Get()
     Collection1.Add(svc(“DisplayName”))
     Next
  B. Dim searcher Ad ManagementObjectSearcher = new ManagementObjectSearcher(
     “Select * from Win32_Service”)
     For Each svc As ManagementObject In searcher.Get()
     Collection1.Add(svc(“DisplayName”))
     Next
  C. Dim searcher Ad ManagementObjectSearcher = new ManagementObjectSearcher(
     “Select * from Win32_Service”)
     For Each svc As ManagementObject In searcher.Get()
     If svc(“State”).ToString() = “Paused” Then
     Collection1.Add(svc(“DisplayName”))
     End If
     Next
  D. Dim searcher Ad ManagementObjectSearcher()
     Searcher.Scope = new ManagementScope(“Win32_Service”)
     For Each svc As ManagementObject In searcher.Get()
     If svc(“State”).ToString() = “Paused” Then
     Collection1.Add(svc(“DisplayName”))
     End If
     Next
答案：A

9.你需要创建一个能够和 COM 进行互操作的类。为此，你需要保证 COM 应用能够创建这个类的实例并且能够调用 GetAddress 方法。
  你应该使用哪个代码段定义你的类？
   A. public class Customer
     {
       string addressString;
       public Customer(string address) { addressString = address; }
       public string GetAddress() { return addressString; }
     }
   B. public class Customer
     {
       static string addressString;
       public Customer() { }
       public static string GetAddress() { return addressString; }
     }
   C. public class Customer
     {
       string addressString;
       public Customer() { }
       public string GetAddress() { return addressString; }
     }
   D. public class Customer
     {
       string addressString;
       public Customer() { }
       internal string GetAddress() { return addressString; }
     }
答案：C

10. 你正在开发一个类库。你的代码需要访问系统环境变量。对于未给调用堆栈中处于较高位置的所有调用方授予当前实例所指定的权限，
    则在运行时强制 SecurityException。你应该调用哪个方法？
     A. set.Demand();
     B. set.Assert();
     C. set.PermitOnly();
     D. set.Deny();
答案：A

11. 请使用下面的条件确定一个类型：
   1) 是一个数字。
   2) 不大于 65,535
   请问，是哪一个类型？
    A. System.UInt16
    B. int
    C. System.String
    D. System.IntPtr
答案：A

12. 你正在写用户验证和授权的代码。username, password 和 roles 存储在你的应用数据存储区。
    你需要建立一个用于授权检查的用户安全上下文，例如 IsInRole。你写如下的代码段去验证用户：
     if (!TestPassword(username, password)) 
     Throw new Exception(“could not authenticate user”);
     String[] userRolesArray = LookupUserRoles(username);
    你需要完成这段代码从而为用户建立安全上下文。你应该使用哪个代码段？
     A. GenericIdentity ident = new GenericIdentity(username);
        GenericPrincipal currentUser = new GenericPrincipal(ident, useRolesArray);
        Thread.CurrentPrincipal = currentUser;
     B. WindowIdentity ident = new WindowIdentity(username);
        WindowPrincipal currentUser = new WindowPrincipal(ident);
        Thread.CurrentPrincipal = currentUser;
     C. NTAccount userNTName = new NTAccount(username);
        GenericIdentity userNTName = new GenericIdentity(userNTName.Value);
        GenericPrincipal currentUser = new GenericPrincipal(ident, useRolesArray);
        Thread.CurrentPrincipal = currentUser;
     D. IntPtr token = IntPtr.Zero;
        token = LogonUserUsingInterop(username, encryptedPassword);
        WindowsImpersonnationContext ctx = WindowIdentity.Impersonate(token);
答案：A

13. 你正在为一个 HongKong 的客户开发一个应用。你需要为本地的货币显示一个符号。你应该使用哪段代码？
     A. NumberFormatInfo culture = new CultureInfo(“zh-HK”).NumberFormat;
        culture.NumberNegativePattern = 1;
        return numberToPrint.ToString(“C”, culture);
     B. NumberFormatInfo culture = new CultureInfo(“zh-HK”).NumberFormat;
        culture.CurrencyNegativePattern = 1;
        return numberToPrint.ToString(“C”, culture);
     C. CultureInfo culture = new CultureInfo(“zh-HK”);
        return numberToPrint.ToString(“-(0)”, culture);
     D. CultureInfo culture = new CultureInfo(“zh-HK”);
        return numberToPrint.ToString(“()”, culture);
答案：B

14. 你正在开发一个将执行数学计算的应用。你需要确保应用能够同时执行多个计算。你应该怎么做？
     A. 设置 ProcessThread 对象的 IdealProcessor 属性。
     B. 设置 ProcessThread 对象的 ProcessAffinity 属性。
     C. 使用 for each 进行计算，调用 ThreadPool 的 QueueUserWorkItem 方法。
     D. 设置 Process.GetCurrentProcess().BasePriority 为 High。
答案：C

15. 你正在开发一个名为 PollingService 的服务，这个服务定期的调用一些需要长时间运行的过程。
    这些过程被 DoWork 方法调用。你的服务代码如下：
    ref class PollingService : public ServiceBase 
    {
       public : 
         static bool binExit = false;
       protected :
         override void OnStart(String ^ args) {
            do {
               DoWork();
            } while (!bInExit);
         }
         override void OnStop() {
            bInExit = true;
         }
       private :
         void DoWork() {}
     };
     当你试图去启动服务的时候，你收到一个错误: 在本地计算机上不能启动 PollingService 服务。
     Error 1053 : 服务不响应启动或控制。你需要去修改服务代码，使服务能够被正确启动。你应该如何做？
       A. 把循环代码从 OnStart 方法移动到服务类的构造函数中。
       B. 在服务的设计界面拖入一个 timer 组件。把调用长运行时间过程的代码从 OnStart 方法移动到 timer 的 Tick 事件中。
          在 OnStart 方法中设置 timer 的 Enabled 属性为 True。并且调用 timer 的Start 方法。
       C. 给服务类增加一个类级别的 System.Timers.Timer 变量。然后在 timer 的 Elapsed 事件中调用 DoWork 方法。
          在 OnStart 方法中设置 timer 的 Enabled 属性为 True, 并且调用timer 的 Start 方法。
       D. 把循环代码从 OnStart 方法移动到 DoWork 方法中。
答案：C

16. 你正在开发一个使用安全哈希算法计算给定数据哈希值的方法。传递给你方法的数据是一个名为 message 的字节数组。
    你需要计算输入数据的 SHA1 哈希值，而且要把计算结果放入名为 hash 的字节数组。
    你需要计算输入数据的 SHA1 哈希值，而且要把计算结果放入名为 hash 的字节数组。你应该使用下面哪一个代码段？
      A. SHA1 sha = new SHA1CryptoServiceProvider();
         byte[] hash = null;
         sha.TransformBlock(message, 0, message.Length, hash, 0);
      B. SHA1 sha = new SHA1CryptoServiceProvider();
         byte[] hash = BitConverter.GetBytes(sha.GetHashCode());
      C. SHA1 sha = new SHA1CryptoServiceProvider();
         byte[] hash = sha.ComputeHash(message);
      D.SHA1 sha = new SHA1CryptoServiceProvider();
         sha.GetHashCode();
         byte[] hash = sha.Hash;
答案：C

17.你正在开发一个以后可以使用 MD5 算法进行验证的，计算哈希值的方法。传递给你方法的数据是一个名为 message 的字节数组。
   你需要计算输入数据的 MD5 哈希值，而且要把计算结果放入名为 hash 的字节数组。你应该使用下面哪一个代码段？
     A. HashAlgorithm algo = HashAlgorithm.Create(“MD5”);
        byte[] hash = algo.ComputeHash(message);
     B. HashAlgorithm algo = HashAlgorithm.Create(“MD5”);
        byte[] hash = BitConverter.GetBytes(algo.GetHashCode());
     C. HashAlgorithm algo;
        algo = HashAlgorithm.Create(message.ToString());
        byte[] hash = algo.Hash;
     D. HashAlgorithm algo = HashAlgorithm.Create(“MD5”);
        byte[] hash = null;
        algo.TransformBlock(message, 0, message.Length, hash, 0);
答案：A

18.你需要创建一个名为 MyAssembly 的动态类库，同时你也需要把类库保存到磁盘。你应该使用下面哪个代码段？
     A. AssemblyName myAssemblyName = new AssemblyName();
        myAssemblyName.Name = “MyAssembly”;
        AssemblyBuilder myAssemblyBuilder = AppDomain.CurrentDomain
            .DefineDynamicAssembly(myAssemblyName, AssemblyBuilderAccess.Run);
        myAssemblyBuilder.Save(“MyAssembly.dll”);
     B. AssemblyName myAssemblyName = new AssemblyName();
        myAssemblyName.Name = “MyAssembly”;
        AssemblyBuilder myAssemblyBuilder = AppDomain.CurrentDomain
            .DefineDynamicAssembly(myAssemblyName, AssemblyBuilderAccess.Save);
        myAssemblyBuilder.Save(“MyAssembly.dll”);
     C. AssemblyName myAssemblyName = new AssemblyName();
        AssemblyBuilder myAssemblyBuilder = AppDomain.CurrentDomain
            .DefineDynamicAssembly(myAssemblyName, AssemblyBuilderAccess.RunAndSave);
        myAssemblyBuilder.Save(“MyAssembly.dll”);
     D. AssemblyName myAssemblyName = new AssemblyName();
        AssemblyBuilder myAssemblyBuilder = AppDomain.CurrentDomain
            .DefineDynamicAssembly(myAssemblyName, AssemblyBuilderAccess.Save);
        myAssemblyBuilder.Save(“c:\\MyAssembly.dll”);
答案：B

19.你需要从托管代码使用平台调用服务(platform invoke services) 调用一个非托管的函数，你应该怎么做？
    A. Create a class to hold DLL functions and then create prototype methods by using managed Code。
    B.注册你的程序集为 COM 组件然后从 COM 中引用你的托管代码。
    C.为你的托管代码导出类型库。
    D.导入类型库作为一个程序集然后创建 COM 对象实例。
答案：A

20.你使用反射(Reflection)来获得方法 MyMethod 的信息。你需要获取 MyMethod 方法是否在派生类中可以访问，你应该如何做？
     A. 访问 MethodInfo 的 IsAssembly 属性。
     B. 访问 MethodInfo 的 IsVirtual 属性。
     C. 访问 MethodInfo 的 IsStatic 属性。
     D. 访问 MethodInfo 的 IsFamily 属性。
答案：D

21.你是公司 A 的一个开发人员。你创建了一个名为 Company1 的程序集。
   Company1包含了一个 public 方法。全局程序集中包含另一个名为 Company2 的程序集。
   你必须保证，public 方法只能够被 Company2 调用。你需要使用下面哪个权限类？
     A. GacIdentityPermission
     B. PublisherIdentityPermission
     C. DataProtectionPermission
     D. StrongNameIdentityPermission
答案：D

22. 你正在创建一个将被用于多个应用的，名为 Company1 的强类型程序集。
    Company1 在整个开发周期中会经常的重新编译。你需要保证，程序集在每次重新编译后使用它的应用都能正确的运行。
    为此，你将配置开发 Company1 的计算机，使每个应用都能使用 Company1 的最新编译版本。你应该通过下面两个步骤完成？
     A. 创建一个指向强类型程序集编译输出目录的DEVPOPATH 环境变量。
     B. 在 machine.config 配置文件中增加：<developmentMode developerInstallation = “true” />
     C. 在 machine.config 配置文件中增加：
        <dependentAssembly>
            <assemblyIdentity name=”Company1” publicKeyToken = ”2ab4ba45e0a69a1” 
                 language = “en-US” version = “*.*.*.*” />
            <publisherPolicy apply = “no”/>
        </dependentAssembly>
     D. 为使用强类型程序集的每个应用的配置文件增加：
        <supportedRuntime version = “*.*.*.*”/>
     E. 为使用强类型程序集的每个应用的配置文件增加：
        <dependentAssembly>
           <assemblyIdentity name=”Company1” publicKeyToken = ”2ab4ba45e0a69a1” 
                  language = “en-US” version = “*.*.*.*” />
           <bindingRedirect newVersion = “*.*.*.*” />
        </dependentAssembly>
答案：A, B

23.你正在定义一个名为 CompanyClass 的，包含几个子对象的类。CompanyClass 类包含一个操作子对象的方法 ProcessChildren。
   CompanyClass 对象将被序列化。你需要确保在 CompanyClass 对象和所有子对象被重新构造后 ProcessChildren 方法将被执行。
   你应该通过下面哪两个操作达到这个目的？
     A. 在 ProcessChildren 方法上应用 OnDeserializing 属性。
     B. 让 CompanyClass 实现 IDDeserializationCallback 接口。
     C. 让 CompanyClass 从 ObjectManager 类继承。
     D. 在 ProcessChildren 方法上应用 OnSerialized 属性。
     E. 创建一个调用 ProcessChildren 的 GetObjectData 方法。
     F. 创建一个调用 ProcessChildren 的 OnDeserialization 方法。
答案：B, F

24.你正在开发从应用目录动态的装入程序集的应用。你需要写一段代码去动态的装入 Company1.dll 程序集到当前的应用执行域中。
   你应该使用下面哪段代码？
     A. AppDomain domain = AppDomain.CurrentDomain;
        string myPath = Path.Combine(domain.BaseDirectory, “Company1.dll”);
        Assembly asm = Assembly.LoadFrom(myPath);
     B. AppDomain domain = AppDomain.CurrentDomain;
        string myPath = Path.Combine(domain.BaseDirectory, “Company1.dll”);
        Assembly asm = Assembly.Load(myPath);
     C. AppDomain domain = AppDomain.CurrentDomain;
        string myPath = Path.Combine(domain.BaseDirectory, “Company1.dll”);
        Assembly asm = AppDomain.CurrentDomain.Load(myPath);
     D. AppDomain domain = AppDomain.CurrentDomain;
        Assembly asm = domain.GetData(“Company1.dll”);
答案：A

25.你需要创建一个清除队列(Queue) q 的方法。你应该使用下面哪段代码？
    A. foreach (object e in q) { q.Dequeue(); }
    B. foreach (object e in q) { Enqueue(null); }
    C. q.Clear();
    D. q.Dequeue();
答案：C

26.你开发一个需要部署的服务应用。你的网络管理员为你的服务应用创建一个用户账号。
   你需要配置你的服务，让它运行在指定用户账号的上下文中。你应该如何做？
    A. 创建服务安装类，设置 ServiceInstaller 类的 StartType 属性。
    B. 创建服务安装类，设置 ServiceProcessInstaller 的 Account，Username 和 Password 属性。
    C. 使用net.exe 命令行
 
27.你正在创建一个使用非托管资源的类。这个类引用了使用托管资源的对象。
   你需要确保使用这个类的用户在不需要类实例的时候能够释放资源。你应该做哪三个工作？
    A．定义一个从 WeakReference 继承的类。
    B．定义一个实现 IDisposable 接口的类。
    C．创建一个类析构函数，调用其它对象的方法去释放托管资源。
    D．创建一个类析构函数，释放非托管资源。
    E．创建一个 Dispose 方法，调用 System.GC.Collect 强制垃圾回收。
    F．创建一个 Dispose 方法，释放非托管资源并且调用其它对象的方法释放托管资源。
答案：B，D，F

28.你正在创建一个执行复杂财务运算的类。这个类包含一个方法 GetCurrentRate，
  它得到当前的汇率并保存在变量currRate 中。你为此类实现了序列化。
  为此，你需要写一段代码，当类被序列化后，能够使用当前的实际汇率更新currRate 变量。
  你应该使用下面哪段代码？
   A.[OnSerializing]internal void UpdateValue(StreamingContext context) {
       currRate = GetCurrentRate();
   }
   B.[OnSerializing]internal void UpdateValue(SerialzationInfo info) {
       Info.AddValue(“currRate”, GetCurrentRate());
   }
   C.[OnDserializing]internal void UpdateValue(SerialzationInfo info) {
      Info.AddValue(“currRate”, GetCurrentRate());
   }
   D.[OnDserialized]internal void UpdateValue(StreamingContext context) {
      currRate = GetCurrentRate();
   }
答案：D

29.你正在写一个使用独立存储区(isolated storage) 存储用户参数信息的应用。
   应用使用了多个程序集，而且多个用户将会在同一个机器上使用此应用。
   你需要在当前的 Microsoft Windows 标识和程序集的独立存储区内创建一个目录 Preferences。
   你应该使用下面哪段代码？
    A.IsolatedStorageFile store;
      store = IsolatedStorageFile.GetUserStoreForAssembly();
      store.CreateDirectory(“Preferences”);
    B.IsolatedStorageFile store;
      store = IsolatedStorageFile.GetMachineStoreForAssembly();
      store.CreateDirectory(“Preferences”);
    C.IsolatedStorageFile store;
      store = IsolatedStorageFile.GetUserStoreForDomain();
      store.CreateDirectory(“Preferences”);
    D.IsolatedStorageFile store;
      store = IsolatedStorageFile.GetMachineStoreForApplication();
      store.CreateDirectory(“Preferences”);
答案：A

30.你正在开发一个自定义事件处理自动打印所有打开的文档。事件处理可以指定要打印的份数。
   为此，你需要开发一个传递给事件处理程序的自定义事件参数类，你应该使用下面哪个代码段？
     A.public class PrintingArgs {
          private int copies;
          public PrintingArgs(int numberOfCopies) {
             this.copies = numberOfCopies;
          }
          public int Copies {
             get { return this.copies; }
          }
     }
     B.public class PrintingArgs : EventArgs {
          private int copies;
          public PrintingArgs(int numberOfCopies) {
             this.copies = numberOfCopies;
          }
          public int Copies {
             get { return this.copies; }
          }
       }
     C.public class PrintingArgs {
          private EventArgs eventArgs;
          public PrintingArgs(EventArgs ea) {
             this.eventArgs = ea;
          }
          public EventArgs Args {
             get { return eventArgs; }
          }
        }
      D.public class PrintingArgs : EventArgs {
          private int copies;
        }
答案：B

31.你正在对一个应用进行测试。你需要找到引起异常的代码。请问，Exception 类的哪个属性能达到这个目的？
     A. Data
     B. Message
     C. StackTrace
     D. Source
答案：C

32.你正在测试一个新开发的方法 PersistToDB。这个方法接收一个类型为 EventLogEntry 的参数，方法没有返回值。
   你需要创建一段代码来帮助你测试这个方法。
   这段代码必须从本地计算机的应用日志读取日志项然后传递日志项给 PersistToDB 方法。
   要求，传递到 PersistToDB 方法的日志项必须是MySource 源而且类型为错误或警告的日志。
   你应该使用下面哪段代码？
      A. EventLog myLog = new EventLog(“Application”, “.”);
         foreach (EventLogEntry entry in myLog.Entries) {
           if (entry.Source == “MySource”) {
              PersistToDB(entry);
           }
         }
      B. EventLog myLog = new EventLog(“Application”, “.”);
         myLog.Source = “MySource”;
         foreach (EventLogEntry entry in myLog.Entries) {
           if (entry.EntryType == (EventLogEntryType.Error & EventLogEntryType.Warning)) {
              PersistToDB(entry);
           }
        }
      C. EventLog myLog = new EventLog(“Application”, “.”);
         foreach (EventLogEntry entry in myLog.Entries) {
           if (entry.EntryType == EventLogEntryType.Error || 
              entry.EntryType == EventLogEntryType.Warning) {
              PersistToDB(entry);
           }
        }
      D. EventLog myLog = new EventLog(“Application”, “.”);
         foreach (EventLogEntry entry in myLog.Entries) {
           if (entry.EntryType == EventLogEntryType.Error || 
              entry.EntryType == EventLogEntryType.Warning) {
              PersistToDB(entry);
           }
        }
答案：C

33.你正在为一个客户开发一个财务报表。你的客户在美国有总部，在墨西哥有分部。
   你需要保证客户在墨西哥产生的报表，则当前的日期格式为 Mexican Spanish 格式。
   你应该使用下面哪个代码段实现？
     A. DateTimeFormatInfo dtfi = new CurrentInfo(“es-MX”, fasle).DateTimeFormat;
        DateTime dt = new DateTime(DateTime.Today.Year, DateTime.Today.Month, DateTime.Today.Day);
        string dateString = dt.ToString(dtfi.LongDatePattern);
     B. Calendar cal = new CurrentInfo(“es-MX”, fasle).Calendar;
        DateTime dt = new DateTime(DateTime.Today.Year, DateTime.Today.Month, DateTime.Today.Day);
        string dateString = dt.ToString();
     C. string dateString = DateTimeFormatInfo.CurrentInfo;
        GetMonthName(DateTime.Today.Month);
     D. string dateString = DateTime.Today.Month.ToString(“es-MX”);
答案：A

34.你正在创建一个应用，它从应用配置文件的自定义节中读取值。XML自定义节如下：
  <ProjectSection name = ” ProjectCompany”>
     <role name = “administrator” />
     <role name = “manager” />
     <role name = “support” />
  </ProjectSection>
  你需要写一个代码段去定义一个名为 Role 的类。
  而且你需要保证 Role 类使用从配置文件自定义节读取的数据进行初始化。你应该使用下面哪个代码段？
   A.public class Role : ConfigurationElement {
       internal string ElementName = “name”;
       [ConfigurationProperty(“role”)]
       public string Name {
          get { return ((string)base[“role”]); }
       }
     }
   B.public class Role : ConfigurationElement {
      internal string ElementName = “role”;
      [ConfigurationProperty(“name”, RequiredValue = True)]
      public string Name {
        get { return ((string)base[“name”]); }
      }
    }
   C.public class Role : ConfigurationElement {
       internal string ElementName = “role”;
       private string name;
       [ConfigurationProperty(“name”)]
       public string Name {
           get { return name; }
       }
     }
   D.public class Role : ConfigurationElement {
        internal string ElementName = “name”;
        private string name;
        [ConfigurationProperty(“name”, RequiredValue = True)]
        public string Name {
           get { return name; }
        }
     }
答案：B

35.你正在使用 Microsoft Visual Studio 200 IDE 去检查一个返回字符串的方法。
   你指定方法的返回值保存到字符串变量 fName 中。
   你需要写一个代码段，如果 fName 的值不等于 “Company” 则打印如下的单行文本消息”Test Failed :” fName。
   你也同时需要保证你的代码并不影响或打断应用的执行。你应该使用下面哪个代码？
     A. Debug.Asssert(fName == “Company”, ‘’Test Failed :”, fName);
     B. Debug.WriteLineIf(fName != “Company”, fName, ‘’Test Failed :”);
     C. if (fName != “Company”) {
          Dubug.Print(‘’Test Failed :”);
          Dubug.Print(fName);
        }
     D. if (fName != “Company”) {
          Dubug.WriteLine(‘’Test Failed :”);
          Dubug.WriteLine(fName);
        }
答案：B

36.你正在开发一个使用自定义身份验证和基于角色安全的应用。
   你需要写一段代码运行时为每个线程指定一个未经过身份验证的标识对象。你可以使用下面哪个代码段？
     A. AppDomain domain = AppDomain.CurrentDomain;
       domain.SetPrincipalPolicy(PrincipalPolicy.WindowsPrincipal);
     B. AppDomain domain = AppDomain.CurrentDomain;
       domain.SetThreadPrincipal(new WindowsPrincipal(null));
     C. AppDomain domain = AppDomain.CurrentDomain;
       domain.SetAppDomainPolicy(PolicyLevel.CreateAppDomainLevel());
     D. AppDomain domain = AppDomain.CurrentDomain;
       domain.SetPrincipalPolicy(PrincipalPolicy.UnauthenticatedPrincipal);
答案：D

37.你正在写一个返回值为 ArrayList 对象 al 的方法。你需要保证对 ArrayList 的修改是线程安全的。
   你应该使用下面哪段代码？
     A. ArrayList al = new ArrayList();
        Lock (al.SyncRoot) {
          return al;
        }
     B. ArrayList al = new ArrayList();
        Lock (al.SyncRoot.GetType()) {
          return al;
        }
     C. ArrayList al = new ArrayList();
        Monitor.Enter(al);
        Monitor.Exit(al);
        return al;
     D. ArrayList al = new ArrayList();
        ArrayList sync_al = ArrayList.Synchronized(al);
        return sync_al;
答案：D

38.你需要读取文件 Message.txt 的完整内容到一个字符串变量中。你应该使用哪段代码？
  A. string result = null;
     StreamReader reader = new StreamReader(“Message.txt”);
     result = reader.Read().ToString();
  B. string result = null;
     StreamReader reader = new StreamReader(“Message.txt”);
     result = reader.ReadToEnd();
  C. string result = string.Empty;
     StreamReader reader = new StreamReader(“Message.txt”);
     While(!reader.EndOfStream) {
        Result += reader.ToString();
     }
  D. string result = null;
     StreamReader reader = new StreamReader(“Message.txt”);
     result = reader.ReadLine();
答案：B

39.你正在创建一个名为 Age 的类。你需要保证 Age 对象的集合能够被排序。你应该使用下面哪段代码？
     A. public class Age {
          public int Value;
          public object CompareTo(object obj) {
             if (obj is Age) {
                Age age = (Age) obj;
                return Value.CompareTo(obj);
             }
             Throw new ArgumentException(“object not an Age”);
          }
        }
     B. public class Age {
          public int Value;
          public object CompareTo(int iValue) {
             try {
               return Value.CompareTo(iValue);
             } catch {
               throw new ArgumentException(“object not an Age”);
             }
          }
       }
     C. public class Age : IComparable {
          public int Value;
          public object CompareTo(object obj) {
             if (obj is Age) {
                Age age = (Age) obj;
                return Value.CompareTo(age.Value);
             }
             Throw new ArgumentException(“object not an Age”);
          }
        }
     D. public class Age : IComparable {
          public int Value;
          public object CompareTo(object obj) {
             try {
               return Value.CompareTo(((Age) obj).Value);
             } catch {
               return -1;
             }
          }
        }
答案：C

40．你写了一个包含如下代码的类 Employee：
     public class Employee {
        string employeeId, employeeName, jobTitleName;
        public string GetName() { return employeeName; }
        public string GetTitle() { return jobTitleName; }
     }
    你需要在类型中把这个类公开为 COM。而且COM接口能够向前兼容 Employee类的新版本。
    你需要选择一种方法去生成COM接口，你应该怎么做？
    A.增加如下的属性定义:
      [ClassInterface(ClassInterfaceType.None)] public class Employee {}  
    B.增加如下的属性定义:
      [ClassInterface(ClassInterfaceType.AutoDual)] public class Employee {}  
    C.[ComVisible(true)] public class Employee {}
    D.为类定义一个接口并增加如下的属性定义：
      [ClassInterface(ClassInterfaceType.None)] public class Employee : IEmployee {}  
答案：D

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

57.你正在写一个名为 MyDictionary 的自定义键/值对的集合(dictionary)。你需要保证MyDictionary 是类型安全的。你应该下面哪段代码？
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

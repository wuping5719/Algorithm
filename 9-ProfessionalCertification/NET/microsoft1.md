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
```

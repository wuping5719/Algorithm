<h2> NET-Framework 微软认证试题及答案 :books: </h2> 

> 微软的认证题还是很有难度的，前路漫漫，革命尚未成功，同志仍需努力！

```C#
21.你是公司 A 的一个开发人员。你创建了一个名为 Company1 的程序集。
   Company1包含了一个 public 方法。全局程序集中包含另一个名为 Company2 的程序集。
   你必须保证，public 方法只能够被 Company2 调用。你需要使用下面哪个权限类？
     A. GacIdentityPermission
     B. PublisherIdentityPermission
     C. DataProtectionPermission
     D. StrongNameIdentityPermission
答案：D

22.你正在创建一个将被用于多个应用的，名为 Company1 的强类型程序集。
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
```

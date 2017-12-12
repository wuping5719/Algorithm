<h2> Java 初级认证试题及答案 :books: </h2> 

> Java 初级认证题, Java Swing 比较多，有一定的借鉴意义。

```java
21. 菜单有两种表现形式：菜单栏和弹出式菜单。 ( A )
    A. 正确。
    B. 错误。

22. 文本框中显示的字符长度和可以显示的字符长度不同，一般后者远大于前者。( A )
    A. 正确。
    B. 错误。

23. 标签是最常用的组件，它的作用是在界面上显示一行文字，标签也可以显示图片，或者既显示图片也显示文字。 ( A )
    A. 正确。
    B. 错误。
    
24. 当动作监听器激发时，会调用什么函数？ (B )
    A. onActivated 函数。
    B. actionPerformed 函数。
    C. doAction 函数。
    D. checkActionOn 函数。

25. 要产生一个动作监听器类，需要实现什么接口？ (D )
   A. OnActionPerformed 接口。
   B. ActionEvent 接口。
   C. OnEventAction 接口。
   D. ActionListener接口。

26. 以下列出的为组件添加动作监听器的过程中，错误的是 (B )。
   A. 将动作监听器添加到组件上。
   B. 将事件响应函数贴到框架的事件响应函数上。
   C. 编写事件响应函数。
   D. 创建动作监听器对象。

27. 一个简单的图形界面(带有一个标签，文本框)需要哪些弹性布局的约束?  (A, C, D)。(多选题)
   A. 设置面板相对于文本框架的位置。
   B. 设置面板的大小。
   C. 设置文本框相对于标签的位置。
   D. 设置标签相对于面板的位置。
   E. 设置标签，文本框的大小。

28. 如果不使用布局管理器，会出现哪些问题？(A, D)。(多选题)
   A. 当界面缩放时，会失去原有的外观。
   B. 当界面最小化时，组件不会最小化。
   C. 当界面缩放时，组件会随机地移动。
   D. 高分辨下设计的界面，在低分辨下可能会超出桌面范围，从面无法看到。
   E. 对每一个组件，都需要指定它的坐标位置。

29. 盒式布局管理器 BoxLayout 的构造函数中必须给出需要它管理的容器对象，以及组件排列的轴线方向。 (A )。
    A. 正确。
    B. 错误。

30. 卡片式分局所管理的是面板。一个采用卡片式布局的面板，上面一般有好几个相同大小的面板，
  每次只能显示其中一个面板，就好像摞在一起的卡片一样，每次只能显示最顶上的一张。 (A )
    A. 正确。
    B. 错误。

31. 数据接收代码是否需要放在独立的线程中？  (A )
    A.需要，因为数据接收过程需要等待网络资源。
    B.需要，因为数据接收过程与主程序在不同的类中，因此必须要不同的线程。
    C.不需要，因为数据接收过程采用中断方式，不需要等待。
    D.不需要，因为数据接收过程是自动的，无须等待。

32. 建立 Socket 类的客户端需要哪些步骤？ (A, C, D)。(多选题)
    A.如果连接成功，则可以通过此 Socket 对象进行通讯。
    B.如果连接成功，则重新创建一个 Socket 对象用于通讯。
    C.向指定的 IP 地址和端口号进行连接尝试。
    D.创建一个 Socket 对象。
    E.首先通过网络扫描工具扫描服务器端是否已经开通。

33. 在 java 中，引用对象变量和对象间有什么关系？  (D )
    A. 对象与引用变量的有效期不一致，当引用变量不存在时，编程人员必须将对象删除，否则会造成内存泄漏。
    B. 对象与引用变量的有效期是一致的，当引用变量不存在时，它所指向的对象也会自动消失。
    C．对象与引用变量的有效期是一致的，不存在没有引用变量的对象，也不存在没有对象引用的变量。
    D．引用变量是指向对象的一个指针。

34. 以下程序执行的结果是什么？ (A )
     int[] myArray = new int[3];
     try {
       for (int i = 0; i < myArray.length; i++) {
          myArray[i] = i * 3;
          System.out.println(“myArray 数组的第” + i + “个元素的值是: ” + myArray[i]);
       }
     } catch(ArrayIndexOutOfBoubsException e) {
       System.out.println(“数组下标越界”);
     }
    A.程序执行，屏幕上显示”数组下标越界”。
    B.程序出现异常，屏幕上提示数组下标越界异常。
    C.程序正常执行结束，屏幕上显示数组中每个元素的值。
    D.程序编译出错。

35．小程序重载的本质是什么？ (C )
    A．先调用 stop 函数，再调用 start 函数。
    B．先调用 destroy 函数，再调用 init 函数。
    C．先卸载小程序，再重新下载小程序，载入，运行小程序。
    D．先调用 System.destory 函数清除所有对象，再调用 System.out.run 函数运行小程序。

36. 执行一个 Java 程序 ”FirstApp” 的方法是 (B )。
    A. 运行：”java FirstApp.java”
    B. 运行：”java FirstApp”
    C. 运行：”javac FirstApp.class”
    D. 直接双击编译好的 java 目标码文件执行。

37. 用 JBuilder 建立图形界面程序的步骤是 (A, B, C)。(多选题)
    A. 建立一个 JBuilder 工程。
    B. 在工程中创建一个应用程序。
    C. 创建一个主框架窗口。
    D. 为应用程序指定可以运行的操作系统和硬件。
    E. 编译，连接应用程序，选择适合操作系统程序来运行。

38. for 循环的一般形式为：
       for(初值; 终值; 增量)
    以下对 for 循环的描述中，正确的是 (D )。
    A.初值，终值，增量必须是整数。
    B.for 循环的次数是由一个默认的循环变量决定的。
    C.for 循环是一种计次循环，每个 for 循环都带有一个内部不可见循环变量(控制 for循环次数)。
    D.初值和增量都是赋值语句，终值是条件判断语句。

39. 有关 for 和 while 循环，以下说法错误的是 (D )。
    A. for 循环的循环变量只能是从零开始或者从 1 开始的整数。
    D. while 循环是最通用的循环语句。
    C. for 循环在固定次数的循环中使用比较方便。
    D. for 循环能够完成工作，用while 循环也能完成。

40. 在变量定义中，对变量名的要求是 (B, C, D)。(多选题)
    A. 在变量所在的整个源程序中变量名必须是唯一的，否则会造成混乱。
    B. 变量名中可以包含关键字，但不能是关键字。
    C. 变量名不能是 java 关键字，逻辑值(true 或 false)，以及保留字 null。
    D. 变量名中不能出现空格，也不能出现减号。
    E. 变量名必须以英文字母打头，不能以数字或汉字打头。

41. Java 中的引用变量需要初始化，简单变量可以不进行初始化。 (B )
    A. 正确。
    B. 错误。

42. 如何定义保护级的成员函数或是成员变量？ (B )
    A. 在头文件中集中定义。
    B. 使用 ”protected” 关键字定义。
    C. 在类的开头集中定义。
    D. 在类的说明文件中集中定义。

43. 子类能否访问父类的保护级成员变量？(指的是不同包的情况下)  (C)
    A．可以，但权限与读取不能修改。
    B．可以。
    C．不能，但可以访问它继承来的保护级成员变量。
    D．不能。

44. 同一个包的子类能否访问父类的保护级成员变量？ (A)
    A. 可以访问。
    B. 不能访问。
    C. 可以访问，但不能从父类中继承保护级成员。
    D. 不能访问，但可以从父类中继承保护级成员。

45. public 级的成员变量能够被以下哪些对象访问到？ (B, E)(多选题)
    A. 所有的对象，但其它包中的对象只能访问少数从包中导出的成员。
    B. 所有的对象，子类可以直接访问，也可以继承父类对象的 public 级成员。
    C. 所有的对象，但子类只能直接访问，而不能继承父类对象的 public 级成员。
    D. 所有的对象，但子类不能访问其它包中的父类对象的 public 级成员。
    E. 所有的对象。

46．下面的代码编译，运行后得出的结果：(D)。
     public class Conv {
        public static void main(String argv[]) {
           Conv c = new Conv();
           String s = new String(“ello”);
           c.amethod(s);
        }
        public void amethod(String s) {
           char c = ‘H’;
           c += s;
           System.out.println(c);
        }
     }
    A.编译成功，打印出”Hello”。
    B.编译成功，打印出”ello”。
    C.编译成功，打印出”elloH”。
    D.编译错误。

47. 以下程序执行后的打印结果为：(C)。
     public class Oct {
        public static void main(String argv[]) {
           Oct o = new Oct();
           o.amethod();
        }
        public void amethod() {
           int oi = 012;
           System.out.println(oi);
        }
     }
    A. 12
    B. 012
    C. 10
    D. 10.0

48. 编译，执行下面的代码会出现的结果：(A)。
    public class Ref {
       public static void main(String argv[]) {
          Ref r = new Ref();
          r.amethod();
       }
       public void amethod(Ref r) {
          int I = 99;
          multi(r);
          System.out.println(i);
       }
       public void multi(Ref r) {
          r.i = r.i * 2;
       }
    }
   A. 一个编译错误。
   B. 99
   C. 198
   D. 一个运行时错误。

49. 现在你存储一个唯一的整形序列，那么你需要哪个容器接口？ (A)
   A. Set
   B. List
   C. Map
   D. Vector

50.给出下列代码，请选择2个正确输出？(D, E)(多选题)
   public class Example {
      public static void main(String args[]) {
         int i = 0;
         do {
            System.out.println(“Doing it for i is” + i);
         } while (--i > 0);
         System.out.println(“Finished”);
      }
   }
   A. Doing it for i is 3
   B. Doing it for i is 2
   C. Doing it for i is 1
   D. Doing it for i is 0
   E. Finished
```

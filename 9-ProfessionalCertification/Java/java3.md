<h2> Java 初级认证试题及答案 :books: </h2> 

> Java 初级认证题, Java Swing 比较多，有一定的借鉴意义。

```java
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

51. Java 是从 ( B ) 语言改进重新设计的。
   A．Ada
   B．C++
   C．Pasacal
   D．BASIC

52.下列语句哪一个是正确的。(B)
   A. Java 程序经编译后会产生 Machine Code。
   B. Java 程序经编译后会产生 Byte Code。
   C. Java 程序经编译后会产生 DLL。
   D. 以上都不正确。

53.下列说法正确的有 (C)。
   A. class 中的 constructor 不可省略。
   B. constructor 必须与 class 同名，但方法不能与 class 同名。
   C. constructor 在一个对象被 new 时执行。
   D. 一个 class 只能定义一个 constructor。

54. 提供 Java 存储数据库能力的包是 (A)。
   A. java.sql
   B. java.awt
   C. java.lang
   D. java.swing

55. 下列运算符合法的是 (A)。
   A. &&
   B. <>
   C. if
   D. :=

56. 执行如下程序代码：
  a = 0; c = 0;
  do {
    --c;
    a = a - 1;
  } while(a > 0);
  后，c 的值是 (C)。
  A．0
  B．1
  C．-1
  D．死循环

57.下列哪一种叙述是正确的 (D)。
  A. abstract 修饰符可修饰字段，方法和类。
  B. 抽象方法的 body 部分必须用一对大括号 { } 包住。
  C. 声明抽象方法，大括号可有可无。
  D．声明抽象方法不可写出大括号。

58.下列语句正确的是 (A)。
  A. 形式参数可被视为 localvariable。
  B. 形式参数可被字段修饰符修饰。
  C. 形式参数为方法被调用时真正被传递的参数。
  D. 形式参数不可以是对象。

59. 下列哪种说法是正确的 (D)。
  A．实例方法可直接调用超类的实例方法。
  B．实例方法可直接调用超类的类方法。
  C．实例方法可直接调用其他类的实例方法。
  D．实例方法可直接调用本类的类方法。

60. 构造函数能否被子类继承？ (D)
  A. 可以被继承。
  B. 可以被继承，但子类如果有自己的构造函数的话会覆盖父类。
  C. 不能被继承，父类的构造函数不再使用。
  D. 不能被继承，但调用子类的构造函数之前会先自动调用父类的构造函数。

61. 如何设定包访问级的成员函数或成员变量。(A)
  A. 不需要任何关键字，缺省的访问级就是包访问级。
  B. 在类的开头集中定义。
  C. 使用 package 关键字。
  D. 在类的说明部分集中定义。

62. 关于Object类，以下描述中正确的有 (A, B, E)(多选题)
  A. Object类中定义了一些重要的成员函数和变量，以方便Java类的使用。
  B. Object类时所有其他Java类的直接或间接父类。
  C. Object类是一个非常特殊的”虚拟”类，也就是说，你只能从Object类中派生出其他类，但不能创建一个Object类的对象。
  D. 如果一个类已经有了父类，那么这个类同时继承了Object类，也就是说，这时候这个类实际上有2个父类。
  E. 由于 Java 中的类是单继承的，因此所有的类以Object类为根形成了一棵继承树。

63. 在类的继承中，构造函数如何处理？(C, D)(多选题)
  A. 子类的构造函数覆盖父类的构造函数。
  B. 以父类的构造函数为准，子类没有自己的构造函数。
  C. 先执行父类的构造函数，再执行子类的构造函数。
  D. 如果父类的构造函数带参数，则子类必须在构造函数的开头用super()显示地调用父类的构造函数。
  E. 除非子类在构造函数中用super()显示地调用，否则不会执行父类的构造函数。

64. 静态变量就是类变量，系统只为每个类分配一套类变量，所有的实例变量共享一套类变量。(A)
   A. 正确。
   B. 错误。

65. 在 Java 程序中，类是由定义和主体构成的。(B)
   A. 正确。
   B. 错误。

66. 对于无用对象，在 Java 中如何处理。(D)
   A. 直接扔掉。
   B. 所有对象都需要回收。
   C. 只有动态创建的对象需要回收，自动创建的对象不需要回收。
   D. 可以不回收，但可能造成内存泄漏，所以作为良好的编程习惯还是应当回收每个无用的对象。

67. 对于变量的初始化，以下几种方法错误的是 (A, C)(多选题)
   A. int a;
      for (int i = 0; i < 12; i++) 
        a = i;
   B. int a;
      if (true)
        a = 7;
   C. int a;
      int b = a;
   D. int a = 0;
   E. int a;
      a = 0;

68. ++op运算符的作用是先将变量的值加1再返回变量的值。(A)
   A. 正确。
   B. 错误。

69. 一个类能否访问其他包中的类的公开级成员变量。(B)
   A. 不行，除非继承了那个类。
   B. 可以。
   C. 不行。
   D. 可以，但是前提是继承了那个类。

70. 包访问级的成员能被哪些对象访问到 (C)。
   A. 子类
   B. 所有类
   C. 同一个包中的其他类
   D. 同一个包中的子类

71. 对象的 finalize 函数的作用是什么? (A)
   A. 对象被销毁时自动调用，用来完成销毁前的最后操作。
   B. 在对象被销毁后调用，完成一些系统辅助工作。
   C. 清除对象。
   D. 表示对象已经失效了。

72. 以下异常中，不属于 RuntimeException 的是 ( C )。
   A. NullPointerException，使用未初始化的引用变量。
   B. IndexOutOfBondsException，数组下标越界异常。
   C. IllegalAccessException，没有足够的权限访问其他类的成员。
   D. ArithmetricException，算术异常。

73. 如何调用 Java 小程序 ( D )。
   A. 双击小程序文件即可执行。
   B. 在命令方式下键入 java 命令来调用。
   C. 在JBuilder 中键入 java 命令来调用。
   D. 打开 HTML 文件即可调用，或者利用 appletviewer 命令调用。

74. JBuilder 中包含多种文件，它们被放在不同的目录下，下面 4 种类型的文件描述中，哪种是错误的 ( D )。
   A. 编译后的 Java 二进制码放在 classes 目录下。
   D. Java源文件放在 src 目录下。
   C. Java程序运行时的工作目录就是工程所在目录，工作目录是指Java程序运行时默认的当前目录。
   D. 编译中产生的 obj 临时文件和最终产生的可执行文件都放在 Debug 目录下。

75. Java中如何区分对象和指向对象的指针。 ( A )
   A. Java中不区分对象和指针，变量都作为指针处理。
   B. Java中没有指针，所有变量都作为对象处理。
   C. 根据变量类型是对象还是指向对象的指针来区分。
   D. 用 ”.” 表示对象 “->” 符号表示指向对象的指针。

76. 如何设置按钮变灰？ ( A )
   A. 通过按钮的 setEnabled 函数设置。
   B. 通过框架的 setEnabled 函数将按钮的字体颜色改变。
   C. 通过框架的 setEnabled 函数设置。
   D. 通过按钮的setEnabled 函数将字体颜色变灰。

77. 当用户点击按钮时，Java程序采用什么方法来响应？ ( C )
   A. 通过框架的事件监听器对象响应。
   B. 通过框架的 onButton 函数响应。
   C. 通过按钮的事件监听器对象响应。
   D. 通过按钮的 onButton 函数响应。

78. 按钮的事件处理类的主要作用是什么?  ( B)
   A. 根据用户点击及时修改按钮的外观。
   B. 监听用户对按钮的点击，及时作出响应。
   C. 展示按钮点击时的动画效果。
   D. 设置按钮对哪一类事件有反应。

79. 中间容器，原子组件，菜单栏，工具栏等都直接放在顶级容器下。( B )
   A. 正确。
   B. 错误。

80. 顶级框架中包括哪些成员？ (A, B, C)(多选题)
   A. 内容窗格
   B. 分层窗格
   C. 根窗格
   D. 事件处理类
   E. 文字标签，按钮

81. 以下列出的产生窗口监听器的步骤中，错误的是 ( A )
   A. 在 Windows 操作系统中注册窗口监听器类。
   B. 由 WindowAdapter 类派生出窗口监听器类。
   C. 编写窗口事件处理函数。
   D. 将窗口监听器对象添加到框架中。
```

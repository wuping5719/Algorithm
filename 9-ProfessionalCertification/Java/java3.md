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
```

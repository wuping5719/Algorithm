### 中国移动（苏州）研发中心秋招笔试题 ###
* 1.什么是java序列化？如何实现java序列化？    
 &nbsp;  ` (1) 序列化就是一种用来处理对象流的机制(对象流就是将对象的内容进行流化). 可以对流化后的对象进行读写操作，也可将流化后的对象传输于网络之间。序列化是为了解决在对对象流进行读写操作时所引发的问题。 `   
 &nbsp;  ` (2) 序列化的实现：将需要被序列化的类实现Serializable接口，该接口没有需要实现的方法，implements Serializable只是为了标注该对象是可被序列化的，然后使用一个输出流(如：FileOutputStream)来构造一个ObjectOutputStream(对象流)对象，接着，使用ObjectOutputStream对象的writeObject(Object obj)方法就可以将参数为obj的对象写出(即保存其状态)，要恢复的话则用输入流。 `
 
* 2.请解释以下两种内存溢出的原因，并写段java代码（伪代码）触发这些异常。   
  &nbsp;&nbsp;  java.lang.StackOverflowError.  
  &nbsp;&nbsp;  java.lang.OutOfMemoryError.    
  &nbsp; ` (1) Java栈StackOverflowError： `     
  &nbsp; ` JVM的运行时数据区中有一个叫做"虚拟机栈"的内存区域, 此区域的作用是: 每个方法在执行时都会创建一个栈帧, 用于存储局部变量表, 操作数栈, 方法出口等信息.因此我们可以创建一个无限递归的递归调用, 当递归深度过大时, 就会耗尽栈空间, 进而导致了StackOverflowError异常. `     
  &nbsp; ` 示例代码: `
  ```java  
  public class OutOfMemoryErrorTest { 
       public static void main (String [] srgs) {
          stackOutOfMemoryError(1);
       }
       
       public static void stackOutOfMemoryError(int depth) {
          depth++;
          stackOutOfMemoryError(depth);
       }
  } 
  ```
  &nbsp; ` (2) Java堆OutOfMemoryError:  `     
  &nbsp; ` Java堆是用来存储对象实例的, 因此如果我们不断地创建对象, 并且保证GC Root和创建的对象之间有可达路径以免对象被垃圾回收, 那么当创建的对象过多时, 会导致heap内存不足, 进而引发OutOfMemoryError异常.`     
  &nbsp; ` 示例代码: `
  ```java  
  public class OutOfMemoryErrorTest {
       public static void main (String[] args) {
            List<Integer> list = new ArryList<>();
            int i=0;
            while(true) {
               list.add(i++);
            }
       }
  }
  ```
* 3.192.168.0.1/24 使用掩码255.255.255.240划分子网，其可使用子网为（16）个，每个子网可用主机地址数（16）个.   
  &nbsp; ` 先将240转换为二进制是1111 0000，根据子网掩码255.255.255.240 `   
  ` 可知是管192.168.0.1/24借了四位主机位来表示网络，剩下四位是表示主机数.  `  
  ` 所以2的四次方=16. `   
  ` 192.168.0.1/24 使用掩码255.255.255.240划分子网，其可使用子网为（16）个，每个子网可用主机地址数（16）个.  `

### 中国移动（苏州）研发中心秋招笔试题 ###
* 1.什么是java序列化？如何实现java序列化？    
 ` (1) 序列化就是一种用来处理对象流的机制(对象流就是将对象的内容进行流化). 可以对流化后的对象进行读写操作，也可将流化后的对象传输于网络之间。序列化是为了解决在对对象流进行读写操作时所引发的问题。 `   
 ` (2) 序列化的实现：将需要被序列化的类实现Serializable接口，该接口没有需要实现的方法，implements Serializable只是为了标注该对象是可被序列化的，然后使用一个输出流(如：FileOutputStream)来构造一个ObjectOutputStream(对象流)对象，接着，使用ObjectOutputStream对象的writeObject(Object obj)方法就可以将参数为obj的对象写出(即保存其状态)，要恢复的话则用输入流。 `
 
* 2.请解释以下两种内存溢出的原因，并写段java代码（伪代码）触发这些异常。   
    java.lang.StackOverflowError   
    java.lang.OutOfMemoryError
  

### 2016年9月26日腾讯秋招, 北京站(海润艾丽华酒店), 后台研发面经 ###
 为了面腾讯, 放弃了华为的一面, 悔死了(╮(╯▽╰)╭).    
 刚到面试的酒店, 签完到就面试, 一点心理准备都没有, 直接方了(╮(╯▽╰)╭).      
 自我介绍, 面试官说他是搞C++的，后台研发岗也主要招C++, 感觉不妙(╮(╯▽╰)╭), 要一轮游了.
* 1. 介绍项目中的创新点.(没有总结好, 答的东西没到重点上)
* 2. 做过C++项目没有？(没做过，就没有然后了)
* 3. 看过Java书籍没有？(看过《Spring In Action》, 《Struts2》和《Effective Java》, 做项目耗费太多时间，书真没读过几本, 基础很重要)
* 4. 手撕代码：快速排序(Easy)
* 5. 一亿个整数里(有重复), 取最大的前100个.(典型的大数据处理问题：基本思路是先Hash, 再用大顶堆取前100个最大值)
* 6. 数据库优化.      
 `数据库访问性能优化: `  <http://www.cnblogs.com/easypass/archive/2010/12/08/1900127.html>    
 `MySQL数据库优化总结: `  <http://www.cnblogs.com/villion/archive/2009/07/23/1893765.html>   
 感觉面试官对Java不是很熟，问的也很少，不过初次面BAT级别的大厂,答的挺烂的.

### 2017年01月11日腾讯补招电面, Java研发面经 ###
 心向往之，百折不挠，只为去自己想去的地方。
* 1. 自我介绍，拿到了哪些 offer？
* 2. 什么是多态？ 以Java为例说明。      
`   多态就是指程序中定义的引用变量所指向的具体类型和通过该引用变量发出的方法调用在编程时并不确定，而是在程序运行期间才确定，即一个引用变量倒底会指向哪个类的实例对象，该引用变量发出的方法调用到底是哪个类中实现的方法，必须在由程序运行期间才能决定。因为在程序运行时才确定具体的类，这样，不用修改源程序代码，就可以让引用变量绑定到各种不同的类实现上，从而导致该引用调用的具体方法随之改变，即不修改程序代码就可以改变程序运行时所绑定的具体代码，让程序可以选择多个运行状态，这就是多态性。 `      
`   深入理解Java多态机制: `  <http://www.cnblogs.com/tsiangleo/p/4415628.html>         
`   理解Java的三大特性之多态: `  <http://www.cnblogs.com/chenssy/p/3372798.html>
* 3. JDK，JRE 的区别？Jstack和Jmap等工具。       
`  JDK(Java Development Kit)：Java 开发工具包，是程序员使用 Java 语言编写 Java 程序所需的开发工具包，是提供给程序员使用的。JDK 包含了 JRE，同时还包含了编译 Java 源码的编译器 Javac，还包含了很多 Java 程序调试和分析的工具：JConsole，JVisualVM 等工具软件，还包含了 Java 程序编写所需的文档和 Demo 例子程序。如果你需要运行 Java 程序，只需安装 JRE 就可以了。如果你需要编写 Java 程序，需要安装 JDK。  `           
`  JRE(Java Runtime Environment)：Java 运行时环境，包含了 Java 虚拟机，Java 基础类库。是使用 Java 语言编写的程序运行所需要的软件环境，是提供给想运行 Java 程序的用户使用的。JRE根据不同操作系统(如：Windows，Linux等)和不同 JRE 提供商(IBM, ORACLE等)有很多版本，最常用的是 Oracle 公司收购 SUN 公司的JRE 版本。  `          
`  最新 JDK1.8 的结构图：`         
  <img src="http://images.cnblogs.com/cnblogs_com/wp5719/936332/o_Java.png" /> 
* 4. StringBuilder 和 StringBuffer。         
  <https://github.com/wuping5719/Reading-Java-SourceCode/blob/master/JDK1.7/java/lang/StringRelated/String.md>
* 5. Java 异常机制？受检异常和运行时异常。         
`  深入理解java异常处理机制：` <http://blog.csdn.net/hguisu/article/details/6155636>
* 6. Dubbo 介绍？      
`  Dubbo 框架入门介绍：` <http://www.cnblogs.com/chy2055/p/5110861.html>               
`  基于 Dubbo 框架构建分布式服务： ` <http://shiyanjun.cn/archives/1075.html>          
`  Dubbo 架构设计详解：` <http://shiyanjun.cn/archives/325.html>      
`  Dubbo 文档：`  <http://dubbo.io/>
* 7. Java 多线程的实现机制。      
  <https://github.com/wuping5719/MyCNBlogs/blob/master/Reading-Notes/JavaConcurrencyInPractice.md>
* 8. 项目简单介绍？从业务和技术两个方面。     
* 9. 有没有什么问题想问面试官的？  
  多学习，多总结。革命尚未成功，同志任需努力。        
  面试可能还会问到数据库优化，Linux相关知识，Web常用框架，Java源码，JVM虚拟机，多线程，机器学习十大算法，消息中间件，NoSQL数据库等。

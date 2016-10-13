### 2016-10-13, 百度, 济南南海, 一面面经 ###
 2016年10月6日, 赶到济南-蓝海大饭店参加百度济南站百度招聘面试。以下为本人的面经：
* 1. 10*10五子棋 五子连珠胜利方法共有多少种？(面试时竟然没有答出来，尴尬(╮(╯▽╰)╭)，这个题其实挺简单的, 实验室的哥们说面试官这个是错的，应该斜着和横着一样，这就没辙了(╮(╯▽╰)╭))   
 ` 横向: ((10-5)+1) * 10 = 60;  `   
 ` 纵向: ((10-5)+1) * 10 = 60;  `   
 ` 斜向: (1+2+3+4+5+((10-5)+1)+5+4+3+2+1) * 2 = 72;  `     
 ` 总共: 60 + 60 + 72 = 192种.  `
* 2. 介绍项目:(画项目结构图, 六西格玛(Six Sigma，6 Sigma), 传感器采集, SSM、SSH框架, Java虚拟机优化，1851家电转换协议等)
* 3. SQL优化(数据库优化)  
 ` (1)字段定义，电话号码用长整形存储; `    
 ` (2)尽量使用固定长度的字段类型(char, varchar);  `     
 ` (3)尽量使查询集小;  `     
 ` (4)使用轻量级锁; `     
 ` (5)控制每一行数据的长度; `   
 ` (6)分库分表技术; `   
 ` (7)使用缓存技术; `  
 ` (8)合并多次查询，减少查询次数. `
* 4.Json格式处理(ECharts), 前端跨域.   
 `1)前端解决跨域问题的8种方案: ` <http://www.cnblogs.com/JChen666/p/3399951.html>   
  `(1)document.domain + iframe(只有在主域相同的时候才能使用该方法); `   
  `(2)动态创建script; `   
  `(3)location.hash + iframe(利用location.hash来进行传值); `   
  `(4)window.name + iframe(name 值在不同的页面(甚至不同域名)加载后依旧存在, 并且可以支持非常长的name值(2MB)); `   
  `(5)postMessage(HTML5中的XMLHttpRequest Level 2中的API); `   
  `(6)CORS(使用自定义的HTTP头部让浏览器与服务器进行沟通, 从而决定请求或响应是应该成功,还是应该失败); `   
  `(7)JSONP(当我们通过script标签请求时,后台就会根据相应的参数(json,handleResponse)来生成相应的json数据(handleResponse({"data": "zhe"})), 最后这个返回的json数据(代码)就会被放在当前js文件中被执行, 至此跨域通信完成); `   
  `(8)Web sockets(在一个单独的持久连接上提供全双工、双向通信(同源策略对web sockets不适用)) `   
  `2)JSON数据格式: ` <http://www.cnblogs.com/SkySoot/archive/2012/04/17/2453010.html>  
  `  Java构造和解析Json数据的两种方法详解一: ` <http://www.cnblogs.com/lanxuezaipiao/archive/2013/05/23/3096001.html>  
* 5.实现多线程的两种方式(继承Thred类, 实现Runable接口)
* 6.Timer线程每隔5秒向Worker线程发送一次消息.(没用过多线程,没写出来，就知道notiy())   
  ` 这个暂时没找到答案，等看完《Thinking in java》并发那章再说吧. `  
  ` Android主线程和子线程之间的消息传递: ` <http://www.cnblogs.com/jackhuclan/archive/2013/07/10/3182084.html>  
  ` @要更加深入的了解多线程编程，得做到以下几步: `   
  `(1)从《Concurrent in practice》开始; `  
  `(2)研究JDK各并发类，最终全部理解AQS实现原理(同时进一步了解非阻塞算法);  `  
  `(3)研究JSR133，同时实践;  `   
  `(4)同时, 开始结合操作系统概念进一步理解;  `   
  `(5)研究一些流行并发框架的源代码. `
* 7.有没有想问面试官的？

<Strong>同学A的面经：</Strong>
* 1.Spring常用的jar包.   
  `(1) spring-core.jar; (2) spring-beans.jar; (3) spring-aop.jar; (4) spring-context.jar; `   
  `(5) spring-dao.jar; (6) spring-hibernate.jar; (7) spring-jdbc.jar; (8) spring-orm.jar; `   
  `(9) spring-remoting.jar; (10) spring-support.jar; (13) spring-web.jar; (14) spring-webmvc.jar;  `  
  `(15) spring-mock.jar. `
* 2.Tcp和Udp应用层分别有哪些协议.   
  ` 斜线前面的数字代表端口号，斜线后面表示tcp和udp，最后是协议名称. `   
  ` 21/tcp FTP 文件传输协议.   `   
  ` 22/tcp SSH 安全登录、文件传送(SCP)和端口重定向.  `    
  ` 23/tcp Telnet 不安全的文本传送.   `    
  ` 25/tcp SMTP Simple Mail Transfer Protocol (E-mail)  `   
  ` 79/tcp finger Finger `    
  ` 80/tcp HTTP 超文本传送协议(WWW) `    
  ` 88/tcp Kerberos Authenticating agent `   
  ` 110/tcp POP3 Post Office Protocol (E-mail) `      
  ` 113/tcp ident old identification server system  `  
  ` 119/tcp NNTP used for usenet newsgroups   `   
  ` 220/tcp IMAP3  `   
  ` 443/tcp HTTPS used for securely transferring web pages  `
  
  ` 69/udp TFTP Trivial File Transfer Protocol   `    
* 3.讲讲HashMap: <http://blog.csdn.net/vking_wang/article/details/14166593> 
* 4.两个列表合成一个列表, 顺序不变.(代码)   
  `《剑指Offer》——面试题17：合并两个排序的链表`
* 5.Linux命令.  
  `Linux命令大全: ` <http://www.runoob.com/linux/linux-command-manual.html> 

<Strong>同学B的面经：</Strong>
* 1.最长非递减子串(动态规划问题)
* 2.m*n矩阵，只能向下或向右走，从左上角走到右下角有多少种走？(动态规划问题)

### 2016-10-13, 百度, 济南南海, 一面面经 ###
 2016年10月6日, 赶到济南-蓝海大饭店参加百度济南站校招面试。以下为本人的面经：
* 1. 10*10五子棋 五子连珠胜利方法共有多少种？(面试时竟然没有答出来，尴尬(╮(╯▽╰)╭)，这个题其实挺简单的, 实验室的哥们说面试官说这个是错的，应该斜着和横着一样，这就没辙了(╮(╯▽╰)╭))   
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
* 7.如何判断查询时是否命中索引？
  查看是否使用了索引：explain命令查看
  1)explain是确定一个查询如何走索引的最简便有效的方法；
  2)关注的字段值：
   ——id字段：表示查询中执行select子句或操作表的顺序。 
   id如果相同，可以认为是一组，从上往下顺序执行；在所有组中， id值越大，优先级越高，越先执行。 
   ——type字段：查询access的方式； 
   type=all表示全表扫描数据，不走索引； 
   type=index表示full index scan，和all的区别是index类型只遍历索引树。 
   ——key字段：本次查询最终选择使用哪个索引，NULL表示未使用索引； 
   ——key_len字段：选择的索引使用的前缀长度或者整个长度（判断联合索引的使用情况）； 
   ——rows字段：可以理解为查询逻辑读，需要扫描过的记录行数； 
   ——extra字段：额外信息，主要指的fetch data的具体方式； 
  extra=using tmporary表示mysql需要使用临时表来存储结果集，常见于排序和分组查询。 
  extra=using filesort表示文件排序，需要对其优化。mysql中无法利用索引完成的排序操作称为“文件排序”。 
   using tmporary可能是内存临时表也可能是磁盘临时表，如果临时表大小超过tmp_table_size大小才会产生基于磁盘的临时表，也就是说，只是通过explain执行计划是无法查看是否用来磁盘临时表的，如果show processlist查看的线程有“Created_tmp_disk_tables”关键字才能代表是用使用了磁盘临时表
 3)explain的一些使用建议：
  (1)对不确定执行计划的关键语句上线前务必explain； 
  (2)type为all的要格外注意，避免全表扫描； 
  (3)key_len只能用很少一部分前缀的，要注意索引字段顺序等； 
  (4)extra里看到using filesort和using tmporary都要尽量优化，这两种fetch方式不应该出现在任何执行频繁的关键语句中。
 4) 强制使用索引hint：
  select * from table_1 force index(xxx)… 
  select * from table_1 ignore index(yyy)…. 
  默认情况下，建议使用mysql优化器，不要强制所用或忽略索引.
* 8.有没有想问面试官的？

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
* 1.最长非递减子串(动态规划问题)(系列问题：最长公共子串，最长公共子序列)   
`代码: ` https://github.com/wuping5719/Algorithm/blob/master/2-Java-Interview/2-16-huaweiOJ/NowCoder/55-CalculatePublicSubString_55.java
* 2.m*n矩阵，只能向下或向右走，从左上角走到右下角有多少种走？(动态规划问题)   
 `思路: 动态规划, dp[0][0]初始化为1, dp[i][j]的大小为dp[i-1][j]+dp[i][j-1], `   
 `     因为只可能是从(i-1,j)和(i,j-1)这两个位置移动过来的, 计算时保证(i,j)的正上方和左边不在边界外即可. `   
 `代码: `  <https://github.com/wuping5719/Algorithm/blob/master/5-CrackingCodingInterview/5-37-Robot1_37.java> 
* 3.volatile关键字: <http://blog.sina.com.cn/s/blog_762cf5f80101aosq.html> 
* 4.synchronized关键字: <http://www.open-open.com/lib/view/open1352431526366.html> 
* 5.快速排序算法.
* 6.36匹马分6个跑道用最快的方法找出跑的最快的3匹马.
  `36匹马分6个组,分别为A、B、C、D、E、F组. `  
  `第一轮,每个组各跑一次,取每组前三名,标识为A1、A2、A3,B1、B2、B3,以此类推. `   
  `第二轮,每个组的第一名（A1——F1）拉出来跑一次,假设名次是：A1第一名,B1第二名,C1第三名. `  
  `则：(1) 后三名及其所在组的其余组员均被淘汰（小组头名都没能进前三,当然是全部淘汰啦） `     
    ` (2) 两战全胜的A1已经提前夺冠了. `     
    ` (3) 由于A1已经占去了一个名额,只剩两个名额了,则B3、C3可以淘汰了.而且由于C1的最好成绩也只能是第三名了,所以C2也可以淘汰了. `   
  `第三轮,A2、A3、B1、B2、C1五匹马跑,取前两名. `   
  `其中第一轮跑6次,第二轮第三轮都各只跑1次,一共8次. `
  
<Strong>同学C的面经：</Strong>
* 1.手机连接服务器，手机断网后，服务器处于什么状态？(TCP断网重连问题)  <http://blog.csdn.net/kkkkkxiaofei/article/details/12966407>    
 `(1) 双方拟定心跳（自实现）`    
  `一般由客户端发送心跳包, 服务端并不回应心跳, 只是定时轮询判断一下与上次的时间间隔是否超时(超时时间自己设定). 服务器并不主动发送是不想增添服务器的通信量, 减少压力. `     
  `客户端很久没传心跳, 确实是自身断掉了. 在其重启之前, 服务端的轮询还未判断出其超时, 在未主动close的时候该客户端已经重新连接.  `   
  `若客户端断开的时候发送了FIN包, 则服务端将会处于CLOSE_WAIT状态; `     
  `若客户端断开的时候未发送FIN包, 则服务端处还是显示ESTABLISHED状态.  `       
 `(2) 利用KeepAlive  `     
  `在S和C建立连接后, 若双方均不发送数据只保持连接, 则再两小时后(这个时间我未测试过, 但很多资料都显示是这个间隔, 貌似是默认的)系统会自动启动保活机制向peer发送包, 看对方是否回应ack, 若可以收到则继续保持, 否则无效. `
* 2.动态规划类的问题.
* 3.智力题.  
* 4.项目介绍.

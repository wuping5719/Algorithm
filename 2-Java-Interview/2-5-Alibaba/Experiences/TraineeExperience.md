<h3> 2016-04：阿里巴巴(Alibaba)实习生招聘面试 </h3>
   一开始肯定会先问个人的研究方向, 论文, 项目, 然后从这些内容中找出一些问题来考察我们.   
   然后java基础大致如下：答案自己Google或百度找吧. (^_^)
* 1. HashMap和HashTable的区别, 及其实现原理. 
* 2. ArrayList, LinkedList和Vector的区别和实现原理.
* 3.TreeMap和TreeSet区别和实现原理.
* 4.ConcurrentHashMap实现原理(锁分离技术).
* 5.问JVM内存分代机制(会问分为哪几个代, 各个代特点), 分代回收的优点(这个问了很多次).
* 6.String和StringBuffer,StringBuilder区别和联系, String为啥不可变, 在内存中的具体形态.
* 7.Java中多线程机制, 实现多线程的两种方式(继承Thread类和实现Runnable接口)的区别和联系.
* 8.Java线程阻塞调用wait函数和sleep区别和联系, 还有函数yield, notify等的作用.
* 9.Java中的同步机制, synchronized关键字, 锁(重入锁)机制, 其他解决同步的方法：volatile关键字,ThreadLocal类的实现原理要懂.
* 10.Java中异常机制.
* 11.comparable接口和comparator接口的实现, 比较区别和用法. Arrays静态类如何实现排序的？
* 12.Java基础的差不多就这么多, 网络方面TCP, HTTP要明白, 进程和线程的区别联系(线程拥有哪些自己的资源).   
* 13.数据库优化.        
` 1)软件优化： `           
` (1)选择合适的数据库引擎. `         
` MyISAM：索引顺序访问方法，支持全文索引，非事务安全，不支持外键，表级锁，三个FRM文件存放表结构。 `          
` InnoDB：事务性存储引擎，行锁，update table set age=3 where name like "%tom%"，锁表，回滚，奔溃恢复。 `       
` ACID事务控制：表和索引存放在一个表空间里，表空间多个文件。 `        
` (2)正确地使用索引. `        
` a.给合适的列建立索引：where子句，连接子句，而不是select选择列表建立索引。 `        
` b.索引值应该不相同，唯一值索引效果最好，大量重复效果很差。 `           
` c.使用短索引，指定前缀长度char(50)，前20值唯一，较小的索引。 `       
` d.最左前缀，n列索引，最左列的值匹配。 `        
` e.like查询，索引失效，尽量少用like，百万 千万数据量级用like Sphinx开源方案结合MySQL。 `          
` f.不能滥用索引：索引占用空间；更新数据，索引必须更新，时间长，尽量不在长期不用的字段上建立索引；SQL执行查询语句，增加了查询优化的时间。 `         
` (3)避免使用select *. `           
`  返回结果内容多，降低查询速度；增大了服务器返回给APP端数据的数据传输量。 `        
` (4)字段尽量设置为Not Null. `         
` 2)硬件优化： `       
` (1)增加物理内存. `          
` Linux内核，内存开缓存存放数据； `            
` 写文件：文件延迟写入机制，先把文件放到缓存，达到一定数量写入硬盘； `           
` 读文件：读文件到缓存，下次需要相同文件从缓存中取。`          
` (2)增加应用缓存. `    
* 14.MySQL配置文件详解. 
```html
  /etc/my.cnf
  
  Client Section
  [client]
  port = 3306    # 设置mysql客户端连接服务端时默认使用的端口
  [mysql]
  default-character-set=utf8   # 设置mysql客户端默认字符集
  
  Server Section
  
```
  导师一直不让去实习，心中永远的痛啊！

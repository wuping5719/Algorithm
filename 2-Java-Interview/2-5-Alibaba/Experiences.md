<h3> 2016-04：阿里巴巴(Alibaba)实习生招聘面试 </h3>
   一开始肯定会先问个人的研究方向, 论文, 项目, 然后从这些内容中找出一些问题来考察我们. 
   然后java基础大致如下：答案自己Google或百度找吧. (^_^)
   
* 1.HashMap和HashTable的区别, 及其实现原理. 
* 2.ArrayList, LinkedList和Vector的区别和实现原理.
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
```txt
  1)软件优化：          
   (1)选择合适的数据库引擎.          
     MyISAM：索引顺序访问方法，支持全文索引，非事务安全，不支持外键，表级锁，三个FRM文件存放表结构。         
     InnoDB：事务性存储引擎，行锁，update table set age=20 where name like "%tom%"，锁表，回滚，奔溃恢复。   
     ACID事务控制：表和索引存放在一个表空间里，表空间多个文件。      
   (2)正确地使用索引.  
     a.给合适的列建立索引：where子句，连接子句，而不是select选择列表建立索引。    
     b.索引值应该不相同，唯一值索引效果最好，大量重复效果很差。      
     c.使用短索引，指定前缀长度char(50)，前20值唯一，较小的索引。
     d.最左前缀，n列索引，最左列的值匹配。  
     e.like查询，索引失效，尽量少用like，百万 千万数据量级用like Sphinx开源方案结合MySQL。 
     f.不能滥用索引：索引占用空间；更新数据，索引必须更新，时间长，
       尽量不在长期不用的字段上建立索引；SQL执行查询语句，增加了查询优化的时间。
   (3)避免使用select *.         
     返回结果内容多，降低查询速度；增大了服务器返回给APP端数据的数据传输量。  
   (4)字段尽量设置为Not Null.        
 2)硬件优化：        
   (1)增加物理内存.         
    Linux内核，内存开缓存存放数据；            
    --写文件：文件延迟写入机制，先把文件放到缓存，达到一定数量写入硬盘；        
    --读文件：读文件到缓存，下次需要相同文件从缓存中取。          
  (2)增加应用缓存. 
```

* 14.MySQL配置文件详解. 
```txt
  /etc/my.cnf
  
  Client Section
   [client]
   port = 3306    # 设置mysql客户端连接服务端时默认使用的端口
   [mysql]
   default-character-set=utf8   # 设置mysql客户端默认字符集
  
  Server Section
   [mysqld]
   port=3306      # mysql服务端默认监听(listen on)的TCP/IP端口
   basedir="D:/MySQL/MySQL Server 5.5/"      # 基准路径，其他路径都相对于这个路径
   datadir="D:/MySQL/MySQL Server 5.5/Data"   # mysql数据库文件所在目录
   character-set-server=latin1    # 服务端使用的字符集默认为8比特编码的latin1字符集
   default-storage-engine=INNODB  # 创建新表时将使用的默认存储引擎
   
   # SQL模式为strict模式
   sql-mode="STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION"  
   
   # mysql服务器支持的最大并发连接数（用户数）。
     但总会预留其中的一个连接给管理员使用超级权限登录，即使连接数目达到最大限制。
     如果设置得过小而用户比较多，会经常出现“Too many connections”错误。
   max_connections=100  
   
   # 查询缓存大小，用于缓存SELECT查询结果。
     如果有许多返回相同查询结果的SELECT查询，并且很少改变表，可以设置query_cache_size大于0，
     可以极大改善查询效率。而如果表数据频繁变化，就不要使用这个，会适得其反.
   query_cache_size=0 
   
   # 这个参数在5.1.3之后的版本中叫做table_open_cache，用于设置table高速缓存的数量。
     由于每个客户端连接都会至少访问一个表，因此此参数的值与max_connections有关。
     当某一连接访问一个表时，MySQL会检查当前已缓存表的数量。
     如果该表已经在缓存中打开，则会直接访问缓存中的表已加快查询速度；
     如果该表未被缓存，则会将当前的表添加进缓存并进行查询。
     在执行缓存操作之前，table_cache用于限制缓存表的最大数目：
     如果当前已经缓存的表未达到table_cache，则会将新表添加进来；
     若已经达到此值，MySQL将根据缓存表的最后查询时间、查询率等规则释放之前的缓存。
   table_cache=256    

   # 内存中的每个临时表允许的最大大小。
     如果临时表大小超过该值，临时表将自动转为基于磁盘的表(Disk Based Table)
   tmp_table_size=34M 
   
   # 缓存的最大线程数。当客户端连接断开时，如果客户端总连接数小于该值，则处理客户端任务的线程放回缓存。
     在高并发情况下，如果该值设置得太小，就会有很多线程频繁创建，线程创建的开销会变大，查询效率也会下降。
     一般来说如果在应用端有良好的多线程处理，这个参数对性能不会有太大的提高。
   thread_cache_size=8 
   
  # MyISAM相关参数
   myisam_max_sort_file_size=100G  # mysql重建索引时允许使用的临时文件最大大小
   myisam_sort_buffer_size=68M
   
   # Key Buffer大小，用于缓存MyISAM表的索引块。决定数据库索引处理的速度(尤其是索引读)
   key_buffer_size=54M  
   
   # 用于对MyISAM表全表扫描时使用的缓冲区大小。针对每个线程进行分配（前提是进行了全表扫描）。
   进行排序查询时，MySql会首先扫描一遍该缓冲，以避免磁盘搜索，提高查询速度，
   如果需要排序大量数据，可适当调高该值。
   但MySql会为每个客户连接发放该缓冲空间，所以应尽量适当设置该值，以避免内存开销过大。
   read_buffer_size=64K 

   read_rnd_buffer_size=256K

   # connection级参数（为每个线程配置），500个线程将消耗500*256K的sort_buffer_size。
   sort_buffer_size=256K 
   
 # InnoDB相关参数
  # InnoDB用于存储元数据信息的内存池大小，一般不需修改
  innodb_additional_mem_pool_size=3M
  
  # 事务相关参数，如果值为1，则InnoDB在每次commit都会将事务日志写入磁盘（磁盘IO消耗较大），
  这样保证了完全的ACID特性。而如果设置为0，则表示事务日志写入内存log和内存log写入磁盘的频率都为1次/秒。
  如果设为2则表示事务日志在每次commit都写入内存log，但内存log写入磁盘的频率为1次/秒。
  innodb_flush_log_at_trx_commit = 1 
  
  # 缓冲大小，如果缓冲满了，就会将缓冲中的日志数据写入磁盘（flush）。
  由于一般至少都1秒钟会写一次磁盘，所以没必要设置过大，即使是长事务。
  innodb_log_buffer_size=2M

  # InnoDB使用缓冲池来缓存索引和行数据。该值设置的越大，则磁盘IO越少。一般将该值设为物理内存的80%。
  innodb_buffer_pool_size=105M 

  # 每一个InnoDB事务日志的大小。一般设为innodb_buffer_pool_size的25%到100%
  innodb_log_file_size=53M 

  innodb_thread_concurrency=9  # InnoDB内核最大并发线程数
```

<h3> 2017-03-20：阿里云 春招电面 </h3>

* 1.简单自我介绍. 
* 2.对着简历，介绍自己做过的两个项目(主要在介绍项目)。
* 3.HashMap 实现原理。
```txt
   实现原理：每一个元素都是链表的数组，当添加一个元素(key-value)时，首先计算元素 key 的 hash 值，
以此确定插入数组中的位置，但是可能存在同一 hash 值的元素已经被放在数组同一位置了，这时就添加到同一
hash 值的后面，它们在数组的同一个位置，但是形成了链表，同一各链表上的 hash 值是相同的，数组存放的是链表。
而当链表长度太长时，链表就转换为红黑树，这样就大大提高了查找效率。
   在 JDK1.8中，HashMap 采用位桶 + 链表 + 红黑树实现，当链表长度超过阈值(8)时，将链表转换为红黑树。
```
  HashMap源码：<https://github.com/wuping5719/Reading-Java-SourceCode/blob/master/JDK1.7/java/util/CollectionRelated/HashMap.md>
  
* 4.分布式事务.

`搜集的两篇文章： `
`  (1) 分布式系统的事务处理：` <http://coolshell.cn/articles/10910.html>
`  (2) 深入理解分布式事务：` <http://www.codeceo.com/article/distributed-transaction.html>
  
* 5.数据库问题：InnoDB 和 MyISAM 两种引擎的区别？
* 6.对阿里云的了解.

<h3> 2016秋招百度测试面经 </h3>
<Strong>一面技术基础</Strong>

* 1.简单自我介绍。 
* 2.讲讲快速排序算法。  
  `快速排序的原理：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序。`
  `"保证列表的前半部分都小于后半部分"就使得前半部分的任何一个数从此以后都不再跟后半部分的数进行比较了，大大减少了数字间的比较次数。`
* 3.我们为什么认为快速排序算法比冒泡法快？   
  `快速排序：是对冒泡法的一种改进。`
* 4.在什么情况下，快速排序法完全失去他的优势，时间复杂度和冒泡一样？    
  `数组已经有序或大致有序的情况下，每次划分只能减少一个元素，快速排序将不幸退化为冒泡排序。`
* 5.列举并解释你所知道的排序算法。   
  <https://github.com/wuping5719/Algorithm/tree/master/12-Sort>
* 6.怎样判断一个单向链表有没有环? 怎样判断指针指向的是尾节点?       
  `(1) 快慢指针法：用两个指针：pSlow，pFast，一个慢一个快；慢的一次跳一步，快的一次跳两步，往链表末端移动。如果pFast==NULL，则说明链表没有环，如果pSlow==pFast，则说明链表存在环。`       
  `(2) 分别从头指针、环入口开始走，相遇的那个点就是环入口(尾节点).`
* 7.写sql语句建个表:包含学生学号、姓名、性别、入学时间.   
```sql
  CREATE TABLE Student 
  (  
     Sno CHAR(9) PRIMARY KEY,  //列级完整性约束，Sno是主码
     Sname CHAR(20) UNIQUE,    //Sname取唯一值
     Ssex CHAR(2),
     S_entrance DATE
  ); 
```
* 8.写sql语句查询最新入学的五位女生.   
```sql
   SELECT TOP 5 * FROM Student 
     WHERE Ssex='女' ORDER BY S_entrance DESC;
```
* 9.写sql语句删除所有学生信息.   
```sql
    DELETE FROM Student;
```
* 10.drop和delete的区别.    
 `SQL truncate、delete与drop的区别: `    
 `1)相同点： `   
 `(1) truncate和不带where子句的delete、以及drop都会删除表内的数据。 `     
 `(2) drop、truncate都是DDL语句(数据定义语言), 执行后会自动提交。 `   
 `2)不同点： `   
 `(1) truncate和delete只删除数据, 不删除表的结构(定义). drop语句将删除表的结构被依赖的约束(constrain)、触发器(trigger)、索引(index)；依赖于该表的存储过程/函数将保留, 但是变为invalid 状态。 `    
 `(2) delete语句是数据库操作语言(DML)，这个操作会放到rollback segement中，事务提交之后才生效；如果有相应的trigger，执行的时候将被触发。truncate、drop是数据库定义语言(DDL)，操作立即生效，原数据不放到rollback segment中，不能回滚，操作不触发trigger。`  
 `(3) delete语句不影响表所占用的extent，高水线(high watermark)保持原位置不动; drop语句将表所占用的空间全部释放; truncate语句缺省情况下将空间释放到minextents个extent，除非使用reuse storage；truncate会将高水线复位(回到最开始)。`   
 `(4) 速度，一般来说: drop > truncate > delete。`     
 `(5) 安全性：小心使用drop和truncate，尤其没有备份的时候。 否则哭都来不及。使用上, 想删除部分数据行用delete，注意带上where子句。回滚段要足够大。想删除表, 当然用drop。想保留表而将所有数据删除，如果和事务无关，用truncate即可。如果和事务有关, 或者想触发trigger,还是用delete。如果是整理表内部的碎片，可以用truncate跟上reuse stroage，再重新导入/插入数据。`   
 `(6) delete是DML语句, 不会自动提交。drop/truncate都是DDL语句, 执行后会自动提交。`      
 `(7) TRUNCATE TABLE在功能上与不带WHERE子句的DELETE语句相同：二者均删除表中的全部行。但TRUNCATE TABLE比DELETE速度快，且使用的系统和事务日志资源少。DELETE语句每次删除一行，并在事务日志中为所删除的每行记录一项。TRUNCATE TABLE通过释放存储表数据所用的数据页来删除数据，并且只在事务日志中记录页的释放。 `     
 `(8) TRUNCATE TABLE删除表中的所有行，但表结构及其列、约束、索引等保持不变。新行标识所用的计数值重置为该列的种子。如果想保留标识计数值，请改用DELETE。如果要删除表定义及其数据，请使用DROP TABLE语句。  `    
 `(9) 对于由FOREIGN KEY约束引用的表，不能使用TRUNCATE TABLE，而应使用不带WHERE子句的DELETE语句。由于TRUNCATE TABLE不记录在日志中，所以它不能激活触发器。`   
 `(10) TRUNCATE TABLE不能用于参与了索引视图的表。 `  
* 11.你觉得你比较适合测试工作的特质是什么?  
* 12.我们的产品你觉得最值得吐槽点是什么? 
* 13.输入两个表示年月日时间的字符串，计算这两个时间相差多少天?   
```java
   import java.util.*;
   public class Test {
      public void dateDiff(String startTime, String endTime, String format) {
         //SimpleDateFormat
         SimpleDateFormat sd = new SimpleDateFormat(format);
         long nd = 1000*24*60*60;  //一天的毫秒数
         long diff = 0;
         try {
           //获得两个时间的毫秒时间差异
           diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
           long day = diff/nd; //计算差多少天
           System.out.println("时间相差："+day+"天.");
         }
      }
    }
```
* 14.linux指令怎么查询一个字符串在哪个文档中出现过?      
  ` find .|xargs grep -ri "IBM" -l `     <https://zhidao.baidu.com/question/305494384200177364.html>
* 15.你了解的linux指令有哪些?     
    <http://www.weixuehao.com/archives/25>
* 16.北京这城市这样，你为什么还想来?   
* 17.你有没有从师姐师兄那儿了解技术工作这么累，为什么还要做?   
* 18.你觉得百度招的这个开发测试工程师和别的公司招的测试工程师有什么差别?   
* 19.在测试的过程中遇到缺陷，但是开发人员很固执怎么办? 我想了个招，她又问要是他还继续固执呢? 我又想了个招，有兴趣的可以来问我，并不觉得自己的招好? 
* 20.对多线程有了解吗?
* 21.你还有什么要问我的吗?        
  一共面了一个小时，建议面前喝适量水，到最后真的好渴，晚上十点半左右收到了二面通知。 

<Strong>二面技术</Strong>
* 1.简单自我介绍。 
* 2.单向链表反转。(我想了个办法要用到三个指针) 追问能不能用两个指针，我就问他对空间复杂度有没有要求，他说没有，我说了一种办法。他继续追问，如果对空间复杂度有要求呢，然后还提示了一下改变一下语句顺序试试，然而我还是没想出来。      
  方法1：将单链表储存为数组，然后按照数组的索引逆序进行反转。    
  方法2：使用三个指针遍历单链表，逐个链接点进行反转。    
  方法3：从第2个节点到第N个节点，依次逐节点插入到第1个节点(head节点)之后，最后将第一个节点挪到新表的表尾。
  <http://blog.csdn.net/sicofield/article/details/8850269>
* 3.他建了两表：一个是课程表，一个是学生表，让我用sql语句建个学生选课表。     
   数据库的题，详见高教版《数据库系统概论(第4版)》(王珊，萨师煊) P85。
```sql
   CREATE TABLE SC
   (
     Sno CHAR(9),
     Cno CHAR(4),
     Grade SMALLINT,
     PRIMARY KEY (Sno, Cno),
     FOREIGN KEY (Sno) REFERENCES Student(Sno),
     FOREIGN KEY (Cno) REFERENCES Course(Cno)
   );
```
* 4.查询每个课程对应的选课人数，我问没人选的需要显示吗，他说不用。他又问我：如果需要显示呢? 还具体问了问group by count是什么意思?
```sql
   SELECT Cno,COUNT(Sno)
   FROM SC
   GROUP BY Cno;
   ```
   ```mysql
    SELECT SC2.Cno as level, COUNT(case when Sno is not null then 1 end) as count
    FROM SC2 LEFT JOIN SC1 ON SC2.Cno = SC1.level
    GROUP BY SC2.Cno;
```
   group by子句将查询结果按某一列或多列的值分组，值相等的为一组.     
    高教版《数据库系统概论(第4版)》(王珊，萨师煊) P99。
* 5.linux服务器某个进程占用了太多系统资源，导致其他进程运行缓慢，怎么办? 我回答要把这个进程挂起，他问我怎么办?
  <http://www.cnblogs.com/panfeng412/archive/2013/12/17/drop-caches-under-linux-system-2.html>
* 6.linux服务器怎么查磁盘占用率和cpu占用率?    
   (1) 查磁盘占用率:     
   df 命令是一个显示文件系统使用情况状态的命令.      
   df -h     
   (2) 查cpu占用率:    
   top命令可以查看CPU、内存利用率.      
   $ top -u oracle
* 7.怎么把linux集群的某个主机上的文件拷贝到另一台主机上?      
  (1) 将远程linux主机上/remote/path的文件copy到本主机的/local/path目录.       
     scp user@remote.machine:/remote/path  /local/path    
  (2) 将本主机的/local/path目录copy到远程linux主机上/remote/path的文件.      
     scp /local/path user@remote.machine:/remote/path
* 8.从文本中读取大量信息，每行信息包含一个ip，一个url和一个时间，之间用逗号分割，表示这个ip在这个时间对这个url进行了访问。问某个ip访问了哪些url，分别对这些url访问了多少次?   
  我提出了最笨的办法，他问我对哈希有没有了解，我就又用了哈希，我又提到了后缀树，他问我后缀树为什么可以? 为什么快? 他继续追问我还有别的办法吗? 我就想到了hadoop的key_value这个场景是多么合适呀！然后他可能没了解，问我能不能用c++的数据结构来表达，我们俩都没想出好办法就过了这题啦!
  大数据题。 <http://blog.csdn.net/v_july_v/article/details/7382693>
* 9.一个类似百度地图的手机应用，他问我怎么保障实时显示的点是准确可靠的? 
* 10.经纬度的表示用什么数据类型? 我说float。他问我这个类型在计算机里是怎么存储的?     
   `float即浮点型变量，在计算机内存中占用4字节(Byte), 即32-bit. 遵循IEEE-754格式标准.`     
   `一个浮点数由2部分组成：底数m和指数e。`       
   `表示为： ±mantissa × 2exponent `    
   `注意，公式中的mantissa和exponent使用二进制表示 `   
   `底数部分:使用2进制数来表示此浮点数的实际值.底数部分实际是占用24-bit的一个值, 由于其最高位始终为1, 所以最高位省去不存储, 在存储中只有23-bit.`    `指数部分:占用8-bit的二进制数,可表示数值范围为0－255.但是指数应可正可负,所以IEEE规定,此处算出的次方须减去127才是真正的指数.所以float的指数可从-126到128. `
* 11.你有什么要问我的吗?     
  二面也问了正好一个小时。

<Strong>三面技术</Strong>     
  技术面被虐太惨，以为没戏就回青岛了。25号傍晚收到通知让我第二天去三面。我已经回青，于是商量了一下27号面。三面没有英语面，但还是会问一点技术问题。我那个三面比较特殊，是他们天津之行的最后一位了，特别仓促。
* 1.未来三五年的职业规划。 
* 2.微信怎么测?  
* 3.认为测试的大体流程是怎样的?   
   <http://blog.sina.com.cn/s/blog_a3be52b6010177o6.html>
* 4.觉得我们公司怎么样有了解吗?  
* 5.会不会觉得做测试没有做开发有成就感?  
* 6.手里有offer吗?  
* 7.如果手里有多个offer会怎么选择?    
* 8.你实习期间测得那些东西, 他们是用什么语言写的?    
* 9.介绍一下你这个实习吧?    
* 10.在学校有没有学过测试相关的课程?      
* 11.有什么问我的吗?    
  这是一段百度测试面经, 拿到Offer。作为男生，压根就没把测试考虑在内。但是狼厂这种大厂，做测试还是需要相当的实力的。基础知识太渣，还得狠补。特别是数据库教材-高教版《数据库系统概论(第4版)》(王珊，萨师煊)得多看几遍, 数据库问的全是原题.

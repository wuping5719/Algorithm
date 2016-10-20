### 途牛(Tuniu)2016秋招笔试题 ###
* 1.实现有序HashMap的原理和伪码?    
 &nbsp; `参考LinkedHashMap实现有序的原理：用额外的链表保证插入顺序.  `    
 &nbsp; `HashMap无序与LinkedHashMap有序: ` <http://xiaoz5919.iteye.com/blog/1250427>

* 2.实现勾股定理.    
  &nbsp; 显示200以内所有整数的勾股定理组合.
  ```java
  public class PythagoreanTheorem {
    //显示200以内所有整数的勾股定理组合
    private static final long num = 200;
    
    public static void main(String[] args) {
	 for (int i = 1; i < num; i++) {
	     for (int j = i; j < num; j++) {
		  for (int k = j; k < num; k++) {
		        if((i * i + j * j) == k * k)
		           System.out.println("勾：" + i + " 股：" + j + " 玄：" + k);
		  }
	      }
	  }
     }
  }
  ```
  
* 3.跨站脚本攻击(XSS)与跨站请求伪造攻击(CSRF).    
 &nbsp; `(1) xss跨站脚本攻击(Cross Site Scripting), 为了不和层叠样式表(Cascading Style Sheets,CSS)缩写混淆, 所以将跨站脚本攻击缩写为xss. Xss是攻击者在web页面插入恶意的代码. 当用户浏览该页面的时候, 代码执行, 从而实现攻击目的. 对受害用户可能采取Cookie资料窃取、会话劫持、钓鱼欺骗等各种攻击. `  
 &nbsp; ` (2) CSRF(Cross-site request forgery)，中文名称：跨站请求伪造，也被称为：one click attack/session riding, 缩写为：CSRF/XSRF。危害是攻击者可以盗用你的身份，以你的名义发送恶意请求。比如可以盗取你的账号，以你的身份发送邮件，购买商品等。 `     
 &nbsp; ` 跨站脚本攻击XSS: ` <http://www.cnblogs.com/dolphinX/p/3391351.html>      
 &nbsp; ` 跨站请求伪造攻击CSRF: ` <http://www.cnblogs.com/4littleProgrammer/p/5089958.html>      
 &nbsp; ` 两者比较：` <http://blog.csdn.net/baidu_24024601/article/details/51957270>

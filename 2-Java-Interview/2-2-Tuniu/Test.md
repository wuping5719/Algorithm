### 途牛(Tuniu)2016秋招笔试题 ###
* 1.实现有序HashMap的原理和伪码?
 &nbsp; 参考LinkedHashMap实现有序的原理：用额外的链表保证插入顺序.    
 &nbsp; HashMap无序与LinkedHashMap有序: <http://xiaoz5919.iteye.com/blog/1250427>

* 2.实现勾股定理.    
  &nbsp;  显示200以内所有整数的勾股定理组合.
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

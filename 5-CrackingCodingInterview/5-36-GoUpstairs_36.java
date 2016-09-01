package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月1日 上午10:02:33
 */

public class GoUpstairs_36 {

   /* 
    * a[i]=((a[i-1]+a[i-2])%1000000007 + a[i-3])%1000000007的解释：
                  取模运算有这样一个性质：(a+b)%c = ((a%c)+(b%c))%c
                  所以(a[i-1]+a[i-2])%1000000007就相当于(a[i-1]%X+a[i-2]%X)%X, 用X代替1000000007
                  这样就使得a[i-1]、a[i-2]、a[i-1]+a[i-2]都没有溢出, 之后再与a[i-3]相加之后取模, 
                  使得全部结果没有溢出.
   */
    public static int countWays(int n) {
       if(n < 1)
	   return 0;
       if(n==1) 
	   return 1;
       if(n==2) 
	   return 2;
       if(n==3)
	   return 4;
       
       int f1 = 1;
       int f2 = 2;
       int f3 = 4;
       int result = 0;
       for(int i=4; i<=n; i++)
       {
           result=((f3 + f2) % 1000000007 + f1) % 1000000007;
           f1 = f2;
           f2 = f3;
           f3 = result;
       }
       return result;
    }
    
    public static void main(String[] args) {
       Scanner cin = new Scanner(System.in);
       while(cin.hasNextInt()) {
	   int n = cin.nextInt();
	   int result = countWays(n);
	   System.out.print(result);
       }
       cin.close();
    }

}

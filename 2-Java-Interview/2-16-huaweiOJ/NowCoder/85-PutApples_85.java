package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午10:43:15
 */

public class PutApples_85 {

   /* 设f(m, n)为m个苹果, n个盘子的放法数目.
            当n>m: 必定有n-m个盘子永远空着, 去掉它们对摆放苹果方法数目不产生影响.
                 即if(n>m) f(m,n) = f(m,m)　　
            当n<=m: 不同的放法可以分成两类:
      1.有至少一个盘子空着, 即相当于f(m, n) = f(m, n-1); 
      2.所有盘子都有苹果, 即f(m,n) = f(m-n,n).
           而总的放苹果的放法数目等于两者的和, 即 f(m,n) = f(m,n-1)+f(m-n,n)
   */
    public static int putApples(int m, int n) {
	if (m < 0) {
	    return 0;
	}
	if (m == 1 || n == 1) {
	    return 1; 
	}
	return putApples(m, n-1) + putApples(m-n, n);
    }

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
            int m = cin.nextInt();
            int n = cin.nextInt();
            if(m<1 || n>10){
                System.out.println(-1);
            }else{
                System.out.println(putApples(m,n));
            }
	}
	cin.close();
    }

}

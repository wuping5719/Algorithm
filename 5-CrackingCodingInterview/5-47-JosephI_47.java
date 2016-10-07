package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月7日 下午10:48:04
 */

public class JosephI_47 {

   /* 
    * 把n个人的编号改为0~n-1, 然后对删除的过程进行分析.
                第一个删除的数字是(m-1)%n, 记为k, 则剩余的编号为(0,1,...,k-1,k+1,...,n-1),
                下次开始删除时, 顺序为(k+1,...,n-1,0,1,...k-1)
                用f(n,m)表示从(0~n-1)开始删除后的最终结果.
                用q(n-1,m)表示从(k+1,...,n-1,0,1,...k-1)开始删除后的最终结果.
                则f(n,m)=q(n-1,m)
                下面把(k+1,...,n-1,0,1,...k-1)转换为(0~n-2)的形式, 即
         k+1 对应  0
         k+2 对于  1
         ...
         k-1 对应  n-2
               转化函数设为p(x)=(x-k-1)%n, p(x)的反函数为p'(x)=(x+k+1)%n。
               则f(n,m)=q(n-1,m)=p'(f(n-1,m))=(f(n-1,m)+k+1)%n, 又因k=(m-1)%n
       f(n,m)=(f(n-1,m)+m)%n;
               最终的递推关系式为:
        f(1,m) = 0;              (n=1)
        f(n,m) = (f(n-1,m)+m)%n; (n>1)
    */
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            
            int result = 0;
            if (n < 0 || m < 0) {
        	result = -1;
            }
            int last = 0;
            for(int i=2; i<=n; i++){
                last = (last + m) % i;
            }
            // 实际编号为(1~n)
            result = last + 1;
            System.out.println(result);
        }
        cin.close();
    }

}

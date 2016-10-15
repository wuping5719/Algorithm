package acmCoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月15日 下午7:53:56
 */

public class WoodenStick {

    /* 接木棍
     * 输入
                   输入包含多组数据，每组数据包括两行。第一行为一个不大于64的整数，表示折断后的木棍数。
                   第二行是折断后各节木棍的长度。
                  在最后一组数据之后的一行是一个零，表示数据结束。
                  输出
                     对每组数据，在单独的行中输出原始木棍的最小可能长度。
                样例输入
      9
      5 2 1 5 2 1 5 2 1
      4
      1 2 3 4
      0
                 样例输出
      6
      5
     */
    
    /*解题思路：http://www.cnblogs.com/lidaxin/p/4861544.html
    DFS+剪枝. 
          显然原始木棍的长度一定是n段小木棍长度之和sum的约数, 
          只需要从小到大一次枚举sum的每一个约数m(m要大于n个数中最大的那一个,
          不然肯定不能切割成这n段小木棍),判断m是否可能为初始木棍长度就OK了.
          判断的方式使用DFS, 主要的剪枝大致有如下几个.
    1)木棍的长度从大到小排序, 因为经验告诉我们越长的木棍灵活性越差, 所以优先放置长一点的木棍.
    2)如果当前长度的木棍无法和后面的木棍组成合法的解, 那么和它同样长度的木棍一样不能, 因此我们可以跳过和它长度相同的木棍.
    3)如果组成原始木棍的第一根木棍无法得出合法解, 那么就直接返回不必搜索了, 因为以后也不可能得出合法解.
    4)(参照LRJ黑书)如果某长度的木棍刚好能填满一根原始木棍并且剩余木棍不能组成合法解, 那么我们考虑两种策略,
           一是使用更长的木棍, 这显然是不可以的, 而如果采用更短的小木棍, 即使存在某个也能填满原始木棍的方法, 也不可能比用长木棍更有希望获得合法解.
           因此当出现这种情况时我们可以直接退出当前的枚举, 没有必要考虑其他木棍了. 
   */
    
    public static int countNum(int[] A, int n) {
	Arrays.sort(A);
	int min = A[n-1];
        
	int sum = 0;
	for(int i=0; i<n; i++) {
	    sum += A[i];
	}
	
        for(int i=A[n-1]; i<sum; i++) {
            if(sum % min == 0) {
        	break;
            }else {
        	min = i;
            }
        }
        return min;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    if(n==0) {
		break;
	    }
	    int[] A = new int[n];
	    for(int i=0; i<n; i++) {
		A[i] = cin.nextInt();
	    }
	    System.out.println(countNum(A, n));
	}
	cin.close();
    }

}

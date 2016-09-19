package acmCoder;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月19日 下午4:07:02
 */

public class JumpingGrasshopper {
    /*
     * 跳跃的蚂蚱 :
     *     时间限制：C/C++语言 1000MS；其他语言 3000MS 内存限制：C/C++语言 65536KB；其他语言 589824KB
     * 题目描述：
     *     小B对脑筋急转弯问题很有兴趣，她觉得这种问题的挑战能够反映一个人的应急反应能力。她正在开发一个智力测试的游戏，游戏的主角是一个蚂蚱。
     *     蚂蚱最初位于0点处，可以在直线上向正向或反向两个方向跳跃。比较特别的是，蚂蚱每次跳跃的距离比前一次跳跃多一个单位，第一次跳跃的距离为一个单位。
     *     小B的问题是，如果让蚂蚱跳跃到x处，需要经过多少次跳跃，你能解决这个问题吗？ 
     * 输入:
     *     输入中有多组测试数据。每组测试数据为单独的一行，包含一个整数x（-10^9 =< x =< 10^9）。
     *     
     * 解题思路：用到BigInteger处理大整数问题
     */
    
    // 方法一: 只能出部分结果
    public static String GetNumOfJumpingGrasshopper(BigInteger n) {
	BigInteger step = BigInteger.ZERO;
	BigInteger current = BigInteger.ZERO;;
	if (n.compareTo(BigInteger.ZERO) >= 0) {
	    while (current.compareTo(n) != 0) {
		BigInteger nextStep = step.add(BigInteger.ONE);
		BigInteger temp = current.add(nextStep);
		if (temp.compareTo(n) <= 0) {
		    current = current.add(nextStep);
		} else {
		    current = current.subtract(nextStep);
		}
		step = step.add(BigInteger.ONE);
	    }
	} else {
	    while (current.compareTo(n) != 0) {
		BigInteger nextStep = step.add(BigInteger.ONE);
		BigInteger temp = current.subtract(nextStep);
		if (temp.compareTo(n) >= 0) {
		    current = current.subtract(nextStep);
		} else {
		    current = current.add(nextStep);
		}

		step = step.add(BigInteger.ONE);
	    }
	}

	return step.toString();
    }

    // 方法二: 闻波的方法
    /* 思路是：令S=0+1+2+3+...+n, 当且仅当S>x且S-x为偶数时n即为所求次数。
                    当S>x时我们就可以采用添加负号（即往回走）来让结果=x，只不过因为往回走m的话会导致实际的总和比原来小2m。
                    所以需要保证1+2+3+...+n - x大于0且为偶数，那么他们的差S-x除以2就是应该添加负号的位置。
                    比如x=7的时候，1+2+3+4 - 7 =3,为奇数，所以不行，然后到1+2+3+4+5 - 7=8，然后除以2得4，
                    也就是说只需要-4（或者-1，-3）都可以5步到7的位置.
    */
    public static long GetNumOfJumpingGrasshopper2(long x) {
	long n = (long) Math.floor(Math.sqrt(2.0 * x));
	if(n*(n+1) < 2*x) {
	    n += 1;
	}
	
	long result = (Math.abs(n*(n+1) / 2 - x) & 1) >= 0 ? (n+1) : n;
        if(x==0) {
            result = 0; 
        }
        if(1==Math.abs(x)) {
            result = 1; 
        }
        if(3==Math.abs(x)) {
            result = 2; 
        }
        
	return result;
    }
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (sc.hasNext()) {
	    //BigInteger n = sc.nextBigInteger();
	    //String result = GetNumOfJumpingGrasshopper(n);
	    //System.out.println(result);
	    
	    long x = sc.nextLong();
	    long res = GetNumOfJumpingGrasshopper2(x);
	    System.out.println(res);
	}
	sc.close();
    }

}

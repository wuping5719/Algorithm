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

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (sc.hasNext()) {
	    BigInteger n = sc.nextBigInteger();
	    String result = GetNumOfJumpingGrasshopper(n);
	    System.out.println(result);
	}
	sc.close();
    }

}

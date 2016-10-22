package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月22日 下午3:41:19
 */

public class SingleNumberII_13 {

    // 方法一：位操作
    // Single Number II中想要记录每个bit出现的次数，一个数搞不定就加两个数，用ones来记录只出现过一次的bits，
    // 用twos来记录只出现过两次的bits，ones&twos实际上就记录了出现过三次的bits，
    // 这时候我们来模拟进行出现3次就抵消为0的操作，抹去ones和twos中都为1的bits。
    public static int singleNumber(int[] A) {
	int ones = 0; //记录只出现过1次的bits
        int twos = 0; //记录只出现过2次的bits
        int threes;
        for(int i = 0; i < A.length; i++){
            int t = A[i];
            twos |= ones & t;  //要在更新ones前面更新twos
            ones ^= t;
            threes = ones&twos; //ones和twos中都为1即出现了3次
            ones &= ~threes;    //抹去出现了3次的bits
            twos &= ~threes;
        }
        return ones;  
    }
    
    // 方法二： 排序比较，题目要求不使用额外缓存空间
    public static int singleNumber2(int[] A) {
	// 排序
	Arrays.sort(A);
	// 肯定是每三个数一组
	for (int i = 0; i < A.length - 3; i += 3) {
	    // 只需要比较每组的第一和第二个数是否相等
	    if ((A[i] != A[i + 1]))
		return A[i];
	}
	return A[A.length - 1]; // 每三个一组, 最后的一个是single one
    }

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[] A = new int[n];
	    for(int i=0; i<n; i++) {
		A[i] = cin.nextInt();
	    }
	    
	    System.out.println(singleNumber(A));
	}
	cin.close();
    }
}

package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月11日 下午5:01:07
 */

public class MaxSum_65 {

    /*思路：时间复杂度O(n), 空间复杂度O(1)
      1.首先定义一个和的最小值
      2.遍历开始累加 一开始是最小值 ，所以 sum += A[0];
        sum > max; max就为A[0]; 判断如果sum是小于0，重置sum = 0， （累加的初始值还应从0开始），
                      因为我们把值存在了max中，所以sum重置为0, 不影响max的变化，所以每次比较 sum和 max就好.
      3.这种解法 还有利于求解: 产生最大值的区间位置.
      4.区间位置：就是最后一次更新 sum = 0时，和最后一次max更新时的位置.
    */  
    public static int getMaxSum(int[] A, int n) {
	int sum = 0;
	int max = Integer.MIN_VALUE;
	if (n == 1) {
	    return A[0];
	}
	for (int i = 0; i < n; ++i) {
	    sum += A[i];
	    if (sum > 0)
		max = max < sum ? sum : max;
	    else
		sum = 0;
	}
	return max;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[] A = new int[n];
	    for(int i=0; i<n; i++) {
		A[i] = cin.nextInt();
	    }
	   
	    System.out.println(getMaxSum(A, n));    
	}
	cin.close();

    }

}

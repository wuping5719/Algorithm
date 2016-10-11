package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月11日 下午9:50:33
 */

public class FindNumAppearOnce {

    //题目: 数组A中, 除了某一个数字x之外, 其他数字都出现了三次, 而x出现了一次.
    // 请给出最快的方法,找到x.要求时间复杂度为O(n),空间复杂度为O(1).
    //分析: 分别统计每一个数字32bit出现1的次数, 然后将所有数字对应bit的次数相加,
    // 得到的次数对3取余,出现3次的数字都在对3取余的过程中抵消掉了,剩下的次数即为x各位出现1的次数.
    //推广: 所有其他数字出现N(N>=2)次, 而一个数字出现1次都可以用这种解法来推导出这个出现1次的数字.
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[] A = new int[n];
	    for(int i=0; i<n; i++) {
		A[i] = cin.nextInt();
	    }
	   
	    int[] counts = new int[32];
	    for (int i = 0; i < n; i++)
	    {
	        for (int j = 0; j < 32; j++)
	        {
	            counts[j] = (counts[j] + (A[i] >> j & 1)) % 3;
	        }
	    }
	    
	    int result = 0;
	    for (int i = 0; i < 32; i++) {
		result += (counts[i] << i);
	    }
	    System.out.println(result);    
	}
	cin.close();

    }

}

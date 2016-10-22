package leetcode;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月22日 下午4:12:14
 */

public class SingleNumberI_14 {
    
    // 位操作: 依次将数组中的数相异或，最后剩下只出现一次的数
    public static int singleNumber(int[] A) {
	int num = 0;
	for (int i = 0; i < A.length; i++) {
	    num ^= A[i];
	}
	return num;
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

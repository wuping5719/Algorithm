package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月11日 下午4:38:46
 */

public class Rearrange_64 {

    public static int[] findSegment(int[] A, int n) {
	if (A == null || n <= 0) {
	    return new int[] { 0, 0 };
	}

	int M = 0;
	int N = 0;

	// 计算[M,N]中的N
	// 如果当前元素小于之前的最大元素则说明当前元素应处于[M N]无序序列中
	// 而且当前元素是当前最大下标的无序元素所以更新N为当前元素下标
	int max = A[0];
	for (int i = 1; i < n; i++) {
	    if (A[i] >= max) {
		max = A[i];
	    } else {
		N = i;
	    }
	}

	// 计算[M,N]中的M
	// 如果当前元素大于之前的最小元素则说明当前元素应处于[M N]无序序列中
	// 而且当前元素是当前最小下标的无序元素所以更新M为当前元素下标
	int min = A[n - 1];
	for (int i = n - 2; i >= 0; i--) {
	    if (A[i] <= min) {
		min = A[i];
	    } else {
		M = i;
	    }
	}

	return new int[] { M, N };
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[] A = new int[n];
	    for(int i=0; i<n; i++) {
		A[i] = cin.nextInt();
	    }
	    
	    int[] result = findSegment(A, n);
	    System.out.println(result[0] +" "+ result[1]);
	}
	cin.close();
    }

}

package leetcode;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年12月18日 下午8:22:35
 */

public class MergeSortedArray_21 {

    //i从A的末尾, j从B末尾开始, 两两比较, 大的放在result的末端。
    //如果A穷尽，把B元素依次放进result的前几个位置，如果B穷尽，正好结束。
    public static int[] merge(int A[], int m, int B[], int n) {
        int[] result = new int[m + n];
	if(m == 0) {
            for(int i=0; i<B.length; i++) {
        	result[i] = B[i];
            }
        }else {
            int aIndex = m - 1;
            int bIndex = n - 1;
            int rIndex = m + n - 1;
            while(bIndex >= 0 && aIndex >= 0) {
        	if(A[aIndex] > B[bIndex]) {
        	    result[rIndex--] = A[aIndex--];
        	}else {
        	    result[rIndex--] = B[bIndex--];
        	}
            }
            if(aIndex == -1){
                for(; bIndex>=0; bIndex--) {
                    result[bIndex] = B[bIndex]; 
                }
            }
        }
	return result;
    }

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);

	int m = 3;
	int n = 3;
	int[] A = { 4, 5, 7 };
	int[] B = { 1, 2, 6 };
	
	int[] result = merge(A, m, B, n);
	for (int i = 0; i < result.length; i++) {
	    System.out.print(result[i] + " ");
	}
	
	cin.close();
    }

}

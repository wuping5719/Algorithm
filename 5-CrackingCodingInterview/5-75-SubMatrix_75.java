package crackingCodingInterview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月19日 上午11:14:24
 */

public class SubMatrix_75 {

    /* 思路：
     1.求子矩阵的最大和，首先得判定所有可能的子矩阵（纵向选定）
     2.纵向选定后，将这块子矩阵按行累加压缩成一维，然后处理简单的一维（横向选定）
     3.过程中有最大值出现即时更新即可
    */
    public static int sumOfSubMatrix(int[][] mat, int n) {       
	if (mat == null || mat.length == 0) {
	    return 0;
	}
	int maxSum = Integer.MIN_VALUE;
	int len = mat.length;
	int[] sum = new int[len];
	for (int i = 0; i < len; i++) {  //压缩的起点
	    Arrays.fill(sum, 0);
	    for (int row = i; row < len; row++) {  //步长，矩阵=起点+步长
		for (int col = 0; col < len; col++) {
		    sum[col] += mat[row][col];  //求上述矩阵的压缩和
		}
		int temp = getMaxSum(sum);    //压缩为一维求和，取最大值     
		maxSum = Math.max(temp, maxSum); 
	    }
	}
	return maxSum;
    }
    
    //一维数组中连续子数组的最大和
    public static int getMaxSum(int sum[]){
	int maxSum = Integer.MIN_VALUE;
	int curSum = 0;
        for(int i=0; i<sum.length; i++){
            curSum += sum[i];
            maxSum = Math.max(maxSum, curSum);
            if(curSum<0) 
        	curSum = 0;
        }
        return maxSum;
    }   
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    
	    int[][] mat = new int[n][n];
	    for(int i=0; i<n; i++) {
		for(int j=0; j<n; j++) {
		    mat[i][j] = cin.nextInt();
		}
	    }
	    
	    System.out.println(sumOfSubMatrix(mat, 3));
	}
	cin.close();
    }

}

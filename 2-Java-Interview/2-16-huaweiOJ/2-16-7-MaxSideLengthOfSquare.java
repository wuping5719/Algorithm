package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月25日 上午9:51:28
 */

public class MaxSideLengthOfSquare {

    /* 最大的正方形
            描述: 	
                    给你一个N*M的矩阵，每个位置的值是0或1，求一个面积最大的子矩阵，这个矩阵必须是一个正方形，
                    且里面只能由1构成，输出最大的正方形边长
                    运行时间限制:  2 Sec
                    内存限制: 	      无限制
             输入: 	
                     第一行输入两个整数n，m，之后n行，每行m个数字，为矩阵第i行第j列的值，只可能是0或者1
        n,m<=400
             输出: 	
                      一个整数，为最大正方形的边长
             样例输入: 	
         3 3
         1 1 1
         1 1 1
         0 0 1
            样例输出: 	
         2
     */	
     
   public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int m = cin.nextInt();
	    int[][] matrix = new int[n][m];
	    for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
		    matrix[i][j] = cin.nextInt();
		}
	    }
	    
	    int xLength = 0;
	    int yLength = 0;
	    int tempLength = 0;
	    int length = 0;
	    for(int i=0; i<n-1; i++) {
	        for(int j=0; j<m-1; j++) {
		    if(matrix[i][j] == 1 && matrix[i + 1][j] == matrix[i][j]) {
			xLength++;
		    }
		    if(matrix[i][j] == 1 && matrix[i][j + 1] == matrix[i][j]) {
			yLength++;
		    }
		    
		    tempLength = xLength < yLength ? xLength: yLength;
		    if(tempLength>length) {;
		       length = tempLength;
		    }
	        }
	    }
	    
	    System.out.println(length);
	}
	cin.close();
    }

}

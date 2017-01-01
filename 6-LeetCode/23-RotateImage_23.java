package leetcode;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2017年1月1日 下午10:11:58
 */

public class RotateImage_23 {

    //两次翻转，先沿右上-左下的对角线翻转，再沿水平中线上下翻转
    public static void rotate(int[][] matrix) {
	int n = matrix.length;
	int temp = 0;
	for (int i = 0; i < n / 2; i++) {
	    for (int j = i; j < n - 1 - i; j++) {
		temp = matrix[i][j];
		matrix[i][j] = matrix[n - j - 1][i];
		matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
		matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
		matrix[j][n - i - 1] = temp;
	    }
	}
    }

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int m = cin.nextInt();
	    int n = cin.nextInt();
	    int[][] matrix = new int[m][n];
	    for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
		    matrix[i][j] = cin.nextInt();
		}
	    }
	    
	    rotate(matrix);
	    for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
		    System.out.print(matrix[i][j] + " ");
		}
		System.out.println();
	    }
	    
	}
	cin.close();
    }

}

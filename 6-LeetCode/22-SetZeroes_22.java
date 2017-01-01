package leetcode;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2017年1月1日 下午9:51:37
 */

public class SetZeroes_22 {

    public static void setZeroes(int[][] matrix) {
        boolean rowFlag = false;
        boolean colFlag = false;
        
        //判断第一行是否有零，防止被覆盖
	for (int i = 0; i < matrix[0].length; i++) {
	    if (matrix[0][i] == 0) {
		rowFlag = true;
		break;
	    }
	}
	
	//判断第一列是否有零，防止被覆盖
	for (int i = 0; i < matrix.length; i++) {
	    if (matrix[i][0] == 0) {
		colFlag = true;
		break;
	    }
	}
	
	//遍历矩阵，用第一行和第一列记录0的位置
	for (int i = 1; i < matrix.length; i++) {
	    for (int j = 1; j < matrix[0].length; j++) {
		if (matrix[i][j] == 0) {
		    matrix[0][j] = 0;
		    matrix[i][0] = 0;
		}
	    }
	}
	
	//根据记录清零
	for (int i = 1; i < matrix.length; i++) {
	    for (int j = 1; j < matrix[0].length; j++) {
		if (matrix[0][j] == 0 || matrix[i][0] == 0) {
		    matrix[i][j] = 0;
		}
	    }
	}
	
	//最后处理第一行和第一列
	if (rowFlag) {
	    for (int i = 0; i < matrix[0].length; i++) {
		matrix[0][i] = 0;
	    }
	}
	if (colFlag) {
	    for (int i = 0; i < matrix.length; i++) {
		matrix[i][0] = 0;
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
	    
	    setZeroes(matrix);
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

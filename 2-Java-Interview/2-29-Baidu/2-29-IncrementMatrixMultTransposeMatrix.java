package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月29日 下午10:12:38
 */

public class IncrementMatrixMultTransposeMatrix {

    public static int[][] multTransposeMatrix(int increment, int rows, int cols) {
	int[][] incrementMatrix = new int[rows][cols];
	int count = increment;
	for (int i = 0; i < rows; i++) {
	    for (int j = 0; j < cols; j++) {
		incrementMatrix[i][j] = count;
		count++;
	    }
	}
	
	int[][] transposeMatrix = new int[cols][rows];
	for (int i = 0; i < rows; i++) {
	    for (int j = 0; j < cols; j++) {
		transposeMatrix[j][i] = incrementMatrix[i][j];
	    }
	}
	
	int row = incrementMatrix.length;
	int col = transposeMatrix[0].length;
	int[][] resultMatrix = new int[row][col];
	for(int i=0; i<row; i++) {
	    for(int j=0; j<col; j++) {
		resultMatrix[i][j] = 0;
		for(int k=0; k<transposeMatrix.length; k++) {
		    resultMatrix[i][j] += incrementMatrix[i][k] * transposeMatrix[k][j];
		}
	    }
	}
	return resultMatrix;
    }
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (sc.hasNext()) {
	    int increment = sc.nextInt();
	    int rows = sc.nextInt();
	    int cols = sc.nextInt();
	    
	    int[][] result = multTransposeMatrix(increment, rows, cols);
            for(int i=0; i<result.length; i++) {
        	for(int j=0; j<result[0].length; j++) {
        	    System.out.print(result[i][j] + " ");   
                }
        	System.out.println(); 
            }
	    
	}
	
	sc.close();
    }

}

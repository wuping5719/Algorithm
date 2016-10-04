package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月4日 下午8:43:19
 */

public class MatrixMul_61 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int rowA = cin.nextInt();
	    int colA = cin.nextInt();
	    int rowB = colA;
	    int colB = cin.nextInt();
	    
	    int[][] matrixA = new int[rowA][colA];
	    for(int i=0; i<rowA; i++) {
		for(int j=0; j<colA; j++) {
		    matrixA[i][j] = cin.nextInt();
		}
	    }
	    
	    int[][] matrixB = new int[rowB][colB];
	    for(int i=0; i<rowB; i++) {
		for(int j=0; j<colB; j++) {
		    matrixB[i][j] = cin.nextInt();
		}
	    }
	    
	    //int[][] matrixResult = new int[rowA][colB];
	    for(int i=0; i<rowA; i++) {
		for(int j=0; j<colB; j++) {
		    int temp = 0;  
	            for(int k=0; k<colA; k++)  
	            {  
	               temp += matrixA[i][k] * matrixB[k][j];       
	            }  
		    //matrixResult[i][j] = temp;
		    
		    if(j==0) {
			System.out.print(temp);
		    }else {
			System.out.print(" " + temp);
		    }
		}
		System.out.println();
	    }
	}
	cin.close();
    }

}

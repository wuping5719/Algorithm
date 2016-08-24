package swordOffer;

import java.util.ArrayList;

/**
 * @author WuPing
 * @version 2016年8月24日 下午3:57:59
 */

public class PrintMatrix_20 {

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
	if(matrix == null) {
	    return null;
	}
	int rows = matrix.length;
	int columns = matrix[0].length;
	int start = 0;
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	while(columns > start*2 && rows > start*2) {
	    int endX = columns - 1 - start;
	    int endY = rows - 1 - start;
	    
	    // 从左到右打印一行
	    for(int i = start; i <= endX; i++) {
		list.add(matrix[start][i]);
	    }
	    
	    // 从上到下打印一列
	    if(start < endY) {
		for(int j = start + 1; j <= endY; j++) {
		    list.add(matrix[j][endX]);
		}
	    }
	    
	    // 从右到左打印一行
	    if(start < endX && start < endY) {
		for(int i = endX - 1; i >= start; i--) {
		    list.add(matrix[endY][i]);
		}
	    }
	    
	    // 从下到上打印一列
	    if(start < endX && start < endY - 1) {
		for(int j = endY - 1; j >= start + 1; j--) {
		    list.add(matrix[j][start]);
		}
	    }
	    
	    start ++;
	}
	return list;
    }
    
    public static void main(String[] args) {
	int[][] matrix = {{ 1, 2, 3, 4},
		          { 5, 6, 7, 8},
		          { 9,10,11,12},
		          {13,14,15,16}};
	ArrayList<Integer> list = printMatrix(matrix);
	for(int i=0; i<list.size(); i++) {
	    System.out.print(list.get(i) + " ");
	}
    }

}

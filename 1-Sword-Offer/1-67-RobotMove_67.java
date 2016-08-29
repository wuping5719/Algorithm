package swordOffer;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年8月29日 下午2:59:23
 */

public class RobotMove_67 {

    public static int movingCount(int threshold, int rows, int cols)
    {
        boolean[] visited = new boolean[rows*cols];
        for(int i=0; i<rows*cols; i++) {
            visited[i] = false;
        }
        
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        
        visited = null;
        
        return count;
    }
    
    private static int movingCountCore(int threshold, int rows, int cols, 
	    int row, int col, boolean[] visited) {
	int count = 0;
	
	if (row < 0 || row >= rows || col < 0 || col >= cols 
		|| getDigitSum(row)+getDigitSum(col)>threshold 
		|| visited[row*cols+col]) {
	    return count;
	}
           
        visited[row*cols+col] = true;
	    
	count = 1 + movingCountCore(threshold, rows, cols, row-1, col, visited)
		 + movingCountCore(threshold, rows, cols, row+1, col, visited)
		 + movingCountCore(threshold, rows, cols, row, col-1, visited)
		 + movingCountCore(threshold, rows, cols, row, col+1, visited);
	
	return count;
    }
    
    private static int getDigitSum(int number) {
	int sum = 0;
	while(number > 0) {
	    sum += number % 10;
	    number /= 10;
	}
	return sum;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int m = cin.nextInt();
	    int n = cin.nextInt();
	    int k = cin.nextInt();
	    int count = movingCount(k, m, n);
	    System.out.println(count);
	}
	cin.close();
    }

}

package swordOffer;

/**
 * @author WuPing
 * @version 2016年8月29日 上午9:28:38
 */

public class StringPathMatrix_66 {

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix==null || rows<1 || cols<1 || str==null) {
            return false;
        }
        
        boolean[] visited = new boolean[matrix.length];
        for(int i=0; i<matrix.length; i++) {
            visited[i]=false;
        }
        
        int pathLength = 0;
        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
        	if(hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
        	    return true;
        	}
            }
        }
        
        visited = null;
        return false;
    }
    
    public static boolean hasPathCore(char[] matrix, int rows, int cols, 
	    int row, int col, char[] str, int pathLength, boolean[] visited) {
	if(pathLength==str.length) {
	    return true;
	}

	int index = row * cols + col;
        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix[index] != str[pathLength] || visited[index])
            return false;
        
	boolean hasPath = false;
	
	pathLength++;
	visited[row * cols + col] = true;

	hasPath = hasPathCore(matrix, rows, cols, row, col - 1, str,
		pathLength, visited)
		|| hasPathCore(matrix, rows, cols, row - 1, col, str,
			pathLength, visited)
		|| hasPathCore(matrix, rows, cols, row, col + 1, str,
			pathLength, visited)
		|| hasPathCore(matrix, rows, cols, row + 1, col, str,
			pathLength, visited);

	if (!hasPath) {
	    pathLength--;
	    visited[row * cols + col] = false;
	}
	
	return hasPath;
    }
    
    public static void main(String[] args) {
	String matrixStr = "abcesfcsadee";
	char[] matrix = matrixStr.toCharArray();
        int rows = 3;
        int cols = 4;
        String strStr1 = "bcced";
        char[] str1 = strStr1.toCharArray();
        boolean result1 = hasPath(matrix, rows, cols, str1);
        System.out.println(result1);
        
        String strStr2 = "abcb";
        char[] str2 = strStr2.toCharArray();
        boolean result2 = hasPath(matrix, rows, cols, str2);
        System.out.println(result2);
	
    }

}

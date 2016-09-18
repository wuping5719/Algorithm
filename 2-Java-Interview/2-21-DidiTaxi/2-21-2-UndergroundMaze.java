package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月18日 下午3:55:20
 */

public class UndergroundMaze {

    /*
    4 4 10
    1 1 0 0
    0 1 1 0
    0 1 1 1
    0 0 1 1
    */
    
    //地下迷宫
    public static String moving(int[][] matrix, int n, int m, int p) {
	if (matrix == null || matrix.length != n || matrix[0].length != m) {
	    return "Can not escape!";
	}
	if (matrix[n - 1][m - 1] != 1 || matrix[0][0] != 1) {// 入口或出口为障碍点
	    return "Can not escape!";
	}
	
	boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                visited[i][j] = false;
            }
        }

        String result = movingCore(matrix, n, m, p, visited);
        
        return result;
    }
    
    private static String movingCore(int[][] matrix, int n, int m, int p, boolean[][] visited) {
	int row = 0;
	int col = 0;
	StringBuffer sb = new StringBuffer("");
	
	while(row>=0 && row<n && col>=0 && col<m && p>0) {
	    visited[row][col]=true;
	    
	    //向下移动
	    if(row<n-1) {
		if(matrix[row+1][col] == 1 && visited[row][col]==true) {
		    row = row + 1;
		    visited[row][col]=true;
		    if(sb.toString().equals("")) {
			sb.append("["+ row +","+ col +"]");
		    }else {
			sb.append(",["+ row +","+ col +"]");
		    }
		    
		    //到达终点
		    if(row==n-1 && col==m-1) {
			return sb.toString();
		    }
		}
	    }
	    
	    //向右移动
	    if(col<m-1) {
		if(matrix[row][col+1] == 1 && visited[row][col]==true) {
		    col = col + 1;
		    visited[row][col]=true;
		    if(sb.toString().equals("")) {
			sb.append("["+ row +","+ col +"]");
		    }else {
			sb.append(",["+ row +","+ col +"]");
		    }
		    p = p-1;
		    
		    //到达终点
		    if(row==n-1 && col==m-1) {
			return sb.toString();
		    }
		}
	    }
	    
	    //向左移动
	    if(col>0) {
		if(matrix[row][col-1] == 1 && visited[row][col-1]==false) {
		    col = col - 1;
		    if(sb.toString().equals("")) {
			sb.append("["+ row +","+ col +"]");
		    }else {
			sb.append(",["+ row +","+ col +"]");
		    }
		    p = p-1;
		}
	    }
	    
	    //向上移动
	    if(row>0) {
		if(matrix[row-1][col] == 1 && visited[row-1][col]==false) {
		    row = row - 1;
		    if(sb.toString().equals("")) {
			sb.append("["+ row+","+ col +"]");
		    }else {
			sb.append(",["+ row +","+ col +"]");
		    }
		    p = p-3;
		}
	    }
	}
	
	return "Can not escape!";
    }
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while(sc.hasNext()) {
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    int p = sc.nextInt();
	    int[][] matrix = new int[n][m];
	    for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
		    matrix[i][j] = sc.nextInt();
		}
	    }
	    String result = moving(matrix, n, m, p);
	    System.out.println(result);
	}
	sc.close();
    }

}

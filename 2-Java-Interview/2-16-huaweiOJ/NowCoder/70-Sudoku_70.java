package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午3:05:02
 */

public class Sudoku_70 {
    // DFS算法
    public static int solveSudoku(int[][] checkerboard) {
	int depth = 0;
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		if (checkerboard[i][j] == 0) {
		    depth++;
		}
	    }
	}

	return dfs(checkerboard, depth);
    }
 
    public static int dfs(int[][] checkerboard, int depth) {
        if (depth == 0) {
            return 0; 
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (checkerboard[i][j] == 0) {
                    for (int k = 1; k <= 10; k++) {
                        if (k == 10) {
                            return depth;   
                        }
                        checkerboard[i][j] = k;
                        if (!isValid(checkerboard, i, j)) {
                            checkerboard[i][j] = 0; 
                        }
                        else {
                            depth--;
                            depth = dfs(checkerboard, depth);
                            if (depth == 0) {
                        	return depth;
                            } 
                            depth++;
                            checkerboard[i][j] = 0;
                        }
                    }
                }
            }
        }
        return depth;
    }
 
    public static boolean isValid(int[][] checkerboard, int row, int col) {
        boolean[] check = new boolean[10];
        for (int i = 0; i < check.length; i++) {
            check[i] = true;
        }
        for (int i = 0; i < checkerboard[0].length; i++) {
            if (check[checkerboard[row][i]]) {
        	 check[checkerboard[row][i]] = false;
            }else if (checkerboard[row][i] != 0) {
        	 return false;
            }   
        }
 
        for (int i = 0; i < check.length; i++) {
            check[i] = true;
        }
        for (int i = 0; i < checkerboard.length; i++) {
            if (check[checkerboard[i][col]]) {
        	check[checkerboard[i][col]] = false;
            } else if (checkerboard[i][col] != 0) {
        	return false;
            }   
        }
 
        for (int i = 0; i < check.length; i++) {
            check[i] = true;
        } 
        int rowTemp = (row / 3) * 3;
        int colTemp = (col / 3) * 3;
        for (int k = 0; k < 9; k++) {
            row = rowTemp + k / 3;
            col = colTemp + k % 3;
            if (check[checkerboard[row][col]]) {
        	check[checkerboard[row][col]] = false;
            }else if (checkerboard[row][col] != 0) {
        	return false;
            } 
        }
        return true;
    }

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int[][] checkerboard = new int[9][9];
	    for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
		    checkerboard[i][j] = cin.nextInt();
		}
	    }
	    
	    solveSudoku(checkerboard);
	    for (int i = 0; i < 9; i++) {
	        for (int j = 0; j < 8; j++) {
	        	System.out.print(checkerboard[i][j] + " ");
	        }  
	        System.out.println(checkerboard[i][8]);
	    }
	}
	cin.close();
    }

}

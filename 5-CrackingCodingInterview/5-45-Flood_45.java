package crackingCodingInterview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WuPing
 * @version 2016年10月7日 下午9:51:15
 */

public class Flood_45 {

    public static int floodFill(int[][] map, int n, int m) {
	if(n == 0|| m == 0|| map[0][0]==1) { 
	    return 0;
	}
	
        Queue<Integer> record = new LinkedList<Integer>();
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        int x = 0;
        int y = 0;
        int nextX = 0;
        int nextY = 0;
        int point = 0;
        record.offer(0);
        while(!record.isEmpty()){
            point = record.peek();
            record.poll();
            x = point / m;
            y = point % m;
            if((x+1) == n && (y+1) == m){
                break;
            }
            for(int k=0; k<4; k++){
                nextX = x + direction[k][0];
                nextY = y + direction[k][1];
                if(nextX>=0 && nextX<n && nextY>=0 && nextY<m && map[nextX][nextY] == 0){
                    record.offer(nextX * m + nextY);
                    map[nextX][nextY] = map[x][y] + 1;
                }
            }
        }
        return map[n-1][m-1];
    }
    
    public static void main(String[] args) {
	int[][] map = {{0,0,1,1,1},
		       {1,0,0,1,1},
		       {0,1,0,1,1},
		       {1,0,0,0,0},
		       {1,0,1,1,0}};
	int n = 5;
	int m = 5;
        System.out.println(floodFill(map, n, m));
    }

}

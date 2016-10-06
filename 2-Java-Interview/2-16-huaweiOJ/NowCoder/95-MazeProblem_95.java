package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月6日 下午6:32:37
 */

public class MazeProblem_95 {

    public static boolean check(int[][] maze, int x, int y) {
        //如果是右下角的出口
        if(x == maze.length - 1 && y == maze[x].length - 1) { 
            return false;
        }
        //如果当前位置是路
        if(x < maze.length && y < maze[maze.length - 1].length && maze[x][y] == 0) {
            //如果下一步横竖都是死
            if(check(maze, x + 1, y) == true && check(maze, x, y + 1) == true) {
                //将本位置封死
                maze[x][y] = 1;
                return true;
            }else { 
        	return false;
            }
        //如果当前位置不是路
        }else {
            return true;
        }
    }
    
    public static String mazePath(int[][] maze, int x, int y) {
        //如果是右下角的出口, 返回坐标
        if(x == maze.length - 1 && y == maze[x].length - 1) {
            return "(" + x + "," + y + ")"; 
        }  
        //如果当前位置是路, 返回坐标并且继续前进
        if(x < maze.length && y < maze[maze.length - 1].length && maze[x][y] == 0) { 
            return "(" + x + "," + y + ")" + "\n" + mazePath(maze, x + 1, y) + mazePath(maze, x, y + 1);
        }
        //如果当前位置不是路,什么也不做
        else {
            return "";
        }
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int rows = cin.nextInt();
	    int cols = cin.nextInt();
	    int[][] maze = new int[rows][cols];
	    for(int i=0; i<rows; i++) {
		for(int j=0; j<cols; j++) {
		    maze[i][j] = cin.nextInt();
		}
	    }
	    check(maze, 0, 0);  //预先探测迷宫一遍, 将走不通的路置1
            System.out.println(mazePath(maze, 0, 0)); //正式走迷宫
	}
	cin.close();
    }

}

package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月19日 下午8:03:13
 */

/*消消乐游戏算法实现 : http://blog.csdn.net/h348592532/article/details/45332197 */

/*
 * 方块消除游戏
    时间限制：C/C++语言 1000MS；其他语言 3000MS
    内存限制：C/C++语言 65536KB；其他语言 589824KB
    题目描述：
         如下图，有10*10个不同颜色的方块，每个方块可能是红、绿、蓝、黄、紫5种颜色之一。
         当点击其中某一个方块时，如果它有相邻的同颜色方块，则将所有与此方块连续同颜色相邻的方块消除；
         剩下的方块中，如果下方有空位则向下移动，如果左侧整列都为空位则向左移动。
    输入:
         输入数据有多组，每组占一行，包括一个或多个正整数，取值范围为1~100。每个数代表一次点击，数值为点击的方块编号。
        上图中的方块初始值定义已为你写好，可以直接粘贴使用：
   const int RED = 0, GREEN = 1, BLUE = 2, YELLOW = 3, PURPLE = 4;
   int p[10][10] = {
        {RED,RED,BLUE,BLUE,GREEN,YELLOW,BLUE,YELLOW,RED,PURPLE},
        {GREEN,GREEN,GREEN,BLUE,RED,PURPLE,RED,YELLOW,YELLOW,BLUE},
        {BLUE,RED,RED,YELLOW,YELLOW,PURPLE,BLUE,GREEN,GREEN,BLUE},
        {YELLOW,RED,BLUE,YELLOW,BLUE,RED,PURPLE,GREEN,GREEN,RED},
        {YELLOW,RED,BLUE,BLUE,PURPLE,GREEN,PURPLE,RED,YELLOW,BLUE},
        {PURPLE,YELLOW,RED,RED,YELLOW,RED,PURPLE,YELLOW,RED,RED},
        {YELLOW,YELLOW,GREEN,PURPLE,GREEN,RED,BLUE,YELLOW,BLUE,GREEN},
        {RED,YELLOW,BLUE,BLUE,YELLOW,GREEN,PURPLE,RED,BLUE,GREEN},
        {GREEN,GREEN,YELLOW,YELLOW,RED,RED,PURPLE,BLUE,BLUE,GREEN},
        {PURPLE,BLUE,RED,RED,PURPLE,YELLOW,BLUE,RED,RED,GREEN}};
       输出:
               对于每个测试实例，要求输出连续各次点击全部完成之后，红、绿、蓝、黄、紫色方块的数量; 每个测试实例的输出占一行。
       样例输入:
    6
    6 1
      样例输出:
    26 18 22 21 13
    24 18 22 21 13
  */

public class SquargeFree_XiaoXiaoLe {
    
    private static final int RED = 0, GREEN = 1, BLUE = 2, YELLOW = 3, PURPLE = 4;
    
    private static final int TRANSPARENT = -1;  //已消除的格子，颜色透明
	    
    public static String getColorBlockNum(int[][] p, int[] point) {
	int RED_num = 0;
	int GREEN_num = 0;
	int BLUE_num = 0;
	int YELLOW_num = 0;
	int PURPLE_num = 0;
	
	for(int i=0; i<point.length; i++) {
	    int targetX = point[i] / 10;
	    int targetY = point[i] % 10;
	    int targetColor = p[targetX][targetY];
	    int row = targetX;
	    int col = targetY;
	    
	    while (row >= 0 && row < 10 && col >= 0 && col < 10
		    && p[row][col] != TRANSPARENT && p[row][col]==targetColor) {
		//四个方向探索
		boolean left = true;
		boolean right = true;
		boolean top = true;
		boolean down = true;
		
		// 向右探索
		while(right) {
		    if (col < 9 && p[row][col + 1] == targetColor) {
			p[targetX][targetY] = TRANSPARENT;
			col = col + 1;
			p[row][col] = TRANSPARENT;
		    } else {
			right = false;
			col = targetY;
			break;
		    } 
		}
		
		// 向下探索
		while(down) {
		    if (row < 9 && p[row + 1][col] == targetColor) {
			p[targetX][targetY] = TRANSPARENT;
			row = row + 1;
			p[row][col] = TRANSPARENT;
		    } else {
			down = false;
			row = targetX;
		    }
		}
		
		// 向左探索
		while (left) {
		    if (col > 0 && p[row][col - 1] == targetColor && left) {
			p[targetX][targetY] = TRANSPARENT;
			col = col - 1;
			p[row][col] = TRANSPARENT;
		    } else {
			left = false;
			col = targetY;
		    }
		}
		
		// 向上探索
		while(top) {
		    if (row > 0 && p[row - 1][col] == targetColor) {
			p[targetX][targetY] = TRANSPARENT;
			row = row - 1;
			p[row][col] = TRANSPARENT;
		    } else {
			top = false;
			row = targetX;
		    }
		}
		
		//四个方向都没有颜色相同的格子，退出
		if(!(left || right || top || down)) {
		    break;
		}
	    }
	    
	    // 如果下方有空位则向下移动
	    for (int j = 0; j < 9; j++) {
		for (int k = 0; k < 10; k++) {
                    if(p[j][k]!=TRANSPARENT && p[j+1][k]==TRANSPARENT) {
                	int temp = p[j][k];
                	p[j][k] = p[j+1][k];
                	p[j+1][k] = temp;
                    }
		}
	    }
	    
	    // 如果左侧整列都为空位则向左移动
	    for (int n = 9; n > 0; n--) {
		int index = 0;
		boolean isExchange = true;
		while(index < 10) {
		    if(p[index][n-1] != TRANSPARENT) {
			isExchange = false;
			break;
		    }
		    index++;
		}
		
		index = 0;
		if (isExchange) {
		    while (index < 10) {
			int temp = p[index][n-1];
                	p[index][n-1] = p[index][n];
                	p[index][n] = temp;
			index++;
		    }
		}
	    }
	}
	
	for(int j=0; j<10; j++) {
	    for(int k=0; k<10; k++) {
		 if(RED==p[j][k]) {
		     RED_num++;
		 }
		 if(GREEN==p[j][k]) {
		     GREEN_num++;
		 }
		 if(BLUE==p[j][k]) {
		     BLUE_num++;
		 }
		 if(YELLOW==p[j][k]) {
		     YELLOW_num++;
		 }
		 if(PURPLE==p[j][k]) {
		     PURPLE_num++;
		 }
            }
	}
	
	String res = RED_num +" "+ GREEN_num +" "+ BLUE_num +" "+ YELLOW_num +" "+ PURPLE_num;
	
	return res;
    }
    
    public static void main(String[] args) {
	int[][] p = {{RED,RED,BLUE,BLUE,GREEN,YELLOW,BLUE,YELLOW,RED,PURPLE},
	            {GREEN,GREEN,GREEN,BLUE,RED,PURPLE,RED,YELLOW,YELLOW,BLUE},
	            {BLUE,RED,RED,YELLOW,YELLOW,PURPLE,BLUE,GREEN,GREEN,BLUE},
	            {YELLOW,RED,BLUE,YELLOW,BLUE,RED,PURPLE,GREEN,GREEN,RED},
	            {YELLOW,RED,BLUE,BLUE,PURPLE,GREEN,PURPLE,RED,YELLOW,BLUE},
	            {PURPLE,YELLOW,RED,RED,YELLOW,RED,PURPLE,YELLOW,RED,RED},
	            {YELLOW,YELLOW,GREEN,PURPLE,GREEN,RED,BLUE,YELLOW,BLUE,GREEN},
	            {RED,YELLOW,BLUE,BLUE,YELLOW,GREEN,PURPLE,RED,BLUE,GREEN},
	            {GREEN,GREEN,YELLOW,YELLOW,RED,RED,PURPLE,BLUE,BLUE,GREEN},
	            {PURPLE,BLUE,RED,RED,PURPLE,YELLOW,BLUE,RED,RED,GREEN}};
	
	Scanner sc = new Scanner(System.in);
	while (sc.hasNext()) {
	    String str = sc.nextLine();
	    String[] arrayStr = str.split(" ");
	    int[] point = new int[arrayStr.length];
	    for(int i=0; i<point.length; i++) {
		point[i] = Integer.parseInt(arrayStr[i]);
	    }
	    
	    String result = getColorBlockNum(p, point);
	    System.out.println(result);
	}
	sc.close();
    }

}


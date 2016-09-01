package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年9月1日 下午3:40:03
 */

public class Robot1_37 {

    // 由于题目中x+y<=12,所以不必担心递归超时问题, 对于每一步, 
    // 只要没有走到边缘（x==1||y==1）就会有两种选择：向下走（x-1）or 向右走（y-1）,
    // 终止条件即走到边缘, 只能一直走下去，即此时只有一种走法.
    public static int countWays1(int x, int y) {
	if (x <= 0 || y <= 0)
	    return 0;
	if (x == 1 || y == 1)
	    return 1;
	return countWays1(x - 1, y) + countWays1(x, y - 1);
    }

    // 方法二: 动态规划, dp[0][0]初始化为1, dp[i][j]的大小为dp[i-1][j]+dp[i][j-1],
    //       因为只可能是从(i-1,j)和(i,j-1)这两个位置移动过来的, 计算时保证(i,j)的正上方和左边不在边界外即可.
    public static int countWays2(int x, int y) {
	int[][] dp = new int[x][y];
        dp[0][0] = 1;
        
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(i>0) 
                    dp[i][j] += dp[i-1][j];
                if(j>0) 
                    dp[i][j] += dp[i][j-1];
            }
        }
        return dp[x-1][y-1];
    }
    
    public static void main(String[] args) {
	int x = 5;
	int y = 6;
	int count1 = countWays1(x, y);
	System.out.println(count1);
	
	int count2 = countWays2(x, y);
	System.out.println(count2);
    }

}

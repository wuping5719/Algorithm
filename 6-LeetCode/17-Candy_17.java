package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月26日 下午8:10:36
 */

public class Candy_17 {

    public static int candy(int[] ratings) {
        if(ratings == null || ratings.length <= 0) {
            return 0;
        }
        int[] dp = new int[ratings.length];
        //每个孩子初始都有一个糖果
        Arrays.fill(dp,1);
        
        //从左向右扫描, 保证一个方向上分数更大的糖果更多
        for(int i=1; i<ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                dp[i] = dp[i-1] + 1;
            }
        }
        //从右向左扫描, 保证另一个方向上分数更大的糖果更多
        for(int i=ratings.length-1; i>0; i--) {
            if(ratings[i]<ratings[i-1] && dp[i]>=dp[i-1]) {
                dp[i-1] = dp[i] + 1;
            }
        }
        
        int sum = 0;
        for(int i=0; i<dp.length; i++){
            sum += dp[i];
        }
        return sum;
    }
 
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[] ratings = new int[n];
	    for(int i=0; i<n; i++) {
		ratings[i] = cin.nextInt();
	    }
	    System.out.println(candy(ratings));
	}
	cin.close();
    }

}

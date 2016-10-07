package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月7日 下午10:19:47
 */

public class CoinExpress_46 {
    
    //硬币面值组合问题: http://www.cnblogs.com/python27/archive/2013/09/05/3303721.html
    public static int countWays(int n) {
	int[] coins = {1, 5, 10, 25};
        int[] dp = new int[n + 1];       
        dp[0] = 1;
        for(int i = 0; i < 4; i++){
            for(int j = coins[i]; j <= n; j++){
                dp[j] =(dp[j] + dp[j-coins[i]]) % 1000000007;               
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            int n = cin.nextInt();
            System.out.println(countWays(n));
        }
        cin.close();
    }

}

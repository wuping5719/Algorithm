package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月10日 下午4:42:29
 */

public class PyramidI_55 {
    
    // 最长递增子序列
    public static int getHeight(int[] men, int n) {
	int[] dp = new int[n];  // 到 i位置时候的最长递增子序列的长度
	dp[0] = 1;
	int longest = 0;
        for(int i = 1; i< n; i++){
            dp[i] = 1;
            for(int j = i-1; j >= 0; j--){
                if(men[i] >= men[j] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
            
            longest = longest > dp[i] ? longest : dp[i];
        }
        return longest; 
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[] man = new int[n];
	    for(int i=0; i<n; i++) {
		man[i] = cin.nextInt();
	    }
	    System.out.println(getHeight(man, n));
	}
	cin.close();
    }

}

package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月2日 下午3:40:12
 */

public class RedraimentMoves_30 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[] input = new int[n];
	    for (int i = 0; i < n; i++) {
		input[i] = cin.nextInt();
	    }

	    // 求最长递增子序列
	    int[] dp = new int[n];
	    for (int i = 0; i < n; i++) {
		dp[i] = 1;
		for (int j = 0; j < i; j++) {
		    if (input[j] < input[i]) {
			dp[i] = Math.max(dp[i], dp[j] + 1);
		    }
		}
	    }
	    // 找到dp数组中的最大值
	    int maxStep = 0;
	    for (int i = 0; i < dp.length; i++) {
		if (dp[i] > maxStep) {
		    maxStep = dp[i];
		}
	    }
	    
            System.out.println(maxStep);
	}
	cin.close();
    }

}

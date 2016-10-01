package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月30日 下午11:43:00
 */

public class ShoppingList_16 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int m = cin.nextInt();
	    int[] price = new int[m];  // 价格
	    int[] weight = new int[m]; // 重要度
	    int[] q = new int[m];      // 主附件
	    int[] val = new int[m];    // 价值 = 价格 * 重要度
	    for(int i=0; i<m; i++) {
		price[i] = cin.nextInt();
		weight[i] = cin.nextInt();
		q[i] = cin.nextInt();
		val[i] = price[i] * weight[i];
	    }
	    
	    // 加了限制条件的背包问题
	    long sum = 0;
	    int[][] dp = new int[m + 1][n + 1];
	    for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
		    if (q[i-1] == 0) {   //主件
			if (price[i-1] <= j) // 用j这么多钱去买 i件商品, 可以获得最大价值
			    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - price[i-1]]
				    + val[i-1]);
		    } else {  // 附件
			if (price[i-1] + price[q[i-1]] <= j) // 附件, 加上主件一起算
			    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - price[i-1]]
				    + val[i-1]);
		    }
		}
	    }
	    sum = dp[m][n];
	    System.out.println(sum);
	}
	cin.close();
    }

}

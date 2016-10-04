package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月4日 下午4:00:20
 */

public class CalculatePublicSubString_55 {

    // 最长公共子串
    /* 最长公共子串是: dp[i][j]-表示以aStr[i]和bStr[j]为结尾的最长公共子串 当aStr[i] == aStr[j]时,
     * dp[i][j] = dp[i-1][j-1] + 1; 否则, dp[i][j] = 0. 最优解为max(dp[i][j]),
     * 其中0<=i<aLen, 0<=j<bLen.
     */
    public static int getCommonSubStrLength(String aStr, String bStr) {
	int aLen = aStr.length();
	int bLen = bStr.length();
	int[][] dp = new int[aLen + 1][bLen + 1];

	for (int i = 0; i <= aLen; i++) {
	    for (int j = 0; j <= bLen; j++) {
		dp[i][j] = 0;
	    }
	}

	for (int i = 1; i <= aLen; i++) {
	    for (int j = 1; j <= bLen; j++) {
		if (aStr.charAt(i - 1) == bStr.charAt(j - 1)) {
		    dp[i][j] = dp[i - 1][j - 1] + 1;
		} else {
		    dp[i][j] = 0;
		}
	    }
	}

	int max = 0;
	for (int i = 0; i <= aLen; i++) {
	    for (int j = 0; j <= bLen; j++) {
		if (max < dp[i][j]) {
		    max = dp[i][j];
		}
	    }
	}

	return max;
    }

    // 最长公共子序列
    /* 最长公共子序列是：dp[i][j] - 表示子串aStr[0...i]和子串bStr[0...j]的最长公共子序列
                    当aStr[i] == bStr[j]时, dp[i][j] = dp[i-1][j-1] + 1;
                    否则, dp[i][j] = max(dp[i-1][j], dp[i][j-1]).
                    最优解为dp[aLen-1][bLen-1];
    */
    public static int getCommonSubSequenceLength(String aStr, String bStr) {
	int aLen = aStr.length();
	int bLen = bStr.length();
	int[][] dp = new int[aLen + 1][bLen + 1];

	for (int i = 0; i <= aLen; i++) {
	    for (int j = 0; j <= bLen; j++) {
		dp[i][j] = 0;
	    }
	}

	for (int i = 1; i <= aLen; i++) {
	    for (int j = 1; j <= bLen; j++) {
		if (aStr.charAt(i - 1) == bStr.charAt(j - 1)) {
		    dp[i][j] = dp[i - 1][j - 1] + 1;
		} else {
		    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
		}
	    }
	}
	return dp[aLen][bLen];
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String aStr = cin.next();
	    String bStr = cin.next();
	    int commonSubStrLength = getCommonSubStrLength(aStr, bStr);
	    System.out.println(commonSubStrLength);
	    
	    int commonSubSequenceLength = getCommonSubSequenceLength(aStr, bStr);
	    System.out.println(commonSubSequenceLength);
	}
	cin.close();
    }

}

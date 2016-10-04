package huawei;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author WuPing
 * @version 2016年10月4日 下午7:30:18
 */

public class StringWildcard_59 {

    //方法一：最简洁, 转化后利用库函数
    public static boolean isMatch1(String regex, String str) {
	String oneReplaceStr = regex.replace("*", ".*");
	String twoReplaceStr = oneReplaceStr.replace("?", ".{1}");
	
	Pattern pattern = Pattern.compile(twoReplaceStr);
	Matcher matcher = pattern.matcher(str);
	return matcher.matches();
    }
    
    //方法二: 基于动态规划的解法
    public static boolean isMatch2(String regex, String str) {
	int regexLen = regex.length();
	int strLen = str.length();
	int[][] dp = new int[regexLen+1][strLen+1]; //多加一行一列作为初始初值所用
	    
	int index = 0;
	while (regex.charAt(index) == '*') {
	    for (int i = 0; i <= regexLen; i++) {
		dp[index][i] = 1;
	    }
	    for (int j = 0; j < strLen; j++) {
		dp[j][index] = 1;
	    }
	    index++;
	}
	
	dp[0][0] = 1;
	for (int i = 1; i <= regexLen; i++) {
	    for (int j = 1; j <= strLen; j++) {
		if ((regex.charAt(i-1) == '?' && j-1 < regexLen)
			|| regex.charAt(i-1) == str.charAt(j-1)) {
		    dp[i][j] = dp[i-1][j-1];
		} else if (regex.charAt(i-1) == '*') {
		    if (dp[i][j-1] == 1 || dp[i-1][j] == 1
			    || dp[i - 1][j - 1] == 1) {
			dp[i][j] = 1;
		    }
		}
	    }
	}
	 
	boolean result = dp[regexLen][strLen] == 1 ? true : false;
	return result;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String regex = cin.nextLine();
	    String input = cin.nextLine();
	    
	    //System.out.println(isMatch1(regex, input));
	    
	    System.out.println(isMatch2(regex, input));
	}
	cin.close();
    }

}

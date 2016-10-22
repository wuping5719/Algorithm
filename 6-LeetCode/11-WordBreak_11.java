package leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author WuPing
 * @version 2016年10月22日 下午3:09:59
 */

public class WordBreak_11 {

    //状态转移方程:
    // f(i): 表示s[0, i]是否可以分词;
    // f(i) = f(j) && f(j+1, i); 0 <= j < i;
    public static boolean wordBreak(String s, Set<String> dict) {
	int len = s.length();
	boolean[] dp = new boolean[len + 1];  // dp[i]表示0到i位可分词
	dp[0] = true;
	for (int i = 1; i <= len; ++i) {
	    for (int j = 0; j < i; ++j) {
		if (dp[j] && dict.contains(s.substring(j, i))) {
		    dp[i] = true;
		    break;
		}
	    }
	}
	return dp[len];
    }

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String s = cin.nextLine();
	    String str = cin.nextLine();
	    String[] arrayStr = str.split(" ");
	    Set<String> dict = new HashSet<String>();
	    for(int i=0; i<arrayStr.length; i++) {
		dict.add(arrayStr[i]);
	    }
	    
	    System.out.println(wordBreak(s, dict));
	}
	cin.close();
    }

}

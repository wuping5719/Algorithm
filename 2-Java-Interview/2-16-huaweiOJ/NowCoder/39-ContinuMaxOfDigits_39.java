package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月3日 下午3:50:25
 */

public class ContinuMaxOfDigits_39 {
  
    //子串系列, 简单动态规划, dp[i]代表当前i的最长数字长度
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            String str = cin.nextLine();
            int maxLength = 0;
            int dp[] = new int[str.length()];
            //动态规划边界
            if (str.charAt(0)>='0' && str.charAt(0)<='9') { 
                dp[0] = 1;
            }
            for (int i=1; i<str.length(); i++) {
        	if (str.charAt(i)>='0' && str.charAt(i)<='9') {
                    dp[i] = dp[i-1] + 1;
                }else {
                    dp[i] = 0;
                }
            }
            
            for (int i=0; i<dp.length; i++) {
                if (dp[i] > maxLength) {
                    maxLength = dp[i];
                }
            }
            
            StringBuffer sb = new StringBuffer();
            for (int i=0; i<dp.length; i++) {
                if (dp[i] == maxLength) {
                    sb.append(str.substring(i-maxLength+1, i+1));
                }
            }
            sb.append(",");
            sb.append(maxLength);
            System.out.println(sb.toString());
        }
        cin.close();
    }

}

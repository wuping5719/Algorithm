package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月3日 下午10:20:32
 */

public class SimilarityOfString_51 {

    public static String calculateStringDistance(String a, String b){
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int i=0; i<=a.length(); i++){
            dp[i][0]=i;
        }
        for(int i=0; i<=b.length(); i++){
            dp[0][i]=i;
        }
        
        for(int i=1; i<=a.length(); i++){
            for(int j=1; j<=b.length(); j++){
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    int temp = dp[i-1][j] < dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
                    dp[i][j] = 1 + (temp < dp[i-1][j-1] ? temp : dp[i-1][j-1]);
                }
            }
        }
        
        StringBuffer sb = new StringBuffer();
        sb.append(1);
        sb.append("/");
        sb.append(dp[a.length()][b.length()]+1);
        return sb.toString();
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String a = cin.nextLine();
            String b = cin.nextLine();
            String result = calculateStringDistance(a, b);
            System.out.println(result);
        }
        cin.close();
    }

}

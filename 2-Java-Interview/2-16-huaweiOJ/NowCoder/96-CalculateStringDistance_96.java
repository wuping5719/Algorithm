package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月6日 下午7:12:48
 */

public class CalculateStringDistance_96 {

    //动态规划
    private static int calculateStringDistance(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
         
        int[][] distance = new int[len1+1][len2+1];
         
        for(int i=1; i<=len1; i++){
            distance[i][0] = i;
        }
        for(int j=1; j<=len2; j++){
            distance[0][j]=j;
        }
        int a=0, b=0, c=0;
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                a = distance[i][j-1]+1;
                b = distance[i-1][j]+1;
                c = distance[i-1][j-1];
                if(str1.charAt(i-1)!=str2.charAt(j-1)) {
                    c = c + 1;
                }
                distance[i][j]= Math.min(Math.min(a,b), c);
            }
        }
        return distance[len1][len2];
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str1 = cin.nextLine();
	    String str2 = cin.nextLine();
	    
	    System.out.println(calculateStringDistance(str1, str2));
	}
	cin.close();
    }

}

package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月6日 下午2:14:41
 */

public class LongestCommonString_88 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
            String strA = cin.nextLine();
            String strB = cin.nextLine();
            String shortStr = strA.length() <= strB.length() ? strA : strB;
            String longStr = strA.length() > strB.length() ? strA : strB;
            int maxLen = 0;
            int maxSubIndex = 0;
            for(int i=0; i<shortStr.length(); i++){
                for(int j=i+1; j<=shortStr.length(); j++){
                    if(longStr.contains(shortStr.substring(i,j)) && j-i>maxLen){
                	maxLen = j-i;
                	maxSubIndex = i;
                    }
                }
            }
            System.out.println(shortStr.substring(maxSubIndex, maxSubIndex+maxLen));
	}
	cin.close();
    }

}

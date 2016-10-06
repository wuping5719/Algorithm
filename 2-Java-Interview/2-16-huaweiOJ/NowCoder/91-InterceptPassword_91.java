package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月6日 下午3:52:24
 */

public class InterceptPassword_91 {

    public static int manacher(String s) {
        StringBuffer sb = new StringBuffer();
        char[] charArray = s.toCharArray();
        sb.append("#");
        // 对字符串进行封装
        for (int i = 0; i < charArray.length; i++) {
           sb.append(charArray[i]);
           sb.append("#");
        }
        int[] rad = new int[sb.length()];  //记录新字符串以每个字符为中心的最大回文半径
        char[] c = sb.toString().toCharArray();
        int max = 0;  //记录已经搜寻到的回文半径能到达右端的最达大值
        int id = 0;   //记录回文半径能到达最有端的回文字符串的中心
        int count =0;   //记录最大回文
        for (int i = 1; i < c.length; i++) {
           if (max > i) {
               rad[i] = Math.min(rad[2*id-i], max-i);
           }else {
               rad[i] = 1;
           }
           while (i-rad[i]>=0 && i+rad[i]<c.length && c[(i-rad[i])]==c[(i+rad[i])]) {
               rad[i]++;
           }
           if (i+rad[i] > max) {
               max = i + rad[i];
               id = i;
           }
           count = Math.max(count, rad[i]-1);
        }
        
        return count;
     }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    System.out.println(manacher(str));   
	}
	cin.close();
    }

}

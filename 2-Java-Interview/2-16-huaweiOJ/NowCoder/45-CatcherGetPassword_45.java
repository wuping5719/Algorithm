package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月3日 下午8:36:00
 */

public class CatcherGetPassword_45 {

    //方法一: 线性复杂度 O(n), 求最长回文子串
    public static int getLongestPalindromeLength1(String str) {
        // 先处理字符串
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            sb.append("#");
        }
        // 记录回文半径长度
        int maxLen = 0;
        for (int i = 0; i < sb.length(); i++) {
            int r = 1;
            // 尝试更大半径
            while(i-r>=0 && i+r<sb.length() && sb.charAt(i-r)==sb.charAt(i+r)){
                r++;
            }
            maxLen = r > maxLen ? r : maxLen;
        }
        return maxLen-1;
    }
    
    //方法二: 获取所有子串, 查看翻转后的字符串是否包含该子串
    public static int getLongestPalindromeLength2(String str){
        //将字符串反转
        StringBuffer sb = new StringBuffer(str);
        String temp = sb.reverse().toString();
        //获取所有子串, 查看翻转后的字符串是否包含该子串
        for(int i=temp.length(); i>=1; i--){
            //i为子串的长度
            for(int j=0; j<=temp.length()-i; j++){
                String tempSubString = temp.substring(j, j + i);
                if(str.contains(tempSubString)){
                    return i;
                }
            }
        }
        return 1;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()) {
           String str = cin.nextLine();
           
           int result1 = getLongestPalindromeLength1(str);
           System.out.println(result1);
           
           //int result2 = getLongestPalindromeLength2(str);
           //System.out.println(result2);
        }
        cin.close();
    }

}

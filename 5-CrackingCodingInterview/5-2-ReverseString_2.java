package crackingCodingInterview;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月29日 下午6:59:25 
 * @version 1.0 
 */
public class ReverseString_2 {
	
	// 方法一
	public static String reverseString1(String iniString) {
		StringBuffer sb = new StringBuffer(iniString);
        return sb.reverse().toString();
    }
	
	// 方法二: 基于循环
	public static String reverseString2(String iniString) {
		String str = "";
		for (int i = 0; i < iniString.length(); i++) {
			str = iniString.charAt(i) + str;
		}
		return str;
	}
		
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			String iniString = cin.nextLine();
			String result1 = reverseString1(iniString);
			System.out.println(result1);

			String result2 = reverseString1(iniString);
			System.out.println(result2);
		}
		cin.close();
	}

}

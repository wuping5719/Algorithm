package crackingCodingInterview;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月29日 下午6:43:24 
 * @version 1.0 
 */
public class CheckCharDifferent_1 {

	// 方法一: 基于正则表达式匹配
	// “(.)”表示一个捕获组, “\\1”表示一个反向引用, 也就是说“\\1”与“(.)”这两个位置的值可以相同,
	// 其他位置都是".*", 表示匹配0~n个任意字符. 总的来说,这个正则表达式是匹配出现重复字符的字符串.
	public static boolean checkDifferent1(String iniString) {
		return !iniString.matches(".*(.)(.*\\1).*");
    }

	// 方法二: 基于异或
	// 使用异或, 因为让支持ASCII所以判断下长度, 长度超了, 肯定重复.
	public static boolean checkDifferent2(String iniString) {
		if (iniString.length() > 256)
			return false;
		for (int i = 0; i < iniString.length(); i++) {
			for (int j = i + 1; j < iniString.length(); j++) {
				if ((iniString.charAt(i) ^ iniString.charAt(j)) == 0)
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
       Scanner cin = new Scanner(System.in);
       while(cin.hasNext()){
    	   String iniString = cin.nextLine();
    	   boolean result1 = checkDifferent1(iniString);
    	   System.out.println(result1);
    	   
    	   boolean result2 = checkDifferent2(iniString);
    	   System.out.println(result2);
       }
       cin.close();
	}

}

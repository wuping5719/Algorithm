package array;

/**
 * @author WuPing
 * @version 2016年7月21日 上午9:38:01
 */

public class RegularExpression {
    
    // 在"32fdsfd8fds0fdsdsf9562sda68ad"中找出3280956268
    public static String getNumber1(String str) {
	String res = "";
	res = str.replaceAll("[^0-9]", "");
	return res;
    }
    
    // 把"2012-04-15 02:32:06"变成20120415023206
    public static String getNumber2(String str) {
	String res = "";
	String[] result = str.split("\\D");
	for(int i = 0; i < result.length; i++) {
	    res += result[i];
	}
	return res;
    }
    
    public static void main(String[] args) {
	String testStr1 = "32fdsfd8fds0fdsdsf9562sda68ad";
	System.out.println("1.从字符串中找出数字子串结果：" + getNumber1(testStr1));
	System.out.println();
	String testStr2 = "2012-04-15 02:32:06";
	System.out.println("2.从字符串中找出数字子串结果：" + getNumber2(testStr2));
    }

}

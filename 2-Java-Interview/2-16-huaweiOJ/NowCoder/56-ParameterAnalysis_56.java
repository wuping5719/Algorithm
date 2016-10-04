package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月4日 下午4:28:01
 */

public class ParameterAnalysis_56 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    StringBuffer sb = new StringBuffer();
	    // 未遇到引号. 标志位设为false
	    boolean isLeftQuote = false;
	    int length = 1;
	    for (int i = 0; i < str.length(); i++) {
		// 如果遇到引号, 且此时左引号标志位为false, 判断此引号为左引号
		if (str.charAt(i) == '\"' && !isLeftQuote) {
		    isLeftQuote = true;
		    continue;
		}
		// 如果遇到引号, 且此时左引号标志位为true, 判断此引号为右引号
		if (str.charAt(i) == '\"' && isLeftQuote) {
		    isLeftQuote = false;
		    continue;
		}
		// 遇到引号间空格的情况
		if (str.charAt(i) == ' ' && isLeftQuote) {
		    sb.append(str.charAt(i));
		    continue;
		}
		// 遇到正常空格的情况
		if (str.charAt(i) == ' ') {
		    sb.append('\n');
		    length++;
		    continue;
		}
		// 其他情况
		sb.append(str.charAt(i));
	    }
	    System.out.println(length);
	    System.out.println(sb.toString());
	}
	cin.close();
    }

}

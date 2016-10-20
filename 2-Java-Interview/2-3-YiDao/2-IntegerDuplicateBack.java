package acmCoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author WuPing
 * @version 2016年10月20日 下午7:57:53
 */

public class IntegerDuplicateBack {

    // 整数去重反转(题目简单，陷阱不少)
    /* 题目描述：
                        输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
                        要求：输入和输出的整数每三位数字之间用逗号分隔，例如654,321。
                    输入:
                          输入数据有多组，每组占一行，输入每三位数字间用逗号分隔的整数n（0<=n<=2,147,483,647）。
                    输出:
                          每个测试实例输出占一行，输出整数每三位数字间用逗号分隔。
                    样例输入:
         1,234
         132,533,675
                    样例输出:
         4,321
         576,321
    */

    public static String duplicateBack(String str) {
	if(str == null) {
	    return "";
	}
	StringBuilder sb = new StringBuilder();
	Set<Character> set = new HashSet<Character>();
	int len = str.length();
	boolean isFirstZero = true;
	for(int i=len-1; i>=0; i--) {
	    if(!set.contains(str.charAt(i)) && str.charAt(i) != ',' 
		    && str.charAt(i) >='0' && str.charAt(i) <= '9') {
		if(str.charAt(i)=='0' && isFirstZero) {
		    if(i==0 && sb.length()==0) {   //处理类似000,000这种情况
			set.add(str.charAt(i));
			sb.append(str.charAt(i)); 
		    }
		    continue;    //忽略前导0
		}else {
		    if(str.charAt(i) != '0') {   //非数字前导0
			isFirstZero = false;
		    }
		    set.add(str.charAt(i));
		    sb.append(str.charAt(i)); 
		}
	    }
	}

	StringBuilder reult = new StringBuilder();
	int tempLen = sb.length();
	for(int i=0; i<sb.length(); i++) {
	    if(tempLen % 3 == 0 && i != 0) {   //每三位添加一个,
		reult.append("," + sb.charAt(i));
	    }else {
		reult.append(sb.charAt(i));
	    }
	    tempLen--;
	}

	return reult.toString();
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    System.out.println(duplicateBack(str));
	}
	cin.close();
    }

}

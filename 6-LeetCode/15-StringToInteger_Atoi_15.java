package leetcode;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月26日 下午6:56:40
 */

public class StringToInteger_Atoi_15 {

    public static int atoi(String str) {
	str = str.trim();
	long result = 0;
	if(str.equals("")) {
	    return 0;
	}
	boolean isPositive = true;
	for(int i=0; i<str.length(); i++) {
	    //在第一位的状态下先处理第一位, 如果第一位带符号，则根据符号处理
	    if(i==0 && (str.charAt(i) == '+' || str.charAt(i) == '-')){
                if(str.charAt(i) == '-'){
                    isPositive = false;
                }
                continue;
            }
            //利用ASCII码比大小, 只要比0小, 比9大的都不是数字
	    if (str.charAt(i) < '0' || str.charAt(i) > '9') {
		break;
	    }
            //从左到右读取,上次的值x*10+本次的值, 就是current值
            /*eg：123 = (1): 1
	               (2): 1*10 + 2
	               (3): (1*10 + 2) * 10 +3 = 123 
	    */
	    result = 10*result + str.charAt(i) - '0';
	}
	
	if (isPositive == false) {
	    result = -result;
	}
	if (result > Integer.MAX_VALUE) {
	    return Integer.MAX_VALUE;
	} else if (result < Integer.MIN_VALUE) {
	    return Integer.MIN_VALUE;
	} else {
	    return (int) result; // 在正常int范围内, 直接转换
	}
    }

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    System.out.println(atoi(str));
	}
	cin.close();
    }

}

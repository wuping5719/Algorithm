package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月1日 下午4:24:01
 */

public class PasswordvIsQualified_20 {

    //注—模块化: 可以将三部分判断写成三个函数分离出来
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String password = cin.nextLine();
	    
	    //长度小于8位
	    if(password==null || password.length()<=8) {
		 System.out.println("NG");
	    }else {
		int digit = 0;
		int lowercase = 0;
		int uppercase = 0;
		int others = 0;
		
		// 包括大小写字母,数字,其它符号,以上四种至少三种
		char[] chArray = password.toCharArray();
		for (int i = 0; i < chArray.length; i++) {
		    if (chArray[i] >= '0' && chArray[i] <= '9') {
			digit = 1;
		    } else if (chArray[i] >= 'a' && chArray[i] <= 'z') {
			lowercase = 1;
		    } else if (chArray[i] >= 'A' && chArray[i] <= 'Z') {
			uppercase = 1;
		    } else {
			others = 1;
		    }
		}
		int total = digit + lowercase + uppercase + others;
		boolean charKindsIsQualified = total >= 3 ? true : false;
		
		// 不能有相同长度超2的子串重复
		boolean subStrRepeatIsQualified = true;
		for(int i=0; i<password.length()-2; i++){
	            String subStr = password.substring(i, i+3);
	            if (password.substring(i+3, password.length()).contains(subStr)) {
	        	subStrRepeatIsQualified = false;
	            }
	        }
		
		if(charKindsIsQualified && subStrRepeatIsQualified) {
		    System.out.println("OK");
		}else {
		    System.out.println("NG");
		}
	    }
	}
	cin.close();
    }

}

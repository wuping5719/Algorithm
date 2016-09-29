package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月29日 下午2:56:38
 */

public class CountCharNum_1 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    String charStr = cin.nextLine();
	    
	    str = str.toUpperCase();
	    charStr = charStr.toUpperCase();
	    
	    if(str.length()<=0 || charStr.length()!=1) {
		System.out.println(0);
	    }else {
		int num = 0;
		char curChar = charStr.charAt(0);
		char[] strArray = str.toCharArray(); 
		for(int i=0; i<strArray.length; i++) {
		    if(strArray[i] == curChar) {
			num++;
		    }
		}
		System.out.println(num);
	    }
	    
	}
	cin.close();
    }

}

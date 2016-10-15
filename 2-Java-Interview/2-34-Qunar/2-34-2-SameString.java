package acmCoder;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月15日 上午11:08:38
 */

public class SameString {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    String[] arrStr = str.split(" ");
	    
	    if (arrStr.length == 2) {
		String strA = arrStr[0];
		String strB = arrStr[1];
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < strA.length(); i++) {
		    if(strA.charAt(i)>='A' && strA.charAt(i)<='Z') {
			set.add(strA.charAt(i));
		    }else {
			break;
		    }
		}

		boolean result = true;
		for (int i = 0; i < strB.length(); i++) {
		    if (!set.contains(strB.charAt(i))) {
			result = false;
			break;
		    }
		}
		System.out.println(result);
	    }else {
		System.out.println(false);
	    }
	}
	cin.close();
    }

}

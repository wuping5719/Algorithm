package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月30日 下午10:24:42
 */

public class StringReversal_12 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    if(!str.trim().equals("")) {
		char[] array = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = array.length - 1; i >= 0; i--) {
		    sb.append(array[i]);
		}
		System.out.println(sb.toString());
	    }
	}
	cin.close();
    }

}

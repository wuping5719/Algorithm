package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月30日 下午10:29:52
 */

public class SentencesReverse_13 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    if(!str.trim().equals("")) {
		String[] strArray = str.split(" ");
		StringBuffer sb = new StringBuffer("");
		for (int i = strArray.length - 1; i >= 0; i--) {
		    if(!sb.toString().equals("")) {
			sb.append(" ");
		    }
		    sb.append(strArray[i]);
		}
		System.out.println(sb.toString());
	    }
	}
	cin.close();
    }

}

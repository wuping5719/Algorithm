package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月1日 下午11:08:32
 */

public class ReverseCharacters_27 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    if(str != null && str.length() > 0) {
	       char[] charArray = str.toCharArray();
	       StringBuffer sb = new StringBuffer();
	       for(int i=charArray.length-1; i>=0; i--) {
		   sb.append(charArray[i]);
	       }
	       System.out.println(sb.toString());
	    }
	}
	cin.close();
    }

}

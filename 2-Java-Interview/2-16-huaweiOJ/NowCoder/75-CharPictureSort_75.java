package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午6:55:22
 */

public class CharPictureSort_75 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while(cin.hasNext()) {
	    String str = cin.nextLine();
	    char[] chArray = str.toCharArray();
	    Arrays.sort(chArray);
	    StringBuffer sb = new StringBuffer();
	    for(int i=0; i<chArray.length; i++) {
		sb.append(chArray[i]);
	    }
	    System.out.println(sb.toString());
	}
	cin.close();
    }

}

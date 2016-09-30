package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月30日 下午9:12:27
 */

public class DigitalUpsideDown_11 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    long n = cin.nextLong();
	    char[] array = String.valueOf(n).toCharArray();
	    StringBuffer sb = new StringBuffer();
	    for(int i=array.length-1; i>=0; i--) {
		sb.append(array[i]);
	    }
	    System.out.println(sb.toString());
	}
	cin.close();
    }

}

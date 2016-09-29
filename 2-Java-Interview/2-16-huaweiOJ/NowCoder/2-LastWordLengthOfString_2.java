package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月29日 下午3:10:49
 */

public class LastWordLengthOfString_2 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    
	    String[] array = str.split(" ");
	    int length = array[array.length-1].length();
            System.out.println(length);
	}
	cin.close();
    }

}

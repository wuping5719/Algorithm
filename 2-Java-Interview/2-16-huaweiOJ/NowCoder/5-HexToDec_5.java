package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月30日 下午6:39:10
 */

public class HexToDec_5 {

    public static String hexToDec(String hexStr) {
        return Integer.valueOf(hexStr.substring(2), 16).toString();
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String hexStr = cin.nextLine();
	    String resStr = hexToDec(hexStr);
	    System.out.println(resStr);
	}
	cin.close();
    }

}

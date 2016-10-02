package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月2日 上午10:39:36
 */

public class StringSegmentation_29 {

    public static void stringSegmentation(String tempStr) {
	if (tempStr != null && tempStr.length() > 0) {
	    char[] charArray = tempStr.toCharArray();
	    int actualLength = 0;
	    if (tempStr.length() % 8 == 0) {
		actualLength = tempStr.length();
	    } else {
		actualLength = tempStr.length() + 8 - tempStr.length() % 8;
	    }

	    int count = 0;
	    for (int j = 0; j < actualLength; j++) {
		if (j < tempStr.length()) {
		    if (count < 8) {
		        System.out.print(charArray[j]);
		    } else {
			System.out.println();
			System.out.print(charArray[j]);
			count = 0;
		    }
		} else {
		    if (count < 8) {
			System.out.print('0');
		    } else {
			count = 0;
			System.out.println();
		    }
		}
		count++;
	    }
	}
	System.out.println();
    }

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String nStr = cin.nextLine();
	    int n = Integer.parseInt(nStr);
	    for (int i = 0; i < n; i++) {
		String tempStr = cin.nextLine();
		stringSegmentation(tempStr);
	    }
	}
	cin.close();
    }

}

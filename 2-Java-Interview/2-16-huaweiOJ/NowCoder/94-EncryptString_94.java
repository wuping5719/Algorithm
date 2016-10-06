package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月6日 下午4:41:06
 */

public class EncryptString_94 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String key = cin.nextLine();
	    String res = cin.nextLine();

	    StringBuffer keyBuffer = new StringBuffer();
	    StringBuffer ciphertext = new StringBuffer();
	    int[] sign = new int[26];
	    for (int i = 0; i < 26; i++) {
		sign[i] = 0;
	    }

	    for (int i = 0; i < key.length(); i++) {
		if (key.charAt(i) >= 'a' && key.charAt(i) <= 'z') {
		    if (sign[key.charAt(i) - 'a'] == 0) {
			keyBuffer.append((char) (key.charAt(i) - 32));
			sign[key.charAt(i) - 'a'] = 1;
		    }
		} else {
		    if (sign[key.charAt(i) - 'A'] == 0) {
			keyBuffer.append((char) key.charAt(i));
			sign[key.charAt(i) - 'A'] = 1;
		    }
		}
	    }
	    for (int i = 0; i < 26; i++) {
		if (sign[i] == 0) {
		    keyBuffer.append((char) ('A' + i));
		}
	    }

	    for (int i = 0; i < res.length(); i++) {
		char c;
		if (res.charAt(i) >= 'a') {
		    c = (char) (keyBuffer.charAt(res.charAt(i) - 'a') + 32);
		    ciphertext.append(c);
		} else {
		    c = (char) (keyBuffer.charAt(res.charAt(i) - 'A'));
		    ciphertext.append(c);
		}
	    }
	    System.out.println(ciphertext.toString());
	}
	cin.close();
    }

}

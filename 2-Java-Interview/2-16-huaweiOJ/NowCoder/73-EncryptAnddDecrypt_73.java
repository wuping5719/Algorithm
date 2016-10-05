package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午4:38:24
 */

public class EncryptAnddDecrypt_73 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while(cin.hasNext()) {
	    String plainText = cin.nextLine();
	    String cipherText = cin.nextLine();
	    
	    //加密
	    StringBuffer encryptStr = new StringBuffer();
	    for(int i=0; i<plainText.length(); i++) {
		if(plainText.charAt(i) >= 'A' && plainText.charAt(i) < 'Z') {
		    char ch = (char)(plainText.charAt(i) + 1);
		    encryptStr.append(Character.toLowerCase(ch));
		}else if(plainText.charAt(i) == 'Z') {
		    encryptStr.append('a');
		}else if(plainText.charAt(i) >= 'a' && plainText.charAt(i) < 'z') {
		    char ch = (char)(plainText.charAt(i) + 1);
		    encryptStr.append(Character.toUpperCase(ch));
		}else if(plainText.charAt(i) == 'z') {
		    encryptStr.append('A');
		}else if(plainText.charAt(i) >= '0' && plainText.charAt(i) < '9') {
		    char ch = (char)(plainText.charAt(i) + 1);
		    encryptStr.append(ch);
		}else if(plainText.charAt(i) == '9') {
		    encryptStr.append('0');
		}else {
		    encryptStr.append(plainText.charAt(i));
		}
	    }
	    System.out.println(encryptStr.toString());
	    
	    //解密
	    StringBuffer decryptStr = new StringBuffer();
	    for(int i=0; i<cipherText.length(); i++) {
		if(cipherText.charAt(i) > 'A' && cipherText.charAt(i) <= 'Z') {
		    char ch = (char)(cipherText.charAt(i) - 1);
		    decryptStr.append(Character.toLowerCase(ch));
		}else if(cipherText.charAt(i) == 'A') {
		    decryptStr.append('z');
		}else if(cipherText.charAt(i) > 'a' && cipherText.charAt(i) <= 'z') {
		    char ch = (char)(cipherText.charAt(i) - 1);
		    decryptStr.append(Character.toUpperCase(ch));
		}else if(cipherText.charAt(i) == 'a') {
		    decryptStr.append('Z');
		}else if(cipherText.charAt(i) > '0' && cipherText.charAt(i) <= '9') {
		    char ch = (char)(cipherText.charAt(i) - 1);
		    decryptStr.append(ch);
		}else if(cipherText.charAt(i) == '0') {
		    decryptStr.append('9');
		}else {
		    decryptStr.append(cipherText.charAt(i));
		}
	    }
	    System.out.println(decryptStr.toString());
	}
	cin.close();
    }

}

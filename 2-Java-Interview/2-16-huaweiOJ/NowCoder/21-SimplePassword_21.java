package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月1日 下午7:26:33
 */

public class SimplePassword_21 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String plaintext = cin.nextLine();
	    
	    if(plaintext != null && plaintext.length() > 0) {
		char[] charArray = plaintext.toCharArray();
		
		StringBuffer cipher = new StringBuffer();
		for(int i=0; i<charArray.length; i++) {
		    // 手机上的字母： 
		    //   1--1， abc--2, def--3, ghi--4, jkl--5, 
		    //   mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,
		    // 就这么简单，把密码中出现的小写字母都变成对应的数字
		    if(charArray[i] >= 'a' && charArray[i] <= 'z') {
			if(charArray[i]=='a' || charArray[i]=='b' || charArray[i]=='c') {
			    cipher.append(2);
			}else if(charArray[i]=='d' || charArray[i]=='e' || charArray[i]=='f') {
			    cipher.append(3);
			}else if(charArray[i]=='g' || charArray[i]=='h' || charArray[i]=='i') {
			    cipher.append(4);
			}else if(charArray[i]=='j' || charArray[i]=='k' || charArray[i]=='l') {
			    cipher.append(5);
			}else if(charArray[i]=='m' || charArray[i]=='n' || charArray[i]=='o') {
			    cipher.append(6);
			}else if(charArray[i]=='p' || charArray[i]=='q' || charArray[i]=='r' || charArray[i]=='s') {
			    cipher.append(7);
			}else if(charArray[i]=='t' || charArray[i]=='u' || charArray[i]=='v') {
			    cipher.append(8);
			}else if(charArray[i]=='w' || charArray[i]=='x' || charArray[i]=='y' || charArray[i]=='z') {
			    cipher.append(9);
			}
		    }else if(charArray[i] >= 'A' && charArray[i] <= 'Z') {
			//密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位.
			//如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。
			//记住，z往后移是a哦。
			if(charArray[i] <'Z') {
			    char charLowerCase = Character.toLowerCase(charArray[i]);
			    int nextCharToInt = ((int)charLowerCase) + 1;
			    char nextChar = (char)nextCharToInt;
			    cipher.append(nextChar);
			}else {
			    cipher.append('a');
			}
		    }else {  // 数字和其他的符号都不做变换
			cipher.append(charArray[i]);
		    }
		}
		
		System.out.println(cipher.toString());
	    }
	}
	cin.close();
    }

}

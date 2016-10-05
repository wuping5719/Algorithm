package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午8:41:33
 */

public class CountCharacter_79 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    int letterNum = 0;
	    int spaceNum = 0;
	    int digitNum = 0;
	    int otherNum = 0;
	    for(int i=0; i<str.length(); i++) {
		if((str.charAt(i)>='A' && str.charAt(i)<='Z') || (str.charAt(i)>='a' && str.charAt(i)<='z')) {
		    letterNum++;
		}else if(str.charAt(i)==' ') {
		    spaceNum++;
		}else if(str.charAt(i)>='0' && str.charAt(i)<='9') {
		    digitNum++;
		}else {
		    otherNum++;
		}
	    }
	    System.out.println(letterNum);
	    System.out.println(spaceNum);
	    System.out.println(digitNum);
	    System.out.println(otherNum);
	}
	cin.close();
    }

}

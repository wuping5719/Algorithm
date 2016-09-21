package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月21日 下午2:04:37
 */

public class CompareString {

    public static String getNoSameChildString(String A, String B) {
	char[] aArray = A.toCharArray();
	char[] bArray = B.toCharArray();
	StringBuffer sb = new StringBuffer();
	
	int curIndex = 0;
	while(curIndex < bArray.length) {
	    if(curIndex < aArray.length) {
		if(bArray[curIndex] != aArray[curIndex]) {
		    sb.append(bArray[curIndex]);
		}
		curIndex++;
	    }else {
		sb.append(bArray[curIndex]);
		curIndex++;
	    }
	}
	
	return sb.toString();
    }
 
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (sc.hasNext()) {
	    String A = sc.nextLine();
	    String B = sc.nextLine();
	    String result = getNoSameChildString(A, B);
	    System.out.println(result);
	}
	sc.close();
    }

}

package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月30日 下午6:52:17
 */

public class PrimeFactorsOfLong_6 {
    
    public static String getResult(long ulDataInput) {
	long input = ulDataInput;
	StringBuffer sb = new StringBuffer();
	while(input != 1) {
	    for (long i = 2; i <= input; i++) {
		if (input % i == 0) {
		    sb.append(i);
		    sb.append(" ");
		    input = input / i;
		    break;
		}
	    }
	}
	return sb.toString();
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    long ulDataInput = cin.nextLong();
	    String resStr = getResult(ulDataInput);
	    System.out.println(resStr);
	}
	cin.close();
    }

}

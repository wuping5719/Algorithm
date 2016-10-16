package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月16日 下午9:21:27
 */

public class minOfSn {

    // Sn = 1+ 1/2 + 1/3 + ... + 1/n; 满足Sn>k的最小整数
    public static long getMinOfSn(int k) {
	double sn = 0;
	double one = 1;
	long n = 1;
	while((k-sn) > 0.00000001) {
	    sn += one / n;
	    n++;
	}
	return n;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int k = cin.nextInt();
	    System.out.println(getMinOfSn(k));
	}
	cin.close();
    }

}

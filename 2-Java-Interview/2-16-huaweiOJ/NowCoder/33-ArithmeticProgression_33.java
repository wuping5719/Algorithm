package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月2日 下午9:43:00
 */

public class ArithmeticProgression_33 {
    
    // 等差数列求和公式: Sn = a1*n + n*(n-1)*d/2
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    if(n<0) {
		System.out.println(-1);
	    }else {
		long sum = 2*n + n*(n-1)*3/2;
		System.out.println(sum);
	    }
	}
	cin.close();
    }

}

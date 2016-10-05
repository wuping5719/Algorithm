package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 上午10:37:39
 */

public class PerfectNumber_68 {

    public static boolean isPerfectNumber(long n) {
	long sum = 0;
	for(long i=1; i<= n/2; i++) {
	    if(n % i == 0) {
		sum = sum + i;
	    }
	}
	if(sum == n) {
	    return true;
	}else {
	    return false;
	}
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	   long n = cin.nextLong();
	   long count = 0;
	   for(int i=1; i<=n; i++) {
	       if(isPerfectNumber(i)) {
		   count++;
	       }
	   }
	   System.out.println(count);
	}
	cin.close();
    }

}

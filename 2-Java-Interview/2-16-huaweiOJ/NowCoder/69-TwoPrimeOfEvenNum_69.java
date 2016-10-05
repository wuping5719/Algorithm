package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 上午10:56:57
 */

public class TwoPrimeOfEvenNum_69 {

    public static boolean isPrimeNumber(long n) {
	for(long i=2; i<=n/2; i++) {
	    if(n % i == 0) {
		return false;
	    }
	}
	return true;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	   long n = cin.nextLong();
	   long firstPrime = n/2;
	   long lastPrime = n/2;
	   while(firstPrime >= 2 && lastPrime < n) {
	       if(isPrimeNumber(firstPrime) && isPrimeNumber(lastPrime) 
		       && (firstPrime + lastPrime == n)) {
		   break;
	       }
               firstPrime--;
               lastPrime++;
	   }
	   System.out.println(firstPrime);
	   System.out.println(lastPrime);
	}
	cin.close();
    }

}

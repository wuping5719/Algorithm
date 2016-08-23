package swordOffer;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年8月23日 下午4:17:49
 */

public class Fibonacci_09 {

    public static long Fibonacci(int n) {
       if(n <= 0) {
	   return 0;
       }
       if(n == 1) {
	   return 1;
       }
       long fibNMinusOne = 1;
       long fibNMinusTwo = 0;
       long fibN = 0;
       for(int i=2; i<=n; i++) {
	   fibN = fibNMinusOne + fibNMinusTwo;
	   
	   fibNMinusTwo = fibNMinusOne;
	   fibNMinusOne = fibN;
       }
       
       return fibN;
    }
    
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	while(scanner.hasNext()) {
	    long result = Fibonacci(scanner.nextInt());
	    System.out.println(result);
	}
	scanner.close();
    }

}

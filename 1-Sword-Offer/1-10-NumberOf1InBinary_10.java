package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月23日 下午6:50:25 
 * @version 1.0 
 */
public class NumberOf1InBinary_10 {
	
	public static long NumberOf1(long n) {
	   long count = 0;
       while(n!=0){
    	   count++;
    	   n = (n-1) & n;
       }
       return count;
    }
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			long result = NumberOf1(scanner.nextLong());
			System.out.println(result);
		}
		scanner.close();
	}

}

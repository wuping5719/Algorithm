package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月23日 下午7:24:55 
 * @version 1.0 
 */
public class Power_11 {
	
	static boolean g_InvalidInput = false;
	
	public static double Power(double base, int exponent) {
		g_InvalidInput = false;
		if(equal(base, 0.0) && exponent < 0){
			g_InvalidInput = true;
			return 0.0;
		}
		
		int absExponent = exponent;
		if(exponent < 0){
			absExponent = -exponent;
		}
		
		double result = PowerWithExponent(base, absExponent);
		if(exponent < 0){
			result = 1.0 / result;
		}
		
		return result;
	}
	
	public static double PowerWithExponent(double base, int exponent){
		if(exponent == 0){
			return 1;
		}
		if(exponent == 1){
			return base;
		}
		
		double result = PowerWithExponent(base, exponent >> 1);
		result *= result;
		if((exponent & (0x1)) ==1){
			result *= base;
		}
		
		return result;
	}
	
	public static boolean equal(double num1, double num2){
		if((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001)){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			double base = scanner.nextDouble();
			int exponent = scanner.nextInt();
			double result = Power(base, exponent);
			System.out.println(result);
		}
		scanner.close();
	}

}

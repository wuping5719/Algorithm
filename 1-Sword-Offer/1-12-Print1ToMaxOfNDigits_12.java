package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月23日 下午8:07:28 
 * @version 1.0 
 */
public class Print1ToMaxOfNDigits_12 {

	public static void Print1ToMaxOfNDigits(int n){
		if(n <= 0){
			return;
		}
		
		char[] number = new char[n];
		for(int i=0; i<10; i++){
			number[0] = (char) (i + '0');
			Print1ToMaxOfNDigitsRecursively(number, n, 0);
		}
	}
	
	public static void Print1ToMaxOfNDigitsRecursively(char[] number, int length, int index){
		if(index == length-1){
			PrintNumber(number);
			return;
		}
		
		for(int i=0; i<10; i++){
			number[index+1] = (char) (i + '0');
			Print1ToMaxOfNDigitsRecursively(number, length, index+1);
		}
	}
	
	public static void PrintNumber(char[] number){
		boolean isBeginning0 = true;
		int nLength = number.length;
		
		for(int i=0; i<nLength; i++){
			if(isBeginning0 && number[i] !='0'){
				isBeginning0 = false;
			}
			
			if(!isBeginning0){
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Print1ToMaxOfNDigits(n);
		
		scanner.close();
	}

}

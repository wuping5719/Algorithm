package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月25日 下午10:48:14 
 * @version 1.0 
 */
public class UglyNumber_34 {

	public static int GetUglyNumber_Solution(int index) {
		if(index <= 0)
           return 0;
		
		int[] uglyNumbers = new int[index];
		uglyNumbers[0] = 1;
		int nextUglyIndex = 1;
		
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		
		while(nextUglyIndex < index){
			int multiply2 = uglyNumbers[i2] * 2;
			int multiply3 = uglyNumbers[i3] * 3;
			int multiply5 = uglyNumbers[i5] * 5;
			int min = (multiply2 < multiply3) ? multiply2: multiply3;
			min = (min < multiply5) ? min: multiply5;
			
			uglyNumbers[nextUglyIndex] = min;
			
			if(min == multiply2){
				i2++;
			}
			if(min == multiply3){
				i3++;
			}
			if(min == multiply5){
				i5++;
			}
			
			nextUglyIndex++;
		}
		
		int ugly = uglyNumbers[nextUglyIndex-1];
		return ugly;
    }
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
        	 int index = scanner.nextInt();
             int result = GetUglyNumber_Solution(index);
             System.out.println(result); 
        }
        scanner.close();
	}

}

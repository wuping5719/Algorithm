package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月27日 下午3:53:21 
 * @version 1.0 
 */
public class AddTwoNumbers_47 {

    public static int Add(int num1, int num2) {
        int sum, carry;
        do{
        	sum = num1 ^ num2;
        	carry = (num1 & num2) << 1;
        	
        	num1 = sum;
        	num2 = carry;
        }while(num2 != 0);
        
        return num1;
    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			int n1 = scanner.nextInt();
			int n2 = scanner.nextInt();
			int sum = Add(n1, n2);
			System.out.println(sum);
		}

		scanner.close();
	}

}

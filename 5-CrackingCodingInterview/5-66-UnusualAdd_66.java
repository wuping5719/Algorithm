package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月15日 下午3:45:24
 */

public class UnusualAdd_66 {

    public static int addAB(int A, int B) {
        int sum = 0;
        int carry = 0; //进位
        do {
           sum = A ^ B;
           carry = (A & B) << 1;
           
           A = sum;
           B = carry;
        }while(B != 0);
        
        return A;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int A = cin.nextInt();
	    int B = cin.nextInt();
	    System.out.println(addAB(A, B));
	}
	cin.close();

    }

}

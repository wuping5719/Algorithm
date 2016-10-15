package interview;

import java.text.DecimalFormat;
import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月13日 下午3:37:27 
 * @version 1.0 
 */
public class SqrtSum {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
        int n1=0;
        int m1=0;
        while(cin.hasNextInt())
        {
             n1 = cin.nextInt();
             m1 = cin.nextInt();
             SumSqrt(n1, m1);
        }
	}

	public static void SumSqrt(int n, int m) {
		double sum = n;
		double tempSqrt = n;
		for(int i=1; i<m; i++){
			tempSqrt = Math.sqrt(tempSqrt);
			sum = sum + tempSqrt;
		}
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println(df.format(sum));
	}
}

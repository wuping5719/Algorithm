package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月10日 下午8:01:06
 */

public class NoJudgeMax_61 {

    public static int getMax(int a, int b) {
	return ((a + b + Math.abs(a - b)) / 2);
    }
    
    public static int getMax1(int a, int b) {
	b = a - b;  //此时b>>31为1, 则b小于0即a<b; 若b>>31为0, 则a>b
	a -= b & (b>>31); //若a<b, a=a-(a-b); 若a>b, a=a-0 
	return a;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int a = cin.nextInt();
	    int b = cin.nextInt();
	    System.out.println(getMax1(a, b));
	}
	cin.close();
    }

}

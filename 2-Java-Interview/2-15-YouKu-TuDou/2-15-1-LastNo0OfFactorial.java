package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月16日 下午8:59:29
 */

public class LastNo0OfFactorial {

    //阶乘的最后一位非0值
    public static int GetLastNo0OfFactorial(int n) {
	int result = 0;
	long f = 1;
	for(int i=2; i<=n; i++)  
        {  
            f *= i;  
            while(f % 10 == 0) {  
               f /= 10;    //将阶乘末尾的0去掉
            }
            f = f % 100000;  //阶乘太大时，只保留最后5位非0尾数，对计算结果没有影响
        }  
	result = (int) f % 10;
	
	return result;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    System.out.println(GetLastNo0OfFactorial(n));
	}
	cin.close();
    }

}

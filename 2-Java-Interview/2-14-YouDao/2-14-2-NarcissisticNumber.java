package interview;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月13日 下午3:59:23 
 * @version 1.0  
 */
public class NarcissisticNumber {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
        int m=0;
        int n=0;
        while(cin.hasNextInt())
        {
             m = cin.nextInt();
             n = cin.nextInt();
             getNarcissisticNumber(m, n);
        }
	}

	public static void getNarcissisticNumber(int m, int n) {
		boolean globFlag = true;    //全局标志，用于如果给定的范围内不存在水仙花数，则输出no
		for(int i=m; i<=n; i++){
		   if(isNarcissisticNumber(i)){
			   System.out.print(i+" ");
			   globFlag = false;
		   }
		}
		
		if(globFlag){
			System.out.println("no");
		}else{
			System.out.println();
		}
	}
	
    public static boolean isNarcissisticNumber(int n) {
    	boolean flag = false; // 判断该三位数是否为水仙花数，默认为false
    	int temp;
		int g;   // 个位
		int s;   // 十位
		int b;   // 百位
		g = n % 10;
		s = n / 10 % 10;
		b = n / 100;
		temp = g*g*g + s*s*s + b*b*b;
		if(temp==n){
			flag=true;
		}
		return flag;
	}
}

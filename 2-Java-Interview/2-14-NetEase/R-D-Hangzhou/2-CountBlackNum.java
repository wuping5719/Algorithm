package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月12日 下午7:25:36
 */

public class CountBlackNum {

    public static long countBlackNum(int n) {
	if(n<1) {
	    return 0;
	}
	if(n==1) {
	    return 3;
	}
	if(n==2) {
	    return 9;  //3*2+f(n-1)
	}
	if(n==3) {
	    return 21;  //3*3*3-3*2
	}
	
	long divSum = 5; 
	int temp2 = n-2;
	while(temp2>0) {
	    divSum = divSum * 3;
	    temp2--;
	}
	
	return divSum;
    }
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while(sc.hasNext()) {
	    int n = sc.nextInt();
	    long result = countBlackNum(n);
	    System.out.println(result);
	}
	sc.close();
    }

}

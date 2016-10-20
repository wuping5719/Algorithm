package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月20日 下午7:44:41
 */

public class BortherPrime {

    // 找到最大孪生素数
    /* 题目描述：
                           孪生素数就是差为2的素数对，例如11和13。输入一个正整数N（0<N<1000000)，返回小于等于N的最大孪生素数。
                    输入:
                           输入数据有多组，每组占一行，输入正整数N（0<N<1000000）
                    输出:
                           每个测试实例输出占一行，输出的孪生素数对用空格分隔，如果不存在则输出No。
                    样例输入:
          20
          43
          2
                    样例输出:
          17 19
          41 43
          No
    */

    public static boolean isPrime(int x) {
	for(int i=2; i <= x/2; i++) {
	    if(x % i == 0) {
		return false;
	    }
	}
	return true;
    }
    
    public static void printMaxBrotherPrime(int n) {
	boolean find = false;
	for(int i=n; i>=4; i--) {
	    if(isPrime(i) && isPrime(i-2)) {
		System.out.println((i-2) +" "+ i);
		find = true;
		break;
	    }
	}
	if(!find) {
	    System.out.println("No");
	}
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    printMaxBrotherPrime(n);
	}
	cin.close();
    }

}

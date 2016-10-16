package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月16日 下午9:53:22
 */

public class NumOfIntegerPair {

    //常规思路算法时间复杂度太高
    //满足最大公约数为a, 最小公倍数为b的m, n整数对 对数
    public static int getNumOfIntegerPair(int a, int b) {
	if(a > b) {  //始终保证: a <= b
	    int temp = a;
	    a = b;
	    b = temp;
	}
	int count = 0;
	for(int i=a; i <= b/2; i++) {
	    for(int j=b; j >= b/2; j--) {
		if(i != j && greatestCommonDivisor(i,j) == a
			&& leastCommonMultiple(i,j) == b) {   
		    count++;
		}
	    }
	}
	return count;
    }
    
    //最大公约数
    /* 一步步的简化a,b这两个数, 简化的方法如下:
     (1)如果y = k*y1, x = k*x1. 那么有f(x,y) = k*f(x1,y1)
     (2)如果x = p*x2, p为素数, 并且y%p != 0, 那么f(x,y) = f(p*x2,y) = f(x2,y)
              于是我们得到下面的解决方法:
              令p = 2,
              若x,y均为偶数, f(x,y) = 2*f(x/2,y/2) = 2*f(x>>1,y>>1);
              若x是偶数, y是奇数, f(x,y) = f(x/2,y) = f(x>>1,y);
              若x是奇数, y是偶数, f(x,y) = f(x,y/2) = f(x,y>>1);
              若x和y均为奇数, f(x,y) = f(y, x-y). 这时x-y一定是偶数,下一步一定会除以2.
    */
    public static int greatestCommonDivisor(int a, int b) {
	if (a < b) {
	    return greatestCommonDivisor(b, a);
	}
	if (0 == b) {
	    return a;
	}
	if (a % 2 == 0) {  //若a是偶数
	    if (b % 2 == 0) {  //若b是偶数
		return greatestCommonDivisor(a >> 1, b >> 1) * 2;
	    }else {  //若b是奇数
		return greatestCommonDivisor(a >> 1, b);
	    }
	} else {   //若a是奇数
	    if (b % 2 == 0 ) {  //若b是偶数
		return greatestCommonDivisor(a, b >> 1);
	    }else {  //若b是奇数
		return greatestCommonDivisor(b, a - b);
	    }
	}
    }
    
    // 最小公倍数  
    public static int leastCommonMultiple(int a, int b) {  
	int gcd = greatestCommonDivisor(a, b);
	if(gcd != 0) {
	    return a * b / gcd;
	}else {
	    return a * b;
	}
    }  
    
    //新思路:
    // 可以将问题转化为: 设n, m就是那个整数对, a, m, n, b, 这4个数都是可以被a整除的, 可以都除以a,
    // 题目转化为求出: 最大公约数为1, 最小公倍数为b/a的对数.
    // 也就是求出在1到b/a里, 乘积为b/a且互质的对数. 可以在O(sqrt(b/a))内解决.
    public static int newNumOfIntegerPair(int a, int b) {
	if(a > b) {  //始终保证: a <= b
	    int temp = a;
	    a = b;
	    b = temp;
	}
	if(b % a != 0) {  
            return 0; 
        }  
	int count = 0;
	int x = b / a;
	for(int i = 1; i <= Math.sqrt(x); i++) {  
            if(x % i == 0) {  
                int j = x / i;  
                if(greatestCommonDivisor(i, j) == 1) 
                    count++;  
            }  
        } 
	return count;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int a = cin.nextInt();
	    int b = cin.nextInt();
	    System.out.println(newNumOfIntegerPair(a, b));
	}
	cin.close();
    }

}

package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月18日 下午4:48:30
 */

public class ZeroNumEndOfNFactorial {

    // 末尾0的个数 ,计算2和5因数个数
    /* 解题思路：两个素数2、5，相乘即可得到10，我们可以认为，有多少组2、5，结尾就有多少个0 */
    /* 操作方法：操作1到1000中所有的数，看每个数能被2和5整除几次，并分别统计，假设被2整除8次，被5整除12次，那我们可以认为有8组（2，5），即8个0*/
    public static int zeroNumEndOfNFactorial(int n) {
	if (n < 0 || n > 1000) {
	    return 0;
	}

	int sum = 0;
	// 计算因数2和5个数
	int num_2 = 0;
	int num_5 = 0;
	for (int i = 1; i <= n; i++) {
	    int merchant = i; // 商
	    while (merchant % 2 == 0) {
		num_2++;
		merchant = merchant / 2;
	    }
	    while (merchant % 5 == 0) {
		num_5++;
		merchant = merchant / 5;
	    }

	    sum = num_2 <= num_5 ? num_2 : num_5;
	}

	return sum;
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (sc.hasNext()) {
	    int n = sc.nextInt();
	    int result = zeroNumEndOfNFactorial(n);
	    System.out.println(result);
	}
	sc.close();
    }

}

package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月11日 下午3:39:32
 */

public class FactorZeroTail_63 {

    //思路: (1)把n!分解成若干个素数相乘, 只有 2*5才可能产生尾随零, 而2的数量多于5,所以问题转化为计算有多少个5.
    //    (2)先数一数1到n之间有几个5的倍数(数量为n/5),然后数有几个25的倍数(数量为n/25),依次类推.
    public static int getFactorSuffixZero(int n) {
        if(n < 5) {
            return 0;
        }
        int count = 0;
        for(int i=5; (n/i)>0; i*=5) {
            count += n/i;
        }
        return count;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    System.out.println(getFactorSuffixZero(n));
	}
	cin.close();
    }

}

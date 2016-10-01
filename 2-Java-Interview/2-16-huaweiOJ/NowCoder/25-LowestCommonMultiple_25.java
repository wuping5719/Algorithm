package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月1日 下午9:57:08
 */

public class LowestCommonMultiple_25 {

    public static long LCM1(int A, int B) {
	long lowestCommonMultiple = A * B;
	int curNum = 0;
	int indexA = 1;
	int indexB = 1;
	int curA = 1;
	int curB = 1;
	while (curNum < (A * B)) {
	    curA = A * indexA;
	    curB = B * indexB;
	    if (curA < curB) {
		curNum = curA;
		indexA++;
	    } else {
		curNum = curB;
		indexB++;
	    }

	    if ((curNum % A == 0) && (curNum % B == 0)) {
		if (curNum < lowestCommonMultiple) {
		    lowestCommonMultiple = curNum;
		    break;
		}
	    }
	}
	return lowestCommonMultiple;
    }
    
    //更快的思路：两数最小公倍数等于两数乘积除以两数的最大公约数
    public static int GCD(int A, int B) {
	while (A % B != 0) {
	    int temp = A;
	    A = B;
	    B = temp % B;
	}
	return B;
    }
    public static long LCM2(int A, int B) {
      return A * B / GCD(A, B);
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int A = cin.nextInt();
	    int B = cin.nextInt();
	    //long result1 = LCM1(A, B);
	    //System.out.println(result1);
	    
	    long result2 = LCM2(A, B);
	    System.out.println(result2);
	}
	cin.close();
    }

}

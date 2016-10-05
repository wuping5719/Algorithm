package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午4:57:53
 */

public class NumOfRabbitsPerMonth_74 {

    // 斐波拉契数列-递推公式: f(n) = f(n-1) + f(n-2) (n>=3)
    public static int getRabbitsNum(int month){
        if(month == 1 || month == 2){
            return 1;
        }
        return getRabbitsNum(month-1) + getRabbitsNum(month-2);
    }

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while(cin.hasNext()) {
	    int month = cin.nextInt();
	    System.out.println(getRabbitsNum(month));
	}
	cin.close();
    }

}

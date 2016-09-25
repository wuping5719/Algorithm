package huawei;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月25日 上午9:34:05
 */

public class BigIntegerQiuYu {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    BigInteger int1 =  cin.nextBigInteger();
	    BigInteger int2 =  cin.nextBigInteger();
	    
	    System.out.println(int1.remainder(int2));
	}
	cin.close();
    }

}

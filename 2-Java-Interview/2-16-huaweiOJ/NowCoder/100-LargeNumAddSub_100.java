package huawei;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月6日 下午9:43:23
 */

public class LargeNumAddSub_100 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            BigInteger m = cin.nextBigInteger();
            BigInteger n = cin.nextBigInteger();
            System.out.println(m.add(n));
        }
        cin.close();
    }

}

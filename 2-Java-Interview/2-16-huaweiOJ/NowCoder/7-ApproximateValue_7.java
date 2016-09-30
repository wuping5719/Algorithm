package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月30日 下午7:23:36
 */

public class ApproximateValue_7 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    float a = cin.nextFloat();
	    int result= (int)(a + 0.5);
	    System.out.println(result);
	}
	cin.close();

    }

}

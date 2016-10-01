package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月1日 下午8:03:15
 */

public class SodaBottles_22 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    // n=0 表示输入结束
	    if(n==0) {
		break;
	    }
	    
	    int left = 0;
	    int temp = n;
	    int sum = 0;
	    while(temp > 1) {
		left = temp % 3;
		sum = sum + temp / 3;
		temp = temp / 3 + left;
		if(temp == 2) {
		    temp++;
		}
	    }
	    System.out.println(sum);
	}
	cin.close();
    }

}

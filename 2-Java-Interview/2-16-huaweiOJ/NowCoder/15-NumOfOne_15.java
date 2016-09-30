package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月30日 下午10:46:39
 */

public class NumOfOne_15 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int temp = n;
	    int count = 0;
	    while(temp != 0) {
		temp = temp & (temp - 1);
		count++;
	    }
	    System.out.println(count);
	}
	cin.close();
    }

}

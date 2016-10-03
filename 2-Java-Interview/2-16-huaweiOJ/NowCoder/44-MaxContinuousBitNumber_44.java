package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月3日 下午8:16:31
 */

public class MaxContinuousBitNumber_44 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()) {
            int n = cin.nextInt();
            int max = 0;
            int count = 0;
            while(n > 0) {
        	if(n % 2 == 1) {
        	    count++;
        	    if (count > max) {
                        max = count;
                    }
        	}else {
        	    count = 0;
        	}
        	n = n >> 1;
            }
            System.out.println(max);
        }
        cin.close();
    }

}

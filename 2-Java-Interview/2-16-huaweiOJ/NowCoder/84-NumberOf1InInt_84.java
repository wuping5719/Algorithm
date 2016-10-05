package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午10:34:35
 */

public class NumberOf1InInt_84 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
            int n = cin.nextInt();
            int count = 0;
            while(n > 0) {
        	count++;
                n = n & n-1;  //将最右边的1置为0
            }  
            System.out.println(count);
	}
	cin.close();
    }

}

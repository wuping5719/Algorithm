package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午7:03:46
 */

public class BallRebound5Times_76 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            int high = cin.nextInt();
            double d = high;
            double currentH = high;
            for(int i=0; i<5; i++) {
        	currentH = currentH / 2;
        	if(i<4) {
        	    d = d + currentH * 2; 
        	}
            }
            System.out.println(d);
            System.out.println(currentH);
        }
        cin.close();
    }

}

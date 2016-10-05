package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午10:22:50
 */

public class ReciprocalKNode_83 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
            int n = cin.nextInt();
            int[] list = new int[n];
            for(int i=0; i<n; i++) {
        	list[i] = cin.nextInt();
            }
            int k = cin.nextInt();
            if(n - k >= 0 && k<=n && k>0) {
        	System.out.println(list[n-k]);
            }else {
        	System.out.println(0);
            }
	}
	cin.close();
    }

}

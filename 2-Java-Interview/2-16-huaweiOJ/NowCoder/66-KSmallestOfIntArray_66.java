package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月4日 下午11:44:11
 */

public class KSmallestOfIntArray_66 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int k = cin.nextInt();
	    if (k > 0 && k <= n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
		    array[i] = cin.nextInt();
		}
		Arrays.sort(array);
		for (int i = 0; i < k; i++) {
                   if(i==0) {
                       System.out.print(array[i]);
                   }else {
                       System.out.print(" " + array[i]);
                   }
		}
		System.out.println();
	    }
	}
	cin.close();
    }

}

package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月2日 下午9:05:35
 */

public class ArraysSort_32 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[] array = new int[n];
	    for(int i=0; i<n; i++) {
		array[i] = cin.nextInt();
	    }
	    int sortFlag = cin.nextInt();
	    // 0表示按升序
	    Arrays.sort(array);
	    if(sortFlag == 0) {
		for(int i=0; i<n; i++) {
		    if(i == 0) {
		       System.out.print(array[i]);
		    }else {
		       System.out.print(" " + array[i]);
		    }
		}
	    }else {  // 1表示按降序
		for(int i=n-1; i>=0; i--) {
		    if(i == n-1) {
		       System.out.print(array[i]);
		    }else {
		       System.out.print(" " + array[i]);
		    }
		}
	    }
	    System.out.println();
	}
	cin.close();
    }

}

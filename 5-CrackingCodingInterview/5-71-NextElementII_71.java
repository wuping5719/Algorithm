package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月15日 下午11:38:22
 */

public class NextElementII_71 {

    public static int[] findNext(int[] A, int n) {
	int[] result = new int[n];
        for(int i=0; i<n; i++) {
            result[i] = -1;
        }
        
        for(int i=0; i<n; i++) {
            int curMin = Integer.MAX_VALUE;
            for(int j=i; j<n; j++) {
                if(A[j] > A[i]) {
                    if(A[j] < curMin) {
                	curMin = A[j];
                    }
                }
            }
            if(curMin < Integer.MAX_VALUE) {
        	result[i] = curMin;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[] A = new int[n];
	    for(int i=0; i<n; i++) {
		A[i] = cin.nextInt();
	    }
	    
	    int[] result = findNext(A, n);
	    for(int i=0; i<n; i++) {
		System.out.print(result[i] + " ");
	    }
	    System.out.println();
	}
	cin.close();
    }

}

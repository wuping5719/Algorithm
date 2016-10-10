package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月10日 下午7:06:58
 */

public class AntiOrder_58 {

    public static int count(int[] A, int n) {
	int count = 0;
	if(n <= 1) {
	    return count;
	}
	
	for(int i=0; i<n; i++) {
	    for(int j=i+1; j<n; j++) {
	        if(A[i]>A[j])  {
	            count++;
	        }
	    } 
	}
	return count;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[] array = new int[n];
	    for(int i=0; i<n; i++) {
		array[i] = cin.nextInt();
	    }
	    
	    System.out.print(count(array, n));
	}
	cin.close();

    }

}

package acmCoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月15日 下午4:29:13
 */

public class FindPair_68 {
    
    public static int countPairs(int[] A, int n, int sum) {
        int count = 0;
        if(n < 2) {
            return 0;
        }
        
	Arrays.sort(A);
	
        int start = 0;
        int end = n-1;
        
        while(start < end) {
            int tempSum = A[start] + A[end];
            if(tempSum == sum) {
                if(A[start] == A[end]){   // 3 3 3这种情况
                    int x = end - start + 1;
                    count += x * (x-1) / 2;
                    break;
                }else{      // 2 2 3 4 4 4这种情况
                    int k = start + 1;
                    while(k <= end && A[start] == A[k]){
                       ++k;
                    }
                    int k2 = end - 1;
                    while(k2 >= start && A[end] == A[k2]){
                       --k2;
                    }
                    count += (k-start)*(end-k2);
                    start = k;
                    end = k2;
                }
            }else if(tempSum < sum) {
        	start++;
            }else {
        	end--;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[] A = new int[n];
	    for(int i=0; i<n; i++) {
	       A[i] = cin.nextInt();
	    }
	    int sum = cin.nextInt();
	    System.out.println(countPairs(A, n, sum));
	}
	cin.close();
    }

}

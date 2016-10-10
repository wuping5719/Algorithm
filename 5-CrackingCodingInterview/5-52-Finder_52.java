package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月10日 下午3:04:06
 */

public class Finder_52 {

    // 二分查找的思路,比较条件做了修改
    public static int findElement(int[] A, int n, int x) {
        int start = 0;
        int end = n-1;
        int mid = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            if(A[mid] == x) {
        	return mid;
            } 
            if(A[mid] < x) {
                if(A[mid]<A[start] && x>A[end]) { 
                    end = mid - 1;
                }
                else { 
                    start = mid + 1;
                }
            }
            else {
                if(A[mid]>A[start] && x<A[start]) { 
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[] array = new int[n];
	    for(int i=0; i<n; i++) {
		array[i] = cin.nextInt();
	    }
	    int x = cin.nextInt();
	    System.out.println(findElement(array, n, x));
	}
	cin.close();
    }

}

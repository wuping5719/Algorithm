package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年9月5日 上午11:03:30
 */

public class MagicIndex_39 {

    public static boolean findMagicIndex(int[] A, int n) {
        if(A == null) {
            return false;
        }
        
        int start = 0;
        int end = n;
        int mid = 0;
        while(start < end) {
            mid = (start + end) / 2;
            if(mid == A[mid]) {
        	return true;
            }
            else if(mid > A[mid]) {
        	start = mid + 1;
            }else {
        	end = mid;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
       int[] A = {1, 2, 3, 4};
       int n = 2;
       boolean result = findMagicIndex(A, n);
       System.out.println(result);
    }

}

package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年9月5日 下午2:13:57
 */

public class MagicIndex2_40 {

    public static boolean findMagicIndex(int[] A, int n) {
        if(A == null) {
            return false;
        }
        
        if(n == 0) {
            return true;
        }else {
            return magicCore(A, 0, n-1);
        }
    }

    public static boolean magicCore(int[] A, int start, int end) {
	if(start > end)
	    return false;
        
        int mid = (start + end) / 2;
        if(mid == A[mid]) {
            return true;
        }
        
        int min = mid - 1 < A[mid] ? mid - 1 : A[mid];
        int max = A[mid] > mid + 1 ? A[mid] : mid + 1;
        return magicCore(A, start, min) || magicCore(A, max, end);
    }
    
    public static void main(String[] args) {
	int[] A = {1, 1, 2, 3, 4};
	int n = 2;
	boolean result = findMagicIndex(A, n);
	System.out.println(result);
    }

}

package crackingCodingInterview;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author WuPing
 * @version 2016年9月5日 下午3:51:01
 */

public class Subset_41 {

    // 总共有2^n-1种情况（n是数组个数）, 每种情况代表一个数, 一个数的各位代表取或者不取.
    public static ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	Arrays.sort(A);
	int max = 1 << n;
	for (int k = max - 1; k >= 1; k--) {
	    ArrayList<Integer> array = new ArrayList<Integer>();
	    for (int i = k, index = 0; i > 0; i >>= 1, index++) {
		if ((i & 1) == 1) {
		    array.add(0, A[index]);
		}
	    }
	    list.add(array);
	}
	return list;
    }
    
    public static void main(String[] args) {
        int[] A = {879, 123, 567, 246};
        int n = 4;
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        resultList = getSubsets(A, n);
        for(int i=0; i<resultList.size(); i++) {
            ArrayList<Integer> temp = resultList.get(i);
            for(int j=0; j<temp.size(); j++) {
        	System.out.print(temp.get(j) + " ");
            }
            System.out.println();
        }
    }

}

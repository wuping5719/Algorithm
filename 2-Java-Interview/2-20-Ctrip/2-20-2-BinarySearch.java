package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月17日 下午8:39:21
 */

public class BinarySearch {
    // 方法一，基于递归
    public static int binarySearch(int[] array, int find) {
       if(array==null || array.length<=0) {
	   return -1;
       }
       
       return binarySearchCore(array, find, 0, array.length-1);
    }
    
    public static int binarySearchCore(int[] array, int find, int start, int end) {
	int mid = (start + end) / 2;
	int index = -1;
	while(start < end) {
	    if(find==array[mid]) {
		return mid;
	    }
	    else if(find<array[mid]) {
		end = mid - 1;
		index = mid - 1;
		binarySearchCore(array, find, start, end);
	    }
	    else {
		start = mid + 1;
		index = mid + 1;
		binarySearchCore(array, find, start, end);
	    }
	}
	
	index = -1-index;
	return index;
    }
    
    // 方法二，基于循环
    public static int binarySearch2(int[] array, int find) {
	int mid = 0;
	int low = 0;
	int high = array.length-1;
	while(low<=high) {
	    mid = (low+high) / 2;
	    if(find==array[mid]) {
		return mid;
	    }
	    else if(find<array[mid]) {
		high = mid - 1;
	    }
	    else {
		low = mid + 1;
	    }
	}
	return low;
    }
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while(sc.hasNext()) {
	    int find = sc.nextInt();
	    int n = sc.nextInt();
	    int[] array = new int[n];
	    for(int i=0; i<n; i++) {
		array[i] = sc.nextInt();
	    }
	    
	    /* 
	    int result = binarySearch(array, find);
	    System.out.println(result);
	    */
	    
	    int index = binarySearch2(array, find);
	    if(index > array.length-1) {
		System.out.println(-1-index);
	    }else {
		if(array[index]==find) {
		    System.out.println(index);
		}else {
		    System.out.println(-1-index);
		}
	    }
	}
	sc.close();
    }

}

package swordOffer;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年8月23日 下午3:33:10
 */

public class MinNumberInRotatedArray_08 {

    public static int minNumberInRotateArray(int[] array) {
	if (array == null || array.length == 0) {
	    try {
		throw new Exception("Invalid parameters");
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}

	int start = 0;
	int end = array.length - 1;
	int mid = start;
	while (array[start] >= array[end]) {
	    if (end - start == 1) {
		mid = end;
		break;
	    }

	    mid = (start + end) / 2;
	    // 如果下标为start,mid和end指向的三个数字相等，只能顺序查找
	    if (array[start] == array[end] && array[mid] == array[start]) {
		int result = array[start];
		for (int i = start + 1; i <= end; i++) {
		    if (result > array[i]) {
			result = array[i];
		    }
		}
		return result;
	    }

	    if (array[mid] >= array[start]) {
		start = mid;
	    } else if (array[mid] <= array[end]) {
		end = mid;
	    }
	}
	return array[mid];
    }

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String str = scanner.nextLine();
	if (str.equals(null) || str.trim().equals("")) {
	    System.out.println("输入数组非法!");
	} else {
	    String[] arrayStr = str.split(",");
	    if (arrayStr.length == 0) {
		System.out.println("输入数组非法!");
	    }
	    int[] array = new int[arrayStr.length];
	    for (int i = 0; i < arrayStr.length; i++) {
		array[i] = Integer.parseInt(arrayStr[i]);
	    }
	    int result = minNumberInRotateArray(array);
	    System.out.println(result);
	}

	scanner.close();
    }

}

package swordOffer;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年8月25日 下午2:28:52
 */

public class MoreThanHalfNumber_29 {
    
    //******* 基于数组特点的解法一  ****************
    private static boolean g_inputInvalid = false;
    
    private static boolean CheckMoreThanHalf(int[] array, int number) {
	int times = 0;
	int length = array.length;
	for(int i=0; i<length; i++) {
	    if(array[i] == number) {
		times++;
	    }
	}
	
	boolean isMoreThanHalf = true;
	if(times*2 <=length) {
	    g_inputInvalid = true;
	    isMoreThanHalf = false;
	}
	return isMoreThanHalf;
    }
    
    public static int MoreThanHalfNum_Solution1(int[] array) {
	if(array ==null || array.length == 0) {
	    g_inputInvalid = true;
	    return 0;
	}
	
	int result = array[0];
	int times = 1;
	int length = array.length;
	for(int i=0; i<length; i++) {
	    if(times == 0) {
		result = array[i];
		times = 1;
	    }
	    else if(array[i] == result) {
		times++;
	    }
	    else {
		times--;
	    }
	}
	
	if(!CheckMoreThanHalf(array, result)) {
	    result = 0;
	}
	return result;
    }
    
    //*************** 基于Partition函数的解法二  **********
    private static void Swap(int num1, int num2) {
	int temp = num1;
	num1 = num2;
	num2 = temp;
    }
    
    private static int Partition(int[] array, int start, int end) {
	if(array ==null || array.length <= 0 || start < 0 || end >= array.length) {
	    System.out.println("非法参数!");
	    return 0;
	}
	Swap(array[0], array[end]);
	
	int small = start - 1;
	for(int i=start; i<end; i++) {
	    if(array[i] < array[end]) {
		small++;
		if(small != i) {
		    Swap(array[i], array[small]);
		}
	    }
	}
	
	small++;
	Swap(array[small], array[end]);
	return small;
    }
    
    public static int MoreThanHalfNum_Solution2(int[] array) {
	if(array ==null || array.length <= 0) {
	    g_inputInvalid = true;
	    return 0;
	}
	 
	int length = array.length;
	int middle = length >> 1;
	int start = 0;
	int end = length - 1;
	int index = Partition(array, start, end);
	while(index != middle) {
	    if(index > middle) {
		end = index - 1;
		index = Partition(array, start, end);
	    }
	    else {
		start = index + 1;
		index = Partition(array, start, end);
	    }
	}
	
	int result = array[middle];
	if(!CheckMoreThanHalf(array, result)) {
	    result = 0;
	}
	return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str==null || str.trim().equals("")) {
            System.out.println("输入非法！");
        }
        String[] arrayStr = str.split(",");
        int[] array = new int[arrayStr.length];
        for(int i=0; i<arrayStr.length; i++) {
            array[i] = Integer.parseInt(arrayStr[i]);
        }
        if(g_inputInvalid) {
            System.out.println("输入非法！");
        } 
        int result = MoreThanHalfNum_Solution1(array);
        //int result = MoreThanHalfNum_Solution2(array);
        System.out.println(result);
        scanner.close();
    }

}

package swordOffer;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年8月26日 下午4:12:53
 */

public class InversePairs_36 {

    private static final int modNum = 1000000007;
    
    public static int InversePairs(int[] array) {
	int p = 0;
	if (array == null || array.length <= 0) {
	    p = 0 % modNum;
	    return p;
	}

	int[] copyArray = new int[array.length];
	for (int i = 0; i < array.length; i++) {
	    copyArray[i] = array[i];
	}

	p = InversePairsCore(array, copyArray, 0, array.length - 1);
	return p;
    }

    public static int InversePairsCore(int[] array, int[] copyArray,
	    int start, int end) {
	if (start == end) {
	    copyArray[start] = array[end];
	    return 0;
	}

	int length = (end - start) / 2;
	// 数值过大求余
	int left = InversePairsCore(copyArray, array, start, start + length) % modNum;
	int right = InversePairsCore(copyArray, array, start + length + 1, end) % modNum;

	// i初始化为前半段最后一个数字的下标
	int i = start + length;
	// j初始化为后半段最后一个数字的下标
	int j = end;
	int indexCopy = end;
	int count = 0;
	while (i >= start && j >= start + length + 1) {
	    if (array[i] > array[j]) {
		copyArray[indexCopy--] = array[i--];
		count += j - start - length;
		if(count>=modNum) //数值过大求余
                {
                   count = count % modNum;
                }
	    } else {
		copyArray[indexCopy--] = array[j--];
	    }
	}

	for (; i >= start; i--) {
	    copyArray[indexCopy--] = array[i];
	}

	for (; j >= start + length + 1; j--) {
	    copyArray[indexCopy--] = array[j];
	}

	return (left + right + count)% modNum;  //数值过大求余
    }

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    if (str == null || str.length() <= 0) {
		System.out.println("输入非法！");
	    } else {
		String[] arrayStr = str.split(",");
		int[] array = new int[arrayStr.length];
		for (int i = 0; i < arrayStr.length; i++) {
		    array[i] = Integer.parseInt(arrayStr[i]);
		}
		long result = InversePairs(array);
		System.out.println(result);
	    }
	}
	cin.close();
    }

}

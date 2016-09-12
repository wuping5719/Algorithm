package acmCoder;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author WuPing
 * @version 2016年9月12日 下午7:59:20
 */

public class HuiWenString {

    public static boolean isHuiWen(int[] array) {
	Stack<Integer> stack = new Stack<Integer>();
	for(int i=0; i<array.length; i++) {
	    stack.push(array[i]);
	}
	for(int i=0; i<array.length; i++) {
	    if(array[i] != stack.peek()) {
		return false;
	    }
	    stack.pop();
	}
	return true;
    }
    
    public static int getMinNumOfOperate(int[] item) {
	if(isHuiWen(item)) {
	    return 0;
	}
	
	int minNum = 0;
	int[] tempItem = item;
	while(!isHuiWen(tempItem)) {
	    int[] temp1Item = operate(tempItem, 0, 1);
	    tempItem = new int[temp1Item.length];
	    tempItem = temp1Item;
	    minNum++;
	}
	return minNum;
    }
    
    public static int[] operate(int[] item, int smallIndex, int bigIndex) {
	int[] res = new int[item.length-1];
	int currentIndex = 0;
	int i = 0;
	while(i<item.length) {
	    if(i == smallIndex) {
		res[currentIndex] = item[smallIndex] + item[bigIndex];
		i++;
		currentIndex++;
	    }else {
		res[currentIndex] = item[i];
		currentIndex++;
	    }
	    i++;
	}
	return res;
    }
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while(sc.hasNext()) {
	    int n = sc.nextInt();
	    int[] item = new int[n];
	    for(int i=0; i<n; i++) {
		item[i] = sc.nextInt();
	    }
	    int result = getMinNumOfOperate(item);
	    System.out.println(result);
	}
	sc.close();
    }

}

package crackingCodingInterview;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author WuPing
 * @version 2016年8月30日 下午3:25:11
 */

public class TwoStacksSort_14 {

    // 方法一: 改变了原栈
    public static ArrayList<Integer> twoStacksSort1(int[] numbers) {
	if(numbers==null || numbers.length<=0) {
	    return null;
	}
	
	ArrayList<Integer> list = new ArrayList<Integer>(numbers.length);
	for(int i=0; i<numbers.length; i++) {
	    int temp = numbers[i];
            while(!list.isEmpty() && list.get(list.size()-1)<temp){
                numbers[i--] = list.get(list.size()-1);
                list.remove(list.size()-1);
            }
            list.add(temp);
	}
	return list;
    }
    
    // 方法二: 利用两个辅助栈排序
    public static ArrayList<Integer> twoStacksSort2(int[] numbers) {
	if (numbers == null || numbers.length < 1)
	    return null;
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	ArrayList<Integer> result = new ArrayList<Integer>();
	for (int i = 0; i < numbers.length; i++) {
	    stack1.push(numbers[i]);
	}
	
	while (!stack1.empty()) {
	    int temp = stack1.pop();
	    while (!stack2.empty() && stack2.peek() > temp) {
		stack1.push(stack2.pop());
	    }
	    stack2.push(temp);
	}
	
	while (!stack2.empty()) {
	    result.add(stack2.pop());
	}
	return result;
    }
    
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine()) {
           String str = cin.nextLine();
           if(str!=null && !str.trim().equals("")) {
               String[] strArray = str.split(",");
               int[] numbers = new int[strArray.length];
               for(int i=0; i<strArray.length; i++) {
        	   numbers[i] = Integer.parseInt(strArray[i]);
               }
               
               ArrayList<Integer> result = new ArrayList<Integer>();
               result = twoStacksSort1(numbers);
               for(int i=0; i<result.size(); i++) {
        	   if(i==0) {
        	       System.out.print(result.get(i));
        	   }else {
        	       System.out.print(" " + result.get(i));
        	   }
               }
           }
        }
        cin.close();
    }

}

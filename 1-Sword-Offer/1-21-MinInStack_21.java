package swordOffer;

import java.util.Stack;

/**
 * @author WuPing
 * @version 2016年8月24日 下午4:57:20
 */

public class MinInStack_21 {

    static Stack<Integer> stack_data = new Stack<Integer>();
    static Stack<Integer> stack_min = new Stack<Integer>();
    
    static boolean isError = false;  //栈空时,top和min返回-1,同时将错误标志置true
    
    public static void push(int node) {
	stack_data.push(node);
	if(stack_min.size() ==0 || node < stack_min.peek()) {
	    stack_min.push(node);
	}
	else {
	    stack_min.push(stack_min.peek());
	}
    }
    
    public static void pop() {
        if(stack_data.size() >0 && stack_min.size() >0) {
            stack_data.pop();
            stack_min.pop();
        }
    }
    
    public static int top() {
	if(stack_data.size() >0 && stack_min.size() >0) {
            return stack_data.peek();
        }else {
            isError = true;
            return -1;
        }
    }
    
    public static int min() {
	if(stack_data.size() >0 && stack_min.size() >0) {
            return stack_min.peek();
	}else {
	    isError = true;
	    return -1;
	}
    }
    
    public static void main(String[] args) {
       push(3);
       System.out.println(min());
       push(4);
       System.out.println(min());
       push(2);
       System.out.println(min());
       push(1);
       System.out.println(min());
       pop();
       System.out.println(min());
       pop();
       System.out.println(min());
       push(0);
       System.out.println(min());
       System.out.println(top());
    }

}

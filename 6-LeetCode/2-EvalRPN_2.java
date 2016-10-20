package leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author WuPing
 * @version 2016年10月20日 下午11:25:07
 */

public class EvalRPN_2 {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<tokens.length; i++) {
            if(tokens[i].equals("+")) {
                if(stack.size() >= 2) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int result = num2 + num1;
                    stack.add(result);
                }
            }else if(tokens[i].equals("-")) {
        	if(stack.size() >= 2) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int result = num2 - num1;
                    stack.add(result);
                }
            }else if(tokens[i].equals("*")) {
        	if(stack.size() >= 2) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int result = num2 * num1;
                    stack.add(result);
                }
            }else if(tokens[i].equals("/")) {
        	if(stack.size() >= 2) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int result = num2 / num1;
                    stack.add(result);
                }
            }else {
        	try {
        	    Integer num = Integer.parseInt(tokens[i]); 
        	    stack.add(num);
        	}catch(Exception e) {
        	    return 0;
        	}
            }
        }
        
        if(stack.size() == 1) {
            return stack.pop();
        }else {
            return 0;
        }
    }

    //老司机的写法
    public static int evalRPN1(String[] tokens) {
	Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i<tokens.length; i++){
            try{
                int num = Integer.parseInt(tokens[i]);
                stack.add(num);
            }catch (Exception e) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(get(a, b, tokens[i]));
            }
        }
        return stack.pop();
    }
    
    private static int get(int a, int b, String operator) {
	switch (operator) {
	case "+":
	    return a + b;
	case "-":
	    return a - b;
	case "*":
	    return a * b;
	case "/":
	    return a / b;
	default:
	    return 0;
	}
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    String[] tokens = str.split(",");
	    System.out.println(evalRPN(tokens));
	}
	cin.close();
    }

}

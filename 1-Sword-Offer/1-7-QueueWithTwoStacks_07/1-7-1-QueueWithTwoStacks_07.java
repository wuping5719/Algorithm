package swordOffer;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author WuPing
 * @version 2016年8月23日 下午2:28:38
 */

public class QueueWithTwoStacks_07 {

    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
	stack1.push(node);
    }

    public static int pop() {
	if (stack2.size() <= 0) {
	    while (stack1.size() > 0) {
		int data = stack1.peek();
		stack1.pop();
		stack2.push(data);
	    }
	}

	if (stack2.size() == 0) {
	    try {
		throw new Exception("queue is empty");
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}

	int head = stack2.peek();
	stack2.pop();

	return head;
    }

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	push(scanner.nextInt());
	push(scanner.nextInt());
	int val = pop();
	System.out.println(val);
	
	scanner.close();
    }

}

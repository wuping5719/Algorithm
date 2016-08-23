package swordOffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年8月23日 下午2:43:46
 */

public class StacksWithTwoQueue_07 {

    static Queue<Integer> queue1 = new LinkedList<Integer>();
    static Queue<Integer> queue2 = new LinkedList<Integer>();

    public static void push(int node) {
	queue1.offer(node);
    }

    public static int pop() {
	if(queue1.size() == 0 && queue2.size() == 0) {
	    try {
		throw new Exception("stacks is empty");
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	
	if (queue2.size() <= 0) {
	    while (queue1.size() > 1) {
		int data = queue1.peek();
		queue1.poll();
		queue2.offer(data);
	    }
	    int head = queue1.peek();
	    queue1.poll();

	    return head;
	} else {
	    while (queue2.size() > 1) {
		int data = queue2.peek();
		queue2.poll();
		queue1.offer(data);
	    }
	    int head = queue2.peek();
	    queue2.poll();

	    return head;
	}
    }

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	push(scanner.nextInt());
	push(scanner.nextInt());
	push(scanner.nextInt());
	int val = pop();
	System.out.println(val);
	
	scanner.close();
    }

}

package swordOffer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import swordOffer.ListNode;

/**
 * @author WuPing
 * @date 2016年8月22日 下午10:00:58
 * @version 1.0
 */

public class PrintListInReversedOrder_05 {

	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		Stack<ListNode> stack = new Stack<ListNode>();
		while (listNode != null) {
			stack.push(listNode);
			listNode = listNode.next;
		}
		ListNode temp;
		while (!stack.isEmpty()) {
			temp = stack.pop();
			arrList.add(temp.val);
		}
		return arrList;
	}

	public static void printListFromTailToHead_Recursively(ListNode listNode) {
		if(listNode != null) {
			printListFromTailToHead_Recursively(listNode.next);
			System.out.println("Recursively: "+ listNode.val);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			if(n>0){
				ListNode headNode = new ListNode(in.nextInt());
				for(int i=1; i<n; i++){
					headNode.next = new ListNode(in.nextInt());
				}
				ArrayList<Integer> tempList = new ArrayList<Integer>();
				tempList = printListFromTailToHead(headNode);
				System.out.println(tempList.get(0));
				
				printListFromTailToHead_Recursively(headNode);
			}
		}
		in.close();
	}

}

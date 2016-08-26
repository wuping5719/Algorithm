package swordOffer;

import java.util.Stack;

/** 
 * @author  WuPing
 * @date 2016年8月26日 下午7:06:59 
 * @version 1.0 
 */
public class FirstCommonNodesInLists_37 {
	// 方法一:先扫描两个链表长度，在长的的链表先走difLength步
	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		// 获得链表1的长度
		int length1 = 0;
		ListNode node1 = pHead1;
		while(node1 != null){
			length1++;
			node1 = node1.next;
		}
		
		// 获得链表2的长度
		int length2 = 0;
		ListNode node2 = pHead2;
		while (node2 != null) {
			length2++;
			node2 = node2.next;
		}
		
		int difLength = length1 - length2;
		ListNode listHeadLong = pHead1;
		ListNode listHeadShort = pHead2;
		if(length2 > length1){
			listHeadLong = pHead2;
			listHeadShort = pHead1;
			difLength = length2 - length1;
		}
		
		// 先在长链表上走几步,再同时在两个链表上遍历
		for(int i=0; i<difLength; i++){
			listHeadLong = listHeadLong.next;
		}
		
		while((listHeadLong != null) && (listHeadShort != null) && (listHeadLong != listHeadShort)){
			listHeadLong = listHeadLong.next;
			listHeadShort = listHeadShort.next;
		}
		
		// 得到第一个公共结点
		ListNode firstCommonNode = listHeadLong;
		
		return firstCommonNode;
    }
	
	// 方法二:利用两个辅助栈
	public static ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
		Stack<ListNode> stack1 = new Stack<ListNode>();
		ListNode node1 = pHead1;
		while(node1 != null){
			stack1.push(node1);
			node1 = node1.next;
		}
		
		Stack<ListNode> stack2 = new Stack<ListNode>();
		ListNode node2 = pHead2;
		while(node2 != null){
			stack2.push(node2);
			node2 = node2.next;
		}
		
		ListNode firstCommonNode = stack1.peek();
		while(!stack1.isEmpty() && !stack2.isEmpty()){
			ListNode stack1Node = stack1.peek();
			ListNode stack2Node = stack2.peek();
			
			if(stack1Node==stack2Node){
				firstCommonNode = stack1Node;
				stack1.pop();
				stack2.pop();
			}else{
				break;
			}
		}
		return firstCommonNode;
	}
	
	public static void main(String[] args) {
		ListNode list1Node1 = new ListNode(1);
		ListNode list1Node2 = new ListNode(2);
		ListNode list1Node3 = new ListNode(3);
		ListNode list2Node1 = new ListNode(4);
		ListNode list2Node2 = new ListNode(5);
		ListNode list12Node1 = new ListNode(6);
		ListNode list12Node2 = new ListNode(7);

		list1Node1.next = list1Node2;
		list1Node2.next = list1Node3;
		list1Node3.next = list12Node1;
		list2Node1.next = list2Node2;
		list2Node2.next = list12Node1;
		list12Node1.next = list12Node2;
		
		ListNode firstCommonNode = FindFirstCommonNode(list1Node1, list2Node1);
		//ListNode firstCommonNode = FindFirstCommonNode2(list1Node1, list2Node1);
		System.out.println(firstCommonNode.val);
	}
}

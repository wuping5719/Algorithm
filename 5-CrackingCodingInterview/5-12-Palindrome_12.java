package crackingCodingInterview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author WuPing
 * @version 2016年8月30日 下午2:19:36
 */

public class Palindrome_12 {

    // 方法一：一个队列和一个栈实现
    public static boolean isPalindrome1(ListNode pHead) {
       if(pHead == null) {
	   return false;
       }
       
       Queue<ListNode> queue = new LinkedList<ListNode>();
       Stack<ListNode> stack = new Stack<ListNode>();
       ListNode pNode = pHead;
       while(pNode !=null ){
	   queue.offer(pNode);
	   stack.push(pNode);
	   pNode = pNode.next;
       }

       while(!queue.isEmpty() && !stack.isEmpty()) {
	   int queueNodeVal = queue.peek().val;
	   int stackNodeVal = stack.peek().val;
	   if(queueNodeVal!=stackNodeVal) {
	       return false;
	   }
	   else {
	       queue.poll();
	       stack.pop();
	   }
       }
       return true;
    }
    
    // 方法一：快慢指针
    // 将链表的前半部分元素装入栈中, 当快速runner（移动的速度是慢速runner的两倍）
    // 到底链表尾部时, 则慢速runner已经处于链表中间位置. 注意链表长度奇偶判断.
    public static boolean isPalindrome2(ListNode pHead) {
	ListNode fast = pHead;
	ListNode slow = pHead;
	Stack<Integer> stack = new Stack<Integer>();

	while (fast != null && fast.next != null) {
	    stack.push(slow.val);
	    slow = slow.next;
	    fast = fast.next.next;
	}
	
	// 当链表为奇数个时, 跳过中间元素
	if (fast != null) {
	    slow = slow.next;
	}
	while (slow != null) {
	    // 如果两者不相同, 则该链表不是回文串
	    if (stack.pop() != slow.val) {
		return false;
	    }
	    slow = slow.next;
	}
	return true;
    }
    
    public static void main(String[] args) {
	ListNode list1Node1 = new ListNode(1);
	ListNode list1Node2 = new ListNode(2);
	ListNode list1Node3 = new ListNode(3);
	ListNode list1Node4 = new ListNode(2);
	ListNode list1Node5 = new ListNode(1);
	list1Node1.next = list1Node2;
	list1Node2.next = list1Node3;
	list1Node3.next = list1Node4;
	list1Node4.next = list1Node5;
	boolean isPalindrome1 = isPalindrome1(list1Node1);
	System.out.println(isPalindrome1);

	ListNode list2Node1 = new ListNode(1);
	ListNode list2Node2 = new ListNode(2);
	ListNode list2Node3 = new ListNode(3);
	ListNode list2Node4 = new ListNode(2);
	ListNode list2Node5 = new ListNode(3);
	list2Node1.next = list2Node2;
	list2Node2.next = list2Node3;
	list2Node3.next = list2Node4;
	list2Node4.next = list2Node5;
	boolean isPalindrome2 = isPalindrome1(list2Node1);
	System.out.println(isPalindrome2);
    }

}

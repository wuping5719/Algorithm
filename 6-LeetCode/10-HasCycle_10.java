package leetcode;

/**
 * @author WuPing
 * @version 2016年10月22日 下午2:58:42
 */

public class HasCycle_10 {

    //快慢指针相遇说明有环
    public static boolean hasCycle(ListNode head) {
	if (head == null) {
	    return false;
	}
	ListNode slow = head;
	ListNode fast = head;
	while (fast != null && fast.next != null) {
	    slow = slow.next;
	    fast = fast.next.next;
	    if (slow == fast) {
		return true;
	    }
	}
	return false;
    }

    public static void main(String[] args) {
	ListNode head = new ListNode(1);
	ListNode node2 = new ListNode(2);
	ListNode node3 = new ListNode(3);
	ListNode node4 = new ListNode(4);
	head.next = node2;
	node2.next = node3;
	node3.next = node4;
	node4.next = node2;
	
	boolean result = hasCycle(head);;
	System.out.println(result);
    }

}

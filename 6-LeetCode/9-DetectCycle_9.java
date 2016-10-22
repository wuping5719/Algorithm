package leetcode;

/**
 * @author WuPing
 * @version 2016年10月22日 下午2:41:46
 */

public class DetectCycle_9 {
    
    // 1)使用快慢指针方法，判定是否存在环，并记录两指针相遇位置；
    // 2)将两指针分别放在链表头和相遇位置，并改为相同速度推进，则两指针在环开始位置相遇。
    public static ListNode detectCycle(ListNode head) {
	if (head == null) {
	    return null;
	}
	ListNode slow = head;
	ListNode fast = head;
	while (fast != null && fast.next != null) {
	    slow = slow.next;
	    fast = fast.next.next;
	    if (slow == fast) {
		break;
	    }
	}
	if (fast == null || fast.next == null) {
	    return null;
	}
	slow = head;
	while (slow != fast) {
	    slow = slow.next;
	    fast = fast.next;
	}
	return slow;
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
	
	ListNode node = detectCycle(head);;
	System.out.print(node.val + " ");
    }

}

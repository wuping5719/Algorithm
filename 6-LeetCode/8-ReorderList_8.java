package leetcode;

/**
 * @author WuPing
 * @version 2016年10月21日 下午10:17:15
 */

public class ReorderList_8 {

    //快慢指针找到中间节点, 将后面的链表反转(前插法), 合并链表
    public static void reorderList(ListNode head) {
	if (head == null)
	    return;
	ListNode slow = head;
	ListNode fast = head;
	while (fast.next != null && fast.next.next != null) {
	    fast = fast.next.next;
	    slow = slow.next;
	}
	
	ListNode pre = slow.next;
	if (pre != null && pre.next != null) {
	    ListNode node = pre.next;
	    while (node != null) {
		pre.next = node.next;
		node.next = slow.next;
		slow.next = node;
		node = pre.next;
	    }
	}  
        merge(head,slow);
    }
    
    public static void merge(ListNode head, ListNode slow) {
	ListNode p = head;
	ListNode q = slow.next;
	while (q != null && p != null) {
	    slow.next = q.next;
	    q.next = p.next;
	    p.next = q;
	    q = slow.next;
	    p = p.next.next;
	}
    }
    
    public static void main(String[] args) {
	ListNode head = new ListNode(1);
	ListNode node2 = new ListNode(2);
	ListNode node3 = new ListNode(3);
	ListNode node4 = new ListNode(4);
	head.next = node2;
	node2.next = node3;
	node3.next = node4;
	
	reorderList(head);
	ListNode node = head;
	while(node != null) {
	    System.out.print(node.val + " ");
	    node = node.next;
	}
    }
}

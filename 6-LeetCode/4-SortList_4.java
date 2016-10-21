package leetcode;

/**
 * @author WuPing
 * @version 2016年10月21日 下午8:01:57
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int x) {
	val = x;
    }
}

public class SortList_4 {

    //单链表的归并排序
    public static ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;
        return merge(sortList(head), sortList(right));
    }
    
    private static ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                cur.next = head1;
                head1 = head1.next;
            }else{
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if(head1 != null){
            cur.next = head1;
        }else if(head2 != null){
            cur.next = head2;
        }
        return dummy.next;
    }
    
    private static ListNode findMid(ListNode head){
        if(head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 单链表的快速排序
    public static ListNode quickSortList(ListNode head){
        return quickSort(head, null);
    }
    
    private static ListNode quickSort(ListNode head, ListNode end){
        if(head != end){
            ListNode cur = partion(head, end);
            quickSort(head, cur);
            quickSort(cur.next, end);
        }
        return head;
    }
    
    private static ListNode partion(ListNode head, ListNode end){
        int key = head.val;
        ListNode p = head;
        ListNode q = head.next;
        while(q != end){
            if(q.val < key){
                p = p.next;
                swap(p, q);
            }
            q = q.next;
        }
        swap(head, p);
        return p;
    }
    
    private static void swap(ListNode p,ListNode q){
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
    
    public static void main(String[] args) {
	ListNode head = new ListNode(8);
	ListNode node2 = new ListNode(3);
	ListNode node3 = new ListNode(10);
	ListNode node4 = new ListNode(2);
	ListNode node5 = new ListNode(6);
	ListNode node6 = new ListNode(12);
	
	head.next = node2;
	node2.next = node3;
	node3.next = node4;
	node4.next = node5;
	node5.next = node6;
	
	ListNode tempNode = sortList(head);
	while(tempNode != null) {
	    System.out.print(tempNode.val + " ");
	    tempNode = tempNode.next;
	}
    }

}

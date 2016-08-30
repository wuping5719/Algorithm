package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年8月30日 上午10:04:19
 */

public class PartitionList_10 {

    public static ListNode partition(ListNode pHead, int x) {
	if (pHead == null || pHead.next == null) {
	    return pHead;
	}
	
	ListNode current = pHead;
	ListNode smallHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);
        ListNode samllTemp = smallHead;
        ListNode bigTemp = bigHead;
        while(current != null) {
            if(current.val < x) {
        	samllTemp.next = new ListNode(current.val);
        	samllTemp = samllTemp.next;
            }else {
        	bigTemp.next = new ListNode(current.val);
        	bigTemp = bigTemp.next;
            }
            current = current.next;
        }
        
        current = smallHead;
        while(current.next != null  && current.next.val != -1) {
            current = current.next;
        }
        current.next = bigHead.next;
        return smallHead.next;
    }
    
    public static void main(String[] args) {
	ListNode listNode1 = new ListNode(5);
	ListNode listNode2 = new ListNode(2);
	ListNode listNode3 = new ListNode(4);
	ListNode listNode4 = new ListNode(1);
	ListNode listNode5 = new ListNode(6);
	ListNode listNode6 = new ListNode(3);
	listNode1.next = listNode2;
	listNode2.next = listNode3;
	listNode3.next = listNode4;
	listNode4.next = listNode5;
	listNode5.next = listNode6;
	
	ListNode pHead = partition(listNode1, 4);
	ListNode pTemp = pHead;
	while(pTemp != null) {
	    System.out.print(pTemp.val + " ");
	    pTemp = pTemp.next;
	}
	
    }

}

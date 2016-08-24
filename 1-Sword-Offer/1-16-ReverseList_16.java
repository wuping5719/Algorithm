package swordOffer;

import swordOffer.ListNode;
/**
 * @author WuPing
 * @version 2016年8月24日 下午2:09:15
 */

public class ReverseList_16 {

    public static ListNode ReverseList(ListNode head) {
	ListNode pReversedHead = null;
	ListNode pNode = head;
	ListNode pPrev = null;
	while(pNode != null) {
	    ListNode pNext = pNode.next;
	    if(pNext == null) {
		pReversedHead = pNode;
	    }
	    pNode.next = pPrev;
	     
	    pPrev = pNode;
	    pNode = pNext;
	}
	return pReversedHead;
    }
    
    public static void main(String[] args) {
	ListNode listNode1 = new ListNode(1);
	ListNode listNode2 = new ListNode(2);
	ListNode listNode3 = new ListNode(3);
	ListNode listNode4 = new ListNode(4);
	ListNode listNode5 = new ListNode(5);
	ListNode listNode6 = new ListNode(6);
	listNode1.next = listNode2;
	listNode2.next = listNode3;
	listNode3.next = listNode4;
	listNode4.next = listNode5;
	listNode5.next = listNode6;

	ListNode pReversedHead = ReverseList(listNode1);
	if (pReversedHead != null) {
	    ListNode pNode = pReversedHead;
	    while (pNode != null) {
		System.out.print(pNode.val + " ");
		pNode = pNode.next;
	    }
	}
    }

}

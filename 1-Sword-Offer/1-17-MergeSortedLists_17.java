package swordOffer;

import swordOffer.ListNode;

/**
 * @author WuPing
 * @version 2016年8月24日 下午2:27:47
 */

public class MergeSortedLists_17 {
    
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        
        ListNode pMergedHead = null;
        if(list1.val < list2.val) {
            pMergedHead = list1;
            pMergedHead.next = Merge(list1.next, list2);
        }
        else {
            pMergedHead = list2;
            pMergedHead.next = Merge(list1, list2.next);
        }
        return pMergedHead;
    }
    
    public static void main(String[] args) {
	ListNode list1Node1 = new ListNode(1);
	ListNode list1Node2 = new ListNode(3);
	ListNode list1Node3 = new ListNode(5);
	ListNode list1Node4 = new ListNode(7);
	list1Node1.next = list1Node2;
	list1Node2.next = list1Node3;
	list1Node3.next = list1Node4;

	ListNode list2Node1 = new ListNode(2);
	ListNode list2Node2 = new ListNode(4);
	ListNode list2Node3 = new ListNode(6);
	ListNode list2Node4 = new ListNode(8);
	list2Node1.next = list2Node2;
	list2Node2.next = list2Node3;
	list2Node3.next = list2Node4;

	ListNode pMergedHead = Merge(list1Node1, list2Node1);
	if (pMergedHead != null) {
	    ListNode pNode = pMergedHead;
	    while (pNode != null) {
		System.out.print(pNode.val + " ");
		pNode = pNode.next;
	    }
	}
    }

}

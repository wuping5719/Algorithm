package swordOffer;

import swordOffer.ListNode;

/**
 * @author WuPing
 * @date 2016年8月23日 下午10:56:29
 * @version 1.0
 */
public class KthNodeFromEnd_15 {

	public static ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k == 0) {
			System.out.println("head is null");
			return null;
		}

		ListNode aHead = head;
		ListNode behind = null;
		for (int i = 0; i < k - 1; i++) {
			if(aHead.next != null) {
				aHead = aHead.next;
			} else {
				System.out.println("k > length");
				return null;
			}
		}

		behind = head;
		while (aHead.next != null) {
			aHead = aHead.next;
			behind = behind.next;
		}

		return behind;
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
		
		int k = 3;
		
		ListNode kNode = FindKthToTail(listNode1, k);
		if (kNode != null) {
			System.out.println(kNode.val);
		} else {
			System.out.println("kNode is null");
		}
	}

}

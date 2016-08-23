package swordOffer;

import swordOffer.ListNode;

/** 
 * @author  WuPing
 * @date 2016年8月23日 下午8:57:14 
 * @version 1.0 
 */
public class DeleteNodeInList_13 {

	public static void DeleteNode(ListNode pListHead, ListNode pToBeDeleted){
		if(pListHead==null || pToBeDeleted==null){
			return;
		}
		
		//链表只有一个结点, 删除头结点(也是尾结点)
		if(pListHead == pToBeDeleted){
			pListHead = null;
		}
		else{
			//要删除的结点不是尾结点
			if(pToBeDeleted.next != null){
				ListNode pNext = pToBeDeleted.next;
				pToBeDeleted.val = pNext.val;
				pToBeDeleted.next = pNext.next;
				pNext = null;
			}else{  //链表有多个结点, 删除尾结点
				ListNode pNode = pListHead;
				while(pNode.next != null){
					pNode = pNode.next;
				}
				pNode = null;
			}
		}
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
		
		ListNode pToBeDeleted = listNode2;
		DeleteNode(listNode1, pToBeDeleted);
		
		if(listNode1 !=null){
			ListNode pNode = listNode1;
			while(pNode != null){
				System.out.print(pNode.val +" ");
				pNode = pNode.next;
			}
		}
	}

}

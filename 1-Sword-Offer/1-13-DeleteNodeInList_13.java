package swordOffer;

import java.util.Scanner;

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
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			
			if(n>0){
				ListNode headNode = new ListNode(in.nextInt());
				for(int i=1; i<n; i++){
					headNode.next = new ListNode(in.nextInt());
				}
				
				ListNode pToBeDeleted = new ListNode(in.nextInt());
				DeleteNode(headNode, pToBeDeleted);
				
				if(headNode !=null){
					ListNode pNode = headNode;
					while(pNode.next != null){
						System.out.print(pNode.val +" ");
						pNode = pNode.next;
					}
				}
			}
		}
		in.close();
	}

}

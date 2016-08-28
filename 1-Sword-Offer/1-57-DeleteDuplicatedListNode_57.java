package swordOffer;
/** 
 * @author  WuPing
 * @date 2016年8月28日 下午3:14:24 
 * @version 1.0 
 */
public class DeleteDuplicatedListNode_57 {
	
	public static ListNode deleteDuplication(ListNode pHead) {
       if(pHead == null){
    	   return pHead;
       }
       
       ListNode pPreNode = null;
       ListNode pNode = pHead;
       while(pNode != null){
    	   ListNode pNext = pNode.next;
    	   boolean needDelete = false;
    	   if(pNext != null && pNext.val == pNode.val){
    		   needDelete = true;
    	   }
    	   
    	   if(!needDelete){
    		   pPreNode = pNode;
    		   pNode = pNode.next;
    	   }else{
    		   int value = pNode.val;
    		   ListNode pToBeDel = pNode;
    		   while(pToBeDel !=null && pToBeDel.val == value){
    			   pNext = pToBeDel.next;
    			   
    			   pToBeDel = null;
    			   pToBeDel = pNext;
    		   }
    		   
    		   if(pPreNode == null){
    			   pHead = pNext;
    		   }else{
    			   pPreNode.next = pNext;
    		   }
    		   pNode = pNext;
    	   }
       }
       return pHead;
	}
	 
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(3);
		ListNode listNode5 = new ListNode(4);
		ListNode listNode6 = new ListNode(4);
		ListNode listNode7 = new ListNode(5);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		listNode6.next = listNode7;
		
		ListNode headNode = deleteDuplication(listNode1);
		ListNode pNode = headNode;
		while(pNode != null){
			System.out.print(pNode.val + " ");
			pNode = pNode.next;
		}
	}

}

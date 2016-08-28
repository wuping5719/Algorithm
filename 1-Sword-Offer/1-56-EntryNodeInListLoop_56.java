package swordOffer;
/** 
 * @author  WuPing
 * @date 2016年8月28日 下午2:42:27 
 * @version 1.0 
 */
public class EntryNodeInListLoop_56 {

	public static ListNode MeetingNode(ListNode pHead){
		if(pHead == null){
			return null;
		}
		
		ListNode pSlow = pHead.next;
		if(pSlow == null){
			return null;
		}
		
		ListNode pFast = pSlow.next;
		while(pFast != null && pSlow != null){
			if(pFast == pSlow){
				return pFast;
			}
			
			pSlow = pSlow.next;
			
			pFast = pFast.next;
			if(pFast != null){
				pFast = pFast.next;
			}
		}
		return null;
	}
	
	public static ListNode EntryNodeOfLoop(ListNode pHead){
		if(pHead == null){
			return null;
		}
		
		ListNode meetingNode = MeetingNode(pHead);
		
        if(meetingNode == null){
        	return null;
        }
        
        // 得到环中结点数
        int nodesInLoop = 1;
        ListNode pNode1 = meetingNode;
        while(pNode1.next != meetingNode){
        	pNode1 = pNode1.next;
        	nodesInLoop++;
        }
        
        // 指针pNode1先移动nodesInLoop步
        pNode1 = pHead;
        for(int i=0; i<nodesInLoop; i++){
        	pNode1 = pNode1.next;
        }
        
        // 指针pNode1和pNode2同时移动
        ListNode pNode2 = pHead;
        while(pNode1 != pNode2){
        	pNode1 = pNode1.next;
        	pNode2 = pNode2.next;
        }
        
        return pNode1;
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
		listNode6.next = listNode3;
		
		ListNode entryNode = EntryNodeOfLoop(listNode1);
		if (entryNode != null) {
			System.out.println(entryNode.val);
		} else {
			System.out.println("entryNode is null");
		}
	}

}

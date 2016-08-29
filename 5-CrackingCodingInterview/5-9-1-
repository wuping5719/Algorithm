package crackingCodingInterview;

/** 
 * @author  WuPing
 * @date 2016年8月29日 下午11:01:02 
 * @version 1.0 
 */
public class RemoveNode_9 {

	/*public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}*/
	
    public static boolean removeNode(ListNode pNode) {
    	if(pNode==null){
    		return false;
    	}
    	if(pNode.next == null){
    		return false;
    	}else{
    		//移除节点
            pNode.val = pNode.next.val; //将下一个节点的值移动到当前节点
            pNode.next = pNode.next.next; //然后指向下下个节点  
            
            return true;
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
		
		boolean result = removeNode(listNode6);
		System.out.println(result);
	}

}

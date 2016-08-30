package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年8月30日 上午11:01:08
 */

public class PlusList_11 {

    public static ListNode plusAB(ListNode a, ListNode b) {
	if(a==null && b!=null) {
	    return b;
	}
	if(a!=null && b==null) {
	    return a;
	}
	if(a==null && b==null) {
	    return a;
	}
	
	ListNode head = new ListNode(-1);
	ListNode temp = head;
	ListNode tempA = a;
	ListNode tempB = b;
	int add = 0;
	while(tempA != null || tempB !=null) {
	    if(tempA != null && tempB !=null) {
		temp.next = new ListNode((tempA.val+tempB.val+add)%10);
		temp = temp.next;
		
		add = (tempA.val+tempB.val+add)/10;
		tempA = tempA.next;
		tempB = tempB.next;
	    }
	    else if(tempA != null) {
		temp.next = new ListNode((tempA.val+add)%10);
		temp = temp.next;
		
		add = (tempA.val+add)/10;
		tempA = tempA.next;
	    }else {
		temp.next = new ListNode((tempB.val+add)%10);
		temp = temp.next;
		
		add = (tempB.val+add)/10;
		tempB = tempB.next;
	    }
	}
	if(add>0) {
	    temp.next = new ListNode(add);
            temp = temp.next;
	}
	return head.next;
    }
    
    public static void main(String[] args) {
	ListNode list1Node1 = new ListNode(1);
	ListNode list1Node2 = new ListNode(2);
	ListNode list1Node3 = new ListNode(3);
	ListNode list2Node1 = new ListNode(3);
	ListNode list2Node2 = new ListNode(2);
	ListNode list2Node3 = new ListNode(1);
	
	list1Node1.next = list1Node2;
	list1Node2.next = list1Node3;
	
	list2Node1.next = list2Node2;
	list2Node2.next = list2Node3;
	
	ListNode pHead = plusAB(list1Node1, list2Node1);
	ListNode pTemp = pHead;
	while(pTemp != null) {
	    System.out.print(pTemp.val + " ");
	    pTemp = pTemp.next;
	}
    }

}

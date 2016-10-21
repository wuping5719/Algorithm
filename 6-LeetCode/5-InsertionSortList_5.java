package leetcode;

/**
 * @author WuPing
 * @version 2016年10月21日 下午8:47:43
 */

public class InsertionSortList_5 {

    //思路: 新建一个链表, 遍历原链表, 将每个节点加入新链表正确的位置
    public static ListNode insertionSortList(ListNode head) {
	//哑节点
        ListNode dumy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        ListNode pre = dumy;
        while (cur != null) {
            //保存当前节点下一个节点
            ListNode next = cur.next;
            pre = dumy;
            //寻找当前节点正确位置的一个节点
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            //将当前节点加入新链表中
            cur.next = pre.next;
            pre.next = cur;
            //处理下一个节点
            cur = next;
        }
        return dumy.next;
    }

    public static void main(String[] args) {
	ListNode head = new ListNode(8);
	ListNode node2 = new ListNode(3);
	ListNode node3 = new ListNode(10);
	ListNode node4 = new ListNode(2);
	ListNode node5 = new ListNode(6);
	ListNode node6 = new ListNode(12);
	
	head.next = node2;
	node2.next = node3;
	node3.next = node4;
	node4.next = node5;
	node5.next = node6;
	
	ListNode tempNode = insertionSortList(head);
	while(tempNode != null) {
	    System.out.print(tempNode.val + " ");
	    tempNode = tempNode.next;
	}
    }

}

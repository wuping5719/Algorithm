package leetcode;

/**
 * @author WuPing
 * @version 2016年10月22日 下午3:23:38
 */

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
	this.label = x;
    }
}
    
public class CopyRandomList_12 {

    //剑指Offer原题：每个节点后都插入一个前面节点的拷贝，全部插入后再遍历，改变拷贝的next与random，形成新链表.
    public static RandomListNode copyRandomList(RandomListNode head) {
	if (head == null || (head.next == null && head.random == null)) {
	    return head;
	}
	
	RandomListNode node = head;
	while (node != null) { // 插入一个前面节点的拷贝
	    // 拷贝一个前面节点
	    RandomListNode copyNode = new RandomListNode(node.label);
	    copyNode.next = node.next;
	    copyNode.random = node.random;
	    // 调整前面节点的指针
	    node.next = copyNode;

	    node = node.next.next;
	}
	
	//将新链表拆成两个链表
	node = head.next;
	while (node != null) {
	    if (node.next != null) {
		node.next = node.next.next;
	    }
	    if (node.random != null) {
		node.random = node.random.next;
	    }
	    node = node.next;
	}

	return head.next;
    }

    public static void main(String[] args) {
	RandomListNode head = new RandomListNode(1);
	RandomListNode node2 = new RandomListNode(2);
	RandomListNode node3 = new RandomListNode(3);
	RandomListNode node4 = new RandomListNode(4);
	head.next = node2;
	head.random = node3;
	node2.next = node3;
	node2.random = node4;
	node3.next = node4;
	node3.random = head;
	node4.random = node2;
		
	RandomListNode node = copyRandomList(head);
	while(node != null) {
	    System.out.print(node.label + " ");
	    node = node.next;
	}
    }

}

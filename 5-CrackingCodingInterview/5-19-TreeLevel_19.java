package crackingCodingInterview;

import java.util.LinkedList;
import java.util.Queue;

/** 
 * @author  WuPing
 * @date 2016年8月30日 下午9:23:10 
 * @version 1.0 
 */
public class TreeLevel_19 {

	// 方法一: 基于递归
	private static ListNode head = new ListNode(-1);
	private static ListNode temp = head; 
	public static ListNode getTreeLevel1(TreeNode root, int dep) {
        if(root==null || dep<=0){
        	return null;
        }
        
        if(dep==1){
        	temp.next = new ListNode(root.val);
        	temp = temp.next;
		} else {
			getTreeLevel1(root.left, dep-1);
			getTreeLevel1(root.right, dep-1);
		}
        return head.next;
    }
	
	// 方法二: 使用队列, 用两个整数变量current, next来记录相邻两层的元素个数,
	// 其中current代表出栈那一层留下的元素个数, next代表下一层进栈元素的个数, 
	// 每当current为0的时候, 说明上一层已经全部出栈, 下一层已经全部入栈, 那么层次遍历层数就加一,
	// 这个时候将next的值复制给current, next=0, 当遍历到第dep层的时候, 便把那一层的所有元素输出, 停止遍历。
	public static ListNode getTreeLevel2(TreeNode root, int dep) {
        if(root==null || dep<=0){
        	return null;
        }
        
        ListNode head2 = new ListNode(-1);
    	ListNode temp2 = head2; 
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	int current = 1;
    	int next = 0;
    	int currentLevel = 1;
    	while(!queue.isEmpty()){
    		if(currentLevel==dep){
    			for(int i=0; i<current; i++){
    				TreeNode treeNode = queue.poll();
        			temp2.next = new ListNode(treeNode.val);
        			temp2 = temp2.next;
    			}
    			return head2.next;
    		}
    		
    		TreeNode tempTreeNode = queue.poll();
            if(tempTreeNode.left != null)
            {
            	queue.offer(tempTreeNode.left);
            	next++;
            }
            if(tempTreeNode.right != null)
            {
            	queue.offer(tempTreeNode.right);
            	next++;
            }
            
            if(--current==0)
            {
            	current = next;
            	next = 0;
            	currentLevel++;
            }
    	}
    	return head2.next;
	}
	
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode6 = new TreeNode(6);
		TreeNode treeNode7 = new TreeNode(7);
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode2.left = treeNode4;
		treeNode3.right = treeNode5;
		treeNode4.left = treeNode6;
		treeNode4.right = treeNode7;
		
		ListNode head = getTreeLevel2(treeNode1, 2);
		ListNode pNode = head;
		while(pNode != null){
			System.out.print(pNode.val + " ");
			pNode = pNode.next;
		}
		
	}

}

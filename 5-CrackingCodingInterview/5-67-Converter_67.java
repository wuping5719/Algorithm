package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年10月15日 下午4:09:35
 */

public class Converter_67 {

    //中序遍历， 递归
    private static ListNode head = new ListNode(-1);
    private static ListNode tempNode = head;
    
    public static ListNode treeToList(TreeNode root) {
	if(root != null)
        {
            treeToList(root.left);
            tempNode.next = new ListNode(root.val);
            tempNode = tempNode.next;
            treeToList(root.right);
        }
        return head.next;
    }
    
    public static void main(String[] args) {
	TreeNode root = new TreeNode(1);
	TreeNode treeNode2 = new TreeNode(2);
	TreeNode treeNode3 = new TreeNode(3);
	TreeNode treeNode4 = new TreeNode(4);
	TreeNode treeNode5 = new TreeNode(5);
	TreeNode treeNode6 = new TreeNode(6);
	root.left = treeNode2;
	root.right = treeNode3;
	treeNode2.left = treeNode4;
	treeNode2.right = treeNode5;
	treeNode3.left = treeNode6;
	
	head = treeToList(root);
	ListNode node = head;
	while(node != null) {
	    System.out.print(node.val + " ");
	    node = node.next;
	}
    }

}

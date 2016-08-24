package swordOffer;

import java.util.Stack;

import swordOffer.TreeNode;
/**
 * @author WuPing
 * @version 2016年8月24日 下午3:24:27
 */

public class MirrorOfBinaryTree_19 {

    public static void Mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            return;
        }
        
        TreeNode pTemp = root.left;
        root.left = root.right;
        root.right = pTemp;
        
        if(root.left != null) {
            Mirror(root.left);
        }
        if(root.right != null) {
            Mirror(root.right);
        }
    }

    public static void MirrorIteratively(TreeNode root) {
	if(root == null) {
            return;
        }
	
	Stack<TreeNode> stack = new Stack<TreeNode>();
	stack.push(root);
	while(stack.size() > 0) {
	    TreeNode pNode = stack.peek();
	    stack.pop();
	    
	    TreeNode pTemp = pNode.left;
	    pNode.left = pNode.right;
	    pNode.right = pTemp;
	    
	    if (pNode.left != null) {
		stack.push(pNode.left);
	    }
	    if (pNode.right != null) {
		stack.push(pNode.right);
	    }
	}
    }
    
    //中序打印树结点
    public static void printTree(TreeNode root) {
        if(root != null) {
            printTree(root.left);
            System.out.print(root.val+ " ");
    	    printTree(root.right);
        }
    }
    
    public static void main(String[] args) {
	TreeNode treeNode1 = new TreeNode(8);
	TreeNode treeNode2 = new TreeNode(6);
	TreeNode treeNode3 = new TreeNode(10);
	TreeNode treeNode4 = new TreeNode(5);
	TreeNode treeNode5 = new TreeNode(7);
	TreeNode treeNode6 = new TreeNode(9);
	TreeNode treeNode7 = new TreeNode(11);

	treeNode1.left = treeNode2;
	treeNode1.right = treeNode3;
	treeNode2.left = treeNode4;
	treeNode2.right = treeNode5;
	treeNode3.left = treeNode6;
	treeNode3.right = treeNode7;
	
	Mirror(treeNode1);
	//MirrorIteratively(treeNode1);
	
	printTree(treeNode1);
    }
}

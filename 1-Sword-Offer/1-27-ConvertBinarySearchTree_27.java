package swordOffer;

import swordOffer.TreeNode;

import java.util.Stack;

/**
 * @author WuPing
 * @version 2016年8月25日 上午9:53:04
 */

public class ConvertBinarySearchTree_27 {

    // 递归版
    // 记录子树链表的最后一个节点，终结点只可能为只含左子树的非叶节点与叶节点
    private static TreeNode pHeadOfList = null;
    
    public static TreeNode Convert(TreeNode pRootOfTree) {
	if(pRootOfTree == null)
            return null;
        if(pRootOfTree.left == null && pRootOfTree.right == null){
            pHeadOfList = pRootOfTree; // 最后的一个节点可能为最右侧的叶节点
            return pRootOfTree;
        }
        
        // 将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(pRootOfTree.left);
        // 如果左子树链表不为空的话，将当前pRootOfTree追加到左子树链表
        if(left!=null){
            pHeadOfList.right = pRootOfTree;
            pRootOfTree.left = pHeadOfList;
        }
        pHeadOfList = pRootOfTree;// 当根节点只含左子树时，则该根节点为最后一个节点
        
        // 将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(pRootOfTree.right);
        // 如果右子树链表不为空的话，将该链表追加到pRootOfTree节点之后
        if(right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null ? left : pRootOfTree;   
    }

    // 非递归版
    public static TreeNode ConvertByStack(TreeNode root) {
	if (root == null)
	    return null;

	Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode pNode = root;
	TreeNode preNode = null; // 用于保存中序遍历序列的上一节点
	boolean isFirst = true;
	while (pNode != null || !stack.isEmpty()) {
	    while (pNode != null) {
		stack.push(pNode);
		pNode = pNode.left;
	    }
	    pNode = stack.pop();
	    if (isFirst) {
		root = pNode; // 将中序遍历序列中的第一个节点记为root
		preNode = root;
		isFirst = false;
	    } else {
		preNode.right = pNode;
		pNode.left = preNode;
		preNode = pNode;
	    }
	    pNode = pNode.right;
	}
	return root;
    }
    
    public static void main(String[] args) {
	TreeNode treeNode1 = new TreeNode(10);
	TreeNode treeNode2 = new TreeNode(6);
	TreeNode treeNode3 = new TreeNode(14);
	TreeNode treeNode4 = new TreeNode(4);
	TreeNode treeNode5 = new TreeNode(8);
	TreeNode treeNode6 = new TreeNode(12);
	TreeNode treeNode7 = new TreeNode(16);

	treeNode1.left = treeNode2;
	treeNode1.right = treeNode3;
	treeNode2.left = treeNode4;
	treeNode2.right = treeNode5;
	treeNode3.left = treeNode6;
	treeNode3.right = treeNode7;

	pHeadOfList = Convert(treeNode1);
	//pHeadOfList = ConvertByStack(treeNode1);
	TreeNode pNodeByRight = pHeadOfList;
	while (pNodeByRight != null) {
	    System.out.print(pNodeByRight.val + " ");
	    pNodeByRight = pNodeByRight.right;
	}
	System.out.println();
	
    }

}

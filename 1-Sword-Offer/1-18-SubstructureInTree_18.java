package swordOffer;

import swordOffer.TreeNode;

/**
 * @author WuPing
 * @version 2016年8月24日 下午2:42:28
 */

public class SubstructureInTree_18 {

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
	boolean result = false;
	if (root1 != null && root2 != null) {
	    if (root1.val == root2.val) {
		result = DoesTree1HaveTree2(root1, root2);
	    }
	    if (!result) {
		result = HasSubtree(root1.left, root2);
	    }
	    if (!result) {
		result = HasSubtree(root1.right, root2);
	    }
	}
	return result;
    }

    public static boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
	if (root2 == null) {
	    return true; // 约定空树不是任意树的子结构
	}
	if (root1 == null) {
	    return false;
	}

	if (root1.val != root2.val) {
	    return false;
	}

	return DoesTree1HaveTree2(root1.left, root2.left)
		&& DoesTree1HaveTree2(root1.right, root2.right);
    }

    public static void main(String[] args) {
	// 初始化树1
	TreeNode tree1Node1 = new TreeNode(8);
	TreeNode tree1Node2 = new TreeNode(8);
	TreeNode tree1Node3 = new TreeNode(7);
	TreeNode tree1Node4 = new TreeNode(9);
	TreeNode tree1Node5 = new TreeNode(2);
	TreeNode tree1Node6 = new TreeNode(4);
	TreeNode tree1Node7 = new TreeNode(7);

	tree1Node1.left = tree1Node2;
	tree1Node1.right = tree1Node3;
	tree1Node2.left = tree1Node4;
	tree1Node2.right = tree1Node5;
	tree1Node5.left = tree1Node6;
	tree1Node5.right = tree1Node7;

	// 初始化树2
	TreeNode tree2Node1 = new TreeNode(8);
	TreeNode tree2Node2 = new TreeNode(9);
	TreeNode tree2Node3 = new TreeNode(2);

	tree2Node1.left = tree2Node2;
	tree2Node1.right = tree2Node3;

	boolean result = HasSubtree(tree1Node1, tree2Node1);
	System.out.println(result);
    }

}

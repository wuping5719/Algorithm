package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author WuPing
 * @version 2016年10月21日 下午9:40:35
 */

public class PostOrderTraversal_6 {

    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
	ArrayList<Integer> list = new ArrayList<Integer>();
	postOrderCore(root, list);
	return list;
    }
    //递归遍历
    public static void postOrderCore(TreeNode root, ArrayList<Integer> list){
        if(root != null){
            postOrderCore(root.left, list);
            postOrderCore(root.right, list);
            list.add(root.val);
        }
    }
    
    //基于栈的非递归方法
    public static ArrayList<Integer> postOrderTraversal2(TreeNode root) {
	ArrayList<Integer> list = new ArrayList<Integer>();
	if (root == null) {
	    return list;
	}

	Stack<TreeNode> stack = new Stack<TreeNode>();
	Stack<TreeNode> stack2 = new Stack<TreeNode>();
	stack.add(root);
	while (!stack.isEmpty()) {
	    TreeNode node = stack.pop();
	    if (node.left != null) {
		stack.add(node.left);
	    }
	    if (node.right != null) {
		stack.add(node.right);
	    }
	    stack2.add(node);
	}
	while (!stack2.isEmpty()) {
	    list.add(stack2.pop().val);
	}
	return list;
    }
    
    public static void main(String[] args) {
	TreeNode root = new TreeNode(1);
	TreeNode node2 = new TreeNode(2);
	TreeNode node3 = new TreeNode(3);
	root.right = node2;
	node2.left = node3;
	
	ArrayList<Integer> list = postorderTraversal(root);
	for(Integer i: list) {
	    System.out.print(i + " ");
	}
    }

}

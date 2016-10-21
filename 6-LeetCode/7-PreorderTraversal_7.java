package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author WuPing
 * @version 2016年10月21日 下午10:01:33
 */

public class PreorderTraversal_7 {

    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
	ArrayList<Integer> list = new ArrayList<Integer>();
	preOrderCore(root, list);
	return list;
    }
    //递归遍历
    public static void preOrderCore(TreeNode root, ArrayList<Integer> list){
        if(root != null){
            list.add(root.val);
            preOrderCore(root.left, list);
            preOrderCore(root.right, list);
        }
    }
    
    //借助栈的非递归版
    public static ArrayList<Integer> preOrderTraversal2(TreeNode root){
	ArrayList<Integer> list = new ArrayList<>();
	if (root == null) {
            return list; 
        }
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null) {
        	stack.add(node.right);
            }   
            if(node.left != null) {
        	stack.add(node.left);
            }
        }
        return list;
    }

    public static void main(String[] args) {
	TreeNode root = new TreeNode(1);
	TreeNode node2 = new TreeNode(2);
	TreeNode node3 = new TreeNode(3);
	root.right = node2;
	node2.left = node3;
	
	//ArrayList<Integer> list = preorderTraversal(root);
	ArrayList<Integer> list = preOrderTraversal2(root);
	for(Integer i: list) {
	    System.out.print(i + " ");
	}
    }

}

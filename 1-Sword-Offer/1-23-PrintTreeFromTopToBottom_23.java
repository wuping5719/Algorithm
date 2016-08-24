package swordOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/** 
 * @author  WuPing
 * @date 2016年8月24日 下午8:08:06 
 * @version 1.0 
 */
public class PrintTreeFromTopToBottom_23 {
	 
	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(root != null){
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			
			while(!queue.isEmpty()){
				TreeNode pNode = queue.peek();
				queue.poll();
				list.add(pNode.val);
				
				if(pNode.left != null){
					queue.offer(pNode.left);
				}
				
				if(pNode.right != null){
					queue.offer(pNode.right);
				}
			}
		}
	    return list;
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
		
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		tempList = PrintFromTopToBottom(treeNode1);
		for(int i=0; i<tempList.size(); i++){
			System.out.print(tempList.get(i) + " ");
		}
	}

}

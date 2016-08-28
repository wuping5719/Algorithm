package swordOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/** 
 * @author  WuPing
 * @date 2016年8月28日 下午4:19:14 
 * @version 1.0 
 */
public class PrintTreesInLines_60 {

	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(pRoot == null){
			return result;
		}
		
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		nodes.offer(pRoot);
		int nextLevel = 0;
		int toBePrinted = 1;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		while(!nodes.isEmpty()){
			TreeNode pNode = nodes.peek();
			temp.add(pNode.val);
			
			if(pNode.left != null){
				nodes.offer(pNode.left);
				nextLevel++;
			}
			if(pNode.right != null){
				nodes.offer(pNode.right);
				nextLevel++;
			}
			nodes.poll();
			toBePrinted--;
			if(toBePrinted == 0){
				result.add(temp);
				toBePrinted = nextLevel;
				nextLevel = 0;
				temp = new ArrayList<Integer>();
			}
		}
		
		return result;
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
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result = Print(treeNode1);
		for(int i=0; i<result.size(); i++){
			for(int j=0; j<result.get(i).size(); j++){
				if(j != result.get(i).size()-1){
					System.out.print(result.get(i).get(j) + " ");
				}else{
					System.out.print(result.get(i).get(j));
				}
			}
			System.out.println();
		}
		
	}

}

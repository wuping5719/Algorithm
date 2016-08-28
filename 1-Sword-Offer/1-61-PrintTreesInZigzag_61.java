package swordOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/** 
 * @author  WuPing
 * @date 2016年8月28日 下午6:17:28 
 * @version 1.0 
 */
public class PrintTreesInZigzag_61 {

	// 方法一:用两个栈实现
	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(pRoot == null){
			return result;
		}

		@SuppressWarnings("unchecked")
		Stack<TreeNode> levels[] = new Stack[2];
		levels[0] = new Stack<TreeNode>();
		levels[1] = new Stack<TreeNode>();
		
		int current = 0;
		int next = 1;
		levels[current].push(pRoot);
		ArrayList<Integer> temp = new ArrayList<Integer>();
	    while(!levels[0].isEmpty() || !levels[1].isEmpty()){
	    	TreeNode pNode = levels[current].peek();
	    	levels[current].pop();
	    	
	    	temp.add(pNode.val);
	    	
	    	if(current==0){
	    		if(pNode.left != null){
	    			levels[next].push(pNode.left);
	    		}
	    		if(pNode.right != null){
	    			levels[next].push(pNode.right);
	    		}
	    	}
	    	else {
	    	    if(pNode.right != null){
	    	    	levels[next].push(pNode.right);
	    		}
	    	    if(pNode.left != null){
	    	    	levels[next].push(pNode.left);
	    		}
	    	}
	    	
	    	if(levels[current].isEmpty()){
	    		result.add(temp);
	    		current = 1 - current;
	    		next = 1 - next;
	    		temp = new ArrayList<Integer>();
	    	}
	    }
	    
	    return result;
	}
	
	// 方法二:用一个栈和一个队列实现
	public static ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Queue<TreeNode> queueTotal = new LinkedList<TreeNode>();

		queue.offer(pRoot);
		queueTotal.offer(pRoot);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		while (!queue.isEmpty() || !stack.isEmpty()) {
			TreeNode pNode = null;
			TreeNode queueTotalNode = null;

			while (!queue.isEmpty()) {
				queueTotalNode = queueTotal.peek();
				pNode = queue.peek();
				queue.poll();
				queueTotal.poll();
				temp.add(pNode.val);

				if (queueTotalNode.left != null) {
					stack.push(queueTotalNode.left);
					queueTotal.offer(queueTotalNode.left);
				}
				if (queueTotalNode.right != null) {
					stack.push(queueTotalNode.right);
					queueTotal.offer(queueTotalNode.right);
				}
			}

			result.add(temp);
			temp = new ArrayList<Integer>();

			while (!stack.isEmpty()) {
				queueTotalNode = queueTotal.peek();
				pNode = stack.peek();
				stack.pop();
				queueTotal.poll();
				temp.add(pNode.val);

				if (queueTotalNode.left != null) {
					queue.offer(queueTotalNode.left);
					queueTotal.offer(queueTotalNode.left);
				}
				if (queueTotalNode.right != null) {
					queue.offer(queueTotalNode.right);
					queueTotal.offer(queueTotalNode.right);
				}
			}

			result.add(temp);
			temp = new ArrayList<Integer>();
		}

		return result;
	}
	
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode6 = new TreeNode(6);
		TreeNode treeNode7 = new TreeNode(7);
		TreeNode treeNode8 = new TreeNode(8);
		TreeNode treeNode9 = new TreeNode(9);
		TreeNode treeNode10 = new TreeNode(10);
		TreeNode treeNode11 = new TreeNode(11);
		TreeNode treeNode12 = new TreeNode(12);
		TreeNode treeNode13 = new TreeNode(13);
		TreeNode treeNode14 = new TreeNode(14);
		TreeNode treeNode15 = new TreeNode(15);
		
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		
		treeNode2.left = treeNode4;
		treeNode2.right = treeNode5;
		
		treeNode3.left = treeNode6;
		treeNode3.right = treeNode7;
		
		treeNode4.left = treeNode8;
		treeNode4.right = treeNode9;
		
		treeNode5.left = treeNode10;
		treeNode5.right = treeNode11;
		
		treeNode6.left = treeNode12;
		treeNode6.right = treeNode13;
		
		treeNode7.left = treeNode14;
		treeNode7.right = treeNode15;
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result = Print(treeNode1);
		//result = Print2(treeNode1);
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

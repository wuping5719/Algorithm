package crackingCodingInterview;

import java.util.LinkedList;
import java.util.Queue;

/** 
 * @author  WuPing
 * @date 2016年8月30日 下午10:40:16 
 * @version 1.0 
 */
public class CheckBST_20 {

	// 方法一：递归处理
	public static boolean checkBST1(TreeNode root) {
		return checkBSTCore(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	public static boolean checkBSTCore(TreeNode root, int min , int max) {
		if(root==null)
            return true;
        if(root.val<min || root.val>max)
            return false;
        return checkBSTCore(root.left, min, root.val) && 
        		checkBSTCore(root.right, root.val, max);
	}
	
	private static Queue<Integer> queue = new LinkedList<Integer>();
	// 方法二：中序遍历是否为有序序列
	public static boolean checkBST2(TreeNode root) {
		if(root==null)
            return true;
		
		InTreeBST(root);
		
		if(queue.size()==1){
			return true;
		}
		int[] num = new int[queue.size()];
		int index = 0;
		while(!queue.isEmpty()){
			num[index] = queue.poll();
			index++;
		}
		
		for(int i=0; i<num.length; i++){
			for(int j=i+1; j<num.length; j++){
				if(num[i] > num[j]){
					return false;
				}
			}
		}
			
		return true;
    }
	public static void InTreeBST(TreeNode root) {
		if(root.left != null){
			InTreeBST(root.left);
		}
		
		if(root != null){
			queue.offer(root.val);
		}
		
		if(root.right != null){
			InTreeBST(root.right);
		}
	}
	
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(8);
		TreeNode treeNode2 = new TreeNode(5);
		TreeNode treeNode3 = new TreeNode(10);
		TreeNode treeNode4 = new TreeNode(2);
		TreeNode treeNode5 = new TreeNode(6);
		TreeNode treeNode6 = new TreeNode(9);
		TreeNode treeNode7 = new TreeNode(12);
		
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		
		treeNode2.left = treeNode4;
		treeNode2.right = treeNode5;
		
		treeNode3.left = treeNode6;
		treeNode3.right = treeNode7;
		
		boolean result = checkBST2(treeNode1);
		System.out.println(result);
	}

}

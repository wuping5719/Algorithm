package swordOffer;

/** 
 * @author  WuPing
 * @date 2016年8月26日 下午8:56:55 
 * @version 1.0 
 */
public class TreeDepth_39_1 {
	
	public static int TreeDepth(TreeNode pRoot)
    {
       if(pRoot == null)
    	   return 0;
       
       int left_n = TreeDepth(pRoot.left);
       int right_n = TreeDepth(pRoot.right);
       
       return (left_n > right_n) ? (left_n + 1) : (right_n + 1);
    }
	
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode6 = new TreeNode(6);
		TreeNode treeNode7 = new TreeNode(7);

		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode2.left = treeNode4;
		treeNode2.right = treeNode5;
		treeNode3.right = treeNode6;
		treeNode5.left = treeNode7;
		
		int result = TreeDepth(treeNode1);
		System.out.println(result);
	}

}

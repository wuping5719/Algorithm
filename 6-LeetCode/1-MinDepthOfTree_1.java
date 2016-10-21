package leetcode;

/**
 * @author WuPing
 * @version 2016年10月20日 下午10:50:01
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { 
       val = x; 
    }
}

public class MinDepthOfTree_1 {

    public static int run(TreeNode root) {
	if(root == null) {
	    return 0;
	}   
	// 只有根结点的情况
        if(root.left == null && root.right == null) { 
            return 1;
        }  
        // 只有右子树的情况
        if(root.left == null) {
            return run(root.right) + 1;
        }
        // 只有左子树的情况
        if(root.right == null) {
            return run(root.left) + 1;
        }  
        // 双子树的情况
        return Math.min(run(root.left), run(root.right)) + 1;
    }
    
    public static void main(String[] args) {
	TreeNode root = new TreeNode(1);
	TreeNode treeNode2 = new TreeNode(2);
	TreeNode treeNode3 = new TreeNode(3);
	TreeNode treeNode4 = new TreeNode(4);
	TreeNode treeNode5 = new TreeNode(5);
	TreeNode treeNode6 = new TreeNode(6);
	TreeNode treeNode7 = new TreeNode(7);
	TreeNode treeNode8 = new TreeNode(8);
	
	root.left = treeNode2;
	root.right = treeNode3;
	treeNode2.left = treeNode4;
	treeNode2.right = treeNode5;
	treeNode3.right = treeNode6;
	treeNode6.left = treeNode7;
	treeNode7.right = treeNode8;
	
	System.out.println(run(root));
    }
	
}

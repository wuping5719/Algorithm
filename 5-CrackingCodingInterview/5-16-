package crackingCodingInterview;

/**
 * @author WuPing
 * @date 2016年8月30日 下午6:33:09
 * @version 1.0
 */
public class BinaryTreeIsBalance_16 {
	
	public static boolean isBalance(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isBalanceCore(root);
	}

	public static boolean isBalanceCore(TreeNode root) {
		if (root == null) {
			return true;
		}

		int leftDepth = getDepthOfTree(root.left);
		int rightDepth = getDepthOfTree(root.right);
		int sub = leftDepth - rightDepth;
		if (sub <= 1 && sub >= -1) {
			return isBalanceCore(root.left) && isBalanceCore(root.right);
		} else {
			return false;
		}

	}

	public static int getDepthOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftDepth = getDepthOfTree(root.left);
		int rightDepth = getDepthOfTree(root.right);

		return leftDepth >= rightDepth ? (leftDepth + 1) : (rightDepth + 1);
	}

	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode2.left = treeNode4;
		treeNode3.right = treeNode5;
		
		boolean result = isBalance(treeNode1);
		System.out.println(result);
	}

}

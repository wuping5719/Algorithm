package leetcode;

/**
 * @author WuPing
 * @version 2016年11月23日 下午10:30:51
 */

public class SumRootToLeafNums_20 {

    public static int sumNumbers(TreeNode root) {
        int sum = 0;
        if(root == null) {
           return sum;
        }
        return sumNumbersCore(root, sum);
    }
    
    //先序遍历的思想(根左右)+数字求和(每一层都比上层和*10+当前根节点的值)
    public static int sumNumbersCore(TreeNode root, int sum) {
	if(root == null) {
	    return 0;
	}
	sum = sum * 10 + root.val;
	if (root.left == null && root.right == null) {
	    return sum;
	}
	
	return sumNumbersCore(root.left, sum) + sumNumbersCore(root.right, sum);
    }
    
    public static void main(String[] args) {
	TreeNode root = new TreeNode(1);
	TreeNode treeNode2 = new TreeNode(2);
	TreeNode treeNode3 = new TreeNode(3);
	
	root.left = treeNode2;
	root.right = treeNode3;

	System.out.println(sumNumbers(root));
    }

}

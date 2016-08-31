package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年8月31日 上午9:26:10
 */

public class LCA_22 {

    // 方法一：满二叉树的子节点与父节点之间的关系为root = child / 2,
    // 利用这个关系, 如果a ！= b, 就让其中的较大数除以2, 如此循环直到a == b,
    // a即是原来两个数的最近公共祖先.
    public static int getLCA1(int a, int b) {
	while (a != b) {
	    if (a > b)
		a >>= 1;
	    else
		b >>= 1;
	}
	return a;
    }
    
    // 方法二
    public static int getLCA2(int a, int b) {
	if (a == b)
	    return a; // 相等, 本身就是祖先
	int min = (a < b) ? a : b;
	int max = (a > b) ? a : b;
	if (min / 2 == max / 2)
	    return min / 2; // 说明兄弟节点,那么祖先就是父节点
	while (min / 2 != max / 2) // 否则, 向上找
	{
	    int temp = max / 2;
	    max = (temp > min) ? temp : min;
	    min = (temp < min) ? temp : min;
	    if (min == 1)
		return 1;
	    if (min == max)
		return min;
	}
	return min / 2;
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
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        
        int result = getLCA2(4, 6);
        System.out.println(result);
        
    }

}

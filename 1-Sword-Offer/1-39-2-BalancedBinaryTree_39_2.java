package swordOffer;
/** 
 * @author  WuPing
 * @date 2016年8月26日 下午9:09:44 
 * @version 1.0 
 */
public class BalancedBinaryTree_39_2 {
	
	// 方法一:需遍历结点多次,效率不高
    public static boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
        	return true;
        }
        
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int diff = left - right;
        if(diff > 1 || diff < -1){
        	return false;
        }
        
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    
    public static int TreeDepth(TreeNode pRoot)
    {
       if(pRoot == null)
    	   return 0;
       
       int left_n = TreeDepth(pRoot.left);
       int right_n = TreeDepth(pRoot.right);
       
       return (left_n > right_n) ? (left_n + 1) : (right_n + 1);
    }
    
    // 方法二:每个结点只遍历一次
    public static boolean IsBalanced_Solution2(TreeNode root) {
    	int depth = 0;
    	return IsBalanced(root, depth);
    }
    
    public static boolean IsBalanced(TreeNode root, int depth){
    	if(root == null){
    		depth = 0;
    		return true;
    	}
    	
    	int left = 0; 
    	int right = 0;
    	if(IsBalanced(root.left, left) && IsBalanced(root.right, right)){
    		int diff = left - right;
    		if(diff <= 1 && diff >= -1){
    			depth = 1 + (left > right ? left : right);
    			return true;
    		}
    	}
    	
    	return false;
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
		
		boolean result = IsBalanced_Solution(treeNode1);
		//boolean result = IsBalanced_Solution2(treeNode1);
		System.out.println(result);
	}

}

package swordOffer;
/** 
 * @author  WuPing
 * @date 2016年8月28日 下午9:02:40 
 * @version 1.0 
 */
public class KthNodeInBST_63 {

	private static int ki;
	
	public static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null || k==0){
        	return null;
        }
        ki = k;
        return KthNodeCore(pRoot);
    }
	
	public static TreeNode KthNodeCore(TreeNode pRoot){
		TreeNode target = null;
		
		if(pRoot.left != null){
			target = KthNodeCore(pRoot.left);
		}
		
		if(target == null){
			if(ki==1){
			   target = pRoot;
			}
			ki--;
		}
		
		if(target == null && pRoot.right != null){
			target = KthNodeCore(pRoot.right);
		}
		
		return target;
	}
	
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(5);
		TreeNode treeNode2 = new TreeNode(3);
		TreeNode treeNode3 = new TreeNode(7);
		TreeNode treeNode4 = new TreeNode(2);
		TreeNode treeNode5 = new TreeNode(4);
		TreeNode treeNode6 = new TreeNode(6);
		TreeNode treeNode7 = new TreeNode(8);
		
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		
		treeNode2.left = treeNode4;
		treeNode2.right = treeNode5;
		
		treeNode3.left = treeNode6;
		treeNode3.right = treeNode7;
		
		TreeNode kthNode = KthNode(treeNode1, 3);
		if(kthNode != null){
			System.out.println(kthNode.val);
		}
	}

}

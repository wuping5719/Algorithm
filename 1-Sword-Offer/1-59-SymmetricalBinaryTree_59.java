package swordOffer;
/** 
 * @author  WuPing
 * @date 2016年8月28日 下午4:00:47 
 * @version 1.0 
 */
public class SymmetricalBinaryTree_59 {

	public static boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetricalCore(pRoot, pRoot);
    }
	
	public static boolean isSymmetricalCore(TreeNode pRoot1, TreeNode pRoot2){
		if(pRoot1==null && pRoot2==null){
			return true;
		}
		
		if(pRoot1==null || pRoot2==null){
			return false;
		}
		
		if(pRoot1.val != pRoot2.val){
			return false;
		}
		
		return isSymmetricalCore(pRoot1.left, pRoot2.right) 
				&& isSymmetricalCore(pRoot1.right, pRoot2.left);
	}
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	public static void test1() {
		TreeNode tree1Node1 = new TreeNode(8);
		TreeNode tree1Node2 = new TreeNode(6);
		TreeNode tree1Node3 = new TreeNode(6);
		TreeNode tree1Node4 = new TreeNode(5);
		TreeNode tree1Node5 = new TreeNode(7);
		TreeNode tree1Node6 = new TreeNode(7);
		TreeNode tree1Node7 = new TreeNode(5);
		
		tree1Node1.left = tree1Node2;
		tree1Node1.right = tree1Node3;
		
		tree1Node2.left = tree1Node4;
		tree1Node2.right = tree1Node5;
		
		tree1Node3.left = tree1Node6;
		tree1Node3.right = tree1Node7;
		
		boolean result1 = isSymmetrical(tree1Node1);
		System.out.println(result1);
	}
	
	public static void test2() {
		TreeNode tree2Node1 = new TreeNode(8);
		TreeNode tree2Node2 = new TreeNode(6);
		TreeNode tree2Node3 = new TreeNode(9);
		TreeNode tree2Node4 = new TreeNode(5);
		TreeNode tree2Node5 = new TreeNode(7);
		TreeNode tree2Node6 = new TreeNode(7);
		TreeNode tree2Node7 = new TreeNode(5);
		
		tree2Node1.left = tree2Node2;
		tree2Node1.right = tree2Node3;
		
		tree2Node2.left = tree2Node4;
		tree2Node2.right = tree2Node5;
		
		tree2Node3.left = tree2Node6;
		tree2Node3.right = tree2Node7;
		
		boolean result2 = isSymmetrical(tree2Node1);
		System.out.println(result2);
	}
	
	public static void test3() {
		TreeNode tree3Node1 = new TreeNode(7);
		TreeNode tree3Node2 = new TreeNode(7);
		TreeNode tree3Node3 = new TreeNode(7);
		TreeNode tree3Node4 = new TreeNode(7);
		TreeNode tree3Node5 = new TreeNode(7);
		TreeNode tree3Node6 = new TreeNode(7);
		
		tree3Node1.left = tree3Node2;
		tree3Node1.right = tree3Node3;
		
		tree3Node2.left = tree3Node4;
		tree3Node2.right = tree3Node5;
		
		tree3Node3.left = tree3Node6;
		
		boolean result3 = isSymmetrical(tree3Node1);
		System.out.println(result3);
	}
}

package swordOffer;
/** 
 * @author  WuPing
 * @date 2016年8月28日 下午8:24:31 
 * @version 1.0 
 */
public class SerializeBinaryTrees_62 {
	private static int index = -1;
	
	public static String Serialize(TreeNode root) {
		 StringBuilder sb = new StringBuilder();
	     if(root == null){
	         sb.append("#,");
	         return sb.toString();
	     }
	     
	     sb.append(root.val + ",");
	     sb.append(Serialize(root.left));
	     sb.append(Serialize(root.right));
	     return sb.toString();
	}
	
        //反序列化时静态Static index有问题
	public static TreeNode Deserialize(String str) {
		index++;
		int len = str.length();
		if (index >= len) {
			return null;
		}

		String[] strArray = str.split(",");
		TreeNode node = null;
		if (!strArray[index].equals("#")) {
			node = new TreeNode(Integer.valueOf(strArray[index]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}

		return node;
    }
	
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode6 = new TreeNode(6);
		
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		
		treeNode2.left = treeNode4;
		
		treeNode3.left = treeNode5;
		treeNode3.right = treeNode6;
		
		String serializeStr = Serialize(treeNode1);
		System.out.println(serializeStr);
		
		Deserialize(serializeStr);
	}

}

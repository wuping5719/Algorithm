package swordOffer;

import java.util.Iterator;
import java.util.LinkedList;

/** 
 * @author  WuPing
 * @date 2016年8月27日 下午7:48:47 
 * @version 1.0 
 */
public class CommonParentInTree_50 {

	// 树的结点定义
	@SuppressWarnings("unused")
	private static class GeneralTreeNode {
    	int val;
        LinkedList<GeneralTreeNode> children = new LinkedList<GeneralTreeNode>();
        
		public GeneralTreeNode() {}
        public GeneralTreeNode(int val) {
            this.val = val;
        }
        @Override
        public String toString() {
            return val + "";
        }
    }
    
    /**
     * 找结点的路径
     * @param root   根结点
     * @param target 目标结点
     * @param path   从根结点到目标结点的路径
     */
	public static void GetNodePath(GeneralTreeNode root, GeneralTreeNode target, LinkedList<GeneralTreeNode> path) {
		if (root == null) {
            return;
        }

        // 添加当前结点
        path.add(root);

        LinkedList<GeneralTreeNode> children = root.children;
        
        // 处理子结点
        for (GeneralTreeNode node : children) {
            if (node == target) {
                path.add(node);
                return;
            } else {
            	GetNodePath(node, target, path);
            }
        }

        // 现场还原
        path.remove(path.size() - 1);
	}
	
	/**
     * 找两个路径中的最后一个共同的结点
     * @param path1 路径1
     * @param path2 路径2
     * @return 共同的结点,没有返回null
     */
    public static GeneralTreeNode getLastCommonNode(LinkedList<GeneralTreeNode> path1, LinkedList<GeneralTreeNode> path2) {
        Iterator<GeneralTreeNode> ite1 = path1.iterator();
        Iterator<GeneralTreeNode> ite2 = path2.iterator();
        GeneralTreeNode last = null;

        while (ite1.hasNext() && ite2.hasNext()) {
        	GeneralTreeNode temp = ite1.next();
            if (temp == ite2.next()) {
                last = temp;
            }
        }

        return last;
    }

    /**
     * 找树中两个结点的最低公共祖先
     * @param root 树的根结点
     * @param node1 结点1
     * @param node2 结点2
     * @return 公共结点,没有返回null
     */
    public static GeneralTreeNode getLastCommonParent(GeneralTreeNode root, GeneralTreeNode node1, GeneralTreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        LinkedList<GeneralTreeNode> path1 = new LinkedList<GeneralTreeNode>();
        GetNodePath(root, node1, path1);
        LinkedList<GeneralTreeNode> path2 = new LinkedList<GeneralTreeNode>();
        GetNodePath(root, node2, path2);

        return getLastCommonNode(path1, path2);
    }
    
	public static void main(String[] args) {
		 test01();
	     System.out.println("==========");
	     test02();
	     System.out.println("==========");
	     test03();
	}

	 // 形状普通的树
    //             1
    //           /   \
    //         2      3
    //        /         \
    //      4            5
    //     / \        /  |  \
    //    6   7      8   9  10
    public static void test01() {
    	GeneralTreeNode n1 = new GeneralTreeNode(1);
        GeneralTreeNode n2 = new GeneralTreeNode(2);
        GeneralTreeNode n3 = new GeneralTreeNode(3);
        GeneralTreeNode n4 = new GeneralTreeNode(4);
        GeneralTreeNode n5 = new GeneralTreeNode(5);
        GeneralTreeNode n6 = new GeneralTreeNode(6);
        GeneralTreeNode n7 = new GeneralTreeNode(7);
        GeneralTreeNode n8 = new GeneralTreeNode(8);
        GeneralTreeNode n9 = new GeneralTreeNode(9);
        GeneralTreeNode n10 = new GeneralTreeNode(10);

        n1.children.add(n2);
        n1.children.add(n3);

        n2.children.add(n4);

        n4.children.add(n6);
        n4.children.add(n7);

        n3.children.add(n5);

        n5.children.add(n8);
        n5.children.add(n9);
        n5.children.add(n10);

        System.out.println(getLastCommonParent(n1, n6, n8));
    }

    // 树退化成一个链表
    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test02() {
        GeneralTreeNode n1 = new GeneralTreeNode(1);
        GeneralTreeNode n2 = new GeneralTreeNode(2);
        GeneralTreeNode n3 = new GeneralTreeNode(3);
        GeneralTreeNode n4 = new GeneralTreeNode(4);
        GeneralTreeNode n5 = new GeneralTreeNode(5);

        n1.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);

        System.out.println(getLastCommonParent(n1, n4, n5));
    }

    // 树退化成一个链表,一个结点不在树中
    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test03() {
        GeneralTreeNode n1 = new GeneralTreeNode(1);
        GeneralTreeNode n2 = new GeneralTreeNode(2);
        GeneralTreeNode n3 = new GeneralTreeNode(3);
        GeneralTreeNode n4 = new GeneralTreeNode(4);
        GeneralTreeNode n5 = new GeneralTreeNode(5);
        GeneralTreeNode n6 = new GeneralTreeNode(6);

        n1.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);

        System.out.println(getLastCommonParent(n1, n5, n6));
    }
    
}

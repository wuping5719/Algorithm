package crackingCodingInterview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WuPing
 * @version 2016年8月31日 上午8:31:27
 */

public class FindNextInTree_21 {

    // 方法一: 将中序遍历结果放入队列
    private static Queue<Integer> queue = new LinkedList<Integer>();
    public static int findSucc1(TreeNode root, int p) {
        if(root == null) {
            return -1;
        }
        
        InfixOrderTree(root);
        int next = -1;
        while(!queue.isEmpty()) {
            int temp = queue.peek();
            if(temp == p) {
        	queue.poll();
        	if(!queue.isEmpty()) {
        	    next = queue.peek();
        	    queue.poll();
        	    return next;
        	}
        	else {
        	    return next;
        	}
            }
            
            queue.poll();
        }
        
        return next;
    }
    
    public static void InfixOrderTree(TreeNode root) {
	if (root.left != null) {
	    InfixOrderTree(root.left);
	}

	if (root != null) {
	    queue.offer(root.val);
	}

	if (root.right != null) {
	    InfixOrderTree(root.right);
	}
    }
    
    // 方法二: 前一个节点, 令此引用按照中序遍历的来移动, 利用它来进行逆向移动
    // 即原来只能是 :根→左 , 现在可以 :左→根
    private static TreeNode pre = new TreeNode(-1);
    public static int findSucc2(TreeNode root, int p) {
	// 空则表示没有
	if (root == null)
	    return -1;

	// 一路向左, 到达最左边的叶子
	int left = findSucc2(root.left, p);

	if (left == -1) {
	    // 最开始到达最左节点后, 令pre指向该节点, 同时root为pre的后继节点
	    // 其后按照左根右的顺序移动
	    // 如果上一个节点中找到p,则该节点后其后继节点
	    if (pre.val == p) {
		return root.val;
	    }
	    pre = root; // 如果前一个节点不是, 则pre指向root的对象
	    return findSucc2(root.right, p);
	}

	// 如果找不到则返回上一层的根节点, 方向为 左→根
	return left;
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
        
        int result1 = findSucc1(treeNode1, 1);
        queue.clear();
        System.out.println(result1);
        
        int result2 = findSucc1(treeNode1, 2);
        queue.clear();
        System.out.println(result2);
        
        int result3 = findSucc1(treeNode1, 6);
        queue.clear();
        System.out.println(result3);
    }

}

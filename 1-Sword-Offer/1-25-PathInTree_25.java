package swordOffer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/** 
 * @author  WuPing
 * @date 2016年8月24日 下午8:56:08 
 * @version 1.0 
 */
public class PathInTree_25 {
	
	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
        if(root==null){
        	return pathList;
        }
            
        Stack<Integer> stack=new Stack<Integer>();
        FindPathByStack(root, target, stack, pathList);
        return pathList;
    }
	
    private static void FindPathByStack(TreeNode root, int target, Stack<Integer> stack, ArrayList<ArrayList<Integer>> pathList) {
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            if(root.val==target){
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i:stack){
                    list.add(new Integer(i));
                }
                list.add(new Integer(root.val));
                pathList.add(list);
            }
        }
        else{
        	stack.push(new Integer(root.val));
        	FindPathByStack(root.left, target-root.val, stack, pathList);
        	FindPathByStack(root.right, target-root.val, stack, pathList);
            stack.pop();
        }
         
    }
	
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(10);
		TreeNode treeNode2 = new TreeNode(5);
		TreeNode treeNode3 = new TreeNode(12);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(7);

		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode2.left = treeNode4;
		treeNode2.right = treeNode5;

		Scanner cin = new Scanner(System.in);
		int target = cin.nextInt();
		ArrayList<ArrayList<Integer>> allPathList = new ArrayList<ArrayList<Integer>>();
		allPathList = FindPath(treeNode1, target);
		for(int i=0; i<allPathList.size(); i++){
			ArrayList<Integer> tempPathList = new ArrayList<Integer>();
			tempPathList = allPathList.get(i);
			for(int j=0; j<tempPathList.size(); j++){
				System.out.print(tempPathList.get(j) + " ");
			}
			System.out.println();
		}
		cin.close();
	}

}

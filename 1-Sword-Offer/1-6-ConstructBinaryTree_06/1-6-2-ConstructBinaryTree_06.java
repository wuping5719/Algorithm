package swordOffer;

import java.util.Arrays;
import java.util.Scanner;

import swordOffer.TreeNode;

/**
 * @author WuPing
 * @version 2016年8月23日 上午10:36:08
 */

public class ConstructBinaryTree_06 {
    
    public static TreeNode reConstructBinaryTree(int[] pre,int[] in) {
	TreeNode rootNode = null;
	if(pre!=null && in!=null && pre.length>0 && in.length>0) {
	    rootNode = new TreeNode(pre[0]);
	    for(int i=0; i<in.length; i++) {
		if(pre[0]==in[i]) {
		    rootNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
		    rootNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
		}
	    }
	}
	return rootNode;
    }
    
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String preStr = scanner.nextLine();   //前序遍历序列
	String inStr = scanner.nextLine();    //中序遍历序列
	String[] preArray = preStr.split(",");
	String[] inArray = inStr.split(",");
	if(preArray.length<=0 || inArray.length <=0) {
	    System.out.println("输入非法!");
	}
	int[] pre = new int[preArray.length];
	int[] in = new int[inArray.length];
	
	for(int i=0; i<preArray.length; i++) {
	    pre[i] = Integer.parseInt(preArray[i]);
	}
	for(int j=0; j<inArray.length; j++) {
	    in[j] = Integer.parseInt(inArray[j]);
	    
	}
	TreeNode rootNode = reConstructBinaryTree(pre, in);
	System.out.println(rootNode.val);
	
	scanner.close();
    }

}

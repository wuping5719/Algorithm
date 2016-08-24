package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月24日 下午8:24:19 
 * @version 1.0 
 */
public class SquenceOfBST_24 {

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence == null || sequence.length==0){
        	return false;
        }
        
        int length = sequence.length;
        int root = sequence[length-1];
        
        // 在二叉搜索树中左子树的结点小于根结点
        int i=0;
        for(; i<length-1; i++){
        	if(sequence[i] > root){
        		break;
        	}
        }
        
        // 在二叉搜索树中右子树的结点大于根结点
        int j=i;
        for(; j<length-1; j++){
        	if(sequence[j] < root){
        		return false;
        	}
        }
        
        // 判断左子树是不是二叉搜索树
        boolean left = true;
        if(i > 0){
        	int[] leftSequence = new int[i+1];
        	for(int k=0; k<i; k++){
        		leftSequence[k] = sequence[k];
        	}
        	left = VerifySquenceOfBST(leftSequence);
        }
        
        // 判断右子树是不是二叉搜索树
        boolean right = true;
        if(i < length-1){
        	int[] rightSequence = new int[length-i-1];
        	for(int k=0; k<length-i-1; k++){
        		rightSequence[k] = sequence[i+k];
        	}
        	right = VerifySquenceOfBST(rightSequence);
        }
        
        return (left && right);
    }

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		if(str == null || str.trim().equals("")){
			System.out.println("输入非法！");
			return;
		}
		String[] arrayStr = str.split(",");
		if(arrayStr.length>0){
			int[] sequence = new int[arrayStr.length];
			for(int i=0; i<arrayStr.length; i++){
				sequence[i] = Integer.parseInt(arrayStr[i]);
			}
			
			boolean result = VerifySquenceOfBST(sequence);
			System.out.println(result);
		}
		
		scanner.close();
	}

}

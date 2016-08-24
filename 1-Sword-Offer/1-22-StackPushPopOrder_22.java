package swordOffer;

import java.util.Scanner;
import java.util.Stack;

/** 
 * @author  WuPing
 * @date 2016年8月24日 下午7:13:16 
 * @version 1.0 
 */
public class StackPushPopOrder_22 {

	public static boolean IsPopOrder(int[] pushA, int[] popA) {
	      boolean isPossible = false;
	      if(pushA!=null && popA!=null && pushA.length>0 && popA.length>0){
	    	  Stack<Integer> stack = new Stack<Integer>();
	    	  int length = pushA.length;
	    	  int nextPushIndex = 0;
	    	  int nextPopIndex = 0;
	    	  while(nextPopIndex < length){
	    		  while(stack.empty() || stack.peek() != popA[nextPopIndex]){
		    		  if(nextPushIndex == length){
		    			  break;
		    		  }
		    		  
		    		  stack.push(pushA[nextPushIndex]);
		    		  nextPushIndex++;
		    	  }
	    		  
	    		  if(stack.peek() != popA[nextPopIndex]){
	    			  break;
	    		  }
	    		  
	    		  stack.pop();
	    		  nextPopIndex++;
	    	  }
	    	  
	    	  if(stack.empty() && nextPopIndex == length){
	    		  isPossible = true; 
	    	  }
	      }
	      return isPossible;
    }
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String[] arrayStr1 = str1.split(",");
		String str2 = scanner.nextLine();
		String[] arrayStr2 = str2.split(",");
		if(arrayStr1.length != arrayStr2.length){
			System.out.println("压入,弹出序列长度不一致！");
		}else{
			int[] pushA = new int[arrayStr1.length];
		    for(int i=0; i<arrayStr1.length; i++){
		    	pushA[i] = Integer.parseInt(arrayStr1[i]);
		    }
		    
		    int[] popA = new int[arrayStr2.length];
		    for(int j=0; j<arrayStr2.length; j++){
		    	popA[j] = Integer.parseInt(arrayStr2[j]);
		    }
		    
		    boolean isPossible = IsPopOrder(pushA, popA);
		    System.out.println(isPossible);
		}
		
		scanner.close();
	}

}

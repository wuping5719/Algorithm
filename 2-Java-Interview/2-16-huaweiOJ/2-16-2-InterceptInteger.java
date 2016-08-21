package interview.huawei;

import java.util.Scanner;
import java.util.Stack;

/** 
 * @author  WuPing
 * @date 2016年8月20日 下午10:55:22 
 * @version 1.0 
 */
public class InterceptInteger {

	public static int interceptInteger(int w) {
		int childW = 0;
		int aBit = 0;
		int otherBit = 0;
		aBit = w % 10;
		otherBit = w / 10;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(aBit);
	    while(otherBit !=0 ){
	    	stack.push(otherBit % 10);
	    	otherBit = otherBit / 10;
	    }
	    String childWStr = "";
	    boolean isFirstBit = true;
	    while(!stack.isEmpty()){
	    	if(!isFirstBit){
	    		childWStr= childWStr + stack.peek();
	    	}else{
	    		isFirstBit = false;
	    	}
	    	stack.pop();
	    }
	    childW = Integer.parseInt(childWStr);
		return childW;
	}
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int w = 0;
		while (cin.hasNextInt()) {
			w = cin.nextInt();
			System.out.println(interceptInteger(w));
		}
		cin.close();
	}

}

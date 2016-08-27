package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月27日 上午10:47:00 
 * @version 1.0 
 */
public class LeftRotateString_42_2 {
	
	public static String LeftRotateString(String str, int n) {
	    if(str == null || str.length() ==0) {
	    	return str;
	    }
	    
	    if(n>0 && n<str.length()){
	    	char[] temp = str.toCharArray(); 
	    	StringBuilder sb = new StringBuilder();
	    	StringBuilder lastStr = new StringBuilder();
	    	for(int i=0; i<str.length(); i++){
	    		if(i<n){
	    			lastStr.append(temp[i]);
	    		}else{
	    			sb.append(temp[i]);
	    		}
	    	}
	    	sb.append(lastStr);
	    	return sb.toString();
	    }else{
	    	return str;
	    }
	}
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
        	String str = cin.nextLine();
        	int n = cin.nextInt();
        	String result = LeftRotateString(str, n);
        	System.out.println(result);
        }
        cin.close();
	}

}

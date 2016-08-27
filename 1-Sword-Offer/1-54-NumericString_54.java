package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月27日 下午10:26:32 
 * @version 1.0 
 */
public class NumericString_54 {

    public static boolean isNumeric(char[] str) {
        if(str==null || str.length==0){
        	return false;
        }
        
        boolean numeric = true;
        int strIndex = 0;
        if(strIndex<str.length){
        	if(str[strIndex]=='+' || str[strIndex]=='-'){
        		strIndex++;
        	}
        	if(strIndex==str.length){
        		return false;
        	}
        	
        	while(strIndex<str.length && str[strIndex]>='0' && str[strIndex]<='9'){
        		strIndex++;
        	}
        	if(strIndex<str.length){
        		// 浮点数float
        		if(str[strIndex]=='.'){
        			strIndex++;
        			while(strIndex<str.length && str[strIndex]>='0' && str[strIndex]<='9'){
        	    		strIndex++;
        	    	}
        			
        			if(strIndex<str.length && (str[strIndex]=='e' || str[strIndex]=='E')){
        				numeric = isExponential(str, strIndex);
        			}
        			
        			if(strIndex<str.length && str[strIndex]=='.'){
        				return false;
        			}
        		}   
        		// 整数Integer
        		else if(strIndex<str.length && (str[strIndex]=='e' || str[strIndex]=='E')){
        			numeric = isExponential(str, strIndex);
        		}
        		else{
        			numeric = false;
        		}
        	}
        }
        return numeric;
    }

    public static boolean isExponential(char[] str, int strIndex) {
    	if(str[strIndex]!='e' && str[strIndex]!='E'){
    		return false;
    	}
    	
    	strIndex++;
    	if(strIndex<str.length && (str[strIndex]=='+' || str[strIndex]=='-')){
    		strIndex++;
    	}
    	
    	if(strIndex==str.length){
    		return false;
    	}
    	
    	while(strIndex<str.length && str[strIndex]>='0' && str[strIndex]<='9'){
    		strIndex++;
    	}
    	
    	return (strIndex==str.length) ? true : false;
    }
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String strStr = scanner.nextLine();
			char[] str = strStr.toCharArray();
			boolean numeric = isNumeric(str);
			
			System.out.println(numeric);
		}
		scanner.close();
	}

}

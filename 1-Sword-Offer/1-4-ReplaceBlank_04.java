package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月22日 下午9:16:31 
 * @version 1.0 
 */
public class ReplaceBlank_04 {
	
    public static String replaceSpace(StringBuffer str) {
    	String result = null;
    	StringBuffer outputBuffer = new StringBuffer();
    	if(str!=null){
    		for(int i=0; i<str.length(); i++){
    			if(str.charAt(i)==' '){
    				outputBuffer.append("%");
    				outputBuffer.append("2");
    				outputBuffer.append("0");
    			}else{
    				outputBuffer.append(str.charAt(i));
    			}
    		}
    	}
    	result = outputBuffer.toString();
    	return result;
    }
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		StringBuffer strBuf = new StringBuffer();
		strBuf.append(str);
		String result = replaceSpace(strBuf);
		System.out.println(result);
		
		in.close();
	}

}

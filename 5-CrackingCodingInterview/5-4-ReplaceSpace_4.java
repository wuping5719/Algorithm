package crackingCodingInterview;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月29日 下午8:20:22 
 * @version 1.0 
 */
public class ReplaceSpace_4 {
	
	public static String replaceSpace(String iniString, int length) {
		if(iniString==null && length<=0){
			return null;
		}
		if(iniString.length() != length){
			return null;
		}
		
        char[] str = iniString.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length; i++){
        	if(str[i]==' '){
        		sb.append("%20");
        	}else{
        		sb.append(str[i]);
        	}
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String iniString = cin.nextLine();
		int length = cin.nextInt();
		String result = replaceSpace(iniString, length);
		System.out.println(result);

		cin.close();
	}

}

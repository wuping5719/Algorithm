package crackingCodingInterview;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月29日 下午8:33:49 
 * @version 1.0 
 */
public class ZipString_5 {

	public static String zipString(String iniString) {
       if(iniString==null){
    	   return iniString;
       }

       char[] str = iniString.toCharArray();
       StringBuilder sb = new StringBuilder();
       int num = 1;
       char currentChar = str[0];
       for(int i=1; i<str.length; i++){
    	   if(str[i] != currentChar){
    		   sb.append(currentChar);
    		   sb.append(num);
    		   currentChar = str[i];
    		   num=1;
    	   }else{
    		   num++;
    	   }
       }
       sb.append(currentChar);
	   sb.append(num);
	   
       if(sb.length()>=iniString.length()){
    	   return iniString;
       }else{
    	   return sb.toString();
       }
    }
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while(cin.hasNextLine()){
			String iniString = cin.nextLine();
			String result = zipString(iniString);
			System.out.println(result);
		}

		cin.close();
	}

}

package crackingCodingInterview;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月29日 下午7:23:42 
 * @version 1.0 
 */
public class CheckStringSam_3 {
	
	public static boolean checkSam(String stringA, String stringB) {
        if(stringA==null && stringB==null){
        	return true;
        }
        else if(stringA!=null && stringB==null){
        	return false;
        }
        else if(stringA==null && stringB!=null){
        	return false;
        }
        else {
        	int lenA = stringA.length();
            int lenB = stringB.length();
            if(lenA != lenB){
            	return false;
            }
            
            int[] strA = new int[256];
            int[] strB = new int[256];
            for(int i=0; i<lenA; i++){
            	strA[stringA.charAt(i)]++;
            	strB[stringB.charAt(i)]++;
            }
            
            for(int i=0; i<256; i++){
                if(strA[i] != strB[i]){
                    return false;
                }
            }
            return true;
        }
    }
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			String stringA = cin.nextLine();
			String stringB = cin.nextLine();
			boolean result = checkSam(stringA, stringB);
			System.out.println(result);
		}
		cin.close();
	}

}

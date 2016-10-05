package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午7:19:19
 */

public class ProcessString_77 {

    public static String processString1(String aStr, String bStr) {
	String tempStr = aStr + bStr;
	
        StringBuffer oddStr = new StringBuffer();
        StringBuffer evenStr = new StringBuffer();
	for (int i = 0; i < tempStr.length(); i++) {
	    if ((i + 1) % 2 == 1) {
		oddStr.append(tempStr.charAt(i));
	    } else {
		evenStr.append(tempStr.charAt(i));
	    }
	}
        char[] oddArray = oddStr.toString().toCharArray();
        Arrays.sort(oddArray);
        char[] evenArray = evenStr.toString().toCharArray();
        Arrays.sort(evenArray);
        
        StringBuffer resStr = new StringBuffer();
        int oddIndex = 0;
        int evenIndex = 0;
        for (int i = 0; i < tempStr.length(); i++) {
	    if ((i + 1) % 2 == 1) {
		resStr.append(oddArray[oddIndex]);
		oddIndex++;
	    } else {
		resStr.append(evenArray[evenIndex]);
		evenIndex++;
	    }
	}
        
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<resStr.length(); i++) {
            if ((resStr.charAt(i) >= 'a' && resStr.charAt(i) <= 'f') 
        	    || (resStr.charAt(i) >= 'A' && resStr.charAt(i) <= 'F')
        	    || (resStr.charAt(i) >= '0' && resStr.charAt(i) <= '9')) {
                String binStr = "0000" + Integer.toBinaryString(Integer.valueOf(resStr.charAt(i) + "", 16));
                binStr = binStr.substring(binStr.length()-4);
                StringBuffer oxStr = new StringBuffer();
                for (int j=binStr.length()-1; j>= 0; j--) {
                    oxStr.append(binStr.charAt(j));
                }
                String c = Integer.toHexString(Integer.parseInt(oxStr.toString(), 2)).toUpperCase();
                sb.append(c);
            } else {
                sb.append(resStr.charAt(i));
            }
        }
        
        return sb.toString();
    }
    
    public static char bitReverse(char c){
	switch (c) {
	   case '0': c = '0'; break;
	   case '1': c = '8'; break;
	   case '2': c = '4'; break;
	   case '3': c = 'C'; break;
	   case '4': c = '2'; break;
	   case '5': c = 'A'; break;
	   case '6': c = '6'; break;
	   case '7': c = 'E'; break;
	   case '8': c = '1'; break;
	   case '9': c = '9'; break;
	   case 'a': c = '5'; break;
	   case 'b': c = 'D'; break;
	   case 'c': c = '3'; break;
	   case 'd': c = 'B'; break;
	   case 'e': c = '7'; break;
	   case 'f': c = 'F'; break;
	   case 'A': c = '5'; break;
	   case 'B': c = 'D'; break;
	   case 'C': c = '3'; break;
	   case 'D': c = 'B'; break;
	   case 'E': c = '7'; break;
	   case 'F': c = 'F'; break;
	   default: break;
	}
	return c;
    }
    
    public static String processString2(String aStr, String bStr) {
	String tempStr = aStr + bStr;
	
        StringBuffer oddStr = new StringBuffer();
        StringBuffer evenStr = new StringBuffer();
	for (int i = 0; i < tempStr.length(); i++) {
	    if ((i + 1) % 2 == 1) {
		oddStr.append(tempStr.charAt(i));
	    } else {
		evenStr.append(tempStr.charAt(i));
	    }
	}
        char[] oddArray = oddStr.toString().toCharArray();
        Arrays.sort(oddArray);
        char[] evenArray = evenStr.toString().toCharArray();
        Arrays.sort(evenArray);
        
        StringBuffer resStr = new StringBuffer();
        int oddIndex = 0;
        int evenIndex = 0;
        for (int i = 0; i < tempStr.length(); i++) {
	    if ((i + 1) % 2 == 1) {
		resStr.append(oddArray[oddIndex]);
		oddIndex++;
	    } else {
		resStr.append(evenArray[evenIndex]);
		evenIndex++;
	    }
	}
        
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<resStr.length(); i++) {
            sb.append(bitReverse(resStr.charAt(i)));
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            String aStr = cin.next();
            String bStr = cin.next();
            //System.out.println(processString1(aStr, bStr));
            System.out.println(processString2(aStr, bStr));
        }
        cin.close();
    }

}

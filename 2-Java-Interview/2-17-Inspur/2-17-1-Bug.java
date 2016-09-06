package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月6日 下午7:40:57
 */

public class Bug {

    public static void main(String[] args) {
       Scanner cin = new Scanner(System.in);
       while(cin.hasNext()) {
	   String str = cin.nextLine();
	   StringBuffer sb1 = new StringBuffer();
	   if(str!=null && !str.trim().equals("")) {
	       char[] array1 = str.toCharArray();
	       for(int i=array1.length-1; i>=0; i--) {
		   sb1.append(array1[i]);
	       }
	   }
	   
	   char[] array2 = sb1.toString().toCharArray();
	   int firstIndex = 0;
	   for(int j=0; j<array2.length; j++) {
	       if(array2[j]!='0') {
		   firstIndex = j;
		   break;
	       }
	   }
	   
	   StringBuffer sb2 = new StringBuffer();
	   for(int i=firstIndex; i<array2.length; i++) {
	       sb2.append(array2[i]);
	   }
	   
	   System.out.println(sb2.toString());
       }
       cin.close();
    }

}

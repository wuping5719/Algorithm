package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月25日 下午3:19:32
 */

public class IntegerAliquot {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    String[] charArray = str.split(",");
	    int[] intArray = new int[charArray.length];
            for(int i=0; i<charArray.length; i++) {
        	intArray[i] = Integer.parseInt(charArray[i]);
            }
            
            boolean[] booleanArray = new boolean[charArray.length];
            for(int i=0; i<intArray.length; i++) {
        	booleanArray[i] = false;
            }
            
            for(int i=0; i<intArray.length; i++) {
        	for(int j=0; j<intArray.length; j++) {
            	   if(i!=j) {
            	     if(intArray[i] % intArray[j] == 0) {
            		booleanArray[i] = true;
            	     }   
            	   }
                }
            }
            
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<intArray.length; i++) {
        	if(booleanArray[i]) {
        	   sb.append(intArray[i]);
        	   sb.append(" ");
        	}
            }
	    System.out.println(sb.toString());
	}
	cin.close();

    }

}

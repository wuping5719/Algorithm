package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月25日 下午3:36:12
 */

public class IntegerSort {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    String[] strArray = str.split(",");
	    int[] intArray = new int[strArray.length];
            for(int i=0; i<strArray.length; i++) {
        	intArray[i] = Integer.parseInt(strArray[i]);
            }
            
            Arrays.sort(intArray);
            boolean[] booleanArray = new boolean[strArray.length];
            for(int i=0; i<intArray.length; i++) {
        	booleanArray[i] = true;
            }
            
            for(int i=1; i<intArray.length; i++) {
                if(intArray[i] == intArray[i-1]+1) {
                    booleanArray[i] = false;
            	}else {   
            	    booleanArray[i-1] = true;
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

package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月30日 下午10:38:06
 */

public class StringArraySort_14 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String nStr = cin.nextLine();
	    int n = Integer.valueOf(nStr);
	    String[] array = new String[n];
	    for(int i=0; i<array.length; i++) {
		array[i] = cin.nextLine();
	    }
	    
	    Arrays.sort(array);
	    for(int i=0; i<array.length; i++) {
		System.out.println(array[i]);
	    }
	}
	cin.close();
    }

}

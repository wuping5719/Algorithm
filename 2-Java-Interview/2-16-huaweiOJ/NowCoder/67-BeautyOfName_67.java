package huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月4日 下午11:55:50
 */

public class BeautyOfName_67 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	   String nStr = cin.nextLine();
	   int n = Integer.parseInt(nStr);
	   
	   String[] strArray = new String[n];
	   for(int i=0; i<n; i++) {
	       strArray[i] = cin.nextLine();
	   }
	       
	    for (int i = 0; i < n; i++) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int j = 0; j < strArray[i].length(); j++) {
		    if (map.containsKey(strArray[i].charAt(j))) {
			map.put(strArray[i].charAt(j), map.get(strArray[i].charAt(j)) + 1);
		    } else {
			map.put(strArray[i].charAt(j), 1);
		    }
		}

		int[] arrayChar = new int[map.size()];
		int index = 0;
		for (Character c : map.keySet()) {
		    arrayChar[index] = map.get(c);
		    index++;
		}

		Arrays.sort(arrayChar);
		int count = 0;
		int degree = 0;
		for (int j = arrayChar.length - 1; j >= 0; j--) {
		    degree = degree + arrayChar[j] * (26 - count);
		    count++;
		}
		System.out.println(degree);
	    }
	}
        cin.close();
    }

}

package huawei;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月4日 下午11:33:18
 */

public class FirstCharOfStringAppearOnce_65 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    
	    LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
	    for(int i=0; i<str.length(); i++) {
		if(map.containsKey(str.charAt(i))) {
		    map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
		}else {
		    map.put(str.charAt(i), 1);
		}
	    }
	    
	    boolean isExisted = false;
	    for(char c: map.keySet()) {
		if(map.get(c)==1) {
		    System.out.println(c);
		    isExisted = true;
		    break;
		}
	    }
	    if(!isExisted) {
		System.out.println(-1);
	    }
	}
	cin.close();
    }

}

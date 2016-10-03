package huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月3日 下午9:51:40
 */

public class StringMatch_49 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String shortStr = cin.nextLine();
            String longStr = cin.nextLine();
            
            HashSet<Character> set = new HashSet<Character>();
            for(int i=0; i<longStr.length(); i++) {
        	if(!set.contains(longStr.charAt(i))) {
        	    set.add(longStr.charAt(i));
        	}
            }
        
            boolean result = true;
            for(int i=0; i<shortStr.length(); i++) {
        	if(!set.contains(shortStr.charAt(i))) {
        	    result = false;
        	    break;
        	}
            }
            System.out.println(result);
        }
        cin.close();
    }

}

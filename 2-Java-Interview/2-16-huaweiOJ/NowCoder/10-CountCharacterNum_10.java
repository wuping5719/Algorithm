package huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月30日 下午9:01:05
 */

public class CountCharacterNum_10 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    int count = 0;
	    if (!str.trim().equals("")) {
		char[] charArray = str.toCharArray();
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < charArray.length; i++) {
		    if (!set.contains(charArray[i])) {
			set.add(charArray[i]);
			count++;
		    }
		}
	    }
	    
	    System.out.println(count);
	}
	cin.close();
    }

}

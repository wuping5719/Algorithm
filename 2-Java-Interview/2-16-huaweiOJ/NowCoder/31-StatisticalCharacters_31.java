package huawei;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author WuPing
 * @version 2016年10月2日 下午4:10:29
 */

public class StatisticalCharacters_31 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    char[] charArray = str.toCharArray();
	    HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
	    for(int i=0; i<charArray.length; i++) {
		if(hashMap.containsKey(charArray[i])) {
		    hashMap.put(charArray[i], hashMap.get(charArray[i]) + 1);
		}else {
		    hashMap.put(charArray[i], 1);
		}
	    }
	    
	    TreeMap<Integer, Character> treeMap = new TreeMap<Integer, Character>();
	    for(char c : hashMap.keySet()) {
		treeMap.put(hashMap.get(c)*128 + 128 - c, c);
	    }
	    
	    StringBuffer sb = new StringBuffer();
	    for (int times : treeMap.keySet()) {
		sb.append(treeMap.get(times));
	    }
	    System.out.println(sb.reverse().toString());
	}
	cin.close();
    }

}

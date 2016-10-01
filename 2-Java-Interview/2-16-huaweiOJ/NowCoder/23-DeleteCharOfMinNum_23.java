package huawei;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月1日 下午8:25:29
 */

public class DeleteCharOfMinNum_23 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    
	    if(str != null && str.length() > 0) {
		 char[] charArray = str.toCharArray();
		 HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		 for(int i=0; i<charArray.length; i++) {
		     if(map.containsKey(charArray[i])) {
			 map.put(charArray[i], map.get(charArray[i]) + 1);
		     }else {
			 map.put(charArray[i], 1);
		     }
		 } 
		 
		 int minNum = map.get(charArray[0]);
		 for(Entry<Character, Integer> entry : map.entrySet()) {  
		    if(entry.getValue() < minNum) {
			minNum = entry.getValue();
		    }
		 }  
		 
		 StringBuffer resStr = new StringBuffer();
		 for(int i=0; i<charArray.length; i++) {
		     if(map.get(charArray[i]) != minNum) {
			 resStr.append(charArray[i]);
		     }
		 } 
		 
		 System.out.println(resStr.toString());
	    }
	}
	cin.close();
    }

}

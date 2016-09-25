package huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月25日 下午3:03:03
 */

public class DeleteString {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    char[] strArray = str.toCharArray();
	    Arrays.sort(strArray);
	    Queue<Character> queue = new LinkedList<Character>();
	    for(int i=0; i<strArray.length; i++) {
		if(!queue.contains(strArray[i])) {
		    queue.add(strArray[i]);
		}
	    }
	    
	    StringBuffer sb = new StringBuffer();
	    while(!queue.isEmpty()) {
		sb.append(queue.peek());
		queue.poll();
	    }
	    
	    System.out.println(sb.toString());
	}
	cin.close();
    }

}

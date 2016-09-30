package huawei;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月30日 下午8:10:29
 */

public class ExtractNoRepeatInteger_9 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    long n = cin.nextLong();
	    String str = String.valueOf(n);
	    char[] temp = str.toCharArray();
	    Queue<Character> queue = new LinkedList<Character>();
	    for(int i=temp.length-1; i>=0; i--) {
		if(!queue.contains(temp[i])) {
		    queue.offer(temp[i]);
		}
	    }
	    
	    StringBuffer sb = new StringBuffer();
	    while(!queue.isEmpty()) {
		sb.append(queue.poll());
	    }
	    System.out.println(sb.toString());
	}
	cin.close();
    }

}

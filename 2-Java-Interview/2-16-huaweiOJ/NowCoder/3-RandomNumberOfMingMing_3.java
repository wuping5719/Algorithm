package huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月29日 下午3:28:51
 */

public class RandomNumberOfMingMing_3 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[] array = new int[n];
	    for(int i=0; i<n; i++) {
		array[i] = cin.nextInt();
	    }

	    Queue<Integer> queue = new LinkedList<Integer>();
	    for(int i=0; i<n; i++) {
		if(!queue.contains(array[i])) {
		    queue.offer(array[i]);
		}
	    }
	     
	    int[] resultArray = new int[queue.size()];
	    int index = 0;
	    while(!queue.isEmpty()) {
		resultArray[index] = queue.poll();
		index++;
	    }
	    
	    Arrays.sort(resultArray);
	    for(int i=0; i<resultArray.length; i++) {
		System.out.println(resultArray[i]);
	    }
	}
	cin.close();

    }

}

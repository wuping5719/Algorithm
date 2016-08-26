package interview.zte;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年8月26日 下午2:23:57
 */

public class CountCacheMiss {
    
    // 方法一: 先进先出缓存算法(FIFO):
    // http://blog.csdn.net/f2006116/article/details/51901811
    
    //方法二:两个队列
    public static int countCacheMiss(int max_cache_size, int[] page_request) {
	if (max_cache_size <= 0 || page_request == null
		|| page_request.length == 0) {
	    return 0;
	}

	int missNum = 0;

	Queue<Integer> queue1 = new LinkedList<Integer>();
	Queue<Integer> queue2 = new LinkedList<Integer>();
	int length = page_request.length;
	int nextIndex = 0;
	while (nextIndex < length) {
	    if (queue1.size() < max_cache_size) {
		queue1.offer(page_request[nextIndex]);
		missNum++;
	    } else if (queue1.size() == max_cache_size) {
		boolean isMiss = true;
		while (!queue1.isEmpty()) {
		    int top1 = queue1.peek();
		    if (top1 == page_request[nextIndex]) {
			isMiss = false;
		    }
		    queue1.poll();
		    queue2.offer(top1);
		}
		while (!queue2.isEmpty()) {
		    int top2 = queue2.peek();
		    queue2.poll();
		    queue1.offer(top2);
		}

		if (isMiss) {
		    missNum++;
		    queue1.poll();
		    queue1.offer(page_request[nextIndex]);
		}
	    }
	    
	    nextIndex++;
	}
	return missNum;
    }

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int max_cache_size = Integer.parseInt(cin.nextLine());
	    String str = cin.nextLine();
	    if (str == null || str.length() <= 0) {
		System.out.println("输入非法！");
	    } else {
		String[] arrayStr = str.split(",");
		int[] page_request = new int[arrayStr.length];
		for (int i = 0; i < arrayStr.length; i++) {
		    page_request[i] = Integer.parseInt(arrayStr[i]);
		}
		int result = countCacheMiss(max_cache_size, page_request);
		System.out.println(result);
	    }
	}
	cin.close();
    }

}

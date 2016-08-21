package interview.youDao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author WuPing
 * @date 2016年8月18日 下午10:26:25
 * @version 1.0
 */
public class MyQueue {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int t = 0;
		while (cin.hasNextInt()) {
			t = cin.nextInt();
			int n = 0;
			while (cin.hasNextInt()) {
				n = cin.nextInt();
				ConstruteQueue(n);
			}
		}
		cin.close();
	}

	public static void ConstruteQueue(int n) {
		Queue<Integer> queue1 = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			queue1.offer(i + 1);
		}

		Queue<Integer> queue2 = new LinkedList<Integer>();

		while (!queue1.isEmpty()) {
			int x = queue1.peek(); // 取出当前队头的值x
			queue1.poll(); // 弹出当前队头
			queue1.offer(x); // 把x放入队尾
			x = queue1.peek(); // 取出这时候队头的值
			queue2.add(x);
			queue1.poll(); // 弹出这时候的队头
		}

		while (!queue2.isEmpty()) {
			System.out.print(queue2.poll() + " ");
		}
		System.out.println();
	}
}

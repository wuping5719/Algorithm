package swordOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

/** 
 * @author  WuPing
 * @date 2016年8月28日 下午11:15:40 
 * @version 1.0 
 */
public class MaxInSlidingWindow_65 {

	// 方法一
	/**  用一个双端队列, 队列第一个位置保存当前窗口的最大值, 当窗口滑动一次
	 *    1.判断当前最大值是否过期;
	 *    2.新增加的值从队尾开始比较, 把所有比他小的值丢掉.
	 */
	public ArrayList<Integer> maxInWindows(int[] num, int size)
    {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (size == 0)
			return result;

		int begin;
		ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
		for (int i = 0; i < num.length; i++) {
			begin = i - size + 1;
			if (deq.isEmpty())
				deq.add(i);
			else if (begin > deq.peekFirst())
				deq.pollFirst();

			while ((!deq.isEmpty()) && num[deq.peekLast()] <= num[i])
				deq.pollLast();
			deq.add(i);
			if (begin >= 0)
				result.add(num[deq.peekFirst()]);
		}
		return result;
    }
	
	// 方法二
	public ArrayList<Integer> maxInWindows2(int[] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null) {
            return result;
        }
        if (num.length < size || size < 1) {
            return result;
        }
         
        LinkedList<Integer> indexDeque = new LinkedList<Integer>();
        for (int i = 0; i < size - 1; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
        }
         
        for (int i = size - 1; i < num.length; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
            if (i - indexDeque.getFirst() + 1 > size) {
                indexDeque.removeFirst();
            }
            result.add(num[indexDeque.getFirst()]);
        }
        return result;
    }
	
	public static void main(String[] args) {
		
	}

}

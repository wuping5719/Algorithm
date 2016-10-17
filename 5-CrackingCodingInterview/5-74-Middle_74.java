package crackingCodingInterview;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月17日 下午9:55:01
 */

public class Middle_74 {
    //插入排序
    public static int[] getMiddle(int[] A, int n) {
        int[] result = new int[n];
        result[0] = A[0];
        for (int i = 1; i < n; i++) {
           int k = i-1;
           int temp = A[i];
           while(k >= 0 && A[k] > temp){
               A[k+1] = A[k];
               k--;
           }
           A[++k] = temp;
           result[i] = A[i/2];
       }
        return result;
    }
    
    
    /*
     * 建立最大最小堆, 具体步骤如下:
     1. 最大堆中存放比最小堆中小的元素.
     2. 如果最大堆中队头的元素大于最小堆的元素, 则交换
     3. i为奇数时存入最小堆, 否则在最大堆中.
    */
    public static int[] getMiddle2(int[] A, int n) {
	if (A == null || n < 1)
	    return null;
	int[] result = new int[n];
	Comparator<Integer> cmp = new Comparator<Integer>() {
	    @Override
	    public int compare(Integer i1, Integer i2) {
		return i2.compareTo(i1);
	    }
	};
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(n, cmp);
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(n);

	for (int i = 0; i < n; i++) {
	    maxHeap.offer(A[i]);
	    if (i % 2 == 1) {
		minHeap.offer(maxHeap.poll());
	    } else {
		if (!minHeap.isEmpty()) {
		    if (maxHeap.peek() > minHeap.peek()) {
			Integer ma = maxHeap.poll();
			Integer mi = minHeap.poll();
			maxHeap.offer(mi);
			minHeap.offer(ma);
		    }
		}
	    }
	    result[i] = maxHeap.peek();
	}
	return result;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[] A = new int[n];
	    for(int i=0; i<n; i++) {
		A[i] = cin.nextInt();
	    }
	    
	    int[] result = getMiddle(A, n);
	    for(int i=0; i<n; i++) {
		System.out.print(result[i] + " ");
	    }
	    System.out.println();
	}
	cin.close();
    }

}

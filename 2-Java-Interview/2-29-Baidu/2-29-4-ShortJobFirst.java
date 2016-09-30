package acmCoder;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月30日 下午4:25:32
 */

public class ShortJobFirst {

    /* 权重轮询调度算法(WeightedRound-RobinScheduling): http://www.cnblogs.com/huligong1234/p/3862665.html
     * 短作业优先调度算法(Short Job First): http://blog.csdn.net/a987073381/article/details/52089927
     * 短作业优先调度算法(Short Job First)用于进程调度时又被称为短进程优先调度算法(Short Process First)，该算法既可以用于作业调度，又可以用于进程调度。 
              在作业调度中，该算法每次从后备作业队列中挑选估计服务时间最短的一个或几个作业，将他们调入内存，分配必要的资源，创建进程并放入就绪队列。在进程调度中的原理类似。
                   问题描述:
                   假设有n项作业位于就绪队列中，这些作业的提交时间用数组arrival按照提交时间的先后顺序存储，对应的作业服务时间（持续时间）用数组run存储。
                   采用SJF算法，计算n项作业的平均等待时间。当存在多个相同长度的短作业时，按照提交时间的先后顺序进行调度。
                   假设0<= n <= 100。
    */
    public static float minWaitTimeOfSJF(int[] arrival, int[] run) {
	Queue<Integer> waitQueue = new LinkedList<Integer>(); // 等待队列: 存放还没运行的任务
	Queue<Integer> taskQueue = new LinkedList<Integer>(); // 任务队列: 存放正在运行的任务

	int n = arrival.length; // 作业数
	int[] predictEndTime = new int[n]; // 预计结束的时间
	int[] actualEndTime = new int[n]; // 实际结束的时间
	int curTime = 0;
	for (int i = 0; i < n; i++) {
	    predictEndTime[i] = arrival[i] + run[i];
	    waitQueue.offer(i);
	}

	while (waitQueue.size() != 0 || taskQueue.size() != 0) {
	    // 有新任务到来, 加到任务队列中
	    if (waitQueue.size() > 0 && arrival[(waitQueue.peek())] <= curTime) {
		for (Iterator<Integer> it = waitQueue.iterator(); it.hasNext();) {
		    int i = it.next();
		    if (arrival[i] <= curTime) {
			taskQueue.offer(i);
			it.remove();
		    } else {
			break;
		    }
		}
	    }
	    // 任务队列有任务, 执行任务
	    else if (taskQueue.size() > 0) {
		int minIndex = taskQueue.iterator().next();
		for (Iterator<Integer> jt = taskQueue.iterator(); jt.hasNext();) {
		    int j = jt.next();
		    if (run[j] < run[minIndex]) // 记录下用时最少的
		    {
			minIndex = j;
		    }
		}
		curTime += run[minIndex]; // 执行任务
		actualEndTime[minIndex] = curTime; // 记录下实际完成时间
		taskQueue.remove(minIndex);
	    }
	    // 如果任务队列里没任务, 等待队列里有任务但未到来
	    else {
		curTime++;
	    }
	}

	float minWaitTime = 0.0f;
	float sumTime = 0.0f;
	for (int i = 0; i < n; i++) {
	    // 等待时间 = 实际结束时间 - 预计结束时间
	    sumTime = sumTime + actualEndTime[i] - predictEndTime[i];
	}
	minWaitTime = sumTime / arrival.length;

	return minWaitTime;
    }

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str1 = cin.nextLine();
	    String str2 = cin.nextLine();

	    String[] str1Array = str1.split(" ");
	    int[] arrival = new int[str1Array.length];
	    for (int i = 0; i < str1Array.length; i++) {
		arrival[i] = Integer.parseInt(str1Array[i]);
	    }

	    String[] str2Array = str2.split(" ");
	    int[] run = new int[str2Array.length];
	    for (int i = 0; i < str2Array.length; i++) {
		run[i] = Integer.parseInt(str2Array[i]);
	    }

	    float averageWaitingTime = minWaitTimeOfSJF(arrival, run);
	    System.out.println(averageWaitingTime);
	}
	cin.close();
    }

}

package acmCoder;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月29日 下午10:49:19
 */

public class RoundRobin {
    
   /* 轮询调度算法: http://blog.csdn.net/a987073381/article/details/52089927
             如果一个系统可以在单个CPU上运行多个并发作业，那么就该系统而言，“调度”是指：系统选择运行哪些任务，何时运行，何时中断以及以何种方式运行或中断。
        轮询调度规则是指：每个作业运行时间固定，该作业结束后，切换到下一个作业。一个作业的等待时间是指运行前需要等待的总时间。
        每个作业会在特定时间到达，等待调度，并占用一段固定时间运行。新作业到达后系统会把该作业正在等待CPU的现有作业之后。
            题目描述：
            给定提交列表，使用轮询策略计算所有作业的平均等待时间。函数waitTimeOfRoundRobin包含两个含有作业到达时间arrival和作业运行时间run的整数数组，一个表示轮询策略使用的固定时长得整数q。
            作业到达时间和作业运行时间根据作业到达时间升序排列。对于同时到达的作业，按照其在到达时间数组中的顺序处理，可以假设，作业到达时，CPU一直未空闲。返回值为使用轮询策略算出的作业平均等待时间（浮点数）。
            假设 0 <= 作业到达时间 < 100 且 0  < 作业运行时间 < 100。
    */
    public static float waitTimeOfRoundRobin(int[] arrival, int[] run, int q) {
	Queue<Integer> waitQueue = new LinkedList<Integer>(); // 等待队列: 存放还没运行的任务
	Queue<Integer> taskQueue = new LinkedList<Integer>(); // 任务队列: 存放正在运行的任务

	int n = arrival.length; // 作业数
	int curTime = 0;
	int[] predictEndTime = new int[n]; // 预计结束的时间
	int[] actualEndTime = new int[n]; // 实际结束的时间
	int[] runTime = new int[n];

	for (int i = 0; i < n; i++) {
	    predictEndTime[i] = arrival[i] + run[i];
	    waitQueue.offer(i);
	    runTime[i] = run[i];
	}

	while (waitQueue.size() != 0 || taskQueue.size() != 0) {
	    for (Iterator<Integer> it = waitQueue.iterator(); it.hasNext();) { 
                int i = it.next();
		if (arrival[i] <= curTime) {
		    taskQueue.offer(i); // 如果有任务到来, 则把该任务从等待队列转到任务队列
		    it.remove();
		}
	    }

	    // 正在运行的任务队列里没有任务, 等待队列里还有任务, 但是新任务还没来
	    if (waitQueue.size() > 0 && taskQueue.size() == 0) {
		curTime++;
	    }

	    // 依次处理任务队列的任务
	    for (Iterator<Integer> jt = taskQueue.iterator(); jt.hasNext();) { 
		int j = jt.next();
		// 该任务剩余运行时间大于调度时间
		if (runTime[j] > q) {
		    curTime += q;
		    runTime[j] -= q;
		}
		// 该任务剩余运行时间小于于调度时间
		else {
		    curTime += runTime[j];
		    runTime[j] = 0;
		    actualEndTime[j] = curTime; // 记录下该任务实际完成时间
		}

		jt.remove(); // 当前任务已经运行过, 从队头移除
		for (Iterator<Integer> it = waitQueue.iterator(); it.hasNext();) { 
	            int i = it.next();
		    if (arrival[i] <= curTime) {
			taskQueue.offer(i);
			it.remove();
		    }

		    // 当前任务还没运行完
		    if (runTime[j] > 0) {
			taskQueue.offer(j); // 添加到任务队列后面
		    }
		    jt = taskQueue.iterator();
		}
	    }
	}

	float averageWaitingTime = 0.0f;
	float sumTime = 0.0f;
	for (int i = 0; i < n; i++) {
	    // 等待时间 = 实际结束时间 - 预计结束时间
	    sumTime = sumTime + actualEndTime[i] - predictEndTime[i];
	}
	averageWaitingTime = sumTime / arrival.length;

	return averageWaitingTime;
    }

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str1 = cin.nextLine();
	    String str2 = cin.nextLine();
	    String str3 = cin.nextLine();

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

	    int q = Integer.parseInt(str3);
	    float averageWaitingTime = waitTimeOfRoundRobin(arrival, run, q);
	    System.out.println(averageWaitingTime);
	}
	cin.close();
    }

}

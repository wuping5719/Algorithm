package leetcode;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月26日 下午8:46:53
 */

public class GasStation_18 {

    // 从start出发, 如果油量足够, 可以一直向后走 end++;  
    // 油量不够的时候, start向后退, 最终 start == end的时候, 如果有解一定是当前 start所在位置.
    public static int canCompleteCircuit(int[] gas, int[] cost) {
	if (gas == null || cost == null || gas.length != cost.length) {
	    return -1;
	}
	int start = gas.length-1;
	int end = 0;
        int sum = gas[start] - cost[start];
        while(start > end){
            if(sum >= 0){
                sum += gas[end] - cost[end];
                ++end;
            }else{
                --start;
                sum += gas[start] - cost[start];
            }
        }
        return sum >=0 ? start : -1;
    }
 
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[] gas = new int[n];
	    int[] cost = new int[n];
	    for(int i=0; i<n; i++) {
		gas[i] = cin.nextInt();
		cost[i] = cin.nextInt();
	    }
	    System.out.println(canCompleteCircuit(gas, cost));
	}
	cin.close();
    }

}

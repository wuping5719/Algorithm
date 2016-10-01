package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月1日 下午8:51:41
 */

public class Chorus_24 {

    // 基本思路, 两遍最长递增子序列, 并找和最大
    /* 首先计算每个数在最大递增子串中的位置
       186  186  150  200  160  130  197  200   quene
        1    1    1    2    2    1    3    4    递增计数
                  后计算每个数在反向最大递减子串中的位置->计算反向后每个数在最大递增子串中的位置
       200  197  130  160  200  150  186  186   反向quene
        1    1    1    2    3    2    3    3    递减计数
                 然后将每个数的递增计数和递减计数相加
       186  186  150  200  160  130  197  200   quene
        1    1    1    2    2    1    3    4    递增计数
        3    3    2    3    2    1    1    1    递减计数
        4    4    3    5    4    2    4    5    每个数在所在队列的人数+1（自己在递增和递减中被重复计算）
                如160这个数
                在递增队列中有2个人数
       150  160
                在递减队列中有2个人数
       160  130
                那么160所在队列中就有3个人
       150  160  130
                每个数的所在队列人数表达就是这个意思
                总人数 - 该数所在队列人数 = 需要出队的人数
     */
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[] height1 = new int[n];
	    for(int i=0; i<n; i++) {
		height1[i] = cin.nextInt();
	    }
	    
            // 第一遍dp
	    int[] incQuene = new int[n];  //递增计数
	    incQuene[0] = 1;
            for(int i = 1; i < n; i++){
        	incQuene[i] = 1;
                for(int j = 0; j < i; j++){
                    if(height1[j] < height1[i] && incQuene[j] + 1 > incQuene[i]){
                	incQuene[i] = incQuene[j] + 1;
                    }
                }
            }
            
            // 第二遍dp, 逆序
            int[] tempDecQuene = new int[n];  
            int[] decQuene = new int[n];  //递减计数
            int[] height2 = new int[n];
            int index = 0;
            for (int i = n-1; i >= 0; i--) {
        	height2[index] = height1[i];
        	index++;
            }
            tempDecQuene[0] = 1;
            for(int i = 1; i < n; i++){
        	tempDecQuene[i] = 1;
                for(int j = 0; j < i; j++){
                    if(height2[j] < height2[i] && tempDecQuene[j] + 1 > tempDecQuene[i]){
                	tempDecQuene[i] = tempDecQuene[j] + 1;
                    }
                }
            }
            int count = 0;
            for (int i = n-1; i >= 0; i--) {
        	decQuene[count] = tempDecQuene[i];
        	count++;
            }
            
            int temp = 0;
            for(int i = 0; i < n; i++){
                if(incQuene[i] + decQuene[i] - 1 > temp) {
                    temp = incQuene[i] + decQuene[i] - 1;
                }
            }
            
            System.out.println(n-temp);
	}
	cin.close();
    }

}

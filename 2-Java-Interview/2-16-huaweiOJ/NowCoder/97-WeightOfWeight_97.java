package huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月6日 下午8:30:18
 */

public class WeightOfWeight_97 {

    /*思路：
                输入砝码种类n;
                输入砝码质量w[i];
                输入砝码个数c[i]；
                输出: 可以拼凑的质量个数
         w1  w2  w3  w4  ......  wn
         c1  c2  c3  c4  ......  cn
               对于前i个砝码：
        (不同质量为Q[i])则 Q[i]=Q[i-1]+k*w[i] (0<=k<=c[i]);   
         Q[i]在Q[i-1]的基础上, 对Q[i-1]个不同的重量, 分别添加k个砝码i;
               在添加的过程中去除重复情况
        c[i]表示N个不同砝码相应的数量  c[1~~n];
               则(结果):Q[i]=(Q[i-1]+k*w[i])  (去除)添加过程中重复的个数
    */
    
    public static int getWeightNum(int n, int[] weights, int[] numbers) {
	HashSet<Integer> set = new HashSet<Integer>();
        if(n > 0) {
            for(int i=0; i<=numbers[0]; i++) {
                set.add(i*weights[0]);
            } 
            for(int i=1; i<n; i++){  //从第二个砝码开始
                ArrayList<Integer> list = new ArrayList<Integer>(set);
                for(int j=1; j<=numbers[i]; j++){ //遍历砝码的个数
                    for(int k=0; k<list.size(); k++) {
                        set.add(list.get(k) + j*weights[i]);
                    } 
                }
            } 
        }
	
        return set.size();
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            int n = cin.nextInt();  //砝码种类
            int[] weights = new int[n];
            int[] numbers = new int[n];
            for(int i=0; i<n; i++) {
        	weights[i]=cin.nextInt();
            }
            for(int i=0; i<n; i++) {
        	numbers[i]=cin.nextInt();
            }
            int result = getWeightNum(n, weights, numbers);
            System.out.println(result);
        }
        cin.close();
    }

}

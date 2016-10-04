package huawei;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author WuPing
 * @version 2016年10月4日 下午3:21:54
 */

public class ArrivalOfTrains_53 {

    private static void permutation(int[] arrival, int start, int n, ArrayList<int[]> result){
        if(start == n){
            return;
        }
        if(start == n-1){
            int[] B = arrival.clone();
            result.add(B);
            return;
        }
        for(int i=start; i<n; i++){
            swap(arrival, start, i);
            permutation(arrival, start+1, n, result);
            swap(arrival, start, i);
        }
         
    }
    
    private static void swap(int[] arrival, int i, int j){
        int temp = arrival[i];
        arrival[i] = arrival[j];
        arrival[j] = temp;
    }
    
    private static boolean isLegal(int[] in, int[] out, int n){
        Stack<Integer> stack = new Stack<Integer>();
        int inIndex = 0;
        int outIndex = 0;
        while(inIndex < n){    // in还有元素的时候都需要判断
            if(in[inIndex] == out[outIndex]){  // 相等时候就不用入栈, 直接后移
        	inIndex++;
                outIndex++;
            }else{
                if(stack.isEmpty()){  //stack空, 入栈
                    stack.push(in[inIndex]);
                    inIndex++;
                }else{
                    int top = stack.peek(); // 栈顶元素相等, 进行出栈
                    if(top == out[outIndex]){
                	outIndex++;
                        stack.pop();
                    }else if(inIndex < n){   // 不等时入栈
                        stack.push(in[inIndex]);
                        inIndex++;
                    }
                }
            }
        }
        
        // in的结束后, 栈中元素出栈序列应该和out剩余的元素相同
        while(!stack.isEmpty() && outIndex < n){  
            int top = stack.pop();
            if(top == out[outIndex]){
        	outIndex++;
            }else{
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            int n = cin.nextInt();
            int[] arrival = new int[n];
            for(int i=0; i<n; i++){
        	arrival[i] = cin.nextInt();
            }
            
            ArrayList<int[]> result = new ArrayList<int[]>();
             
            permutation(arrival, 0, n, result);  //求出所有排列
            
            TreeSet<String> treeSort = new TreeSet<String>();
             
            for(int[] out: result){
                if(isLegal(arrival, out, n)){
                    StringBuffer sb = new StringBuffer();
                    for(int i=0; i<n-1; i++){
                       sb.append(out[i]+" ");
                    }
                    sb.append(out[n-1]);
                    treeSort.add(sb.toString());
                }
            }
            
            for(String str: treeSort){
                System.out.println(str);
            }
        }
        cin.close();
    }

}

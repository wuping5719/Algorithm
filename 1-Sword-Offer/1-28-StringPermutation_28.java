package swordOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年8月25日 上午10:44:48
 */

public class StringPermutation_28 {

    public static ArrayList<String> Permutation(String str) {
	ArrayList<String> result = new ArrayList<String>();
	if (str != null && str.length() > 0) {
            char[] sequence = str.toCharArray();
            Arrays.sort(sequence); //排列
            result.add(String.valueOf(sequence)); //先输出一个解
 
            int len = sequence.length;
            while (true) {
                int p = len - 1, q;
                
                //从后向前找一个sequence[p - 1] < sequence[p]
                while (p >= 1 && sequence[p - 1] >= sequence[p]) { 
                    p--;
                }
                if (p == 0) {
                    break; //已经是“最小”的排列，退出
                }
                
                //从p向后找最后一个比sequence[p]大的数
                q = p; 
                p--;
                while (q < len && sequence[q] > sequence[p]) { 
                    q++;
                }
                q--;
                
                //交换这两个位置上的值
                swap(sequence, q, p);
                
                //将p之后的序列倒序排列
                reverse(sequence, p + 1);
                
                result.add(String.valueOf(sequence));
            }
        }
 
        return result;
    }
    
    public static void reverse(char[] sequence, int start) {
        int length = sequence.length;
        if(sequence == null || length <= start)
            return;
        for (int i = 0; i < ((length - start) >> 1); i++) {
            int p = start + i;
            int q = length - 1 - i;
            if (p != q) {
        	 swap(sequence, p, q);
            }
        }
    }
     
    public static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
    
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String str = scanner.nextLine();
       ArrayList<String> result = new ArrayList<String>();
       result = Permutation(str);
       for(int i=0; i<result.size(); i++) {
	   System.out.println(result.get(i));
       }
       scanner.close();
    }

}

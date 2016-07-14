
package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** 
 * @author  WuPing
 * @date 2016年4月10日 下午3:39:06 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class RadixSort {
	public static void radixSort(int[] array) {
        if(array != null && array.length != 0){
        	int maxBit = getMaxBit(array);
            for(int i=1; i<=maxBit; i++) {
                List<List<Integer>> buf = distribute(array, i);  //分配
                collecte(array, buf); //收集
            }
        }
    }
    
    /**
     * 分配
     * @param array 待分配数组
     * @param iBit 要分配第几位
     * @return
     */
    public static List<List<Integer>> distribute(int[] array, int iBit) {
        List<List<Integer>> buf = new ArrayList<List<Integer>>();
        for(int j=0; j<10; j++) {
            buf.add(new LinkedList<Integer>());
        }
        for(int i=0; i<array.length; i++) {
            buf.get(getNBit(array[i], iBit)).add(array[i]);
        }
        return buf;
    }
    
    /**
     * 收集
     * @param array 把分配的数据收集到array中
     * @param buf 
     */
    public static void collecte(int[] array, List<List<Integer>> buf) {
        int k = 0;
        for(List<Integer> bucket : buf) {
            for(int element : bucket) {
            	array[k++] = element;
            }
        }
    }
    
    /**
     * 获取最大位数
     * @param x
     * @return
     */
    public static int getMaxBit(int[] array) {
        int max = Integer.MIN_VALUE;
        for(int element : array) {
            int len = (element+"").length();
            if(len > max)
                max = len;
        }
        return max;
    }
    
    /**
     * 获取x的第n位，如果没有则为0.
     * @param x
     * @param n
     * @return
     */
    public static int getNBit(int x, int n) {
        String sx = x + "";
        if(sx.length() < n)
            return 0;
        else
            return sx.charAt(sx.length()-n) - '0';
    }
}


package sort;

import java.util.Arrays;

/** 
 * @author  WuPing
 * @date 2016年4月10日 上午10:57:32 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class CountSort {
	public static void countSort(int[] array) {  
        if(array != null && array.length != 0) {
        	int max = max(array);  
            int[] count = new int[max+1];  
            Arrays.fill(count, 0);  
            for(int i=0; i<array.length; i++) {  
                count[array[i]] ++;  
            }  
            int k = 0;  
            for(int i=0; i<=max; i++) {  
                for(int j=0; j<count[i]; j++) {  
                	array[k++] = i;  
                }  
            }     
        }
    }  
      
    public static int max(int[] array) {  
        int max = Integer.MIN_VALUE;  
        for(int element : array) {  
            if(element > max)  
                max = element;  
        }   
        return max;  
    }  
}

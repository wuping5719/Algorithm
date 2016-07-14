
package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/** 
 * @author  WuPing
 * @date 2016年4月10日 下午3:20:43 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class BucketSort {
	
	static int BucketNums = 10;    //这里默认为10，规定待排数[0,100) 
	
	public static void bucketSort(int[] array) {  
        if(array != null && array.length != 0){  
            List<List<Integer>> buckets = new ArrayList<List<Integer>>();  //桶的索引  
              
            for(int i=0; i<10; i++) {  
                buckets.add(new LinkedList<Integer>());  //用链表比较合适  
            }  
              
            //划分桶  
            for(int i=0; i<array.length; i++) {  
                buckets.get(f(array[i])).add(array[i]);  
            }  
              
            //对每个桶进行排序  
            for(int i=0; i<buckets.size(); i++) {  
                if(!buckets.get(i).isEmpty()) {  
                    Collections.sort(buckets.get(i));  //对每个桶进行快排  
                }  
            }  
              
            //还原排好序的数组  
            int k = 0;  
            for(List<Integer> bucket : buckets) {  
                for(int element : bucket) {  
                    array[k++] = element;  
                }  
            }  
        }
    }  
      
    /** 
     * 映射函数 
     * @param x 
     * @return 
     */  
    public static int f(int x) {  
        return x / BucketNums;  
    }  
}


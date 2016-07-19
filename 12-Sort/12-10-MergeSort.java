package sort;
/** 
 * @author  WuPing
 * @date 2016年4月10日 上午10:29:06 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class MergeSort {
    public static void mergeSort(int[] array) {  
       mSort(array, 0, array.length-1);  
    }  
  
    /** 
     * 递归分治 
     * @param array 待排数组 
     * @param left 左指针 
     * @param right 右指针 
     */  
    public static void mSort(int[] array, int left, int right) {  
        if(left < right)  {
        	int mid = (left + right) / 2;  
            mSort(array, left, mid);  //递归排序左边  
            mSort(array, mid+1, right);  //递归排序右边  
            merge(array, left, mid, right);  //合并  
        }
    }  
      
    /** 
     * 合并两个有序数组 
     * @param array 待合并数组 
     * @param left 左指针 
     * @param mid 中间指针 
     * @param right 右指针 
     */  
    public static void merge(int[] array, int left, int mid, int right) {    
        int[] temp = new int[right - left + 1];  //中间数组  
          
        int i = left;  
        int j = mid + 1;  
        int k = 0;  
        while(i <= mid && j <= right) {  
        	temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }  
          
        while(i <= mid) {  
            temp[k++] = array[i++];  
        }  
          
        while(j <= right) {  
            temp[k++] = array[j++];  
        }  
          
        for(int p=0; p<temp.length; p++) {  
        	array[left + p] = temp[p];  
        }  
    }  
}

package sort;
/** 
 * @author  WuPing
 * @date 2016年4月4日 下午10:45:09 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class HeapSort {
	
	public static void swap(int[] array, int i, int j) {  
           int temp = array[i];  
           array[i] = array[j];  
           array[j] = temp;  
        } 
	
	/** 
     * 堆筛选，除了start之外，start~end均满足大顶堆的定义。 
     * 调整之后start~end称为一个大顶堆。 
     * @param arr 待调整数组 
     * @param start 起始指针 
     * @param end 结束指针 
     */  
    public static void heapAdjust(int[] array, int start, int end) {  
        int temp = array[start];  
        for(int i=2*start+1; i<=end; i*=2) {  
            //左右孩子的节点分别为2*i+1,2*i+2  
            //选择出左右孩子较小的下标  
            if(i < end && array[i] < array[i+1]) {  
                i++;   
            }  
            if(temp >= array[i]) {  
                break;  //已经为大顶堆，保持稳定性。  
            }  
            array[start] = array[i];  //将子节点上移  
            start = i;  //下一轮筛选  
        }  
        array[start] = temp; //插入正确的位置  
    }  
  
    public static void heapSort(int[] array) {  
        if(array != null && array.length != 0) {  
        	//建立大顶堆  
            for(int i=array.length/2; i>=0; i--) {  
                heapAdjust(array, i, array.length-1);  
            }  
            for(int i=array.length-1; i>=0; i--) {  
                swap(array, 0, i);  
                heapAdjust(array, 0, i-1);  
            }    
        }
    }  
}

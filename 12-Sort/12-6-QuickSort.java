package sort;
/** 
 * @author  WuPing
 * @date 2016年4月2日 下午11:57:28 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class QuickSort {
	//一次划分
	public static int partition(int[] array, int left, int right) {
        int pivotKey = array[left];
        while(left < right) {
            while(left < right && array[right] >= pivotKey)
                right --;
            array[left] = array[right];    //把小的移动到左边
            while(left < right && array[left] <= pivotKey)
                left ++;
            array[right] = array[left];    //把大的移动到右边
        }
        array[left] = pivotKey;  //最后把pivot赋值到中间
        return left;
    }
    
    //递归划分子序列
    public static void quickSort(int[] array, int left, int right) {
        if(left >= right)
            return ;
        int pivotPos = partition(array, left, right);
        quickSort(array, left, pivotPos-1);
        quickSort(array, pivotPos+1, right);
    }
    
    public static void sort(int[] array) {
        if(array != null && array.length != 0){
          quickSort(array, 0, array.length-1);
        }
    }
	
}

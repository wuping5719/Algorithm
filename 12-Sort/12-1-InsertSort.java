package sort;
/** 
 * @author  WuPing
 * @date 2016年4月2日 下午11:44:26 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class InsertSort {
	public static void insertSort(int[] array) {
		if (array != null && array.length != 0) {
			//假设第一个数位置时正确的；要往后移，必须要假设第一个。 
			for (int i = 1; i < array.length; i++) {   
				int j = i;
				int target = array[i];
				//后移  
	            while(j > 0 && target < array[j-1]) {  
	            	array[j] = array[j-1];  
	                j--;  
	            }  
	            //插入   
	            array[j] = target; 
			}
		}
	}
}

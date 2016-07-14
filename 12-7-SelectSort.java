
package sort;
/** 
 * @author  WuPing
 * @date 2016年4月2日 下午10:58:52 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class SelectSort {

	public static void selectSort(int[] array){
		if(array!=null&&array.length!=0){
		  int minIndex=0;
		  for(int i=0; i<array.length-1; i++){ //只需要比较n-1次  
			 minIndex=i;
			 for(int j=i+1; j<array.length; j++){  //从i+1开始比较，因为minIndex默认为i了，i就没必要比了。 
				 if(array[j]<array[minIndex]){
					minIndex=j;
				 }
			 }
			 if(minIndex!=i){  //如果minIndex不为i，说明找到了更小的值，交换之。  
				 int temp = array[i];
				 array[i] = array[minIndex];
				 array[minIndex] = temp;
			 } 
	     }
	   }
	}
}


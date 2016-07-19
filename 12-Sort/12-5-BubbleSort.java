package sort;

/** 
 * @author  WuPing
 * @date 2016年4月2日 下午9:40:44 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */

public class BubbleSort {

   public static void bubbleSort(int[] array)
   {
	   if(array!=null&&array.length!=0){
	     for(int i=0; i<array.length-1; i++){
		     for(int j=array.length-1; j>i; j--){
			    if(array[j]<array[j-1]){
				   int temp = array[j];
				   array[j] = array[j-1];
				   array[j-1] = temp;
			    }
		    }
	     }
	   }
   }
}

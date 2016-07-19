package sort;
/** 
 * @author  WuPing
 * @date 2016年4月10日 下午6:48:37 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class BinaiSort {
   //array为已排序的数组，i为待插入的记录，length为已排序数组的长度
   public static void binaiPass(int[] array, int i, int length){
	   int insertNote = i;  //设置监视哨
	   int low = 0;     //初始化搜索的边界
	   int high = length;
	   
	   //查找待插入位置
	   while(low<=high){
		   int mid = (low+high)/2;    //找出中间值
		   if(insertNote>array[mid])  //在大于中间值的那部分查找
		       low = mid + 1;
		   else                       
			   high = mid - 1;        //在小于中间值的那部分查找
	   }
	   
	   //后移插入位置后的记录，留出空位
	   for(int j=length+1; j>low; j--){
		   array[j]=array[j-1];
	   }
	   //将记录插入到适当的位置
	   array[low]=insertNote;
   }
   
   public static void binaiSort(int[] array){
	   if (array != null && array.length != 0) {
		   for(int i=1; i<array.length; i++){
			   binaiPass(array, array[i], i-1);
		   }
	   }
   }
}

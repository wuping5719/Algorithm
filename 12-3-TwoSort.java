
package sort;

/**
 * @author WuPing
 * @date 2016年4月10日 下午10:03:45
 * @version 1.0
 * @parameter
 * @since
 * @return 
 */
public class TwoSort {
	public static void twoSort(int[] array) {
		if (array == null || array.length == 0) 
			return;
		
		int first = 0; 
		int last = 0;
		int length = array.length;
		int[] aim = new int[length];
		aim[0] = array[0];
		for (int i = 1; i < length; i++) {
			if (array[i] < aim[first]) {      //小于当前最小值,前插  
				first = (first - 1 + length) % length;
				aim[first] = array[i];
			} else if (array[i] > aim[last]) {  //大于当前最大值,后插  
				last++;
				aim[last] = array[i];
			} else {   //大于当前最小值，小于当前最大值，中间插  
				int low, high, mid, n;
				low = first;
				high = last;
				while (low != high)  //折半查找
				{
					n = (high - low + length) % length;  //元素个数
					mid = (low + n / 2) % length; // 中间位置
					if (array[i] < aim[mid])
						high = mid;
					else
					    low = (mid + 1) % length;
				}
				for (int j = last + 1; j != low; j = (j - 1 + length) % length){
					// 移动元素
					aim[j] = aim[(j - 1 + length) % length];
				}
				aim[low] = array[i];
				last++;
			}
		}
		//将已排好序的数组复制到原数组
		for (int i = 0; i < length; i++) {
			array[i] = aim[(i + first) % length];
		}
	}
}


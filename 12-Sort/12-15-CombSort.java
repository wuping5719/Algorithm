package sort;

/**
 * @author WuPing
 * @version 2017年2月25日 上午10:43:56
 */

public class CombSort {
    // 梳排序
    public static void combSort(int[] array) {
	if (array != null && array.length != 0) {
	    int n = array.length - 1;
	    int j = n;
	    double s = 1.3;
	    boolean flag = false;
	    while(j > 1 || flag == true) {
		int i = 0;
		j = (int) Math.max(Math.floor(j / s), 1);
		flag = false;
		while((i + j) <= n) {
		    if(array[i] > array[i + j]) {
			int temp = array[i];
			array[i] = array[i + j];
			array[i + j] = temp;
			flag = true;
		    }
		    i = i + 1;
		}
	    }
	}
    }
}

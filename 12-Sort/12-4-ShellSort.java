package sort;

/**
 * @author WuPing
 * @date 2016年4月10日 上午10:06:29
 * @version 1.0
 * @parameter d 增量
 * @since
 * @return
 */
public class ShellSort {
	public static void shellPass(int[] array, int d) {
		for (int i = d; i < array.length; i++) {
			int j = i - d;
			int temp = array[i]; // 记录要插入的数据
			while (j >= 0 && array[j] > temp) { // 从后向前，找到比其小的数的位置
				array[j + d] = array[j]; // 向后挪动
				j -= d;
			}
			if (j != i - d) // 存在比其小的数
				array[j + d] = temp;
		}
	}

	public static void shellSort(int[] array) {
		if (array != null && array.length != 0) {
			int d = array.length / 2;
			while (d >= 1) {
				shellPass(array, d);
				d /= 2;
			}
		}
	}
}

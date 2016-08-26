package swordOffer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author WuPing
 * @date 2016年8月26日 下午10:18:48
 * @version 1.0
 */
public class TwoNumbersWithSum_41_1 {

	public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (array == null || array.length < 2) {
			return list;
		}

		int head = 0;
		int behind = array.length - 1;
		while (head < behind) {
			long currentSum = array[head] + array[behind];

			if (currentSum == sum) {
				list.add(array[head]);
				list.add(array[behind]);
				return list;
			} else if (currentSum < sum) {
				head++;
			} else {
				behind--;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int sum = scanner.nextInt();
		if (str != null && !str.trim().equals("")) {
			String[] arrayStr = str.split(",");
			int[] array = new int[arrayStr.length];
			for (int i = 0; i < arrayStr.length; i++) {
				array[i] = Integer.parseInt(arrayStr[i]);
			}

			ArrayList<Integer> list = new ArrayList<Integer>();
			list = FindNumbersWithSum(array, sum);
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
		}

		scanner.close();
	}

}

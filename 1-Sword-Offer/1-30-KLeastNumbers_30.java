package swordOffer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author WuPing
 * @date 2016年8月25日 下午6:56:38
 * @version 1.0
 */
public class KLeastNumbers_30 {
	public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		if (input == null || input.length <= 0 || k > input.length || k <= 0) {
			System.out.println("输入非法!");
			return output;
		}

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < input.length - i - 1; j++) {
				if (input[j] < input[j + 1]) {
					int temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
				}
			}
			output.add(input[input.length - i - 1]);
		}

		return output;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int k = scanner.nextInt();
		if (str == null || str.trim().equals("")) {
			System.out.println("输入非法！");
		}
		String[] arrayStr = str.split(",");
		int[] array = new int[arrayStr.length];
		for (int i = 0; i < arrayStr.length; i++) {
			array[i] = Integer.parseInt(arrayStr[i]);
		}

		ArrayList<Integer> result = new ArrayList<Integer>();
		result = GetLeastNumbers_Solution(array, k);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i) + " ");
		}

		scanner.close();
	}

}

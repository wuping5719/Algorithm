package swordOffer;

import java.util.Scanner;

/**
 * @author WuPing
 * @date 2016年8月27日 下午3:40:33
 * @version 1.0
 */
public class Accumulate_46 {

	public static int Sum_Solution(int n) {
		int sum = n;
		@SuppressWarnings("unused")
		boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
		return sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int sum = Sum_Solution(n);
			System.out.println(sum);
		}

		scanner.close();
	}

}

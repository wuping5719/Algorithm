package swordOffer;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年8月23日 下午5:00:19
 */

public class RectCover_09 {

	public static long RectCover(int target) {
		if (target <= 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		long rectCoverOne = 2;
		long rectCoverTwo = 1;
		long rectCoverN = 0;
		for (int i = 3; i <= target; i++) {
			rectCoverN = rectCoverOne + rectCoverTwo;

			rectCoverTwo = rectCoverOne;
			rectCoverOne = rectCoverN;
		}

		return rectCoverN;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			long result = RectCover(scanner.nextInt());
			System.out.println(result);
		}
		scanner.close();
	}

}

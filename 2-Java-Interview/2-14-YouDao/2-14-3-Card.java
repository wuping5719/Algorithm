package interview.youDao;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author WuPing
 * @date 2016年8月18日 下午10:22:39
 */
public class Card {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int t = 0;
		while (cin.hasNextInt()) {
			t = cin.nextInt();
			int n = 0;
			int k = 0;
			int[] cardData;
			while (cin.hasNextInt()) {
				n = cin.nextInt();
				k = cin.nextInt();
				cardData = new int[n * 2];
				for (int i = 0; i < n * 2; i++) {
					cardData[i] = cin.nextInt();
				}

				shuffleCard(cardData, n, k);
			}
		}
		cin.close();
	}

	public static void shuffleCard(int card[], int n, int k) {
		int cardA[], cardB[];
		cardA = new int[n];
		cardB = new int[n];
		for (int i = 0; i < card.length; i++) {
			if (i < n) {
				cardA[i] = card[i];
			} else {
				cardB[i - n] = card[i];
			}
		}

		Stack<Integer> stack = new Stack<Integer>();
		for (int j = n - 1; j >= 0; j--) {
			stack.push(cardB[j]);
			stack.push(cardA[j]);
		}
		while (!stack.empty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}

}

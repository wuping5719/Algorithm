package swordOffer;

import java.util.Scanner;

/**
 * @author WuPing
 * @date 2016年8月25日 下午11:43:44
 * @version 1.0
 */
public class FirstNotRepeatingChar_35 {

	public static char FirstNotRepeatingChar(String input) {
		char result = '\0';
		if (input == null || input.length() <= 0)
			return result;
		int[] hashTable = new int[256];
		for (int i = 0; i < 256; i++) {
			hashTable[i] = 0;
		}

		char[] inputChar = input.toCharArray();
		for (int i = 0; i < inputChar.length; i++) {
			int asciiChar = (int) inputChar[i];
			hashTable[asciiChar] = hashTable[asciiChar] + 1;
		}

		for (int i = 0; i < inputChar.length; i++) {
			int asciiChar = (int) inputChar[i];
			if (hashTable[asciiChar] == 1) {
				result = (char) asciiChar;
				return result;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String input = scanner.nextLine();
			char result = FirstNotRepeatingChar(input);
			System.out.println(result);

		}

		scanner.close();
	}

}

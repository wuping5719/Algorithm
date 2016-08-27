package swordOffer;

import java.util.Scanner;

/**
 * @author WuPing
 * @date 2016年8月27日 下午4:06:25
 * @version 1.0
 */
public class StringToInt_49 {

	@SuppressWarnings("unused")
	private static boolean g_status = false;

	public static int StrToInt(String str) {
		int num = 0;
		if (str != null && str.length() > 0) {
			boolean minus = false;
			boolean haveSymbol = false;
			char[] numChar = str.toCharArray();
			char[] tempChar = new char[numChar.length - 1];
			if (numChar[0] == '-') {
				minus = true;
				haveSymbol = true;
				for (int i = 1; i < numChar.length; i++) {
					tempChar[i - 1] = numChar[i];
				}
			} else if (numChar[0] == '+') {
				haveSymbol = true;
				for (int i = 1; i < numChar.length; i++) {
					tempChar[i - 1] = numChar[i];
				}
			}

			int nextIndex = 0;
			int length = numChar.length;
			char[] currentChar;
			if (haveSymbol) {
				length = numChar.length - 1;
				currentChar = tempChar;
			} else {
				currentChar = numChar;
			}
			while (nextIndex < length) {
				if (currentChar[nextIndex] >= '0'
						&& currentChar[nextIndex] <= '9') {
					int flag = minus ? -1 : 1;
					num = num * 10 + flag * (currentChar[nextIndex] - '0');

					if ((!minus && num > 0x7FFFFFFF)
							|| (minus && num < 0x80000000)) {
						num = 0;
						g_status = true;
						break;
					}

					nextIndex++;
				} else {
					num = 0;
					g_status = true;
					break;
				}
			}
		}
		return num;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String str = scanner.nextLine();
		int num = StrToInt(str);
		System.out.print(num);

		scanner.close();
	}

}

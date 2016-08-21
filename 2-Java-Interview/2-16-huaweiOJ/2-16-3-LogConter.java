package interview.huawei;

import java.util.*;

/**
 * @author WuPing
 * @date 2016年8月21日 下午8:46:28
 * @version 1.0
 */
public class LogConter {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int x = in.nextInt();
			int count = getCount(x);
			System.out.println(count);
		}

		in.close();
	}

	public static int getCount(int num) {
		int count = 0;
		while (num <= 999999) {
			num++;
			if (num == 1000000) {
				num = 0;
				count++;
				break;
			}
			if (!isPail(num)) {
				count++;
			} else {
				count++;
				break;
			}
		}
		return count;
	}

	public static boolean isPail(int num) {
		if (num <= 9)
			return true;
		int p = 1;
		int x = num;
		while (x > 9) {
			x /= 10;
			p *= 10;
		}
		while (num >= 10) {
			int l = num / p;
			int r = num % 10;
			if (l != r)
				return false;
			num %= p;// 去除第一位数
			num /= 10;// 去除最后一位数
			p = p / 100;
		}
		return true;
	}
}

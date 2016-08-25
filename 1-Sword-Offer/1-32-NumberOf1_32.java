package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月25日 下午8:20:36 
 * @version 1.0 
 */
public class NumberOf1_32 {
    
	// 解法1: leetcode解法-奇妙的解法
	// https://leetcode.com/discuss/44281/4-lines-o-log-n-c-java-python
	public static int NumberOf1Between1AndN_Solution1(int n) {
	    int ones = 0;
	    // m表示当前分析的是哪一个数位
	    for (long m = 1; m <= n; m *= 10)
	        ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
	    return ones;
    }
	
	// 解法2: 将数字转为字符串处理-时间效率不高
	public static int NumberOf1Between1AndN_Solution2(int n) {
		int num = n;
	    int count = 0;   // 计算数字中含有1的数字个数
	    int strLen = 0;  // 每个数字的长度
	    for (int i = 0; i <= num; i++) {
	        String str = String.valueOf(i);
	        strLen = str.length();
	        for (int j = 0; j < strLen; j++) {
	            if (str.charAt(j) == '1') {
	                count++;
	            }
	        }
	    }
	 
	    return count;
	}
	
	// 解法3-递归解法
	public static int NumberOf1Between1AndN_Solution3(int n) {
		if (n < 1)
			return 0;
		int len = getLenOfNum(n);
		if (len == 1)
			return 1;
		int tmp = (int) Math.pow(10, len - 1);
		int first = n / tmp;
		int firstOneNum = first == 1 ? n % tmp + 1 : tmp;
		int otherOneNum = first * (len - 1) * (tmp / 10);
		return firstOneNum + otherOneNum
				+ NumberOf1Between1AndN_Solution3(n % tmp);
	}

	private static int getLenOfNum(int n) {
		int len = 0;
		while (n != 0) {
			len++;
			n /= 10;
		}
		return len;
	}
    
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int result = NumberOf1Between1AndN_Solution2(n);
        //int result = NumberOf1Between1AndN_Solution1(n);
        int result = NumberOf1Between1AndN_Solution3(n);
        System.out.println(result);
        scanner.close();
	}

}

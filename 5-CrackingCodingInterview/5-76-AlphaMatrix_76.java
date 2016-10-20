package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月20日 上午9:50:11
 */

public class AlphaMatrix_76 {

    // 1.建立一个数组rows[n], 存放每个字符串的长度.
    // 2.从1 -> n-1, 判断相邻两个字符串是否相等, 若相等, 更新rows[i] = rows[i-1] + rows[i], 
    //   否则, rows[i]为该字串的长度, 不变.
    // 3.最大字母矩阵面积即为max(rows[i])(i=0,,,n-1);
    public static int findAlphaMatrix(String[] dic, int n) {
	int[] rows = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            rows[i] = dic[i].length();
        }
        for (int i = 1; i < n; i++) {
            if (dic[i].equals(dic[i-1])) {
        	 rows[i] += rows[i - 1];
            }
            max = Math.max(max, rows[i]);
        }
 
        return Math.max(max, rows[0]);
    }  
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    String[] dic = str.split(",");
	    int n = dic.length;
	    
	    System.out.println(findAlphaMatrix(dic, n));
	}
	cin.close();
    }

}

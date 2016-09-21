package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月21日 下午7:44:14
 */

public class XOR {

    /*       异或
     * 时间限制：C/C++语言 1000MS；其他语言 3000MS
                   内存限制：C/C++语言 65536KB；其他语言 589824KB
                   题目描述：
                          给定整数m以及n个数字A1, A2, …, An，将数列A中所有元素两两异或，共能得到n(n-1)/2个结果。请求出这些结果中大于m的有多少个。
                   输入:
                          第一行包含两个整数n, m。
                          第二行给出n个整数A1, A2, …, An。
                   输出:
                          输出仅包括一行，即所求的答案。
                  样例输入:
          3 10
          6 5 10
                  样例输出:
          2
                  样例解释:
                       可能的两两异或的结果有：
        5 xor 6 = 3
        5 xor 10 = 15
        6 xor 10 = 12
                 所以异或值大于10的有两种方案。
                 数据范围:
                       对于30%的数据，1 <= n, m <= 1000
                       对于100%的数据，1 <= n, m, Ai <= 10^5
       */

   // 为了防止大数组溢出,将int数组转换为二维byte数组
   public static long getNumBigM(int n, int m, byte[][] A) {
	long num = 0;
	for(int i=0; i<n; i++) {
	    for(int j=i+1; j<n; j++) {
		// 字节数组转换成整形变量
		int Ai = 0;
		for(int ii=0; ii<4; ii++){
		    Ai += (A[i][ii]&0xff) << (24-8*ii);
		}
		
		// 字节数组转换成整形变量
		int Aj = 0;
		for(int jj=0; jj<4; jj++){
		    Aj += (A[j][jj]&0xff) << (24-8*jj);
		}
		
		if((Ai ^ Aj) > m) {
		    num++; 
		}
	    } 
	}
	return num;
    }
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (sc.hasNext()) {
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    
	    byte[][] A = new byte[n][4];
	    for(int i=0; i<n; i++) {
		// 整形变量转换成字节数组
		int a = sc.nextInt();
		A[i][0] = (byte)(a>>24 & 0xff);
		A[i][1] = (byte)(a>>16 & 0xff);
		A[i][2] = (byte)(a>>8 & 0xff);
		A[i][3] = (byte)(a & 0xff);
	    }
	    long result = getNumBigM(n, m, A);
	    System.out.println(result);
	}

	sc.close();
    }

}

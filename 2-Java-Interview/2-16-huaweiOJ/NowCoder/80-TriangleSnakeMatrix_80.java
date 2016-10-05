package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午8:57:51
 */

public class TriangleSnakeMatrix_80 {
    //找规律的解法
    public static void printSnakeMatrix2(int n) {
	int threshold = 1;
        for(int i=1; i<=n; i++)
        {
            System.out.print(threshold);
            int temp = threshold;
            for(int j=i+1; j <= n; j++)
            {
        	temp += j;
        	System.out.print(" " + temp);      
            }
            System.out.println();
            threshold += i;
        }
    }
    
    public static void printSnakeMatrix1(int n) {
	 int[][] array = new int[n][n];
         int k = 0;
         int count = 1;
         for (int i = 0; i < n; i++) { //从下标0,0开始沿着从左下到右上的斜线依次对矩阵赋值
             for (int j = 0; j <= i; j++) {
        	 array[k-j][j] = count; //每次循环中用k-j控制行的变化
                 count++;               //因为从左下到右上角,矩阵值依次加1
             }
             k++;
         }
         for(int i = 0; i < n; i++){  //打印蛇形矩阵
             int q = n - i;
             for(int j = 0; j < q; j++){
                 if(j == q-1) {
                     System.out.print(array[i][j]);
                 }else {
                     System.out.print(array[i][j] + " ");
                 }    
             }
             System.out.println();
         }
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    //printSnakeMatrix1(n);
	    printSnakeMatrix2(n);
	}
	cin.close();
    }

}

package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月6日 下午9:26:51
 */

public class LinearInterpolation_99 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            int m = cin.nextInt();
            cin.nextInt();
            
            int M, N, A, B;
            M = cin.nextInt();
            A = cin.nextInt();
            System.out.println(M +" "+ A);
            for (int i = 1; i < m; i++)
            {
                N = cin.nextInt();
                B = cin.nextInt();
                if (N == M) {  // 重复数据, 丢弃
                    continue;   
                }
                else   // 不连续, 在M-N之间插值
                {
                    for (int j = 1; j < N - M; j++)
                    {
                	System.out.println((M + j) +" "+ (A + ((B - A) / (N - M))*j));
                    }
                    System.out.println(N +" "+ B);
                    M = N;
                    A = B;
                }
            }
        }
        cin.close();

    }

}

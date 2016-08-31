package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年8月31日 上午9:52:25
 */

public class BinInsert_23 {

   /*            i   j    
       1024：1000 00000 00
       19  ：              10011
                  可以看到上面得出, 只要我们用1011与1024的第j位到第i位做或运算（|）即可。
                  我们想到可以让10011左移j位就可以正常做运算了。
         1000 00000 00
         0000 10011 00
    */
    public static int binInsert(int n, int m, int j, int i) {
	 m <<= j;
	 return m|n;
    }
    
    public static void main(String[] args) {
        int n = 1024;
        int m = 19;
        int j = 2;
        int i = 6;
        int result = binInsert(n, m, j, i);
        System.out.println(result);
    }

}

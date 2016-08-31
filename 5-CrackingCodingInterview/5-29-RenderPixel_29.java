package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年8月31日 下午4:20:01
 */

public class RenderPixel_29 {
    
    // 方法一: 从第x到第y位, 其中的像素全部变为1, 如此两种情况 :
    // 0-->1, 1-->1, 所以这时候就很清楚的用位操作中的 '|'
    public static int[] renderPixel(int[] screen, int x, int y) {
       if(screen == null) {
	   return null;
       }
       
       for(int i = x ; i <= y ; i ++)
       {
           int k = i % 8;
           int t = i / 8;
           screen[t] = screen[t] | (1 << k);
       }

       return screen;
    }

    public static void main(String[] args) {
	int[] screen = {0,0,0,0,0,0};
	int x = 0;
	int y = 47;
	int[] result = renderPixel(screen, x, y);
	for(int i=0; i<result.length; i++) {
	    System.out.print(result[i] + " ");
	}
    }

}

package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年8月31日 下午2:58:20
 */

public class Transform_26 {

    public static int calcCost(int A, int B) {
        int aXORb = A ^ B;
        
        int result = 0;
        while(aXORb != 0){
            result++;
            aXORb = (aXORb-1) & aXORb;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
       int A = 10;
       int B = 5;
       int result = calcCost(A, B);
       System.out.println(result);
    }

}

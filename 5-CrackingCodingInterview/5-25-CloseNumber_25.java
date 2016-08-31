package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年8月31日 下午2:36:01
 */

public class CloseNumber_25 {

    public static int[] getCloseNumber(int x) {
        int small = x - 1;
	int big = x + 1;
        int countOfOne_x = getCountOfOne(x);
        while(countOfOne_x != getCountOfOne(small)) {
            small--;
        }
        while(countOfOne_x != getCountOfOne(big)) {
            big++;
        }
        
        int[] array = {small, big};
        return array;
    }
    
    private static int getCountOfOne(int x){
        int result = 0;
        while(x != 0){
            result++;
            x = (x-1) & x;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            int x = cin.nextInt();
            int[] array = getCloseNumber(x);
            System.out.println(array[0] + "," + array[1]);
        }
        cin.close();
    }

}

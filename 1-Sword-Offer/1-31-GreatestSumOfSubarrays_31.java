package swordOffer;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年8月25日 下午4:58:41
 */

public class GreatestSumOfSubarrays_31 {

    private static boolean g_InvalidInput = false;
    
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array==null || array.length<=0) {
            g_InvalidInput = true;
            return 0;
        }
        
        g_InvalidInput = false;
        
        int currentSum = 0;
        int greatestSum = 0x80000000;
        int length = array.length;
        for(int i=0; i<length; i++) {
            if(currentSum <= 0) {
        	currentSum = array[i];
            }
            else {
        	currentSum = currentSum + array[i];
            }
            
            if(currentSum > greatestSum) {
        	greatestSum = currentSum;
            }
        }
        
        return greatestSum;
    }

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str==null || str.trim().equals("")) {
            System.out.println("输入非法！");
        }
        String[] arrayStr = str.split(",");
        int[] array = new int[arrayStr.length];
        for(int i=0; i<arrayStr.length; i++) {
            array[i] = Integer.parseInt(arrayStr[i]);
        }
        if(g_InvalidInput) {
            System.out.println("输入非法！");
        } 
        int result = FindGreatestSumOfSubArray(array);
        System.out.println(result);
        
        scanner.close();
    }

}

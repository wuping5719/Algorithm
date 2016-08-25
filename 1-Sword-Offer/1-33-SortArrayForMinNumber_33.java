package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月25日 下午9:04:35 
 * @version 1.0 
 */
public class SortArrayForMinNumber_33 {

	public static String PrintMinNumber(int[] numbers) {
       if(numbers == null || numbers.length <= 0)
    	   return "";
       
       String[] numStr = new String[numbers.length];
       for(int i=0; i<numbers.length; i++){
    	   numStr[i] = String.valueOf(numbers[i]);
       }
       
       // 模拟冒泡排序,排序字符串数组
       for(int i=0; i<numbers.length-1; i++){
    	   for(int j=0; j<numbers.length-i-1; j++){
    		   String ab = numStr[j] + numStr[j+1];
    		   String ba = numStr[j+1] + numStr[j];
    		   //自定义的大于小于规则：如果ab>ba,则a>b
    		   if(ab.compareTo(ba) > 0){
    			   String temp = numStr[j];
    			   numStr[j] = numStr[j+1];
    			   numStr[j+1] = temp;
    		   }
    	   }
       }
       
       StringBuffer sb = new StringBuffer();
       for(int i=0; i<numbers.length; i++){
    	   sb.append(numStr[i]);
       }
       String result = new String(sb);
       return result;
    }
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str != null && !str.trim().equals("")){
        	String[] arrayStr = str.split(",");
        	int[] numbers = new int[arrayStr.length];
        	for(int i=0; i<arrayStr.length; i++){
        		numbers[i] = Integer.parseInt(arrayStr[i]);
        	}
        	
        	String result = PrintMinNumber(numbers);
        	System.out.println(result);
        }
        scanner.close();
	}

}

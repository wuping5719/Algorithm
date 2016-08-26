package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月26日 下午9:37:58 
 * @version 1.0 
 */
public class NumbersAppearOnce_40 {

	public static void FindNumsAppearOnce(int[] array, int[] num1 , int[] num2) {
		int length = array.length;
		if(array == null || length < 2) {   
	    	return;
	    }
	    
	    int resultExclusiveOR = 0;
	    for(int i=0; i<length; i++){
	    	resultExclusiveOR ^= array[i];
	    }
	    
	    int indexOf1 = FindFirstBitIs1(resultExclusiveOR);
	    
	    num1[0] = 0;
	    num2[0] = 0;
	    for(int j=0; j<length; j++){
	    	if(IsBit1(array[j], indexOf1)){
	    		num1[0] ^= array[j];
	    	}
	    	else{
	    		num2[0] ^= array[j];
	    	}
	    }
	}
	//找出第一个为1的位的位置
	public static int FindFirstBitIs1(int num){
	    int indexBit = 0;
	    while(((num & 1) == 0) && (indexBit < 32)){
	    	num = num >> 1;
	        indexBit++;
	    }
	    return indexBit;
	}
	public static boolean IsBit1(int num, int indexBit){
		num = num >> indexBit;
	    int isBit1i = (num & 1);
	    boolean isBit1 = false;
	    if(isBit1i==0){
	    	isBit1 = false;
	    }else{
	    	isBit1 = true;
	    }
	    return isBit1;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
        	String str = scanner.nextLine();
            if(str != null && !str.trim().equals("")){
            	String[] arrayStr = str.split(",");
            	int[] array = new int[arrayStr.length];
            	for(int i=0; i<arrayStr.length; i++){
            		array[i] = Integer.parseInt(arrayStr[i]);
            	}
            	
            	int[] num1 = new int[1];
            	int[] num2 = new int[1];
            	
            	FindNumsAppearOnce(array, num1, num2);
            	System.out.print(num1[0] + " " + num2[0]);
            }
        }
        scanner.close();
	}

}

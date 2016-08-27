package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月27日 下午8:38:11 
 * @version 1.0 
 */
public class DuplicationInArray_51 {

	public static boolean duplicate(int[] numbers, int length, int[] duplication) {
	    if(numbers == null || length <= 0){
	    	return false;
	    }
	    
	    for(int i=0; i<length; i++){
	    	if(numbers[i]<0 || numbers[i]>length-1){
	    		return false;
	    	}
	    }
	    
	    for(int i=0; i<length; i++){
	    	while(numbers[i] != i){
	    		if(numbers[i] == numbers[numbers[i]]){
	    			duplication[0] = numbers[i];
	    			return true;
	    		}
	    		
	    		int temp = numbers[i];
	    		numbers[i] = numbers[temp];
	    		numbers[temp] = temp;
	    	}
	    }
	    return false;
    }

	public static void main(String[] args) {
       Scanner cin = new Scanner(System.in);
       while(cin.hasNext()){
    	   String str = cin.nextLine();
    	   int length = cin.nextInt();
    	   int[] duplication = new int[1];
    	   duplication[0] = -1;
    	   if(str!=null && !str.trim().equals("")){
    		   String[] array = str.split(",");
    		   int[] numbers = new int[array.length];
    		   for(int i=0; i<array.length; i++){
    			   numbers[i]=Integer.parseInt(array[i]);
    		   }
    		   boolean result = duplicate(numbers, length, duplication);
    		   System.out.println(result);
    		   if(result){
    			   System.out.println(duplication[0]);
    		   }
    	   }
    	  
       }
       cin.close();
	}

}

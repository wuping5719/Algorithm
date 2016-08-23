package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月23日 下午10:05:36 
 * @version 1.0 
 */
public class ReorderArray_14 {
    
	public static void reOrderArray(int[] array) {
        if(array == null || array.length == 0){
        	return;
        }
        int begin = 0;
        int end = array.length-1;
        while(begin < end){
        	//向后移动begin,直到它指向偶数
        	while(begin < end && (array[begin] & 0x1) !=0){
        		begin++;
        	}
            //向前移动end,直到它指向奇数
        	while(begin < end && (array[end] & 0x1) ==0){
        		end--;
        	}
        	
        	if(begin < end){
        		int temp = array[begin];
        		array[begin] = array[end];
        		array[end] = temp;
        	}
        }
    }
	
	public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        if(str!=null && !str.trim().equals("")){
        	 String[] arrayStr = str.split(",");
        	 int[] array = new int[arrayStr.length];
        	 for(int i=0; i<arrayStr.length; i++){
        		 array[i] = Integer.parseInt(arrayStr[i]);
        	 }
        	 reOrderArray(array);
        	 for(int j=0; j<array.length; j++){
        		 if(j<array.length-1){
        			 System.out.print(array[j]+",");
        		 }else{
        			 System.out.println(array[j]);
        		 }
        	 }
        }
        cin.close();
	}

}

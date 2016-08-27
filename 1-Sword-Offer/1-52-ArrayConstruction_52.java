package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月27日 下午9:00:38 
 * @version 1.0 
 */
public class ArrayConstruction_52 {
	
	public static int[] multiply(int[] A) {
       int length = A.length;
       int[] B = new int[length];
       
       if(A!=null && length>1){
    	   B[0]=1;
    	   for(int i=1; i<length; i++){
    		   B[i]= B[i-1] * A[i-1];
    	   }
    	   
    	   int temp=1;
    	   for(int i=length-2; i>=0; i--){
    		   temp *= A[i+1];
    		   B[i] *= temp;
    	   }
       }
       return B;
    }
	
	public static void main(String[] args) {
	   Scanner cin = new Scanner(System.in);
	   while(cin.hasNext()){
		   String str = cin.nextLine();
		   if(str!=null && !str.trim().equals("")){
			   String[] tempArray = str.split(",");
			   int[] A = new int[tempArray.length];
			   for(int i=0; i<tempArray.length; i++){
				   A[i] = Integer.parseInt(tempArray[i]);
			   }
			   int[] B = multiply(A);
			   for(int i=0; i<B.length; i++){
				   if(i!=B.length-1){
					   System.out.print(B[i] + " ");
				   }else{
					   System.out.print(B[i]);
				   }
			   }
		   }
	   }
	   cin.close();
	}

}

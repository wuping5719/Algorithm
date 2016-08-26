package swordOffer;

import java.util.ArrayList;
import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月26日 下午11:11:47 
 * @version 1.0 
 */
public class ContinuesSquenceWithSum_41_2 {

	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(sum < 3){
			return result;
		}
		
		int small = 1;
		int big = 2;
		int middle = (1 + sum) / 2;
		int currentSum = small + big;
		
		while(small < middle){
			if(currentSum == sum){
				ArrayList<Integer> tempResult = new ArrayList<Integer>();
				for(int i=small; i<=big; i++){
					tempResult.add(i);
				}
				result.add(tempResult);
			}
			
			while(currentSum > sum && small < middle){
				currentSum = currentSum - small;
				small++;
				
				if(currentSum == sum){
					ArrayList<Integer> tempResult = new ArrayList<Integer>();
					for(int i=small; i<=big; i++){
						tempResult.add(i);
					}
					result.add(tempResult);
				}
			}
			
			big++;
			currentSum = currentSum + big;
		}
		
		return result;
    }
	
	public static void main(String[] args) {
	   Scanner scanner = new Scanner(System.in);
       while(scanner.hasNext()){
    	   int sum = scanner.nextInt();
    	   ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	   result = FindContinuousSequence(sum);
    	   for(int i=0; i<result.size(); i++){
    		   ArrayList<Integer> tempResult = new ArrayList<Integer>();
    		   tempResult = result.get(i);
    		   for(int j=0; j<tempResult.size(); j++){
    			   System.out.print(tempResult.get(j) + " ");
    		   }
    		   System.out.println();
    	   }
       }
       scanner.close();
	}

}

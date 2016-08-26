package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月26日 下午8:34:25 
 * @version 1.0 
 */
public class NumberOfK_38 {

	public static int GetNumberOfK(int[] array, int k) {
	    int number = 0;
	    
	    if(array != null && array.length > 0){
	    	int first = GetFirstK(array, k, 0, array.length-1);
	    	int last = GetLastK(array, k, 0, array.length-1);
	    	
	    	if(first > -1 && last > -1){
	    		number = last - first + 1;
	    	}
	    }
	    
	    return number;
	}
	
    public static int GetFirstK(int[] array, int k, int start, int end) {
	    if(start > end)
	    	return -1;
	    
	    int middleIndex = (start + end) / 2;
	    int middleData = array[middleIndex];
	    
	    if(middleData == k){
	    	if((middleIndex > 0 && array[middleIndex-1] != k) || middleIndex == 0){
	    		return middleIndex;
	    	}else{
	    		end = middleIndex - 1;
	    	}
	    }else if(middleData > k){
	    	end = middleIndex - 1;
	    }else{
	    	start = middleIndex + 1;
	    }
	    
	    return GetFirstK(array, k, start, end);
	}

    public static int GetLastK(int[] array, int k, int start, int end) {
	    if(start > end)
	    	return -1;
	    
	    int middleIndex = (start + end) / 2;
	    int middleData = array[middleIndex];
	    
	    if(middleData == k){
	    	if((middleIndex < (array.length-1) && array[middleIndex+1] != k) || middleIndex == (array.length-1)){
	    		return middleIndex;
	    	}else{
	    		start = middleIndex + 1;
	    	}
	    }else if(middleData < k){
	    	start = middleIndex + 1;
	    }else{
	    	end = middleIndex - 1;
	    }
	    
	    return GetLastK(array, k, start, end);
	}
    
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			String str = cin.nextLine();
			int k = cin.nextInt();
			if (str == null || str.length() <= 0) {
				System.out.println("输入非法！");
			} else {
				String[] arrayStr = str.split(",");
				int[] array = new int[arrayStr.length];
				for (int i = 0; i < arrayStr.length; i++) {
					array[i] = Integer.parseInt(arrayStr[i]);
				}
				int result = GetNumberOfK(array, k);
				System.out.println(result);
			}
		}
		cin.close();
	}

}

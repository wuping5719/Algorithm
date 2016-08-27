package swordOffer;

import java.util.Arrays;
import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月27日 下午2:25:17 
 * @version 1.0 
 */
public class ContinousCards_44 {

	public static boolean isContinuous(int[] numbers) {
        if(numbers == null || numbers.length<1){
        	return false;
        }
        
        Arrays.sort(numbers);
        
        int numberOfZero = 0;
        int numberOfGap = 0;
        
        // 统计数组中0的个数
        for(int i=0; i<numbers.length && numbers[i]==0; i++){
        	numberOfZero++;
        }
        
        // 统计数组中的间隔数目
        int small = numberOfZero;
        int big = small + 1;
        while(big < numbers.length){
        	// 两个数相等,有对子,不可能是顺子
        	if(numbers[small] == numbers[big]){
        		return false;
        	}
        	
        	numberOfGap += numbers[big] - numbers[small] - 1;
        	small = big;
        	big++;
        }
        
        return (numberOfGap > numberOfZero) ? false : true;
    }
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String str = scanner.nextLine();
			if (str != null && !str.trim().equals("")) {
				String[] arrayStr = str.split(",");
				int[] numbers = new int[arrayStr.length];
				for (int i = 0; i < arrayStr.length; i++) {
					numbers[i] = Integer.parseInt(arrayStr[i]);
				}

				boolean result = isContinuous(numbers);
			    System.out.print(result);
			}
		}
		
		scanner.close();
	}

}

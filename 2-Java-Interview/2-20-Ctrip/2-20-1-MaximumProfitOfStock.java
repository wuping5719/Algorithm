package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月17日 下午8:26:13
 */

public class MaximumProfitOfStock {

    public static int MaxProfit(int[] price) {
        if(price==null || price.length<=0) {
            return 0;
        }
        
        int maxLiRun = 0;
        int inIndex = 0;
        while(inIndex < price.length) {
            for(int i=inIndex+1; i<price.length; i++) {
                if(price[i]-price[inIndex] > maxLiRun) {
                    maxLiRun = price[i]-price[inIndex];
                }
            }
            inIndex++;
        }
        return maxLiRun;
    }
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while(sc.hasNext()) {
	    String str = sc.nextLine();
	    String[] strArray = str.split(",");
	    int[] price = new int[strArray.length];
	    for(int i=0; i<price.length; i++) {
		price[i] = Integer.parseInt(strArray[i]);
	    }
	    int result = MaxProfit(price);
	    System.out.println(result);
	}
	sc.close();
    }

}

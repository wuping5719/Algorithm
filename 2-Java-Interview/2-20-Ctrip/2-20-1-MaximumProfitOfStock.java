package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月17日 下午8:26:13
 */

public class MaximumProfitOfStock {

    public static int MaxProfit(int[] jiaGe) {
        if(jiaGe==null || jiaGe.length<=0) {
            return 0;
        }
        
        int maxLiRun = 0;
        int inIndex = 0;
        while(inIndex < jiaGe.length) {
            for(int i=inIndex+1; i<jiaGe.length; i++) {
                if(jiaGe[i]-jiaGe[inIndex] > maxLiRun) {
                    maxLiRun = jiaGe[i]-jiaGe[inIndex];
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
	    int[] jiaGe = new int[strArray.length];
	    for(int i=0; i<jiaGe.length; i++) {
		jiaGe[i] = Integer.parseInt(strArray[i]);
	    }
	    int result = MaxProfit(jiaGe);
	    System.out.println(result);
	}
	sc.close();
    }

}

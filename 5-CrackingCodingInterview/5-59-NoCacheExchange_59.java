package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月10日 下午7:21:33
 */

public class NoCacheExchange_59 {

    public static int[] exchangeAB(int[] AB) {
	AB[0] = AB[0] + AB[1];
	AB[1] = AB[0] - AB[1];
	AB[0] = AB[0] - AB[1];
	return AB;
    }
    
    public static int[] exchangeAB2(int[] AB) {
	AB[0] = AB[0] ^ AB[1];
	AB[1] = AB[0] ^ AB[1];
	AB[0] = AB[0] ^ AB[1];
	return AB;    
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
            int[] AB = new int[2];
            AB[0] = cin.nextInt();
            AB[1] = cin.nextInt();
	    
            //int[] BA = exchangeAB(AB);
            //System.out.println(BA[0] +" "+ BA[1]);
            
            int[] BA2 = exchangeAB2(AB);
            System.out.println(BA2[0] +" "+ BA2[1]);
	}
	cin.close();
    }

}

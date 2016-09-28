package acmCoder;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月28日 下午8:23:45
 */

public class NetFees {

    public static String countNetFees(float hour) {
	DecimalFormat dec = new DecimalFormat(".00");
	if(hour <= 3.00f) {
	    return dec.format(5.00f);
	}
	
	float res;
	res = 5.00f + (hour - 3.00f) * 2;
	if(res > 50.00f) {
	    res = 50.00f;
	}
	
	return dec.format(res);
    }
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (sc.hasNext()) {
	    float hour = sc.nextFloat();
	    String result = countNetFees(hour);
	    System.out.println(result);
	}
	sc.close();
    }

}

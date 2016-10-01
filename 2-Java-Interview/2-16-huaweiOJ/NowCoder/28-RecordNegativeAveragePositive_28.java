package huawei;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月1日 下午11:37:44
 */

public class RecordNegativeAveragePositive_28 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	
	int numOfNegative = 0;
	int numOfPositive = 0;
	double averagePositive = 0.0;
	double sum = 0.0;
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    
	    if(n < 0) {
		numOfNegative++;
	    }else if(n > 0) {
		numOfPositive++;
		sum = sum + n;
	    }else {
		break;
	    }
	}
	
	if(numOfPositive > 0) {
	    averagePositive = sum / numOfPositive;
	}
	
	DecimalFormat df = new DecimalFormat("0.0"); 
	System.out.println(numOfNegative);
	System.out.println(df.format(averagePositive));
	
	cin.close();
    }

}

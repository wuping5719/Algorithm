package huawei;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月1日 下午10:56:02
 */

public class CubeRoot_26 {

    // 牛顿迭代法:
    // 设f(x) = x3 - y, 求f(x)=0时的解x, 即为y的立方根.
    // 根据牛顿迭代思想, xn + 1 = xn - f(xn) /f'(xn) 
    // 即 x = x - (x3 - y)/(3 * x2) = (2*x + y/x/x)/3;
    public static double getCubeRoot(double input) {
	 double x0 = 1;
	 double x1 = x0 - (x0 * x0 * x0 - input) / (3 * x0 * x0);
	 while (Math.abs(x1 - x0) > 0.000001) {
	     x0 = x1;
	     x1 = x0 - (x0 * x0 * x0 - input) / (3 * x0 * x0);
	 }
	 DecimalFormat df = new DecimalFormat("#0.0");
	 return Double.parseDouble(df.format(x1));
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    double input = cin.nextDouble();
            System.out.println(getCubeRoot(input));
	}
	cin.close();
    }

}

package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月2日 下午9:52:13
 */

public class AutomorphicNumber_34 {

    //判断是否为自守数
    public static boolean isAutomorphicNumber(int n)
    {
       long square = n * n;
       String nStr = String.valueOf(n);
       String squareStr = String.valueOf(square);
       String subSquareStr = squareStr.substring(squareStr.length()-nStr.length());
       if(subSquareStr.equals(nStr)) {
	   return true;
       }else {
	   return false;
       }
    }

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    
	    int count = 0;
	    for(int i=0; i<=n; i++) {
		if(isAutomorphicNumber(i)) {
		    count++;
		}
	    }
	    System.out.println(count);
	}
	cin.close();
    }

}

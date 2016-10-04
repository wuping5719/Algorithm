package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月4日 下午3:39:23
 */

public class NicoChesterTheorem_54 {

    public static String getSequeOddNum(int n)
    {
	StringBuffer sb = new StringBuffer();
	if(n > 0) {
	    long temp = n * n * n;
	    long first = 1;
	    if(n % 2 == 1) {  //n为奇数
		long mid = temp / n;
		int r = (n-1) / 2;
		first = mid - r * 2;
	    }else {
		long mid = temp / n;
		int r = n / 2;
		first = mid - r * 2 + 1;
	    }
	    
	    for(int i=0; i<n-1; i++) {
		long tempNum = first + i * 2;
		sb.append(tempNum);
		sb.append("+");
	    }
	    long num = first + (n-1) * 2;
	    sb.append(num);
	}
        return sb.toString();
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            int n = cin.nextInt();
            String result = getSequeOddNum(n);
            System.out.println(result);
        }
        cin.close();
    }

}

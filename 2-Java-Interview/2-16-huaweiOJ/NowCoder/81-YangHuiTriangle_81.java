package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午9:14:48
 */

public class YangHuiTriangle_81 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    long n = cin.nextLong();
	    //找规律的解法
	    if(n <= 2) {
		System.out.println(-1);
	    }else if(n % 2 == 1){
                System.out.println(2);
            }else{
                if(n % 4 == 0) {
                    System.out.println(3);
                }else {
                    System.out.println(4);
                }
            }
	}
	cin.close();
    }

}

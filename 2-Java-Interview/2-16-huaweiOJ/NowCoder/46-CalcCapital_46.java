package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月3日 下午8:59:41
 */

public class CalcCapital_46 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()) {
           String str = cin.nextLine();
           int num = 0;
           for(int i=0; i<str.length(); i++) {
               if(str.charAt(i)>='A' && str.charAt(i)<='Z') {
        	   num++;
               }
           }
           System.out.println(num);
        }
        cin.close();
    }

}

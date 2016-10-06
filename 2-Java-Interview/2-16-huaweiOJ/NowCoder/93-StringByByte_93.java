package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月6日 下午4:26:30
 */

public class StringByByte_93 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.next();
	    int n = cin.nextInt();
	    StringBuilder sb = new StringBuilder();
            for(int i=0, len=0; i<str.length() && len<n; i++){
                int cNum = (int)str.charAt(i);
                if(cNum > 255){
                    if((len+2)> n) {
                	break;
                    }  
                    len += 2;
                    sb.append(str.charAt(i));
                }
                if(cNum>=0 && cNum<=255){
                    len++;
                    sb.append(str.charAt(i));
                }
            }
            System.out.println(sb.toString());
	}
	cin.close();
    }

}

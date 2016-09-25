package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月25日 上午8:55:00
 */

public class IPSwitching {
    
    public static void main(String[] args) {
       Scanner cin = new Scanner(System.in);
       while(cin.hasNext()) {
	   long ipLong = cin.nextLong();
	   StringBuffer sb = new StringBuffer();
	   
	   if(ipLong < 0) {
	       sb.append("");
	   }else {
	       String str = Long.toHexString(ipLong);
	       try {
		    String ipStr1 = str.substring(0, 2);
		    String ipStr2 = str.substring(2, 4);
		    String ipStr3 = str.substring(4, 6);
		    String ipStr4 = str.substring(6, 8);

		    sb.append(Integer.valueOf(ipStr1, 16).toString());
		    sb.append(":");
		    sb.append(Integer.valueOf(ipStr2, 16).toString());
		    sb.append(":");
		    sb.append(Integer.valueOf(ipStr3, 16).toString());
		    sb.append(":");
		    sb.append(Integer.valueOf(ipStr4, 16).toString());
	       }catch(Exception e) {
		   sb.append("");
	       }
	   }
	       
	   System.out.println(sb.toString()); 
       }
       cin.close();
    }

}

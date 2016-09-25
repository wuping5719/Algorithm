package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月25日 下午3:50:18
 */

public class IpToLong {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    
	    Long num = 0L;  
	    try{  
		str = str.replaceAll("[^0-9\\.]", ""); //去除字符串前的空字符  
	        String[] ips = str.split("\\.");  
	        if (ips.length == 4){  
	            num = Long.parseLong(ips[0], 10) * 256L * 256L * 256L + Long.parseLong(ips[1], 10) * 256L * 256L + Long.parseLong(ips[2], 10) * 256L + Long.parseLong(ips[3], 10);  
	            num = num >>> 0;  
	        }  
	    }catch(NullPointerException ex){  
	        System.out.println(str);  
	    }  
	    System.out.println(num);
	    
	    /*String[] strArray = str.split("\\.");

	    StringBuffer sb = new StringBuffer();
	    sb.append(Integer.toHexString(Integer.parseInt(strArray[0])));
	    sb.append(Integer.toHexString(Integer.parseInt(strArray[1])));
	    sb.append(Integer.toHexString(Integer.parseInt(strArray[2])));
	    sb.append(Integer.toHexString(Integer.parseInt(strArray[3])));
	    
	    System.out.println(sb.toString());
	    
	    //long res = Long.valueOf(sb.toString(), 10);
	    //System.out.println(res);
	     * 
	     */
	}
	cin.close();
    }

}

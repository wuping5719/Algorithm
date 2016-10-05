package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午4:09:33
 */

public class LongIntAndIP_72 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while(cin.hasNext()) {
	    String ipStr = cin.nextLine();
	    String longStr = cin.nextLine();
	    
	    //IP To Long
	    String[] ipArray = ipStr.split("\\.");
	    long ip1 = Long.parseLong(ipArray[0]);
	    long ip2 = Long.parseLong(ipArray[1]);
	    long ip3 = Long.parseLong(ipArray[2]);
	    long ip4 = Long.parseLong(ipArray[3]);
	    
	    System.out.println(((ip1 << 24)|(ip2 << 16)|(ip3 << 8)|ip4));
	    //long ipToLong = 0;
	    //ipToLong += (ip1 << 24) + (ip2 << 16) + (ip3 << 8) + ip4;
	    //System.out.println(ipToLong);
	    
	    //Long To IP
	    long longToIp = Long.parseLong(longStr);
	    System.out.print((longToIp & 0xff000000) >> 24);
	    System.out.print(".");
	    System.out.print((longToIp & 0x00ff0000) >> 16);
	    System.out.print(".");
	    System.out.print((longToIp & 0x0000ff00) >> 8);
	    System.out.print(".");
	    System.out.print((longToIp & 0x000000ff));
	    System.out.println();
	}
	cin.close();
    }

}

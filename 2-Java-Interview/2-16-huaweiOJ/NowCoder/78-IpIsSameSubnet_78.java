package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午8:13:17
 */

public class IpIsSameSubnet_78 {

    public static int checkNetSegment(String mask, String ip1, String ip2) {
	String[] maskArray = mask.split("\\.");
	String[] ip1Array = ip1.split("\\.");
	String[] ip2Array = ip2.split("\\.");

	int maskA = 0;
	int maskB = 0;
	int maskC = 0;
	int maskD = 0;

	int ip1A = 0;
	int ip1B = 0;
	int ip1C = 0;
	int ip1D = 0;

	int ip2A = 0;
	int ip2B = 0;
	int ip2C = 0;
	int ip2D = 0;

	try {
	    maskA = Integer.parseInt(maskArray[0]);
	}catch(Exception e) {}
	try {
	    maskB = Integer.parseInt(maskArray[1]);
	}catch(Exception e) {}
	try {
	    maskC = Integer.parseInt(maskArray[2]);
	}catch(Exception e) {}
	try {
	    maskD = Integer.parseInt(maskArray[3]);
	}catch(Exception e) {}

	ip1A = Integer.parseInt(ip1Array[0]);
	ip1B = Integer.parseInt(ip1Array[1]);
	ip1C = Integer.parseInt(ip1Array[2]);
	ip1D = Integer.parseInt(ip1Array[3]);

	ip2A = Integer.parseInt(ip2Array[0]);
	ip2B = Integer.parseInt(ip2Array[1]);
	ip2C = Integer.parseInt(ip2Array[2]);
	ip2D = Integer.parseInt(ip2Array[3]);

	if ((maskA > 255 || maskA < 0) || (maskB > 255 || maskB < 0) || (maskC > 255 || maskC < 0) || (maskD > 255 || maskD < 0)
		|| (ip1A > 255 || ip1A < 0) || (ip1B > 255 || ip1B < 0) || (ip1C > 255 || ip1C < 0) || (ip1D > 255 || ip1D < 0)
		|| (ip2A > 255 || ip2A < 0) || (ip2B > 255 || ip2B < 0) || (ip2C > 255 || ip2C < 0) || (ip2D > 255 || ip2D < 0)) {
	    return 1;
	} else if (((maskA & ip1A) == (maskA & ip2A)) && ((maskB & ip1B) == (maskB & ip2B))
		&& ((maskC & ip1C) == (maskC & ip2C)) && ((maskD & ip1D) == (maskD & ip2D))) {
	    return 0;
	} else {
	    return 2;
	}
    }

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String mask = cin.nextLine();
	    String ip1 = cin.nextLine();
	    String ip2 = cin.nextLine();
	    System.out.println(checkNetSegment(mask, ip1, ip2));
	}
	cin.close();
    }

}

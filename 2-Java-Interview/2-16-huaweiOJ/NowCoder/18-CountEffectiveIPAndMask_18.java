package huawei;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author WuPing
 * @version 2016年10月1日 下午2:58:59
 */

public class CountEffectiveIPAndMask_18 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	int typeA = 0;
	int typeB = 0;
	int typeC = 0;
	int typeD = 0;
	int typeE = 0;
	int errorIPOrMaskCode = 0;
	int privateIP = 0;

	while (cin.hasNext()) {
	    String ipStr = cin.nextLine();
            if(ipStr.trim().equals("end")) {
        	break;
            }
	    
	    String[] ipAndMaskCode = ipStr.split("~");
	    String ip = ipAndMaskCode[0];
	    String maskCode = ipAndMaskCode[1];

	    // 判断格式
	    if (!isValidFormat(ip) || !isValidFormat(maskCode)) {
		errorIPOrMaskCode++;
		continue;
	    }

	    // 判断掩码是否错误
	    if (!validMaskCode(maskCode)) {
		errorIPOrMaskCode++;
		continue;
	    }

	    // 判断ip类别
	    String fnStr = ip.substring(0, ip.indexOf("."));
	    int fn = Integer.valueOf(fnStr);
	    if (fn >= 1 && fn < 127) {
		// A
		typeA++;
	    } else if (fn >= 128 && fn < 192) {
		// B
		typeB++;
	    } else if (fn >= 192 && fn < 224) {
		// C
		typeC++;
	    } else if (fn >= 224 && fn < 240) {
		// D
		typeD++;
	    } else if (fn >= 240 && fn <= 255) {
		// E
		typeE++;
	    }

	    // 判断是否是私网IP
	    String ipSubStr = ip.substring(ip.indexOf(".") + 1);
	    String snStr = ipSubStr.substring(0, ipSubStr.indexOf("."));
	    int sn = Integer.valueOf(snStr);
	    if (fn == 10 || (fn == 172 && sn >= 16 && sn <= 31)
		    || (fn == 192 && sn == 168)) {
		privateIP++;
	    }
	}
	cin.close();
	
	StringBuffer sb = new StringBuffer();
	sb.append(typeA);
	sb.append(" ");
	sb.append(typeB);
	sb.append(" ");
	sb.append(typeC);
	sb.append(" ");
	sb.append(typeD);
	sb.append(" ");
	sb.append(typeE);
	sb.append(" ");
	sb.append(errorIPOrMaskCode);
	sb.append(" ");
	sb.append(privateIP);
	System.out.println(sb.toString());
    }

    // 判断ip和掩码是否是xxx.xxx.xxx.xxx的格式
    private static boolean isValidFormat(String ip) {
	boolean res = true;
	if (ip == null || ip.equals(""))
	    return false;
	Pattern pattern = Pattern
		.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$");
	Matcher matcher = pattern.matcher(ip);

	if (matcher.matches()) {
	    String[] nums = ip.split("\\.");
	    for (String num : nums) {
		int n = Integer.valueOf(num);
		if (n < 0 || n > 255) {
		    res = false;
		    break;
		}
	    }
	} else {
	    res = false;
	}

	return res;
    }

    // 判断掩码是否是前面全为1后面全为0的格式
    private static boolean validMaskCode(String maskCode) {
	boolean res = true;
	String[] nums = maskCode.split("\\.");
	StringBuffer sb = new StringBuffer();
	for (String num : nums) {
	    int n = Integer.valueOf(num);
	    sb.append(binaryString(n));
	}
	int firstIndexOf0 = sb.indexOf("0");
	int lastIndexOf1 = sb.lastIndexOf("1");
	if (firstIndexOf0 < lastIndexOf1) {
	    res = false;
	}
	return res;
    }

    // 将整数转成对应的八位二进制字符串
    private static String binaryString(int num) {
	StringBuffer result = new StringBuffer();
	int flag = 1 << 7;
	for (int i = 0; i < 8; i++) {
	    int val = (flag & num) == 0 ? 0 : 1;
	    result.append(val);
	    num <<= 1;
	}
	return result.toString();
    }

}

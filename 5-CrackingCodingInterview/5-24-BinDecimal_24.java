package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年8月31日 上午10:19:01
 */

public class BinDecimal_24 {

    // 方法一： div=num*2, 判断是否>=1: >=1代表该位为1, num=div-1.0; 否则该位为0.
    public static String printBin1(double num) {
	StringBuffer sb = new StringBuffer();
	sb.append("0.");

	while (num > 0) {
	    double div = num * 2;
	    if (div >= 1) {
		sb.append("1");
		num = div - 1.0;
	    } else {
		sb.append("0");
		num = div;
	    }
	    if (sb.length() > 34)
		return "Error";
	}
	return sb.toString();
    }

    // 方法二：base=0.5, num>=base, 则第一位则为1, num减去0.5; 否则为0.
    //      无论是不是为1, base都的除以2, 以来判断第二位是不是为1.
    public static String printBin2(double num) {
	StringBuffer sb = new StringBuffer();
	sb.append("0.");

	double base = 0.5;
	while (num > 0) {
	    if (num >= base) {
		num -= base;
		sb.append("1");
	    } else {
		sb.append("0");
	    }

	    base /= 2;

	    if (sb.length() > 32) {
		return "Error";
	    }
	}
	return sb.toString();
    }
    
    public static void main(String[] args) {
	String numStr1 = printBin1(0.625);
	System.out.println(numStr1);
	
	String numStr2 = printBin2(0.625);
	System.out.println(numStr2);
    }

}

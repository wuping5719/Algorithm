package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月3日 下午9:37:01
 */

public class TransferToEgypt_48 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.nextLine();
 
            String result = transferToEgypt(str);
            System.out.println(result);
        }
        cin.close();
    }
 
    // 将一个分数转换成埃及分数之和
    private static String transferToEgypt(String str) {
        StringBuffer sb = new StringBuffer();
        int index = str.indexOf('/');
        int numerator = Integer.parseInt(str.substring(0, index));       //分子
        int denominator = Integer.parseInt(str.substring(index + 1));    //分母
 
        while (numerator >= 1) {
            if (denominator %  numerator == 0) {  //可以约分化为真分数形式
                sb.append(1).append("/").append(denominator/numerator);
                break;
            }
            for (int i=1, j=numerator-1; i<j; i++, j--) {
                if (denominator%i==0 && denominator%j==0) {
                    sb.append(1);
                    sb.append("/");
                    sb.append(denominator/j);
                    sb.append("+");
                    sb.append(1);
                    sb.append("/");
                    sb.append(denominator/i);
                    return sb.toString();
                } else {
                    i++;
                    j--;
                }
            }
 
            int quotient = denominator / numerator;   //商
            numerator = numerator * (quotient + 1) - denominator;
            denominator = denominator * (quotient + 1);
            sb.append(1);
            sb.append("/");
            sb.append(quotient + 1);
            sb.append("+");
        }
 
        return sb.toString();
    }
} 

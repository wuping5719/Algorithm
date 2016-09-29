package huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月29日 下午3:43:48
 */

public class StringsSeparate_4 {

    public static ArrayList<String> getSeparateString(String str) {
	ArrayList<String> result = new ArrayList<String>();
	if (str.length() > 0) {
	    int length = 0;
	    boolean isNeedFillZero = false;
	    if (str.length() % 8 == 0) {
		length = str.length() / 8;
	    } else {
		length = str.length() / 8 + 1;
		isNeedFillZero = true;
	    }

	    char[] temp = str.toCharArray();
	    int count = 0;
	    StringBuffer sb = new StringBuffer();
	    if (isNeedFillZero) {
		for (int i = 0; i < 8 * length; i++) {
		    if (i < temp.length) {
			if (count < 8) {
			    sb.append(temp[i]);
			} else {
			    count = 0;
			    result.add(sb.toString());

			    sb = new StringBuffer();
			    sb.append(temp[i]);
			}
		    } else {
			sb.append('0');
			if (i == 8 * length - 1) {
			    result.add(sb.toString());
			}
		    }
		    count++;
		}
	    } else {
		for (int i = 0; i < temp.length; i++) {
		    if (count < 8) {
			sb.append(temp[i]);
		    } else {
			count = 0;
			result.add(sb.toString());

			sb = new StringBuffer();
			sb.append(temp[i]);
		    }
		    if (i == temp.length - 1) {
			result.add(sb.toString());
		    }
		    count++;
		}
	    }
	}
	return result;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str1 = cin.nextLine();
	    String str2 = cin.nextLine();
	    
	    ArrayList<String> result1 = new ArrayList<String>(); 
	    result1 = getSeparateString(str1);
	    for(int i=0; i<result1.size(); i++) {
		System.out.println(result1.get(i));
	    }
	    
	    ArrayList<String> result2 = new ArrayList<String>(); 
	    result2 = getSeparateString(str2);
	    for(int i=0; i<result2.size(); i++) {
		System.out.println(result2.get(i));
	    }
	}
	cin.close();

    }

}

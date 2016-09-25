package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月25日 下午4:20:18
 */

public class CountCharNum {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    String[] array = str.split(" ");
	    char[] charArry1 = array[0].toCharArray();
	    char[] charArry2 = array[1].toCharArray();
	    StringBuffer sb = new StringBuffer();
	    for(int i=0; i<charArry2.length; i++) {
		int count = 0;
		for(int j=0; j<charArry1.length; j++) {
		    if(charArry1[j] == charArry2[i]) {
			count++;
		    }
		}
		sb.append(count);
		sb.append(" ");
	    }
	    System.out.println(sb.toString());
	}
	cin.close();
    }

}

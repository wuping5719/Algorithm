package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月4日 下午10:47:53
 */

public class StringSort_63 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    StringBuffer sb = new StringBuffer();
	    for (int i=0; i<26; i++)
            {
                char c = (char)(i + 'A');
                for (int j=0; j<str.length(); j++)
                {
                    if (str.charAt(j) == c || str.charAt(j) == (char)(c + 32)) {
                	sb.append(str.charAt(j));
                    }
                }
            }
             
            for (int i=0; i<str.length(); i++)
            {
                if (!((str.charAt(i)>='A' && str.charAt(i)<='Z') 
                	|| (str.charAt(i)>='a' && str.charAt(i)<='z'))) {
                    sb.insert(i, str.charAt(i));
                }
            }
            System.out.println(sb.toString());
	}
	cin.close();
    }

}

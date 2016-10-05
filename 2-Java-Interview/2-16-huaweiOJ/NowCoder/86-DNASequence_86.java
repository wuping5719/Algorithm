package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午11:02:28
 */

public class DNASequence_86 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
            String str = cin.next();
            int n = cin.nextInt();
            int max = 0;
	    int maxBeginIndex = 0;
	    for (int i = 0; i <= str.length() - n; i++) {
		int count = 0;
		for (int j = i; j < i + n; j++) {
		    if (str.charAt(j) == 'G' || str.charAt(j) == 'C') {
			count++;
		    }
		}
		if (count > max) {
		    maxBeginIndex = i;
		    max = count;
		}
	    }
	    System.out.println(str.substring(maxBeginIndex, maxBeginIndex + n));
	}
	cin.close();
    }

}

package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月4日 下午11:20:15
 */

public class Pick7_64 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    
	    int count = 0;
	    for(int i=1; i<=n; i++) {
		if(i % 7 == 0) {
		    count++; 
		}else {
		    boolean isHave7 = false;
		    String numStr = String.valueOf(i);
		    for(int j=0; j<numStr.length(); j++) {
			if(numStr.charAt(j)=='7') {
			    isHave7 = true;
			    break;
			}
		    }
		    if(isHave7) {
			count++; 
		    }
		}
	    }
	    
	    System.out.println(count);
	}
	cin.close();
    }

}

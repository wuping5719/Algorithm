package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月15日 上午10:54:31
 */

public class GetNextSymmetrixNum {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    
	    if(n > 0) {
		int nextN = n+1;
		boolean hasFind = false;
	        while(!hasFind) {
		    String tempStr = String.valueOf(nextN);
		    int start = 0;
		    int end = tempStr.length() - 1;
		    boolean isSymmetrix = false;
		    while(start <= end) {
			if(tempStr.charAt(start) == tempStr.charAt(end)) {
			    start++;
			    end--;
			}else {
			    break;
			}
		    }
		    if(start > end) {
			isSymmetrix = true;
		    }
		    if(isSymmetrix) {
			break;
		    }
		    nextN++;
		}
	        System.out.println(nextN);
	    }
	}
	cin.close();
    }

}

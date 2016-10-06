package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月6日 下午10:45:53
 */

public class CountNumberOf2_43 {

    public static int countNumberOf2s(int n) {
        String str = "";
        int count = 0;
	for(int i=0; i<=n; i++) {
	    str = String.valueOf(i);
            for(int j=0; j<str.length(); j++) {
        	if(str.charAt(j)=='2') {
        	    count++;
        	}
            }
        }
	return count;
    }
    
    public static int countNumberOf2s1(int n) {
	int count = 0;
        int low = 0;
        int high = 0;
        int cur = 0;
        int flag = 1;
        while(n / flag != 0)
        {
            low = n - (n / flag) * flag;
            cur = (n / flag) % 10;
            high = n / (flag * 10);
            if(cur == 1 || cur == 0) {
        	count += high * flag;
            }
            if(cur == 2) {
        	count += high * flag + low + 1;
            } 
            if(cur > 2) {
        	count += (high + 1) * flag;
            }
                
            flag *= 10;
        }
        return count;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    //System.out.println(countNumberOf2s(n));
	    System.out.println(countNumberOf2s1(n));
	}
	cin.close();
    }

}

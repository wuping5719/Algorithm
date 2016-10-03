package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月3日 下午4:26:50
 */

public class LegalIP_41 {

    public static String isLegalIP(String str) {
	String[] strArray = str.split("\\.") ;
	String isLegalIP = "YES";
	if(strArray.length != 4) {
	    return "NO";
	}else {
	    for(int i=0; i<strArray.length; i++) {
		if(strArray[i].length() > 3) {
		    isLegalIP = "NO";
		    break;
		}else {
		    int temp = Integer.parseInt(strArray[i]);
		    if(temp<0 || temp>255) {
			isLegalIP = "NO";
		    }
		}
	    }
	}
	return isLegalIP;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            String str = cin.nextLine();
            System.out.println(isLegalIP(str));
        }
        cin.close();
    }

}

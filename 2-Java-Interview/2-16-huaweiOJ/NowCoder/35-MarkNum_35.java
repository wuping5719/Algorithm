package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月2日 下午10:14:17
 */

public class MarkNum_35 {
  
    //将数字周围都加上*, 两个数字中间肯定有两个**,然后替换掉就行
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String inputStr = cin.nextLine();
	    char[] charArray = inputStr.toCharArray();
	    StringBuffer sb = new StringBuffer();
	    
	    for(int i=0; i<charArray.length; i++) {
		if(charArray[i]>='0' && charArray[i]<='9') {
		    sb.append('*');
		    sb.append(charArray[i]);
		    sb.append('*');
		}else {
		    sb.append(charArray[i]);
		}
	    }
	    //两个数字中间有**替换掉
	    System.out.println(sb.toString().replace("**", ""));
	}
	cin.close();
    }

}

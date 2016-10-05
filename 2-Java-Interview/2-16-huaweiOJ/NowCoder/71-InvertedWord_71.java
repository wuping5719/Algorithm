package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午3:32:38
 */

public class InvertedWord_71 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    String[] strArray = str.split("\\W");  //str.split("[^a-zA-Z]+");
	    StringBuffer sb = new StringBuffer();
	    for(int i=strArray.length-1; i>1; i--) {
		sb.append(strArray[i].trim() + " ");
	    }
	    //如果字符串数组的第一个元素是空串, 那么下标为1的元素就是最后一个要输出的元素, 末尾不要再加空格
	    if(strArray[0].length()==0) {
		sb.append(strArray[1].trim());
	    }else {
		sb.append(strArray[1] +' '+ strArray[0]);
	    }
	    System.out.println(sb.toString());
	}
        cin.close();
    }

}

package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月10日 下午3:31:49
 */

public class StringFinder_53 {
    
    public static int findString(String[] str, int n, String x) {
	int start = 0;
        int end = n-1;
        int mid = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            //假如是空格, 向左(或向右)找到第一个不为空的字符
            if(str[mid].compareTo("") == 0)
            {
                int index = mid;
                while(index >= start && str[index].compareTo("") == 0) { 
                    index--;
                }
                if(index < start) { 
                    start = mid + 1;  //一直到最左边都是空格,那么只能在右半边查找
                }else if(str[index].compareTo(x) == 0) {
                    return index;   //左边第一个非空字符等于x, 直接返回下标
                }
                else if(str[index].compareTo(x) > 0) { 
                    end = mid - 1;     //左边第一个非空字符串大于x, 那只能继续向左查找
                }else {
                    start = mid + 1;   //否则, 向右查找
                }
            }
            else{
                if(str[mid].compareTo(x) == 0) { 
                    return mid;
                }
                else if(str[mid].compareTo(x) > 0) { 
                    end = mid - 1;
                }else {  
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    String[] strArray = str.split(",");
	    String strN = cin.nextLine();
	    int n = Integer.parseInt(strN);
	    String x = cin.nextLine();
	    System.out.println(findString(strArray, n, x));
	}
	cin.close();
    }

}

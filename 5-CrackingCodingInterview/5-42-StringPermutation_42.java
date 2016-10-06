package crackingCodingInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月6日 下午10:24:58
 */

public class StringPermutation_42 {

    public static ArrayList<String> getPermutation(String A) {
	ArrayList<String> list = new ArrayList<String>();
	if(A.length() == 0) {
	    return list;
	}
	
        char[] cArray = A.toCharArray();
	permutation(cArray, list, 0);
	
	//排序
	Collections.sort(list, new Comparator<String>() {
	    public int compare(String o1, String o2) {
		return o2.compareTo(o1);
	    }
	});
	
	return list;
    }
    
    public static void permutation(char[] cArray, ArrayList<String> list, int cur){
        int len = cArray.length;

        if(cur == len-1){  //到最后一个字符, 就插入结果
            list.add(String.valueOf(cArray));
            return;
        }
        for(int i = cur; i < len; ++i){
            //交换元素
            char temp1 = cArray[i];
            cArray[i] = cArray[cur];
            cArray[cur] = temp1;
            
            permutation(cArray, list, cur+1); //递归调用
            
            //换回来
            temp1 = cArray[i];
            cArray[i] = cArray[cur];
            cArray[cur] = temp1;
        }
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String A = cin.nextLine();
	    ArrayList<String> list = getPermutation(A);
	    for(int i=0; i<list.size(); i++) {
		System.out.print(list.get(i) + " ");
	    }
	    System.out.println();
	}
	cin.close();
    }

}

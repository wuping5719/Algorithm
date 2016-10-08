package crackingCodingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月8日 下午10:55:11
 */

public class VariableWordOrder_51 {
    
    /* 对每个字符串进行内部排序, 得到变位词的一个标准排序作为hash的key,
    *  value采用链表存储该key对应的各变位词,遍历完后假定分成了x组
    *  对x组进行遍历,找出每组最小的字符串进行存储,最后将ArrayList中的字符串再次排序
    */
    public static ArrayList<String> sortStrings(String[] str, int n) {
	ArrayList<String> reslist = new ArrayList<String>();
	if(str==null || n<=0) {
	    return reslist;
	}
	
	LinkedHashMap<String, LinkedList<String>> hash = new LinkedHashMap<String, LinkedList<String>>();
        for(String s : str){
            String firstStr = sortChar(s);
            if(hash.containsKey(firstStr)){
        	LinkedList<String> list = hash.get(firstStr);
                list.add(s);
            }else{
        	LinkedList<String> list = new LinkedList<String>();
                list.add(s);
                hash.put(firstStr, list);
            }
        }

        for(String key : hash.keySet()){
            LinkedList<String> list = hash.get(key);
            Collections.sort(list);
            reslist.add(list.getFirst());
        }
        Collections.sort(reslist);
        return reslist;
    }
    
    private static String sortChar(String s) {
        char[] sChar = s.toCharArray();
        Arrays.sort(sChar);
        return new String(sChar);
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    String[] strArray = str.split(",");
	    int n = strArray.length;
	    
	    ArrayList<String> reslist = sortStrings(strArray, n);
	    for(String s : reslist) {
		System.out.print(s + " ");
	    }
	    System.out.println();
	}
	cin.close();
    }

}

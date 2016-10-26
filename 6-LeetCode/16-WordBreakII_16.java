package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author WuPing
 * @version 2016年10月26日 下午7:39:53
 */

public class WordBreakII_16 {

    // 思路: 将字符串切割为两部分左边s1和右边s2, 如果s1包含在字典中, 
    // 则递归计算s2切割生成的字符串集合, 并将s1和s2返回的结果合并.
    // s2可能无法切割, 我们让其返回一个空的ArrayList.
    // s为空串是我们规定返回包含一个""的ArrayList.
    // 仅仅递归会超时, 用一个map记录字符串对应的结果.
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
	HashMap<String, List<String>> map = new HashMap<>();
	return dfs(s, dict, map);
    }

    public static ArrayList<String> dfs(String s, Set<String> dict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) {
            return (ArrayList<String>) map.get(s);
        }
            
        ArrayList<String> lists = new ArrayList<>();
        if (s.equals(""))
            lists.add("");
        else {
            int len = s.length();
            for (int i = 1; i <= len; i++) {
                String sub = s.substring(0, i);
                if (dict.contains(sub)) {
                    ArrayList<String> temp = dfs(s.substring(i, len), dict, map);
                    if (temp.size() == 0) {
                        continue;
                    } else {
                        for (int j = 0; j < temp.size(); j++) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(sub).append(" ").append(temp.get(j));
                            lists.add(sb.toString().trim());
                        }
                    }
                }
            }
        }
        map.put(s, lists);
        return lists;
    }
    
    public static void main(String[] args) {
	String s = "catsanddog";
	Set<String> dict = new HashSet<>();
	dict.add("cat");
	dict.add("cats");
	dict.add("and");
	dict.add("sand");
	dict.add("dog");
	
	ArrayList<String> result = wordBreak(s, dict);
	for(String str: result) {
	    System.out.println(str);
	}
    }

}

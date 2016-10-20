package crackingCodingInterview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月20日 下午4:22:08
 */

public class LongestString_79 {
    
    // 先按字符串长度排个序, 然后从长度最长的开始判断是否是由其他的组成的。
    // 每次都从字符串的前端开始切, 递归地判断.
    public static int getLongest(String[] str, int n) {
        if (str == null || str.length == 0) {
            return 0;
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        for (String key : str) {
            map.put(key, true);
        }
        for (String string : str) {
            if (canBuildWord(string, true, map)) {
                return string.length();
            }
        }
        return 0;
    }
 
    private static boolean canBuildWord(String str, boolean isOriginal, Map<String, Boolean> map) {
        if (map.containsKey(str) && !isOriginal) {
            return map.get(str);
        }
        for (int i = 1; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i);
            if (map.containsKey(left) && map.get(left) && canBuildWord(right, false, map)) {
                return true;
            }
        }
        map.put(str, false);
        return false;
    }
 

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String strLine = cin.nextLine();
	    String[] str = strLine.split(",");
	    int n = str.length;
	    
	    System.out.println(getLongest(str, n));
	}
	cin.close();
    }

}

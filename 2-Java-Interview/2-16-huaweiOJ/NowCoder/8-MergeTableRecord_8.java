package huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author WuPing
 * @version 2016年9月30日 下午7:29:00
 */

public class MergeTableRecord_8 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();

	    TreeMap<Integer, Long> map = new TreeMap<Integer, Long>();
	    for (int i = 0; i < n; i++) {
		int key = cin.nextInt();
		long value = cin.nextInt();
		if (map.containsKey(key)) {
		    long temp = map.get(key) + value;
		    map.put(key, temp);
		} else {
		    map.put(key, value);
		}
	    }

	    for (Map.Entry<Integer, Long> entry : map.entrySet()) {
		System.out.println(entry.getKey() + " " + entry.getValue());
	    }
	}
	cin.close();
    }

}

package huawei;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月1日 下午3:40:58
 */

public class SimpleMistakeRecord_19 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);

	//需要按输入顺序输出所以要使用LinkedHashMap
	LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
	while (cin.hasNext()) {
	    String filePath = cin.next();
	    
	    //以end结束输出
	    if(filePath.trim().equals("end")) {
		break;
	    }
	    
	    int lineNumber = cin.nextInt();
	    
	    // 输入的文件可能带路径，记录文件名称不能带路径
	    String[] filePathArray = filePath.split("\\\\"); // 根据'\'分隔文件路径
	    String file = filePathArray[filePathArray.length - 1];

	    // 超过16个字符的文件名称，只记录文件的最后有效16个字符
	    if (file.length() > 16) {
		file = file.substring(file.length() - 16);
	    }

	    // 对相同的错误记录(净文件名称和行号完全匹配)只记录一条, 错误计数增加
	    String key = file + " " + lineNumber;
	    if (map.containsKey(key)) {
		map.put(key, map.get(key) + 1);
	    } else {
		map.put(key, 1);
	    }
	}
	cin.close();

	// 记录最多8条错误记录, 循环记录
	int count = 0;
	for (String str : map.keySet()) {
	    count++;
	    if (count > (map.keySet().size() - 8)) { // 输出最后八个记录
		System.out.println(str + " " + map.get(str));
	    }
	}
    }

}

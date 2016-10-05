package huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月5日 下午11:17:08
 */

public class ConfigurationFileRecovery_87 {

    public static boolean isMatch(String src, String des) {
        int index = 0;
        while(index < src.length() && index < des.length()){
            if(src.charAt(index) == des.charAt(index)) {
        	index++;
            }else {
        	 break;
            } 
        }
        if(index == src.length()) {
            return true; 
        }else {
            return false;
        } 
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	
	HashMap<String, String> map = new HashMap<>();
	map.put("reset", "reset what");
	map.put("reset board", "board fault");
	map.put("board add", "where to add");
	map.put("board delet", "no board at all");
	map.put("reboot backplane", "impossible");
        map.put("backplane abort", "install first");
        
	while (cin.hasNext()) {
            String str = cin.nextLine();
            String[] strArray = str.split(" ");
            
            int count = 0;  // 记录匹配个数
            String key = "";
            for(String s : map.keySet()){
                String[] temps = s.split(" ");
                if(temps.length == strArray.length){
                    int i = 0;
                    while(i < temps.length){
                        if(isMatch(strArray[i], temps[i])) {
                            i++;  
                        }else {
                            break;
                        }  
                    }
                    if(i == temps.length){  //找到匹配
                        key = s;
                        count++;
                    }                      
                }
            }
            if(count != 1) {
        	System.out.println("unkown command");
            }else {
        	System.out.println(map.get(key));
            } 
	}
	cin.close();
    }

}

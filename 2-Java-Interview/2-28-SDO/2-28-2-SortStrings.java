package acmCoder;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author WuPing
 * @version 2016年9月28日 下午8:40:33
 */

public class SortStrings {
    /*
China
USA
Japan
Italy
France
Spain
Germany
Denmark
end
    */
    public static String sortCountry(ArrayList<String> list) {
	String res = "";
	if(list!=null && list.size()>0) {
	    int num = list.size();
	    String[] country = new String[num];
	    for(int i=0; i<num; i++) {
		country[i] = list.get(i);
	    }
	    Arrays.sort(country);
	    
	    StringBuffer sb = new StringBuffer();
	    for(int i=0; i<num; i++) {
		if(i==0) {
		    sb.append(country[i]);
		}else {
		    sb.append(",");
		    sb.append(country[i]);
		}
	    }
	    res = sb.toString();
	}
	return res;
    }
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	ArrayList<String> list = new ArrayList<String>();
	while (sc.hasNext()) {
	    String str = sc.nextLine().trim();
	    if(str.equals("end")) {
		String result = sortCountry(list);
		System.out.println(result);
		list.clear();
	    }else {
		list.add(str);
	    }
	}
	
	sc.close();
    }

}

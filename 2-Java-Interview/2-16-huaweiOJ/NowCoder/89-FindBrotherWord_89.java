package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月6日 下午2:50:04
 */

public class FindBrotherWord_89 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
            String[] wordbook = new String[n];
            for(int i=0; i<n; i++){
        	wordbook[i] = cin.next();
            }
            String key = cin.next();
            char[] keyChar = key.toCharArray();
            Arrays.sort(keyChar);
            int num = cin.nextInt(); //第几个
            
            int count = 0;
            ArrayList<String> list = new ArrayList<String>();
            for(int i=0; i<n; i++){
        	if(!key.equals(wordbook[i]) && key.length()==wordbook[i].length()) {
        	    char[] wordChar = wordbook[i].toCharArray();
                    Arrays.sort(wordChar);
                    if(Arrays.equals(keyChar, wordChar)) {
                        count += 1;
                        list.add(wordbook[i]);
                    }
        	}
            }
                    
            System.out.println(count);
            Collections.sort(list);
            if(count >= num) {
        	System.out.println(list.get(num-1));
            } 
	}
	cin.close();
    }

}

package crackingCodingInterview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月20日 上午10:38:34
 */

public class StringChange_78 {
    
    public static int countChanges(String[] dic, int n, String s, String t) {
        if(s.equals(t)) {
            return 0;
        }  
        if(isChange(s, t)) {
            return 1;  
        } 
        Queue<String> queue = new LinkedList<String>();
        queue.offer(s);
        boolean[] flag = new boolean[n];
        for(int i=0; i<n; i++)
            if(dic[i].equals(s)){
                flag[i] = true;
                break;
            }
        int count=0;
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int i=0; i<size; i++){
                String temp = queue.poll();
                for(int j=0; j<n; j++){
                    if(!flag[j] && isChange(temp, dic[j])){
                        if(dic[j].equals(t)) {
                            return count;
                        } 
                        queue.offer(dic[j]);
                        flag[j] = true;
                    }
                }
            }
        }
        return -1;
    }
    public static boolean isChange(String s, String st){
        if(s.length() != st.length()) {
            return false;
        }
            
        int len = s.length();
        int count = 0;
        for(int i=0; i <len; i++) {
            if(s.charAt(i) != st.charAt(i)) {
        	count++; 
            }   
        }
        if(count != 1) {
            return false;
        }else {
            return true; 
        }  
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    String[] dic = str.split(",");
	    int n = dic.length;
	    String s = cin.nextLine();
	    String t = cin.nextLine();
	    System.out.println(countChanges(dic, n, s, t));
	}
	cin.close();
    }

}

package swordOffer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author WuPing
 * @date 2016年8月27日 下午2:50:14
 * @version 1.0
 */
public class LastNumberInCircle_45 {

	// 方法一
	public static int LastRemaining_Solution1(int n, int m) {
       if(n<1 || m<1){
    	   return -1;
       }
       
       ArrayList<Integer> list = new ArrayList<Integer>();
       for(int i=0; i<n; i++){
    	   list.add(i);
       }
       
       int index = -1;
       while (list.size() > 1) {
           index = (index + m) % list.size();
           list.remove(index);
           index--;
       }
       int lastOne = list.get(0);
       
       return lastOne;
	}

	// 方法二
	public static int LastRemaining_Solution2(int n, int m) {
		if(n<1 || m<1){
	    	   return -1;
	    }
        if(n==1)
            return 0;
        else
            return (LastRemaining_Solution2(n-1, m) + m) % n;
	}
	
	// 方法三
	public static int LastRemaining_Solution3(int n, int m) {
		if(n<1 || m<1){
	    	   return -1;
	    }
        
        int last = 0;
        for(int i=2; i<=n; i++){
        	last = (last + m) % i;
        }
        return last;
	}
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
        	int n = cin.nextInt();
        	int m = cin.nextInt();
        	int result = LastRemaining_Solution1(n, m);
        	//int result = LastRemaining_Solution2(n, m);
        	//int result = LastRemaining_Solution3(n, m);
        	System.out.println(result);
        }
        cin.close();
	}

}

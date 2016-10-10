package crackingCodingInterview;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月10日 下午8:19:09
 */

public class MasterMind_62 {
    // 伪猜中个数 = 可能的伪猜中个数 - 猜中个数  
    public static int[] calcResult(String A, String guess) {
	if (A == null || guess == null) {
            return new int[] {0, 0};
        }
        // right 表示猜中
        // unright 表示伪猜中
        int right = 0;
        int unright = 0;
        // 保存A中的<字符,字符个数>
        HashMap<Character, Integer> map = new HashMap<>();
         
        for (int i = 0; i < A.length(); i++){
            // 统计猜中
            if(A.charAt(i) == guess.charAt(i))
                right++;
             
            // 获取A中的<字符,字符个数>
            if(map.containsKey(A.charAt(i))){
        	map.put(A.charAt(i), map.get(A.charAt(i))+1);
            }else{
        	map.put(A.charAt(i), 1);
            }
        }
         
        // 统计伪猜中的个数(猜中也属于伪猜中)
        for(int i=0; i<guess.length(); i++){
            
            if(map.containsKey(guess.charAt(i))) {
        	int val = map.get(guess.charAt(i));
        	if(val > 0) {
        	    unright++;
        	    val--;
        	    if(val < 0) {
        		val = 0;
        	    }
                    map.put(guess.charAt(i), val);
        	}
            }
        }
        // 从伪猜中当中, 去除猜中个数
        unright = unright - right;
        return new int[] {right, unright}; 
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String A = cin.nextLine();
	    String guess = cin.nextLine();
	    int[] result = calcResult(A, guess);
	    System.out.println(result[0] +","+ result[1]);
	}
	cin.close();
    }

}

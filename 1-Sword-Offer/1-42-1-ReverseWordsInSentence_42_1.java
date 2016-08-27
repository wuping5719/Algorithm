package swordOffer;

import java.util.Scanner;
import java.util.Stack;

/** 
 * @author  WuPing
 * @date 2016年8月27日 上午9:33:05 
 * @version 1.0 
 */
public class ReverseWordsInSentence_42_1 {

	// 方法一：用Split单独处理每个单词,对于多个空格的处理不是很好
    public static String ReverseSentence(String str) {
        if(str == null)
        	return null;
        
        if(str.trim().equals("")){
            return str;
        }
        
        String[] wordArray = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=wordArray.length; i>0; i--){
        	sb.append(wordArray[i-1]);
            if(i > 1){
            	sb.append(" ");
            }
        }
        return sb.toString();
    }

    // 方法二：用栈实现
    public static String ReverseSentence2(String str) {
        if (str == null || str.length() == 0)
            return str;
        
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            } else {
                stack.push(sb.toString());
                sb = new StringBuilder();
            }
        }
        stack.push(sb.toString());
        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
    
	public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
        	String str = cin.nextLine();
        	String result = ReverseSentence(str);
        	//String result = ReverseSentence2(str);
        	System.out.println(result);
        }
        cin.close();
	}

}

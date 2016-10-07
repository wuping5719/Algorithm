package crackingCodingInterview;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author WuPing
 * @version 2016年10月7日 下午3:01:50
 */

public class LegalBracketSequence_44 {

    public static boolean chkParenthesis1(String A, int n) {
	if(A == null || A.length() != n){
            return false;
        }
	int l = 0;  //左括号数
        for (int i = 0; i < n; i++) {
           char c = A.charAt(i);
           if (c == '(') {
              l++;
            } else if (c == ')') {
               if (l > 0) {
                  l--;
               } else {
                  return false;
               }
            } else {
               return false;
           }
        }
 
        return l == 0;
    }
    
    public static boolean chkParenthesis2(String A, int n) {
	// 1.碰到")"开始弹出栈顶的"(", 如果此时栈为空, 则返回false
        // 2.碰到其他内容直接返回false
        // 3.字符串结尾时,栈非空返回false
         
        Stack<Character> lefts = new Stack<Character>();
        if(A == null || A.length() != n){
            return false;
        }
        for(int i = 0; i < n; i++){
            if(A.charAt(i) == '('){
                lefts.push(A.charAt(i));
            }else if(A.charAt(i) == ')'){
                if(lefts.empty()){
                    return false;
                }else{
                    lefts.pop();
                }
            }else{
                return false;
            }
        }
        if(lefts.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    String[] strArray = str.split(",");
	    String A = strArray[0];
	    int n = Integer.parseInt(strArray[1]);
	    //System.out.println(chkParenthesis1(A, n));
	    
	    System.out.println(chkParenthesis2(A, n));
	}
	cin.close();
    }

}

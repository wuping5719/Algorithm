package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年10月16日 下午11:51:15
 */

public class IsSubString_73 {
    
    public static boolean[] chkSubStr(String[] p, int n, String s) {
	boolean[] result = new boolean[n];
	for(int i=0; i<n; i++) {
	    if(s.contains(p[i])){ 
		result[i] = true;
	    }else {
		result[i] = false;
	    }
	}
	return result;
    }
    
    public static void main(String[] args) {
	String[] p = {"a", "b", "c", "d"};
	int n = p.length;
	String s = "abc";
	boolean[] result = chkSubStr(p, n, s);
	for(int i=0; i<n; i++) {
	    System.out.print(result[i] + " ");
	}
    }

}

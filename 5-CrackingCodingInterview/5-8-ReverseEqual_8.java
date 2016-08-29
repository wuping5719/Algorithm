package crackingCodingInterview;
/** 
 * @author  WuPing
 * @date 2016年8月29日 下午10:36:16 
 * @version 1.0 
 */
public class ReverseEqual_8 {

	// 方法一
	public static boolean checkReverseEqual(String s1, String s2) {
		if (s1 == null && s2 != null) {
			return false;
		}
		if (s1 != null && s2 == null) {
			return false;
		}
		if(s1 == null && s2 == null){
			return true;
		}
		if (s1.length() != s2.length()) {
			return false;
		}

		char[] strArray1 = new char[256];
		char[] strArray2 = new char[256];
		for (int i = 0; i < strArray1.length; i++) {
			strArray1[i] = 0;
			strArray2[i] = 0;
		}

		char[] str1 = s1.toCharArray();
		for (int i = 0; i < str1.length; i++) {
			strArray1[str1[i]]++;
		}

		char[] str2 = s2.toCharArray();
		for (int i = 0; i < str2.length; i++) {
			strArray2[str2[i]]++;
		}

		for (int i = 0; i < strArray1.length; i++) {
			if (strArray1[i] != strArray2[i]) {
				return false;
			}
		}

		return true;
    }
	
	// 方法二
	public static boolean checkReverseEqual2(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) {
			return false;
		}
		String tempStr = s1 + s1;
		if (tempStr.contains(s2)) {
			return true;
		}
		return false;

	}
	
	public static void main(String[] args) {
        String s1 = "Hello world";
        String s2 = "worldhello ";
        boolean result1 = checkReverseEqual2(s1, s2);
        System.out.println(result1);
        
        String s3 = "waterbottle";
        String s4 = "erbottlewat";
        boolean result2 = checkReverseEqual2(s3, s4);
        System.out.println(result2);
	}

}

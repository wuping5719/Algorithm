package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月3日 下午11:00:06
 */

public class AddExtraLongPositiveInt_52 {

    public static String addExtraLongPositiveInt(String addend, String augend)
    {
       StringBuffer sb = new StringBuffer();
       int addendLen = addend.length();
       int augendLen = augend.length();
       int maxLen = addendLen > augendLen ? addendLen : augendLen;
       
       int[] addendArray = new int[maxLen+1];
       int[] augendArray = new int[maxLen+1];
       int[] resultArray = new int[maxLen+1];
       for(int i=0; i<(maxLen+1); i++) {
	   addendArray[i] = 0;
	   augendArray[i] = 0;
	   resultArray[i] = 0;
       }
       for(int i=0; i<addendLen; i++) {
	   addendArray[i] = addend.charAt(addendLen-i-1) - '0';
       }
       for(int i=0; i<augendLen; i++) {
	   augendArray[i] = augend.charAt(augendLen-i-1) - '0';
       }
       
       for(int i=0; i<maxLen; i++) {
	    resultArray[i] = resultArray[i] + addendArray[i] + augendArray[i];
	    if (resultArray[i] > 9) {
		resultArray[i+1] = resultArray[i] / 10;
		resultArray[i] = resultArray[i] % 10;
	    }
       }
       
       if(resultArray[maxLen] != 0) {
	  sb.append(resultArray[maxLen]);
       }
       for(int i=maxLen-1; i>=0; i--) {
	  sb.append(resultArray[i]);
       }
       
       return sb.toString();     
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String addend = cin.nextLine();
            String augend = cin.nextLine();
            String result = addExtraLongPositiveInt(addend, augend);
            System.out.println(result);
        }
        cin.close();
    }

}

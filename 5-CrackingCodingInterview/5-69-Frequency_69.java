package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月15日 下午6:46:08
 */

public class Frequency_69 {
    
    public static int getFrequency(String[] article, int n, String word) {
        if(article ==null || n < 0) {
            return 0;
        }
        int count = 0;
        for(int i=0; i<n; i++) {
            if(article[i].equals(word)) {
        	count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String str = cin.nextLine();
	    String[] article = str.split(" ");
	    String word = cin.nextLine();
	    int n = article.length;
	    System.out.println(getFrequency(article, n, word));
	}
	cin.close();
    }

}

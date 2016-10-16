package acmCoder;

/**
 * @author WuPing
 * @version 2016年10月16日 下午11:29:10
 */

public class WordClosestDistance_72 {

    public static int getDistance(String[] article, int n, String x, String y) {
	int index_X = -1;
	int index_Y = -1;
	int result = n;
	for (int i = 0; i < n; i++) {
	    if (x.equals(article[i])) {
		index_X = i;
	    } else if (y.equals(article[i])) {
		index_Y = i;
	    }
	    // 确保x和y都至少找到了一个
	    if (index_X != -1 && index_Y != -1) {
		int temp = Math.abs(index_Y - index_X);
		result = temp < result ? temp : result;
	    }
	}
	return result;
    }
    
    public static void main(String[] args) {
	String[] article = {"word1", "word2", "word3", "word4", "word5", 
		"word1", "word4", "word3", "word2", "word5"};
	int n = article.length;
	String x = "word1"; 
	String y = "word3"; 
	System.out.println(getDistance(article, n, x, y));
    }

}

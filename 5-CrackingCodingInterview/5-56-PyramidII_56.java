package crackingCodingInterview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月10日 下午4:52:04
 */

public class PyramidII_56 {

    public static int getHeight(int[][] actors, int n) {
	Comparator<int[]> comparator = new Comparator<int[]>() {
	    public int compare(int[] a, int[] b) {
		if (a[0] < b[0])
		    return -1;
		else if (a[0] > b[0])
		    return 1;
		else {
		    if (a[1] < b[1])
			return -1;
		    else if (a[1] > b[1])
			return 1;
		    else
			return 0;
		}
	    }
	};
	Arrays.sort(actors, comparator);
	int[] res = new int[n];
	res[0] = 1;
	int max = 1;

	for (int i = 1; i < n; i++) {
	    int t = 0;
	    for (int j = 0; j < i; j++) {
		if (actors[i][1] > actors[j][1])
		    t = Math.max(t, res[j]);
	    }
	    res[i] = t + 1;
	    max = Math.max(max, res[i]);
	}
	return max;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int[][] actors = new int[n][2];
	    for(int i=0; i<n; i++) {
		actors[i][0] = cin.nextInt();
		actors[i][1] = cin.nextInt();
	    }
	    System.out.println(getHeight(actors, n));
	}
	cin.close();
    }

}

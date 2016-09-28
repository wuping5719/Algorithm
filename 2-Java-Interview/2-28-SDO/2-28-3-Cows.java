package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月28日 下午9:18:23
 */

public class Cows {
    
    // 三角形构造:最大三角形面积
    /*
     5
     1
     1
     3
     3
     4
     692
    */
    
    public static int countCow(int n, int[] array) {
	int res = -1;
	
	int a = 0;
	int b = 0;
	int c = 0;

	double maxArea = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
        	for(int k=0; k<n; k++) {
                    if(i!=j && i!=k && j!=k) {
                	a = array[i];
                	b = array[j];
                	c = array[k];
                	
                	int min = a < b ? a : b;
                	min = min < c ? min : c;
                	
                	int max = a > b ? a : b;
                	max = max > c ? max : c;
                	
                	int mid = a+b+c-min-max;
                	
                	if((min>0) && (min + mid > max) && (max - mid < min)) {
                	    double p = (a+b+c) / 2.0;
                	    double curArea = Math.sqrt(p*(p-a)*(p-b)*(p-c));
                	    if(curArea > maxArea) {
                		maxArea = curArea;
                		res = (int)(maxArea * 100);
                	    }
                	}
                    }
                }  
            } 
        }
	return res;
    }
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (sc.hasNext()) {
	    int n = sc.nextInt();
	    int[] array = new int[n];
	    for(int i=0; i<n; i++) {
		array[i] = sc.nextInt();
	    }
	    
	    int result = countCow(n, array);
            System.out.println(result);   
	}
	
	sc.close();
    }

}

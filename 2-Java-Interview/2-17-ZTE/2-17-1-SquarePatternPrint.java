package interview.zte;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年8月26日 下午2:08:19
 */

public class SquarePatternPrint {

    public static void squarePatternPrint(int n) {
       if(n<=0)
	   return;
       if(n==1) {
	   System.out.print(1);
       }
       
       if(n>1) {
	   int[][] array = new int[n][n];
	   int startIndex = 0;
	   int endIndex = n-1;
	   int sumNum = 1;
	   while(startIndex<=endIndex) {
	       if(n/2==startIndex) {
		   for(int i=0; i<n; i++) {
		       array[startIndex][i] = sumNum;
		       sumNum++;
		   }
		   startIndex++;
	       }else {
		   for(int i=0; i<n; i++) {
		       array[startIndex][i] = sumNum;
		       sumNum++;
		   }
		   startIndex++;
		   
		   for(int j=0; j<n; j++) {
		       array[endIndex][j] = sumNum;
		       sumNum++;
		   }
		   endIndex--;
	       }
	   }
	   
	   for(int i=0; i<n; i++) {
	       for(int j=0; j<n; j++) {
		   if(j==n-1) {
		       System.out.print(array[i][j]);
		   }
		   else {
		       System.out.print(array[i][j] + "*");
		   }
	       }
	       System.out.println();
	   }
       }
    }

    public static void main(String[] args) {
       Scanner cin = new Scanner(System.in);
       while(cin.hasNext()) {
	   int n = cin.nextInt();
	   squarePatternPrint(n);
       }
       cin.close();
    }

}

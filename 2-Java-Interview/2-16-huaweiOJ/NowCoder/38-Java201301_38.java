package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月3日 下午3:29:52
 */

public class Java201301_38 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            int n = cin.nextInt();
            int sum1 = 0; 
            int sum2 = 0;
            int[] array = new int[n];
            int count = 0;
            for(int i=0; i<n; i++){
                int temp = cin.nextInt();
                if(temp%5 == 0){
                    sum1 += temp;
                }
                else if(temp%3 == 0)
                    sum2 += temp;
                else{
                    array[count++] = temp;
                }
            }
            int difference = Math.abs(sum1-sum2);  //这里只考虑绝对值就可以了
            System.out.println(f(0, count, array, 0, difference));
        }
        cin.close();
   }

   public static boolean f(int i, int n, int[] array, int result, int difference){
       if(i == n){
          return Math.abs(result) == difference;  //绝对值相等就可以
       }
       else{
           return (f(i+1, n, array, result+array[i], difference)
        	   || f(i+1, n, array, result-array[i], difference));
       }
   }
   
}

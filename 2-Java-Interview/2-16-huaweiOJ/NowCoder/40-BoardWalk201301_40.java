package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月3日 下午4:15:17
 */

public class BoardWalk201301_40 {

    //简单递归
    public static int f(int n,int m)
    {
        if(n == 1) {
            return (m+1); 
        }   
        else if(m == 1) {
            return (n+1); 
        }  
        else {
            return f(n, m-1) + f(n-1, m);  
        } 
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            int n = cin.nextInt();
            int m = cin.nextInt();
            long result = f(n, m);
            System.out.println(result);
        }
        cin.close();
    }

}

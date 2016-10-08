package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月8日 下午9:08:03
 */

public class Queens_48 {

    public static void nQueensCore(int array[], int i, int n, int[] count){
        if(i > n){
            count[0]++;
            return;
        }
        for(int j=1; j<=n; j++){
            array[i] = j;
            if(place(array, i)) {
        	nQueensCore(array, i+1, n, count);
            } 
        }
    }
    
    public static boolean place(int[] array, int i){
        for(int j=1; j<i; j++) {
            if((array[j]==array[i]) || (array[j]-array[i]==(j-i))
        	    || (array[j]-array[i]==i-j)) {
        	return false;
            }
        } 
       return true;
    }
    
    public static int nQueens(int n) {
	int[] count = new int[1];
	count[0] = 0;
	int[] array = new int[n+1];
	nQueensCore(array, 1, n, count);
	return count[0];
    }
    
    //方法二
    //思路: 运用数组cols[n]保存第n行的皇后位置
    public static int nQueens1(int n) { 
        int[] cols = new int[n]; 
        int[] num = {0}; 
        for (int i = 0; i < n; i++) { 
            cols[0] = i;  //第一行皇后的位置 
            getCount(cols, 1, num); 
        } 
        return num[0]; 
    } 
    //除了第一行外,每行赋值皇后的位置,并判断位置是否合理,若能成功赋值最后一行位置 ,方法数+1
    public static void getCount(int[] cols, int row, int[] num) { 
        if (row == (cols.length)) { 
            num[0]++; 
            return; 
        } 
        for (int i = 0; i < cols.length; i++) { 
            if (checkValid(cols, row, i)) { 
                cols[row] = i; 
                getCount(cols, row + 1, num); 
            } 
        } 
   
    } 
    // 判断插入的皇后位置是否合理 
    private static boolean checkValid(int[] cols, int row, int col) { 
        for (int i = 0; i < row; i++) { 
            int temp = cols[i]; 
            if ((temp == col) || (Math.abs(row - i) == Math.abs(temp - col))) { 
        	return false; 
            }  
        } 
        return true; 
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    //System.out.println(nQueens(n));
	    
	    System.out.println(nQueens1(n));
	}
	cin.close();
    }

}

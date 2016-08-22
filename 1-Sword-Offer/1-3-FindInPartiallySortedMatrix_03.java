package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月22日 下午8:35:53 
 * @version 1.0 
 */
public class FindInPartiallySortedMatrix_03 {

	public static boolean Find(int [][] array, int target) {
	   boolean found = false;
	   if(array!=null){
		   int n = array[0].length;  //矩阵维数
		   int row = 0;
		   int column = n - 1;
		   while(row < n && column >= 0){
			   if(array[row][column]==target){
				   found = true;
				   break;
			   }
			   else if(array[row][column]>target){
				   column--;
			   }
			   else{
				   row++;
			   }
		   }
		   
	   }
	   return found;
    }
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();  //矩阵维数
			int [][] array = new int[n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					array[i][j] = in.nextInt();
				}
			}
			int target = in.nextInt();
			boolean isFind = Find(array, target);
			System.out.println(isFind);
		}
		in.close();
	}

}

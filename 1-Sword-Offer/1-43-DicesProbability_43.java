package swordOffer;

import java.util.Scanner;

/** 
 * @author  WuPing
 * @date 2016年8月27日 下午2:00:25 
 * @version 1.0 
 */
public class DicesProbability_43 {

	private static final int g_maxValue = 6;
	
	public static void PrintProbability(int number) {
		if(number < 1){
			return;
		}
		
		int[][] probabilities = new int[2][g_maxValue * number + 1];
		for(int i=0; i<g_maxValue * number + 1; i++){
			probabilities[0][i] = 0;
			probabilities[1][i] = 0;
		}
		
		int flag = 0;
		for(int i=1; i<=g_maxValue; i++){
			probabilities[flag][i] = 1;
		}
		
		for(int k=2; k<=number; k++){
			for(int i=0; i<k; i++){
				probabilities[1-flag][i] = 0;
			}
			
			for(int i=k; i<=g_maxValue*k; i++){
				probabilities[1-flag][i] = 0;
				for(int j=1; j<=i && j<=g_maxValue; j++){
					probabilities[1-flag][i] += probabilities[flag][i-j];
				}
			}
			
			flag = 1 - flag;
		}
		
		double total = Math.pow((double)g_maxValue, number);
		for(int i=number; i<=g_maxValue * number; i++){
			double ratio = (double)probabilities[flag][i] / total;
			System.out.println(i + ": " + ratio);
		}
	}
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
        	int n = cin.nextInt();
        	PrintProbability(n);
        }
        cin.close();
	}

}

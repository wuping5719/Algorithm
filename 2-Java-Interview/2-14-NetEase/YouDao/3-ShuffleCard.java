package interview;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author WuPing
 * @version 2016年8月17日 下午7:39:55
 */

public class ShuffleCard {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	int t = cin.nextInt();
	while (t-- > 0) {
	    int n = cin.nextInt();
	    int k = cin.nextInt();
	    int[] cardData = new int[n * 2];
	    for (int i = 0; i < n * 2; i++) {
		cardData[i] = cin.nextInt();
	    }
	    
            for (int j = 0; j < k; j++) {
        	cardData = shuffleCard(cardData, n);	
	    }
		    
            for (int i = 0; i < n * 2; i++) {
        	if(i==0) {
        	    System.out.print(cardData[i]);
        	}else {
        	    System.out.print(" "+cardData[i]);
        	}
	    }
            System.out.println();
	}
	cin.close();
    }

    public static int[] shuffleCard(int card[], int n) {
	int cardA[], cardB[];
	cardA = new int[n];
	cardB = new int[n];
	for (int i = 0; i < card.length; i++) {
		if (i < n) {
		    cardA[i] = card[i];
		} else {
		    cardB[i - n] = card[i];
		}
	}

	Stack<Integer> stack = new Stack<Integer>();
	for (int j = n - 1; j >= 0; j--) {
	    stack.push(cardB[j]);
	    stack.push(cardA[j]);
	}
	
	int nextIndex = 0;
	while (!stack.empty()) {
	    card[nextIndex]= stack.peek();
	    stack.pop();
	    nextIndex++;
	}
	return card;
    }

}


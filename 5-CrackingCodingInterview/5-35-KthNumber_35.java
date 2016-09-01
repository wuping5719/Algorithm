package crackingCodingInterview;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月1日 上午9:17:31
 */

public class KthNumber_35 {

    // 方法一
    public static int findKth1(int k) {
	int kthIndex = k + 1;
	int[] numbers = new int[kthIndex];
	numbers[0] = 1;
	int nextIndex = 1;

	int i3 = 0;
	int i5 = 0;
	int i7 = 0;

	while (nextIndex < kthIndex) {
	    int multiply3 = numbers[i3] * 3;
	    int multiply5 = numbers[i5] * 5;
	    int multiply7 = numbers[i7] * 7;
	    int min = (multiply3 < multiply5) ? multiply3 : multiply5;
	    min = (min < multiply7) ? min : multiply7;

	    numbers[nextIndex] = min;

	    if (min == multiply3) {
		i3++;
	    }
	    if (min == multiply5) {
		i5++;
	    }
	    if (min == multiply7) {
		i7++;
	    }

	    nextIndex++;
	}

	int kthN = numbers[nextIndex-1];
	return kthN;

    }

    // 方法二
    public static int findKth(int k) {
        int num = 3;
        while(num>0 && k>0){
            int temp = num;
            while(temp % 3 == 0)
                temp /= 3;
            while(temp % 5 ==0)
                temp /= 5;
            while(temp % 7 ==0)
                temp /= 7;
            if(1 == temp)
                k--;
            num++;
        }
        return --num;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNextInt()) {
	    int k = cin.nextInt();
	    int kthN = findKth(k);
	    System.out.print(kthN);
	}
	cin.close();
    }

}

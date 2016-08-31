package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年8月31日 下午9:41:18
 */

public class AddSubstitution_32 {
    
    //方法一
    private static boolean zeroDivError = false;

    public static int calc(int a, int b, int type) {
	int result = 0;
	if (type == 1) {
	    if (b != 0) {
		for (int i = 0; i < b; i++) {
		    result = result + a;
		}
	    }

	    if ((a < 0 && b < 0)) {
		result = -result;
	    }
	} else if (type == 0) {
	    if (b == 0) {
		zeroDivError = true;
		result = -1;
	    }

	    int tempSum = 0;
	    int tempA = Math.abs(a);
	    int tempB = Math.abs(b);
	    int divNum = 0;
	    while (tempSum <= tempA) {
		tempSum = tempSum + tempB;
		divNum++;
	    }

	    result = divNum-1;
	    if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
		result = -result;
	    }
	} else if (type == -1) {
	    if (b < 0) {
		result = a + Math.abs(b);
	    }
	    if (a < 0 && b > 0) {
		result = -(Math.abs(a) + b);
	    } 
	    if (a > 0 && b > 0) {
		int sub = 0;
		int tempA = a;
		int tempB = b;
		if(a > b) {
		    while(tempB < a) {
			tempB++;
			sub++;
		    }
		}else {
		    while(tempA < b) {
			tempA++;
			sub++;
		    }
		}
		
		result = a > b ? sub: -sub;
	    } 
	}

	return result;
    }

    //方法二
    public static int calc2(int a, int b, int type) {
	int result = 0;
	if (type == 1) {
	    int temp = 0;
	    for (int i = 0; i < b; i++) {
		temp += a;
	    }
	    result = temp;
	} else if (type == 0) {
	    int temp = a;
	    int count = 0;
	    while (temp > 0 && temp >= b) {
		temp = temp + (~b) + 1;
		count++;
	    }
	    result = count;
	} else {
	    result = a + (~b) + 1;
	}
	return result;
    }
    
    public static void main(String[] args) {
	int a = 4;
	int b = 2;
	int type = -1;
	int result = calc(a, b, type);
	System.out.println(result);
	System.out.println(zeroDivError);
    }

}

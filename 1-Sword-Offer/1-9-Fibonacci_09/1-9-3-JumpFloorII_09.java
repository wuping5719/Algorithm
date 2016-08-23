package swordOffer;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年8月23日 下午4:40:52
 */

public class JumpFloorII_09 {

    public static long JumpFloorII(int target) {
        if(target<=0) {
            return 0;
        }
        if (target == 1) {
	    return 1;
	}
        long jumpFloorIIN = 1;
        for(int i=1; i<target; i++) {
            jumpFloorIIN = jumpFloorIIN*2;
        }
        return jumpFloorIIN;
    }

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	while(scanner.hasNext()) {
	    long result = JumpFloorII(scanner.nextInt());
	    System.out.println(result);
	}
	scanner.close();
    }

}

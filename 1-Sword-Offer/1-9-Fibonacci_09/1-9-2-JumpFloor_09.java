package swordOffer;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年8月23日 下午4:33:19
 */

public class JumpFloor_09 {

    public static long JumpFloor(int target) {
	if (target <= 0) {
	    return 0;
	}
	if (target == 1) {
	    return 1;
	}
	if (target == 2) {
	    return 2;
	}
	long jumpFloorOne = 2;
	long jumpFloorTwo = 1;
	long jumpFloorN = 0;
	for (int i = 3; i <= target; i++) {
	    jumpFloorN = jumpFloorOne + jumpFloorTwo;

	    jumpFloorTwo = jumpFloorOne;
	    jumpFloorOne = jumpFloorN;
	}

	return jumpFloorN;
    }

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	while(scanner.hasNext()) {
	    long result = JumpFloor(scanner.nextInt());
	    System.out.println(result);
	}
	scanner.close();
    }

}

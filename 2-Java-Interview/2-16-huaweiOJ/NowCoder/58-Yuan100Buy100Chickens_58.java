package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月4日 下午7:12:51
 */

public class Yuan100Buy100Chickens_58 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    cin.nextInt();
	    
	    int cock = 0;    //公鸡
	    int hen = 0;     //母鸡
	    int chick = 0;   //小鸡
	    int sum = 0;
	    for(int i=0; i<100/5; i++) {
		for(int j=0; j<100/3; j++) {
		    cock = i;
		    hen = j;
		    chick = 100 - cock - hen;
		    if(chick % 3 == 0) {
			sum = cock * 5 + hen * 3 + chick / 3;
			if(sum == 100) {
			    System.out.println(cock +" "+ hen +" "+ chick);
			}
		    }
		}
	    }
	    
	}
	cin.close();
    }

}

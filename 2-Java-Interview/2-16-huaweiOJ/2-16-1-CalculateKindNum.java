package interview.huawei;

import java.util.*;

/**
 * @author WuPing
 * @date 2016年8月20日 下午10:46:47
 * @version 1.0
 */
public class CalculateKindNum {
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextInt()) {
			int x = cin.nextInt();
			int y = cin.nextInt();
			int kindNum = calculateKindNum(x, y);
			System.out.println(kindNum);
		}
	    cin.close();
	}
	
	public static int calculateKindNum(int x, int y) {
		int manNum = 1; // 男人数量
		int womanNum = 1; // 女人数量
		int childNum = x - manNum - womanNum; // 小孩数量
		int kindNum = 0; // 有效组合数
		for(int i=1; i<=x; i++){
			manNum = i;
			for(int j=1; j<=x; j++) {
				womanNum = j;
				if(3 * manNum + 2 * womanNum + 1 * childNum == y){
					kindNum++;
				}
			}
		}
		return kindNum;
	}
}

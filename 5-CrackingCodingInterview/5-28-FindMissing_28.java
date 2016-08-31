package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年8月31日 下午3:31:16
 */

public class FindMissing_28 {

    // 方法一
    public static int findMissing1(int[][] numbers, int n) {
        if(numbers == null) {
            return 0;
        }
        
	int num = n;
	for(int i=0; i<numbers.length; i++) {
            int temp = 0;
            for(int j=0; j<numbers[i].length; j++) {
        	temp = temp + numbers[i][j] * (int) Math.pow(2.0, (double)j);
            }
            if(temp != i) {
        	num = i;
        	return num;
            }
        }
	return num;
    }
    
    // 方法二
    // 整数值x的二进制表示最低位为1的时候, x为奇数; 最低位为0时, x为偶数.
    // 由于数组中的数是0~n剩余数按照从小到大进行排列的, 因此在缺失数之前,
    // 数组行标与数是相等的, 即行标i=x, 此时行标i%2的值与数组中numbers[i][0]是相等的, 
    // 即i为奇数, numbers[i][0]为1; 为偶数时,numbers[i][0]为0.
    // 第一个 i%2与numbers[i][0]不相等处即为缺失数.
    // 要注意缺失数为n即最大值的情况, 要单独return n.
    public static int findMissing2(int[][] numbers, int n) {
	for (int i = 0; i < n; i++) {
	    if (i % 2 != numbers[i][0])
		return i;
	}

	return n;
    }
    
    public static void main(String[] args) {
	int[][] numbers = {{0},{0,1}}; 
	int n = 2;
	int result = findMissing1(numbers, n);
	System.out.println(result);
    }

}

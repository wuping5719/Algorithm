package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年8月31日 下午3:08:13
 */

public class ExchangeOddEven_27 {

    // 方法一：  用0xAAAAAAAA与x相与求的奇数位上数字(偶数位上数字为0)
    //       用0x55555555与x相与求的偶数位上数字(奇数位上数字为0)
    // oddVal右移一位, even左移一位相加即可.
    public static int exchangeOddEven1(int x) {
	int oddVal = (x & 0xAAAAAAAA);   // bit 1 3 5 ... 31
        int evenVal = (x & 0x55555555);  // bit 0 2 4 ... 30
        return (oddVal >> 1) + (evenVal << 1);
    }
    
    // 方法二：  用0xAAAAAAAA与x相与求的奇数位上数字(偶数位上数字为0)
    // int是有符号整型, 所以如果x的最高位为1, 那么取偶数位得到的数even的最高位也为1, 
    // 如果此时右移, 那么最高位补1而不是0, 后面或的时候就有可能出问题, 因为1|0等于1, 改变了不该变的值.
    public static int exchangeOddEven2(int x) {
	 int odd  = ((x&0x55555555)<<1);
	 int even = ((x&0xAAAAAAAA)>>1)&0x7fffffff; 
	 return even|odd;
    }
    
    public static void main(String[] args) {

    }

}

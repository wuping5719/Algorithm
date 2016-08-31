package crackingCodingInterview;
/** 
 * @author  WuPing
 * @date 2016年8月31日 下午7:09:03 
 * @version 1.0 
 */
public class AntsCollision_30 {

	/*
	 * 每个蚂蚁爬行的方向都有两个, 即围绕多边形顺时针爬和逆时针爬, 因此n个蚂蚁爬行的方法有2^n种.
	 * 只有当所有的蚂蚁按照同一个方向爬行才能保证所有的蚂蚁都不相撞, 只有两种方法--都按逆时针或顺时针方向爬行.
	 * 所以相撞的概率为1 - (double) 2 / (2 ^n).
	*/
	public static double antsCollision(int n) {
        //return 1-2/Math.pow(2, n);
        return 1.0 - 1.0/(1 << (n-1));
    }
	
	public static void main(String[] args) {
		int n = 8;
		double result = antsCollision(n);
		System.out.print(result);
	}

}

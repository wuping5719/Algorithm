package crackingCodingInterview;
/** 
 * @author  WuPing
 * @date 2016年8月31日 下午7:23:51 
 * @version 1.0 
 */
public class CrossLine_31 {

	// 小数比较要考虑精度问题
	public static boolean checkCrossLine(double s1, double s2, double y1, double y2) {
        if(Math.abs(s1-s2) < 1E-32){
        	if(Math.abs(y1-y2) < 1E-32){
        		return true;
        	}
        	else{
        		return false;
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		double s1 = 0.5;
		double s2 = 0.5;
		double y1 = 10.0;
		double y2 = 20.0;
		boolean result = checkCrossLine(s1, s2, y1, y2);
		System.out.print(result);
	}

}

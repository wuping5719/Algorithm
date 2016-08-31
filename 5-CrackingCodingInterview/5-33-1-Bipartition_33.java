package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年8月31日 下午10:12:25
 */

public class Bipartition_33 {

    // 精度计算存在一些问题
    public static double[] getBipartition(Point[] A, Point[] B) {
	double[] result = new double[2];
	
	double a_center_x = (A[0].x + A[2].x) / 2.0; // A中心点的X坐标
	double a_center_y = (A[0].y + A[2].y) / 2.0; // A中心点的Y坐标
	double b_center_x = (B[0].x + B[2].x) / 2.0; // B中心点的X坐标
	double b_center_y = (B[0].y + B[2].y) / 2.0; // B中心点的Y坐标

	result[0] = (a_center_y - b_center_y) / (a_center_x - b_center_x); // 斜率
	if(Math.abs(result[0])==0) {
	    result[0] = 0.0; 
	}
	result[1] = a_center_y - result[0] * a_center_x; // 截距

	return result;
    }

    public static void main(String[] args) {
	Point[] A = new Point[4];
	A[0] = new Point(0, 0);
	A[1] = new Point(0, 1);
	A[2] = new Point(1, 1);
	A[3] = new Point(1, 0);

	Point[] B = new Point[4];
	B[0] = new Point(1, 0);
	B[1] = new Point(1, 1);
	B[2] = new Point(2, 0);
	B[3] = new Point(2, 1);

	double[] result = getBipartition(A, B);
	System.out.println(result[0] + "," + result[1]);
    }

}

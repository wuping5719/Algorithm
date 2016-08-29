package crackingCodingInterview;
/** 
 * @author  WuPing
 * @date 2016年8月29日 下午9:05:46 
 * @version 1.0 
 */
public class TransFormImage_6 {

	// 方法一
	/* 思路：逐层旋转, 最外层向内, 其中layer表示当前所处理的层,
	  每次都是n*n矩阵中可以形成方阵中的四个数进行旋转,
	  左->上, 下->左, 右->下, 上->右的顺序,
	  在第一步之前先存储“上”中的值.
	*/
	public static int[][] transformImage1(int[][] mat, int n) {
		for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n-1-layer;
            for(int i = first; i < last; i++){
                int offset = i - first;
                int top = mat[first][i];
                //left -> top
                mat[first][i] = mat[last - offset][first];
                //bottom -> left
                mat[last-offset][first] = mat[last][last-offset];
                //right -> bottom
                mat[last][last-offset] = mat[i][last];
                //top -> right
                mat[i][last] = top;
            }
        }
        return mat;
    }
	
	// 方法二
	// 两次交换：1.交换副对角线上的数, 2.第i行和第n-i-1交换(i从0开始计数)
	public static int[][] transformImage2(int[][] mat, int n) {
		// 交换副对角线上的数
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[n - j - 1][n - i - 1];
				mat[n - j - 1][n - i - 1] = temp;
			}
		}
		// 第i行和第n-i-1交换(i从0开始计数)
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[n - i - 1][j];
				mat[n - i - 1][j] = temp;
			}
		}
		return mat;
	}

	public static void main(String[] args) {
       int[][] mat = {{1,2,3},
    		   {4,5,6},
    		   {7,8,9}};
       int n = 3;
       transformImage2(mat, n);
	}

}

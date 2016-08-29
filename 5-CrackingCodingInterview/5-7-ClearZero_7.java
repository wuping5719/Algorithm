package crackingCodingInterview;
/** 
 * @author  WuPing
 * @date 2016年8月29日 下午9:52:08 
 * @version 1.0 
 */
public class ClearZero_7 {

	public static int[][] clearZero(int[][] mat, int n) {
		if (mat == null || n <= 0) {
			return null;
		}
		boolean[] rowArray = new boolean[n];
		boolean[] columnArray = new boolean[n];
		// 记录为0的位置, 把相应的行列位置设为true
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					rowArray[i] = true;
					columnArray[j] = true;
				}
			}
		}

		// 遍历找到之前记录的位置, 把相应行列赋值为0
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (rowArray[i] || columnArray[j]) {
					mat[i][j] = 0;
				}
			}
		}
		return mat;
	}
	 
	public static void main(String[] args) {
        int[][] mat = {{1,2,3},{0,1,2},{0,0,1}};
        int n = 3;
        int[][] result = clearZero(mat, n);
        for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
        }
	}

}

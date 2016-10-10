package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年10月10日 下午4:03:07
 */

public class FinderMatrix_54 {

    /*
     * 从右上角开始, 每次将搜索值与右上角的值比较, 如果大于右上角的值, 则直接去除1行, 否则,则去掉1列.
                   算法复杂度O(n),最坏情况需要2n步,即从右上角开始查找,而要查找的目标值在左下角的时候.
    */
    public static int[] findElement(int[][] mat, int n, int m, int x) {
	int[] result = new int[2];
	if(n == 0 || m == 0){
            return result;
        }
        int row = 0;
        int col = m - 1;
        while(row < n && col >= 0){
            // 大于目标, 剔除这个数字所在的列
            if(mat[row][col] > x){
        	col--;
            } // 小于目标, 剔除这个数字所在的行
            else if(mat[row][col] < x){
        	row++;
            }else{
        	result[0] = row;
        	result[1] = col;
                return result;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
	int[][] mat= {{1, 2, 3}, {4, 5, 6}};
	int n = 2;
	int m = 3;
	int x = 6;
	int[] point = findElement(mat, n, m, x);
        System.out.println("["+ point[0] +","+ point[1] +"]");
    }

}

package crackingCodingInterview;
/** 
 * @author  WuPing
 * @date 2016年8月30日 下午9:03:32 
 * @version 1.0 
 */
public class MinimalBST_18 {

	// 方法一: 投机直接算
	public static int buildMinimalBST1(int[] vals) {
		int size = vals.length;       
        return (int)(Math.log(size+1)/Math.log(2))+1;
	}
	
	// 方法二: 构造二叉搜索树, 然后计算高度
	public static int buildMinimalBST2(int[] vals) {
		if (vals == null || vals.length < 1)
            return 0;
        return buildBST(vals, 0, vals.length - 1);
	}
	public static int buildBST(int[] vals, int start, int end) {
        if (end <= start) {
            return 1;
        }
        int mid = (start + end) >> 1;
        int leftHeight = buildBST(vals, start, mid - 1);
        int rightHeight = buildBST(vals, mid + 1, end);
        return (leftHeight+1) > (rightHeight+1) ? (leftHeight+1) : (rightHeight+1);
    }
	
	public static void main(String[] args) {
	    int[] vals = {1,2,3,4,5,6,7,8,9};
	    int minimalBSTHeight = buildMinimalBST2(vals);
        System.out.println(minimalBSTHeight);
	}

}

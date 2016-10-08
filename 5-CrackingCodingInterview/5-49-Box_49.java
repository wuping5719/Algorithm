package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年10月8日 下午9:49:40
 */

public class Box_49 {

    private static void swap(int[] array, int x, int y) {
	int temp = array[x];
	array[x] = array[y];
	array[y] = temp;
    }
    
    //严格的最大递增子序列问题
    //先按照宽度排序(或者长度排序), 然后从第一个点开始找起, 看看本身能达到的最大高度
    public static int getHeight(int[] w, int[] l, int[] h, int n) {
	if (n <= 0) {
	    return 0;
	}
	
	for (int i = 0; i < n; i++) {
	    for (int j = i + 1; j < n; j++) {
		if (w[i] < w[j]) {
		    swap(w, i, j);
		    swap(l, i, j);
		    swap(h, i, j);
		}
	    }
	}
	
	int[] maxH = new int[n]; //存放n个箱子的最大上升高度
        maxH[0] = h[0];            //第一个箱子得到的最大高度就是本身
        int result = maxH[0];
        for(int i=1; i<n; i++)
        {
            maxH[i] = h[i];   //该箱子的最小高度(至少)就是本身的高度
            int temp = 0;
            //下面这个for循环主要计算该点(前面)能够得到的最大高度
            for(int j=i-1; j>=0; j--)
            {
                if(w[j]>w[i] && l[j]>l[i])
                {
                    temp = (temp > maxH[j]) ? temp : maxH[j];
                }
            }
            //将本身的高度加上之前箱子可以得到的最大高度, 得到现在的高度
            maxH[i] += temp;
            //result主要不断维护最大值, 不然还要在maxH数组中寻找最大值
            result=(result > maxH[i]) ? result : maxH[i];
        }
        return result;
    }
    
    public static void main(String[] args) {
	int[] w = {2, 1, 3, 5, 6};
	int[] l = {1, 2, 2, 4, 5};
	int[] h = {1, 1, 2, 2, 3};
	int n = 5;
	System.out.println(getHeight(w, l, h, n));
    }

}

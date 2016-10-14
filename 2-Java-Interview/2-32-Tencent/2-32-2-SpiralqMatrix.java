package array;

/**
 * @author WuPing
 * @version 2016年4月28日 下午3:46:44
 */

public class SpiralqMatrix {
    
    private static int Max(int a1, int a2) {  
        return a1 < a2 ? a2 : a1;  
    }  
  
    private static int Abs(int x) {  
        return x < 0 ? -x : x;  
    }  

    public static void PrintSpiralMatrix(int x, int y) {
	int c = Max(Abs(x), Abs(y));    // 当前坐标所在圈  
	int max = (c * 2 + 1) * (c * 2 + 1);// 当前圈上最大值  
	int number = 0; 
        if (y == -c) {  //上边  
            number = max + (x + y);  
        } else if (x == -c) {  //左边  
            number = max + (3 * x - y);  
        } else if (y == c) {  // 下边  
            number = max + (-x - 5 * y);  
        } else {    // 右边  
            number = max + (-7 * x + y);  
        }  
        
        System.out.print(" " + number + " ");
    }

    public static void Test(int dime) {
	int DimeMax = 20;   //设置矩阵最大维数，防止二维数组存储空间溢出
	if (dime < 1 || dime > DimeMax) {
	    System.out.println("矩阵维数非法！");
	    return;
	}
	System.out.println(dime*2+1 +"维螺旋矩阵：");
	for(int y=-dime; y<=dime; y++) {
	    for(int x=-dime; x<=dime; x++) {
		PrintSpiralMatrix(x, y);   
	    }
	    System.out.println();
	}
    }
    
    public static void main(String[] args) {   
	Test(0);   //非法值测试，0
	Test(-1);   //非法值测试，负值
	Test(60);   //非法值测试，超过上界
	
	Test(1);   //下界值测试
	Test(2);   //中间值测试
	Test(8);   //中间值测试
	Test(20);   //上界值测试
    }
}

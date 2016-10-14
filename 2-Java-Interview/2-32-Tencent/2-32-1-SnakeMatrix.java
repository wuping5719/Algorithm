package array;

/**
 * @author WuPing
 * @version 2016年4月28日 上午9:59:14
 */

public class SnakeMatrix {

    public static int[][] CreateSnakeMatrix(int dime) {
	int[][] snakeMatrix = new int[dime][dime];

	int count = 1; // 蛇形矩阵赋值计数
	int start = 0;

	while (dime > start * 2) {
	    int endX = dime - 1 - start;
	    int endY = dime - 1 - start;

	    // 从左到右生成一行
	    for (int i = start; i <= endX; ++i) {
		snakeMatrix[start][i] = count;
		count++;
	    }

	    // 从上到下生成一列
	    for (int i = start + 1; i <= endY; ++i) {
		snakeMatrix[i][endX] = count;
		count++;
	    }

	    // 从右到左生成一行
	    for (int i = endX - 1; i >= start; --i) {
		snakeMatrix[endY][i] = count;
		count++;
	    }

	    // 从下到上生成一行
	    for (int i = endY - 1; i >= start + 1; --i) {
		snakeMatrix[i][start] = count;
		count++;
	    }

	    ++start;
	}
	return snakeMatrix;
    }

    public static void PrintSnakeMatrix(int[][] snakeMatrix, int dime) {
	for (int i = 0; i < dime; i++) {
	    for (int j = 0; j < dime; j++) {
		System.out.print(" " + snakeMatrix[i][j] + " ");
	    }
	    System.out.println();
	}
    }

    public static void Test(int dime) {
	int DimeMax = 50;   //设置矩阵最大维数，防止二维数组存储空间溢出
	if (dime < 2 || dime > DimeMax) {
	    System.out.println("矩阵维数非法！");
	    return;
	}
	int[][] snakeMatrix = CreateSnakeMatrix(dime);
	System.out.println(dime +"维蛇形矩阵：");
	PrintSnakeMatrix(snakeMatrix, dime);
	System.out.println();
    }
    
    public static void main(String[] args) {
	Test(1);   //非法值测试，1
	Test(0);   //非法值测试，0
	Test(-1);   //非法值测试，负值
	Test(100);   //非法值测试，超过上界
	
	Test(5);   //中间值测试
	Test(8);   //中间值测试
	Test(2);   //下界值测试
	Test(50);   //上界值测试
    }
}

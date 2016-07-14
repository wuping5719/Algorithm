package array;
/**
 * @author WuPing
 * @version 2016年4月7日 下午7:11:44
 */

public class FindInPartiallySortedMatrix {

    public static boolean FindNumber(int[] matrix, int rows, int columns,
	    int number) {
	boolean found = false;
	if (matrix != null && rows > 0 && columns > 0) {
	    //以二维数组左下角的数为查找比对标准
	    int row = rows - 1;
	    int column = 0;
	    while (row >= 0 && column < columns) {
		if (matrix[row * columns + column] == number) {
		    found = true;
		    break;
		} else if (matrix[row * columns + column] > number) {
		    --row;
		} else {
		    ++column;
		}
	    }
	}
	return found;
    }

    public static void Test(String testName, int[] matrix, int rows,
	    int columns, int number, boolean expected) {
	if(testName != null) {
	    System.out.print(testName + " begins: ");
	    boolean result = FindNumber(matrix, rows, columns, number);
	    if(result == expected) {
		System.out.print("Passed.");
	        System.out.println();
	    }
	    else {
		System.out.print("Failed.");
	        System.out.println();
	    }
	}
    }
    
    public static void main(String[] args) {
	//此处以一维数组加行数和列数的形式表示二维数组
	int[] matrix = {1, 3, 6, 9, 2, 5, 7, 11, 4, 10, 13, 16, 8, 12, 15, 18};
    
	//要找的数在二维数组中，但不在左上角或右下角
	Test("Test1", matrix, 4, 4, 7, true);
	
	//要找的数不在二维数组中，但在数组范围内
	Test("Test2", matrix, 4, 4, 14, false);
	
	//要找的数在二维数组左上角
	Test("Test3", matrix, 4, 4, 1, true);
	
	//要找的数在二维数组右下角
	Test("Test4", matrix, 4, 4, 18, true);
	
	//要找的数在二维数组范围下界外
	Test("Test5", matrix, 4, 4, 0, false);
	
	//要找的数在二维数组范围上界外
	Test("Test6", matrix, 4, 4, 20, true);
	
	//传递的二维数组为空
	Test("Test7", null, 4, 4, 20, false);
	
    }
}

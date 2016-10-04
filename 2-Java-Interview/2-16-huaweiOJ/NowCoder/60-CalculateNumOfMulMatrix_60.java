package huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author WuPing
 * @version 2016年10月4日 下午8:09:26
 */

public class CalculateNumOfMulMatrix_60 {

    // 若矩阵表达式为(A(BC(D(EF)))), 首先将表达式化成(A(X(D(Y)))), 然后通过找")"依次计算
    private static int calculateMultiplyingCount(int[][] matrix, String expression) {
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        for(int i=0; i<expression.length(); i++) {
            char item = expression.charAt(i);
            if (Character.isLetter(item)) {   //若为一个矩阵
                if (!stack.isEmpty() && stack.peek() != -1) { //栈顶不为"("时, 计算矩阵并合并
                    int col = stack.pop();
                    int row = stack.pop();
                    int col2 = matrix[index][1];
                    result += row * col * col2;
 
                    stack.push(row);
                    stack.push(col2);
                } else {  
                    stack.push(matrix[index][0]);
                    stack.push(matrix[index][1]);
                }
                index++;
            }else if (item == '(') {
        	stack.push(-1);
            }else if (item == ')') {
                int col1 = stack.pop();  //弹出栈顶的矩阵
                int row1 = stack.pop();
                stack.pop();             //弹出"("
                if (stack.size() <= 1) {
                    return result;
                }
                if (stack.peek() != -1) { //若栈顶不为"(", 弹出栈顶矩阵并计算
                    stack.pop();  //col2 排在前面的矩阵
                    int row2 = stack.pop();
                    result += row2 * row1 * col1;
                    row1 = row2;
                }
                stack.push(row1);
                stack.push(col1);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String nStr = cin.nextLine();
	    int n = Integer.parseInt(nStr);
	    int[][] matrix = new int[n][2];
	    for(int i=0; i<n; i++) {
		String str = cin.nextLine();
		String[] tempArray =str.split(" ");
		matrix[i][0] = Integer.parseInt(tempArray[0]);
		matrix[i][1] = Integer.parseInt(tempArray[1]);
	    }
	    String expression = cin.nextLine();
	    
	    int result = calculateMultiplyingCount(matrix, expression);
	    System.out.println(result);
	}
	cin.close();

    }

}

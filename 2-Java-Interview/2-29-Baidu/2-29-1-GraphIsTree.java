package acmCoder;

/**
 * @author WuPing
 * @version 2016年9月29日 下午9:34:14
 */

public class GraphIsTree {

    public static int graphIsTree(int[][] matrix) {
       int edgeNum = 0;
       for(int i=0; i<matrix.length; i++) {
	   for(int j=0; j<matrix[0].length; j++) {
	      if(matrix[i][j]==1) {
		  edgeNum += 1;
	      } else if(i==j && matrix[i][j]==1) {
		  return 0;
	      }
	   } 
       }
       
       if(edgeNum %2 == 0) {
	   edgeNum = edgeNum / 2;
	    if (edgeNum == matrix.length - 1) {
		return 1;
	    } else {
		return 0;
	    }
       }else {
	   return 0;
       }
    }
    
    public static void main(String[] args) {
	int[][] matrix1 = {
		{0,1},
		{1,1}
		};
	int result1 = graphIsTree(matrix1);
	System.out.println(result1);
	
	int[][] matrix2 = {
		{0,1,0},
		{1,0,1},
		{0,1,0}
		};
	int result2 = graphIsTree(matrix2);
	System.out.println(result2);
	
	int[][] matrix3 = {
		{0,1,0,1},
		{1,0,1,0},
		{0,1,0,0},
		{1,0,0,0}
		};
	int result3 = graphIsTree(matrix3);
	System.out.println(result3);
    }

}

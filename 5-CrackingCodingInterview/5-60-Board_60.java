package crackingCodingInterview;

/**
 * @author WuPing
 * @version 2016年10月10日 下午7:39:41
 */

public class Board_60 {

    public static boolean checkWon(int[][] board) {
	int len = board.length;
	//检查行
        for(int i=0; i<len; i++)
        {
            int sum = 0;
            for(int j=0; j<len; j++) {
        	sum += board[i][j];
            } 
            if(sum == len) {
        	return true;
            }
        }
        //检查列
        for(int i=0; i<len; i++)
        {
            int sum = 0;
            for(int j=0; j<len; j++) {
        	sum += board[j][i];
            }
            if(sum == len) {
        	return true;
            }   
        }
        //检查主对角线
        int temp = 0;
        for(int i=0; i<len; i++)
        {
            temp += board[i][i];
        }
        if(temp == len) { 
            return true;
        }
         
        //检查副对角线
        temp = 0;
        for(int i=0; i<len; i++)
        {
            temp += board[i][len-i-1];
        }
        if(temp == len) { 
            return true;
        }
         
        return false;
    }
    
    public static void main(String[] args) {
	int[][] board = {{1, 0, 1}, {1, -1, -1}, {1, -1, 0}};
        System.out.println(checkWon(board));
    }

}

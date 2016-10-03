package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月3日 下午9:04:19
 */

public class TwoDimensionalArrayOperate_47 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()) {
           int m = cin.nextInt();
           int n = cin.nextInt();
           
           // 初始化表格是否成功, 若成功则返回0, 否则返回-1
           if(m>0 && m<=9 && n>0 && n<=9) {
               System.out.println(0);
           }else {
               System.out.println(-1);
           }
           
           int x1 = cin.nextInt();
           int y1 = cin.nextInt();
           int x2 = cin.nextInt();
           int y2 = cin.nextInt();
           // 输出交换单元格是否成功
           if((x1>=0 && x1<m && y1>=0 && y1<n) && (x2>=0 && x2<m && y2>=0 && y2<n)) {
               System.out.println(0);
           }else {
               System.out.println(-1);
           }
           
           int row = cin.nextInt();
           // 输出插入行是否成功
           if(row>=0 && row<m) {
               System.out.println(0);
           }else {
               System.out.println(-1);
           }
           
           int col = cin.nextInt();
           // 输出插入列是否成功
           if(col>=0 && col<n) {
               System.out.println(0);
           }else {
               System.out.println(-1);
           }
           
           int x = cin.nextInt();
           int y = cin.nextInt();
           // 输出要查询的运动轨迹的单元查询是否成功
           if(x>=0 && x<m && y>=0 && y<n) {
               System.out.println(0);
           }else {
               System.out.println(-1);
           }
        }
        cin.close();
    }

}

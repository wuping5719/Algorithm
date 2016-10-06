package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月6日 下午9:57:20
 */

public class MP3CursorPosition_101 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
           int n = cin.nextInt();
           String str = cin.next();
           
           int curHead = 1;
           int curPos = 0;
           if (n <= 4) {  //歌曲总数<=4的时候, 不需要翻页, 只是挪动光标位置
               for (int i = 0; i < str.length(); i++) {
                   if (str.charAt(i) == 'U') {
                       curPos = (curPos + n - 1) % n;
                   } else {
                       curPos = (curPos + 1) % n;
                   }
               }
           } else {
               for (int i = 0; i < str.length(); i++) {
        	   if (str.charAt(i) == 'U') {
        	       // 特殊翻页: 屏幕显示的是第一页(即显示第1–4首)时, 光标在第一首歌曲上,
        	       // 用户按Up键后, 屏幕要显示最后一页(即显示第7-10首歌),同时光标放到最后一首歌上
        	       if (curHead == 1 && curPos == 0) {
                           curHead = n - 3;
                           curPos = 3;
                       } else {
                           if (curPos > 0) {
                               curPos--;
                           } else {
                               curHead--;
                           }
                       }
                   } else { 
                       //屏幕显示最后一页时, 光标在最后一首歌曲上, 用户按Down键, 屏幕要显示第一页, 光标挪到第一首歌上
                       if (curHead == n - 3 && curPos == 3) {
                           curHead = 1;
                           curPos = 0;
                       } else {
                           if (curPos < 3) {
                               curPos++;
                           } else {
                               curHead++;
                           }
                       }
                   }
               }
           }
           for (int i = 0; i < Math.min(n, 4); i++) {
               if (i != 0) {
                   System.out.print(" ");
               }
               System.out.print((curHead + i));
           }
           System.out.println();
           System.out.println((curHead + curPos));
        }
        cin.close();
    }

}

package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月3日 下午7:04:19
 */

public class PlayingCardSize_42 {
    
    private static String poker = "345678910JQKA2jokerJOKER";
    
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
        while(cin.hasNext()) {
            String str = cin.nextLine();
            if(str.contains("joker JOKER")) {
                System.out.println("joker JOKER");
            }else {
                String[] strArray = str.split("\\-");
                String[] left = strArray[0].split(" ");
                String[] right = strArray[1].split(" ");
                if(left.length == 4 && right.length != 4) {
                    System.out.println(strArray[0]);
                }else if(left.length != 4 && right.length == 4) {
                    System.out.println(strArray[1]);
                }else if(left.length == right.length) {
                    String larger = poker.indexOf(left[0]) > poker.indexOf(right[0]) ? strArray[0] : strArray[1];
                    System.out.println(larger);
                }else {
                    System.out.println("ERROR");
                }
            }
        }
        cin.close();
    }

}

package interview;
/** 
 * @author  WuPing
 * @date 2016年8月3日 下午8:44:53 
 * @version 1.0 
 *  扑克类（一副扑克）  
 */
public class Poker {
	private static String[] suites = {"黑桃", "红桃", "草花", "方块"};
    private static int[] faces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    private Card[] cards;

    // 构造器
    public Poker() {
        cards = new Card[52];
        for(int i = 0; i < suites.length; i++) {
            for(int j = 0; j < faces.length; j++) {
                cards[i * 13 + j] = new Card(suites[i], faces[j]);
            }
        }
    }

    //洗牌 （随机乱序）
    public void shuffle() {
        for(int i = 0, len = cards.length; i < len; i++) {
            int index = (int) (Math.random() * len);
            Card temp = cards[index];
            cards[index] = cards[i];
            cards[i] = temp;
        }
    }

    //发牌
    //@param index 发牌的位置
    public Card deal(int index) {
        return cards[index];
    }

    /**
     * 卡片类（一张扑克）
     * [内部类]
     */
    public class Card {
        private String suite;   // 花色
        private int face;       // 点数

        public Card(String suite, int face) {
            this.suite = suite;
            this.face = face;
        }

        @Override
        public String toString() {
            String faceStr = "";
            switch(face) {
               case 1: faceStr = "A"; break;
               case 11: faceStr = "J"; break;
               case 12: faceStr = "Q"; break;
               case 13: faceStr = "K"; break;
               default: faceStr = String.valueOf(face);
            }
            return suite + faceStr;
        }
    }
}

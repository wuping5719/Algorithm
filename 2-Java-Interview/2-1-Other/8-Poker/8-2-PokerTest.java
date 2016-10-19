package interview;
/** 
 * @author  WuPing
 * @date 2016年8月3日 下午8:47:19 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class PokerTest {

	public static void main(String[] args) {
		Poker poker = new Poker();
        poker.shuffle();                // 洗牌
        Poker.Card c1 = poker.deal(0);  // 发第一张牌
        // 对于非静态内部类Card
        // 只有通过其外部类Poker对象才能创建Card对象
        Poker.Card c2 = poker.new Card("红心", 1);    // 自己创建一张牌

        System.out.println(c1);     // 洗牌后的第一张
        System.out.println(c2);     // 打印: 红心A
	}

}

package array;

/**
 * @author WuPing
 * @version 2016年7月21日 上午11:01:53
 */

public class JosephRing {

    public static void main(String[] args) {
	boolean[] usaJapa = new boolean[30];
	CalJosephRing(usaJapa, 9, 15);
    }

    /*
     * 使用一个boolean数组模拟，非教徒站在false位置，教徒站在true位置。
     * 开始所有的位置为true，每数到count时，自动将true设为false，
     * 如果该位置已为false，设置下一个true位置为false，如果已经循环到底，则重新开始。
     */
    // boolean数组模拟约瑟夫环， count代表出圈计数，noChristiansNum代表非教徒数量
    public static void CalJosephRing(boolean[] usaJapa, int count, int noChristiansNum) {
	for(int i=0; i<usaJapa.length; i++) {
	    usaJapa[i] = true;
	}
	
	int leftCount = usaJapa.length;
	int countNum = 0;
	int index = 0;
	while(leftCount > noChristiansNum) {
	    countNum ++;
	    if(usaJapa[index] == true && countNum == count) {
		countNum = 0;
		usaJapa[index] = false;
		leftCount --;
	    }
	    index ++;
	    if(index == usaJapa.length) {
		index = 0;
	    }
	}
	for(int i=0; i<usaJapa.length; i++) {
           System.out.println(i+"=" + usaJapa[i] + " ");
	}
    }
}

package os;
/** 
 * @author  WuPing
 * @date 2016年7月21日 下午10:21:10 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class SynchronizedTest {
	/*
	 * example:
	 * 一个电影院有20张票要卖，目前有3个售票员。
	 * 用sleep()函数来模拟售票，使用synchronized关键字避免冲突。
	 */
	public static class SellThread implements Runnable {
 		private int i = 20;
 		
 		public void run() {
 			while(true) {
 				synchronized (this) {
 					if(i > 0) {
 						try {
 							Thread.sleep(100);
 						} catch(Exception e){
 							e.printStackTrace();
 						}
 						System.out.println(Thread.currentThread().getName()
 								+ " sell" + i--);
 					}
 				}
 			}
 		}
    }
	public static void main(String[] args) {
	   SellThread sell = new SellThread();
       Thread sell1 = new Thread(sell, "sellMan1");
       Thread sell2 = new Thread(sell, "sellMan2");
       Thread sell3 = new Thread(sell, "sellMan3");
       sell1.start();
       sell2.start();
       sell3.start();
	}

}

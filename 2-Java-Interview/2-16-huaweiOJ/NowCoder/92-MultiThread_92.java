package huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author WuPing
 * @version 2016年10月6日 下午4:07:50
 */

public class MultiThread_92 implements Runnable {

    private String name;
    private Object prev;
    private Object self;
    private int count;
    
    private MultiThread_92(String name, Object prev, Object self, int count) {
        this.name = name;
        this.prev = prev;
        this.self = self;
        this.count = count;
    }
    
    @Override
    public void run() {
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Object d = new Object();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int count = Integer.valueOf(br.readLine());
        MultiThread_92 pa = new MultiThread_92("A", d, a, count);
        MultiThread_92 pb = new MultiThread_92("B", a, b, count);
        MultiThread_92 pc = new MultiThread_92("C", b, c, count);
        MultiThread_92 pd = new MultiThread_92("D", c, d, count);
         
        new Thread(pa).start();
        Thread.sleep(100);  // 确保按顺序A、B、C、D执行
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
        new Thread(pd).start();
    }

}

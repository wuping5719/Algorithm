package interview;

/**
 * @author WuPing
 * @version 2016年11月27日 下午8:34:19
 */

class WaitNotify {
    public class MonitorObject {
    }

    MonitorObject monitorObject = new MonitorObject();
    boolean wasSignalled = false;

    public void doWait() {
	synchronized (monitorObject) {
	    while (!wasSignalled) {
		try {
		    monitorObject.wait();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	    // clear signal and continue running.
	    wasSignalled = false;
	}
    }

    public void doNotify() {
	synchronized (monitorObject) {
	    wasSignalled = true;
	    monitorObject.notify();
	}
    }
}

public class ThreadCommunication{
    public static void main(String[] args){
	final WaitNotify waitNotify = new WaitNotify();
	Runnable aRunnable = new Runnable(){
	    public void run() {
		waitNotify.doWait();
		System.out.println("Hello B!");
	    }
	};
        
	Runnable bRunnable = new Runnable(){
	    public void run() {
		waitNotify.doNotify();
		System.out.println("Hello A!");
	    }
	};
	
	Thread aThread = new Thread(aRunnable);
	aThread.start();
        try {
	    Thread.sleep(1000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	Thread bThread = new Thread(bRunnable);
	bThread.start();
    }
}

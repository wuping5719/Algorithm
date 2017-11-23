package com.myra.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class LogService {

	public static void main(String[] args) {
		String status = "I love Myra!";
		BlockingQueue<String> msgQ = new LinkedBlockingQueue<String>();
		
		Runnable log = new Runnable() {
			public void run() {
				try {
					for(;;){
						System.out.println(msgQ.take());
					}	
				} catch (InterruptedException e) { 
					e.printStackTrace();
				}
			}
		};
		Executors.newSingleThreadExecutor().execute(log);
		
		try {
			msgQ.put(status);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

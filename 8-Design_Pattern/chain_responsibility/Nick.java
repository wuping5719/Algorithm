package com.myra.design.pattern.chain_responsibility;

import java.util.ArrayList;

public class Nick implements Handler {
	private Handler handler;

	private ArrayList<String> list;

	Nick() {
		list = new ArrayList<String>();
		list.add("ShenZhen.");
		list.add("We make love!");
		list.add("China.");
		list.add("Myra love Nick!");
	}

	public void handleRequest(String str) {
		if (list.contains(str)) {
			System.out.println(str);
		} else {
			if (handler != null) {
				handler.handleRequest(str);
			}
		}
	}

	public void setNextHandler(Handler handler) {
		this.handler = handler;
	}
}

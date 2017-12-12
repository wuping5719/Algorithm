package com.myra.design.pattern.chain_responsibility;

import java.util.ArrayList;

public class Lover implements Handler {
	private Handler handler;

	private ArrayList<String> list;

	Lover() {
		list = new ArrayList<String>();
		list.add("Moon.");
		list.add("Myra is my girlfriend!");
		list.add("Earth.");
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

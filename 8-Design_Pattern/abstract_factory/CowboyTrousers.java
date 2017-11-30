package com.myra.design.pattern.abstract_factory;

public class CowboyTrousers extends Trousers {
	private int waistSize;
	private int height;
	private String name;
	
	CowboyTrousers(String name, int waistSize, int height) {
		this.name = name;
		this.waistSize = waistSize;
		this.height = height;
	}

	public int getWaistSize() {
		return waistSize;
	}

	public int getHeight() {
		return height;
	}

	public String getName() {
		return name;
	}
}

package com.myra.design.pattern.abstract_factory;

public class TestAbstractFactory {

	public static void main(String[] args) {
		Shop shop = new Shop();
		ClothesFactory factory = new MyraClothesFactory();
		shop.giveSuit(factory, 110, 82, 170);
		
		factory = new NickClothesFactory();
		shop.giveSuit(factory, 120, 88, 180);
	}

}

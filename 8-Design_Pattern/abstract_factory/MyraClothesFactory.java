package com.myra.design.pattern.abstract_factory;

public class MyraClothesFactory extends ClothesFactory {
	public UpperClothes createUpperClothes(int chestSize, int height) {
		return new WesternUpperClothes("Myra牌西服上衣", chestSize, height);
	}
	
	public Trousers createTrousers(int waistSize, int height) {
		return new WesternTrousers("Myra牌西服裤子", waistSize, height);
	}
}

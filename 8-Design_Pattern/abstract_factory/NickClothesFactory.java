package com.myra.design.pattern.abstract_factory;

public class NickClothesFactory extends ClothesFactory {
	public UpperClothes createUpperClothes(int chestSize, int height) {
		return new CowboyUpperClothes("Nick牌牛仔上衣", chestSize, height);
	}
	
	public Trousers createTrousers(int waistSize, int height) {
		return new CowboyTrousers("Nick牌牛仔裤子", waistSize, height);
	}
}

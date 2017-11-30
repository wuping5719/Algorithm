package com.myra.design.pattern.abstract_factory;

public abstract class ClothesFactory {
	public abstract UpperClothes createUpperClothes(int chestSize, int height);
	public abstract Trousers createTrousers(int waistSize, int height);
}

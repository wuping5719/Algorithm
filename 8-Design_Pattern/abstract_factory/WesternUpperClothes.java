package com.myra.design.pattern.abstract_factory;

public class WesternUpperClothes extends UpperClothes {
   private int chestSize;
   private int height;
   private String name;
   
   WesternUpperClothes(String name, int chestSize, int height) {
	   this.name = name;
	   this.chestSize = chestSize;
	   this.height = height;
   }
   
   public int getChestSize() {
	   return chestSize;
   }
   
   public int getHeight() {
	   return height;
   }
   
   public String getName() {
	   return name;
   }
}

package com.myra.design.pattern.flyweight;

public class ConcreteFlyweight implements Flyweight {
   private double width;
   
   private double height;
   
   private double length;
   
   ConcreteFlyweight(double width, double height, double length) {
	   this.width = width;
	   this.height = height;
	   this.length = length;
   }
   
   public double getWidth() {
	   return width;
   }
   
   public double getHeight() {
	   return height;
   }
   
   public double getLength() {
	   return length;
   }
   
   public void printMessage(String message) {
	   System.out.println(message);
	   System.out.println("宽度: " + width);
	   System.out.println("高度: " + height);
	   System.out.println("长度: " + length);
   }
}

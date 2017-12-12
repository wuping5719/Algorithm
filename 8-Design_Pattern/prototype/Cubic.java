package com.myra.design.pattern.prototype;

public class Cubic implements Prototype, Cloneable {
   double length;
   double width;
   double height;
   
   Cubic(double length, double width, double height) {
	   this.length = length;
	   this.width = width;
	   this.height = height;
   }
   
   public Object cloneMe() throws CloneNotSupportedException {
	   Cubic cubic = (Cubic) clone();
	   return cubic;
   }
}

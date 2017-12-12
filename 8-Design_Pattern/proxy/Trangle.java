package com.myra.design.pattern.proxy;

public class Trangle implements Geometry {
   double sideA;
   double sideB;
   double sideC;
   double area;
   
   public Trangle(double sideA, double sideB, double sideC) {
	   this.sideA = sideA;
	   this.sideB = sideB;
	   this.sideC = sideC;
   }
   
   public double getArea() {
	   double p = (sideA + sideB + sideC) / 2.0;
	   area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
	   return area;
   }
}

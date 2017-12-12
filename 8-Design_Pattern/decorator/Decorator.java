package com.myra.design.pattern.decorator;

public abstract class Decorator extends Bird {
   protected Bird bird;
   
   public Decorator(Bird bird) {
	   this.bird = bird;
   }
}

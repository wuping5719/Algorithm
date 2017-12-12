package com.myra.design.pattern.state;

public class LowState implements TemperatureState {
   double t = 0;
   
   LowState(double t) {
	   if (t <= 0) {
		   this.t = t;
	   }
   }
   
   public void showTemperature() {
	   System.out.println("现在的温度是" + t + "℃，属于低温度.");
   }
}

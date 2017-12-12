package com.myra.design.pattern.state;

public class HighState implements TemperatureState {
   double t = 39;
   
   HighState(double t) {
	   if (t >= 39) {
		   this.t = t;
	   }
   }
   
   public void showTemperature() {
	   System.out.println("现在的温度是" + t + "℃，属于高温度.");
   }
}

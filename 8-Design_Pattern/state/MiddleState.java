package com.myra.design.pattern.state;

public class MiddleState implements TemperatureState {
   double t = 15;
   
   MiddleState(double t) {
	   if (t > 0 && t < 26) {
		   this.t = t;
	   }
   }
   
   public void showTemperature() {
	   System.out.println("现在的温度是" + t + "℃，属于正常温度.");
   }
}

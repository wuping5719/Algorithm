package com.myra.design.pattern.adapter;

public class TV implements TwoElectricOutlet {
    String name;
    
    TV() {
       this.name = "Nick牌电视机";
    }
    
    TV(String name) {
        this.name = name;
    }
    
    public void connectElectricCurrent() {
		turnOn();
	}
    
    public void turnOn() {
    	System.out.println(name + "开始播节目了！");
    }
}

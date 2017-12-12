package com.myra.design.pattern.adapter;

public class Wash implements ThreeElectricOutlet {
    String name;
    
    Wash() {
       this.name = "Myra牌洗衣机";
    }
    
    Wash(String name) {
        this.name = name;
    }
    
    public void connectElectricCurrent() {
		turnOn();
	}
    
    public void turnOn() {
    	System.out.println(name + "开始洗衣服了！");
    }
}

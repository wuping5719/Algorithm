package com.myra.design.pattern.adapter;

public class TestAdapter {

	public static void main(String[] args) {
		ThreeElectricOutlet outlet;
		
		Wash wash = new Wash();
		outlet = wash;
		System.out.println("使用三相插座接通电源.");
		outlet.connectElectricCurrent();
		
		TV tv = new TV();
		ThreeElectricAdapter adapter = new ThreeElectricAdapter(tv);
		outlet = adapter;
		System.out.println("使用三相插座接通电源.");
		outlet.connectElectricCurrent();
	}

}

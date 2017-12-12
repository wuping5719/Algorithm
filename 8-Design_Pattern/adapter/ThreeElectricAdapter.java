package com.myra.design.pattern.adapter;

public class ThreeElectricAdapter implements ThreeElectricOutlet {
	TwoElectricOutlet outlet;
	
	ThreeElectricAdapter(TwoElectricOutlet outlet)  {
		this.outlet = outlet;
	}
	
	public void connectElectricCurrent() {
		outlet.connectElectricCurrent();
	}
}

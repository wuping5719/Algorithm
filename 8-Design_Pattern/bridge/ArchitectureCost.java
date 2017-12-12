package com.myra.design.pattern.bridge;

public abstract class ArchitectureCost {
	BuildingDesign design;
	
	double unitPrice;
	
	public abstract double giveCost();
}

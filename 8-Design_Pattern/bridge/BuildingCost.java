package com.myra.design.pattern.bridge;

public class BuildingCost extends ArchitectureCost {
	BuildingCost(BuildingDesign design, double unitPrice) {
		this.design = design;
		this.unitPrice = unitPrice;
	}
	
	public double giveCost() {
		double area = design.computeArea();
		return area * unitPrice;
	}
}

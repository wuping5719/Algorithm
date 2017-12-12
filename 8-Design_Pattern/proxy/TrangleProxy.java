package com.myra.design.pattern.proxy;

public class TrangleProxy implements Geometry {
	double sideA;
	double sideB;
	double sideC;
	Trangle trangle;

	public void setSideABC(double sideA, double sideB, double sideC) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	public double getArea() {
		double area = -1;
		if ((sideA + sideB > sideC) && (sideA + sideC > sideB)
				&& (sideB + sideC > sideA)) {
			trangle = new Trangle(sideA, sideB, sideC);
			area = trangle.getArea();
		}
		return area;
	}
}

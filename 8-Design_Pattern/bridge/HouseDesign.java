package com.myra.design.pattern.bridge;

public class HouseDesign implements BuildingDesign {
    double width;
    
    double length;
    
    int floorNumber;
    
    HouseDesign(double width, double length, int floorNumber) {
    	this.width = width;
    	this.length = length;
    	this.floorNumber = floorNumber;
    }
    
    public double computeArea() {
    	return width * length * floorNumber;
    }
}

package com.myra.design.pattern.flyweight;

public class Car {
	Flyweight flyweight;
	
	String name;
	
	String color;
	
	int power;
	
	Car(Flyweight flyweight, String name, String color, int power) {
		this.flyweight = flyweight;
		this.name = name;
		this.color = color;
		this.power = power;
	}
	
	public void print() {
		System.out.println("名称: " + name);
		System.out.println("颜色: " + color);
		System.out.println("功率: " + power);
		System.out.println("宽度: " + flyweight.getWidth());
		System.out.println("高度: " + flyweight.getHeight());
		System.out.println("长度: " + flyweight.getLength());
	}
}

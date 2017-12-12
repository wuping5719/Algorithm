package com.myra.design.pattern.flyweight;

public class TestFlyWeight {

	public static void main(String[] args) {
		FlyweightFactory factory = FlyweightFactory.getFactory();
		
		double width = 1.82;
		double height = 1.47;
		double length = 5.12;
		String key = width + "#" + height + "#" + length;
		Flyweight flyweight = factory.getFlyweight(key);
		
		Car audiA6 = new Car(flyweight, "奥迪A6", "黑色", 128);
		Car bmwX1 = new Car(flyweight, "宝马X1", "白色", 180);
		
		audiA6.print();
		System.out.println();
		bmwX1.print();
		System.out.println();
		
		width = 1.77;
		height = 1.45;
		length = 4.63;
		key = width + "#" + height + "#" + length;
		flyweight = factory.getFlyweight(key);
		
		/*
		Car benzS500 = new Car(flyweight, "奔驰S500", "银色", 168);
		Car bmw7 = new Car(flyweight, "宝马7系", "红色", 158);
		benzS500.print();
		bmw7.print();
		*/
		
		flyweight.printMessage("名称: 奔驰S500, 颜色: 银色, 功率: 168");
		System.out.println();
		flyweight.printMessage("名称: 宝马7系, 颜色: 红色, 功率: 158");
	}

}

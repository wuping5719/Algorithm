package com.myra.design.pattern.proxy;

import java.util.Scanner;

public class TestProxy {

	public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("请输入三个数，每输入一个数回车确认!");
       double sideA = -1;
       double sideB = -1;
       double sideC = -1;
       sideA = scanner.nextDouble();
       sideB = scanner.nextDouble();
       sideC = scanner.nextDouble();
       TrangleProxy proxy = new TrangleProxy();
       proxy.setSideABC(sideA, sideB, sideC);
       double area = proxy.getArea();
       System.out.println("面积是: " + area);
       scanner.close();
	}

}

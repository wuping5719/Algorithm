package com.myra.test;

public class ConcreteClass implements TargetInterface {
	public int targetMethodA(int number) {
		System.out.println("开始调用目标类的 targetMethodA 方法...");
		System.out.println("操作-打印数字：" + number);
		number++;
		System.out.println("结束调用目标类的 targetMethodA 方法...");
		return number;
	}
	
	public int targetMethodB(int number) {
		System.out.println("开始调用目标类的 targetMethodB 方法...");
		System.out.println("操作-打印数字：" + number);
		number++;
		System.out.println("结束调用目标类的 targetMethodB 方法...");
		return number;
	}
}

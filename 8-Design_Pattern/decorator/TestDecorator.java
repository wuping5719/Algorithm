package com.myra.design.pattern.decorator;

public class TestDecorator {

	public void needBird(Bird bird) {
		int flyDistance = bird.fly();
		System.out.println("这只鸟能飞行 " + flyDistance + " 米.");
	}
	
	public static void main(String[] args) {
		TestDecorator client = new TestDecorator();
		Bird sparrow = new Sparrow();
		Bird myra = new SparrowDecorator(sparrow);
		Bird nick = new SparrowDecorator(myra);
		client.needBird(myra);
		client.needBird(nick);
	}

}

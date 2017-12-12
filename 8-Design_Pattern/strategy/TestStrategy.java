package com.myra.design.pattern.strategy;

public class TestStrategy {

	public static void main(String[] args) {
		GymnasticsGame game = new GymnasticsGame();
		game.setStrategy(new Strategy1());
		double[] array1 = {81.2, 68.8, 99, 100, 92, 88,8};
		
		System.out.println("使用算术平均值方案: ");
		System.out.printf("最后得分: %5.3f%n", game.getPersonScore(array1));
		
		game.setStrategy(new Strategy2());
		System.out.println("使用几何平均值方案: ");
		System.out.printf("最后得分: %5.3f%n", game.getPersonScore(array1));
		
		game.setStrategy(new Strategy3());
		System.out.println("使用(去掉最高、最低)算术平均值方案: ");
		System.out.printf("最后得分: %5.3f%n", game.getPersonScore(array1));
	}

}

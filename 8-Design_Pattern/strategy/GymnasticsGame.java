package com.myra.design.pattern.strategy;

public class GymnasticsGame {
	ComputableStrategy strategy;
	
	public void setStrategy(ComputableStrategy strategy) {
		this.strategy = strategy;
	}
	
	public double getPersonScore(double[] array) {
		if (strategy != null) {
			return strategy.computeScore(array);
		} else {
			return 0;
		}
	}
}

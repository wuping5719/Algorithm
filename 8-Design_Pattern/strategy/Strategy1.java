package com.myra.design.pattern.strategy;

public class Strategy1 implements ComputableStrategy {
	public double computeScore(double[] array) {
		double score = 0;
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		score = sum / array.length;
		return score;
	}
}

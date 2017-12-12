package com.myra.design.pattern.strategy;

public class Strategy2 implements ComputableStrategy {
	public double computeScore(double[] array) {
		double score = 0;
		double multi = 1;
		int n = array.length;
		for (int i = 0; i < n; i++) {
			multi = multi * array[i];
		}
		score = Math.pow(multi, 1.0/n);
		return score;
	}
}

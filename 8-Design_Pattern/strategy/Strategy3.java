package com.myra.design.pattern.strategy;

import java.util.Arrays;

public class Strategy3 implements ComputableStrategy {
	public double computeScore(double[] array) {
		double score = 0;
		double sum = 1;
		int n = array.length;
		if (n <= 2){
			return 0;
		}
		Arrays.sort(array);
		for (int i = 1; i < n - 1; i++) {
			sum = sum + array[i];
		}
		score = sum / (n - 2);
		return score;
	}
}

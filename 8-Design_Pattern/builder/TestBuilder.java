package com.myra.design.pattern.builder;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestBuilder {
	public static void main(String[] args) {
		Builder bulider = new ConcreteBuilderMyra();
		Director director = new Director(bulider);
		JPanel panel = director.constructProduct();
		JFrame frameMyra = new JFrame();
		frameMyra.add(panel);
		frameMyra.setBounds(12, 12, 200, 120);
		frameMyra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameMyra.setVisible(true);
		
		bulider = new ConcreteBuilderNick();
		director = new Director(bulider);
		panel = director.constructProduct();
		JFrame frameNick = new JFrame();
		frameNick.add(panel);
		frameNick.setBounds(212, 12, 200, 120);
		frameNick.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameNick.setVisible(true);
	}
}

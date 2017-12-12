package com.myra.design.pattern.builder;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConcreteBuilderMyra implements Builder {
	private PanelProduct panel;

	ConcreteBuilderMyra() {
		this.panel = new PanelProduct();
	}

	public void buildButton() {
		panel.button = new JButton("Say");
	}

	public void buildLabel() {
		panel.label = new JLabel("I love Nick");
	}

	public void buildTextField() {

	}

	public JPanel getPanel() {
		panel.add(panel.button);
		panel.add(panel.label);
		return panel;
	}
}

package com.myra.design.pattern.builder;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConcreteBuilderNick implements Builder {
	private PanelProduct panel;

	ConcreteBuilderNick() {
		this.panel = new PanelProduct();
	}

	public void buildButton() {
		panel.button = new JButton("Say");
	}

	public void buildLabel() {
		
	}

	public void buildTextField() {
		panel.textField = new JTextField("I love Myra");
	}

	public JPanel getPanel() {
		panel.add(panel.button);
		panel.add(panel.textField);
		return panel;
	}
}

package com.myra.design.pattern.builder;

import javax.swing.JPanel;

public interface Builder {
	public abstract void buildButton();

	public abstract void buildLabel();

	public abstract void buildTextField();

	public abstract JPanel getPanel();
}

package com.myra.design.pattern.builder;

import javax.swing.JPanel;

public class Director {
	
   private Builder builder;
   
   Director(Builder builder) {
	   this.builder = builder;
   }
   
   public JPanel constructProduct() {
	   builder.buildButton();
	   builder.buildLabel();
	   builder.buildTextField();
	   JPanel panel = builder.getPanel();
	   return panel;
   }
}

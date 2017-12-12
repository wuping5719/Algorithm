package com.myra.design.pattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Goat implements Prototype, Serializable {

	private static final long serialVersionUID = -8005847708804172213L;

	StringBuffer color;

	public void setColor(StringBuffer color) {
		this.color = color;
	}

	public StringBuffer getColor() {
		return color;
	}

	public Object cloneMe() throws CloneNotSupportedException {
		Object object = null;

		try {
			ByteArrayOutputStream outOne = new ByteArrayOutputStream();
			ObjectOutputStream outTwo = new ObjectOutputStream(outOne);
			outTwo.writeObject(this);
			ByteArrayInputStream inOne = new ByteArrayInputStream(outOne.toByteArray());
			ObjectInputStream inTwo = new ObjectInputStream(inOne);
			object = inTwo.readObject();
		} catch (Exception e) {
			System.out.println(e);
		}

		return object;
	}
}

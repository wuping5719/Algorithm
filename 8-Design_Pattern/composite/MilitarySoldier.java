package com.myra.design.pattern.composite;

import java.util.Iterator;

public class MilitarySoldier implements MilitaryPerson {
	double salary;

	String name;

	MilitarySoldier(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public void add(MilitaryPerson person) {
	}

	public void remove(MilitaryPerson person) {
	}

	public MilitaryPerson getChild(int index) {
		return null;
	}

	public Iterator<MilitaryPerson> getAllChildren() {
		return null;
	}

	public boolean isLeaf() {
		return true;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}

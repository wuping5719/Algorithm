package com.myra.design.pattern.composite;

import java.util.Iterator;
import java.util.LinkedList;

public class MilitaryOfficer implements MilitaryPerson {
	LinkedList<MilitaryPerson> list;

	String name;

	double salary;

	MilitaryOfficer(String name, double salary) {
		this.name = name;
		this.salary = salary;
		list = new LinkedList<>();
	}

	public void add(MilitaryPerson person) {
		list.add(person);
	}

	public void remove(MilitaryPerson person) {
		list.remove(person);
	}

	public MilitaryPerson getChild(int index) {
		return list.get(index);
	}

	public Iterator<MilitaryPerson> getAllChildren() {
		return list.iterator();
	}

	public boolean isLeaf() {
		return false;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}

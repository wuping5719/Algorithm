package com.myra.design.pattern.template_method;

import java.io.File;

public class ConcreteTemplate2 extends AbstractTemplate {
	ConcreteTemplate2(File dir) {
		super(dir);
	}
	
	public void sort() {
		for (int i = 0; i < files.length; i++) {
			for (int j = i + 1; j < files.length; j++) {
				if (files[j].length() < files[i].length()) {
					File file = files[j];
					files[j] = files[i];
					files[i] = file;
				}
			}
		}
	}
	
	public void printFiles() {
		for (int i = 0; i < files.length; i++) {
			long fileSize = files[i].length();
			String name = files[i].getName();
			int k = i + 1;
			System.out.println(k + " " + name + " (" + fileSize + "字节).");
		}
	}
}

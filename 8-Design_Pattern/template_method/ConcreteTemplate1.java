package com.myra.design.pattern.template_method;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConcreteTemplate1 extends AbstractTemplate {
	ConcreteTemplate1(File dir) {
		super(dir);
	}
	
	public void sort() {
		for (int i = 0; i < files.length; i++) {
			for (int j = i + 1; j < files.length; j++) {
				if (files[j].lastModified() < files[i].lastModified()) {
					File file = files[j];
					files[j] = files[i];
					files[i] = file;
				}
			}
		}
	}
	
	public void printFiles() {
		for (int i = 0; i < files.length; i++) {
			long time = files[i].lastModified();
			Date date = new Date(time);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = sdf.format(date);
			String name = files[i].getName();
			int k = i + 1;
			System.out.println(k + " " + name + " (" + str + ").");
		}
	}
}

package com.myra.design.pattern.template_method;

import java.io.File;

public abstract class AbstractTemplate {
   File[] files;
   
   File dir;
   
   AbstractTemplate(File dir) {
	   this.dir = dir;
   }
   
   public final void showFileName() {
	   files = dir.listFiles();
	   sort();
	   printFiles();
   }
   
   public abstract void sort();
   
   public abstract void printFiles();
}

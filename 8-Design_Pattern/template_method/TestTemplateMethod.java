package com.myra.design.pattern.template_method;

import java.io.File;

public class TestTemplateMethod {

	public static void main(String[] args) {
       File dir = new File("E:/学习文档/专业认证/Java");
       AbstractTemplate template = new ConcreteTemplate1(dir);
       System.out.println(dir.getPath() + "目录下的文件: ");
       template.showFileName();
       template = new ConcreteTemplate2(dir);
       System.out.println(dir.getPath() + "目录下的文件: ");
       template.showFileName();
	}

}

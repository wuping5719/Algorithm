package com.myra.design.pattern.observer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class OverseasReturnee implements Observer {
	Subject subject;
	
	File file;
	
	OverseasReturnee(Subject subject, String fileName) {
		this.subject = subject;
		subject.addObserver(this);  // 使当前实例成为 subject 所引用的具体主题的观察者
		file = new File(fileName);
	}
	
	public void hearTelephone(String hearMessage) {
		try {
			boolean isHas = hearMessage.contains("程序员") || hearMessage.contains("软件");
			if(isHas) {
				RandomAccessFile out = new RandomAccessFile(file, "rw");
				out.seek(out.length());
				byte[] b = hearMessage.getBytes();
				out.write(b);  // 更新文件中的内容
				System.out.println("我是一个海归.");
				System.out.println("我向文件" + file.getName() + "写入如下内容: ");
				System.out.println(hearMessage);
				out.close();
			} else {
				System.out.println("我是海归, 这次观察中没有我需要的信息.");
			}
			
		} catch (IOException e) {
			System.out.println(e.toString());
		} 
	}

}

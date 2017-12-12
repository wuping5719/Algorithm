package com.myra.design.pattern.singleton;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class TestSingleton {

	public static void main(String[] args) {
		MoonFrame myraMoon = new MoonFrame("Myra 在新西兰看月亮，睹物思人.");
		MoonFrame nickMoon = new MoonFrame("Nick 在中国看月亮，思念佳人.");
		myraMoon.setBounds(10, 10, 360, 150);
		nickMoon.setBounds(370, 10, 360, 150);
		myraMoon.validate();
		nickMoon.validate();
	}
	
}

class MoonFrame extends JFrame {
	private static final long serialVersionUID = 7688611460992515003L;
	
	String str;
	
	MoonFrame(String title) {
		setTitle(title);
		Moon moon = Moon.getMethod();
		str = moon.show();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(new Font("宋体", Font.BOLD, 14));
		g.drawString(str, 5, 100);
	}
}

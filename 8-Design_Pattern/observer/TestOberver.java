package com.myra.design.pattern.observer;

public class TestOberver {

	public static void main(String[] args) {
		SeekJobCenter center = new SeekJobCenter();
		UniversityStudent nick = new UniversityStudent(center, "nick.txt");
		OverseasReturnee myra = new OverseasReturnee(center, "myra.txt");
		center.giveNewMessage("阿里巴巴招聘10个Java程序员.");
		center.notifyObservers();
		center.giveNewMessage("腾讯招聘5个前端.");
		center.notifyObservers();
		center.giveNewMessage("网易游戏招聘8个游戏设计师.");
		center.notifyObservers();
		center.giveNewMessage("科大讯飞招聘6个AI工程师.");
		center.notifyObservers();
		nick.hearTelephone("Myra love Nick!");
		myra.hearTelephone("You are my girl!");
	}

}

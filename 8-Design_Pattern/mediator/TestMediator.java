package com.myra.design.pattern.mediator;

public class TestMediator {

	public static void main(String[] args) {
		ConcreteMediator mediator = new ConcreteMediator();
		ColleagueA colleagueA = new ColleagueA(mediator);
		ColleagueB colleagueB = new ColleagueB(mediator);
		ColleagueC colleagueC = new ColleagueC(mediator);
		colleagueA.setName("A国");
		colleagueB.setName("B国");
		colleagueC.setName("C国");
		String[] messagesA = {"要求归还曾经抢夺的100斤土豆.", "要求归还曾经抢夺的20头牛."};
		colleagueA.giveMessages(messagesA);
		String[] messagesB = {"要求归还曾经抢夺的10只公鸡.", "要求归还曾经抢夺的15匹马."};
		colleagueB.giveMessages(messagesB);
		String[] messagesC = {"要求归还曾经抢夺的300斤小麦.", "要求归还曾经抢夺的50头驴."};
		colleagueC.giveMessages(messagesC);
	}

}

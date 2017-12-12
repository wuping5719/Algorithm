package com.myra.design.pattern.mediator;

public class ConcreteMediator {
	ColleagueA colleagueA;
	ColleagueB colleagueB;
	ColleagueC colleagueC;
	
	public void registerColleagueA(ColleagueA colleagueA) {
		this.colleagueA = colleagueA;
	}
	
	public void registerColleagueB(ColleagueB colleagueB) {
		this.colleagueB = colleagueB;
	}
	
	public void registerColleagueC(ColleagueC colleagueC) {
		this.colleagueC = colleagueC;
	}
	
	public void deliverMessage(Colleague colleague, String[] messages) {
		if (colleague == colleagueA) {
			if (messages.length >= 2) {
				colleagueB.receiveMessage(colleague.getName() + messages[0]);
				colleagueC.receiveMessage(colleague.getName() + messages[1]);
			}
		} else if (colleague == colleagueB) {
			if (messages.length >= 2) {
				colleagueA.receiveMessage(colleague.getName() + messages[0]);
				colleagueC.receiveMessage(colleague.getName() + messages[1]);
			}
		} else {
			if (messages.length >= 2) {
				colleagueA.receiveMessage(colleague.getName() + messages[0]);
				colleagueB.receiveMessage(colleague.getName() + messages[1]);
			}
		}
	}
}

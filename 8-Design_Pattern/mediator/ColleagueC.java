package com.myra.design.pattern.mediator;

public class ColleagueC implements Colleague {
	ConcreteMediator mediator;
	
	String name;
	
	ColleagueC(ConcreteMediator mediator) {
		this.mediator = mediator;
		mediator.registerColleagueC(this);
	}
	
    public void giveMessages(String[] messages) {
    	mediator.deliverMessage(this, messages);
    }
    
    public void receiveMessage(String message) {
    	System.out.println(name + "收到的信息：" + message);
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return name;
    }
}

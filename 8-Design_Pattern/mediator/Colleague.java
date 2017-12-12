package com.myra.design.pattern.mediator;

public interface Colleague {
    public void giveMessages(String[] messages);
    
    public void receiveMessage(String message);
    
    public void setName(String name);
    
    public String getName();
}

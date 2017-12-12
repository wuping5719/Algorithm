package com.myra.design.pattern.chain_responsibility;

public class TestChainResponsibility {
	private Handler myra;
	
	private Handler nick;
	
	private Handler lover;
	
	public void createChain() {
		myra = new Myra();
		nick = new Nick();
		lover = new Lover();
		myra.setNextHandler(nick);
		nick.setNextHandler(lover);
	}
	
	public void reponseClient(String str) {
		myra.handleRequest(str);
	}
	
	public static void main(String[] args) {
		TestChainResponsibility chainResponsibility = new TestChainResponsibility();
		chainResponsibility.createChain();
		chainResponsibility.reponseClient("Myra is my girlfriend!");
	}
}

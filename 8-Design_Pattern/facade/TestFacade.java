package com.myra.design.pattern.facade;

public class TestFacade {

	public static void main(String[] args) {
		ClientServerFacade clientFacade;
		String advertisement = "Myra to connect world!";
		clientFacade = new ClientServerFacade(advertisement);
		clientFacade.doAdvertisement();
	}

}

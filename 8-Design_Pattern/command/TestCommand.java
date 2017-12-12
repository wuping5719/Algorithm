package com.myra.design.pattern.command;

public class TestCommand {

	public static void main(String[] args) {
		CompanyArmy companyArmy = new CompanyArmy();
		Command command = new ConcreteCommand(companyArmy);
		ArmySuperior armySuperior = new ArmySuperior();
		armySuperior.setCommand(command);
		armySuperior.startExecuteCommand();
	}

}

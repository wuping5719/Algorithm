package com.myra.design.pattern.command;

public class ArmySuperior {
	Command command;    // 用来存放具体命令的引用
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void startExecuteCommand() {
		command.execute();
	}
}

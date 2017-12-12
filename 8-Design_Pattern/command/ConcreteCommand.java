package com.myra.design.pattern.command;

public class ConcreteCommand implements Command {
	CompanyArmy army;   // 含有接收者的引用
	
	ConcreteCommand(CompanyArmy army) {
		this.army = army;
	}
	
	public void execute() {  // 封装着指挥官的命令
		army.sneakAttack();  // 偷袭敌人
	}
}

package com.myra.design.pattern.composite;

public class TestComposite {

	public static void main(String[] args) {
		MilitaryPerson companyCommander = new MilitaryOfficer("连长", 5000);
		
		MilitaryPerson platoonLeader1 = new MilitaryOfficer("一排长", 4000);
		
		MilitaryPerson squadLeader1_1 = new MilitaryOfficer("一班长", 3000);
		MilitaryPerson squadLeader1_2 = new MilitaryOfficer("二班长", 3000);
		MilitaryPerson squadLeader1_3 = new MilitaryOfficer("三班长", 3000);
		
		MilitaryPerson platoonLeader2 = new MilitaryOfficer("二排长", 4000);
		
		MilitaryPerson squadLeader2_1 = new MilitaryOfficer("一班长", 3000);
		MilitaryPerson squadLeader2_2 = new MilitaryOfficer("二班长", 3000);
		MilitaryPerson squadLeader2_3 = new MilitaryOfficer("三班长", 3000);
		
        MilitaryPerson platoonLeader3 = new MilitaryOfficer("三排长", 4000);
		
		MilitaryPerson squadLeader3_1 = new MilitaryOfficer("一班长", 3000);
		MilitaryPerson squadLeader3_2 = new MilitaryOfficer("二班长", 3000);
		MilitaryPerson squadLeader3_3 = new MilitaryOfficer("三班长", 3000);
		
		MilitaryPerson[] soldiers = new MilitarySoldier[90];
		for(int i = 0; i < soldiers.length; i++) {
			soldiers[i] = new MilitarySoldier("上等兵", 2000);
		}

		companyCommander.add(platoonLeader1);
		companyCommander.add(platoonLeader2);
		companyCommander.add(platoonLeader3);
		
		platoonLeader1.add(squadLeader1_1);
		platoonLeader1.add(squadLeader1_2);
		platoonLeader1.add(squadLeader1_3);
		
		platoonLeader2.add(squadLeader2_1);
		platoonLeader2.add(squadLeader2_2);
		platoonLeader2.add(squadLeader2_3);
		
		platoonLeader3.add(squadLeader3_1);
		platoonLeader3.add(squadLeader3_2);
		platoonLeader3.add(squadLeader3_3);
		
		for(int j = 0; j < 9; j++) {
			squadLeader1_1.add(soldiers[j]);
			squadLeader1_2.add(soldiers[j + 10]);
			squadLeader1_3.add(soldiers[j + 20]);
			squadLeader2_1.add(soldiers[j + 30]);
			squadLeader2_2.add(soldiers[j + 40]);
			squadLeader2_3.add(soldiers[j + 50]);
			squadLeader3_1.add(soldiers[j + 60]);
			squadLeader3_2.add(soldiers[j + 70]);
			squadLeader3_3.add(soldiers[j + 80]);
		}
		
		System.out.println("一排一班的军饷: " + ComputeSalary.computeSalary(squadLeader1_1) + " 元.");
		System.out.println("二排的军饷: " + ComputeSalary.computeSalary(platoonLeader2) + " 元.");
		System.out.println("全连的军饷: " + ComputeSalary.computeSalary(companyCommander) + " 元.");
	}

}

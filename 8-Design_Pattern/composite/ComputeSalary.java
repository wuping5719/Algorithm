package com.myra.design.pattern.composite;

import java.util.Iterator;

public class ComputeSalary {
   public static double computeSalary(MilitaryPerson person) {
	   double sum = 0;
	   if (person.isLeaf()) {
		   sum = sum + person.getSalary();
	   } else {
		   sum = sum + person.getSalary();
		   Iterator<MilitaryPerson> iterator = person.getAllChildren();
		   while (iterator.hasNext()) {
			   MilitaryPerson p = iterator.next();
			   sum = sum + computeSalary(p);
		   }
	   }
	   return sum;
   }
}

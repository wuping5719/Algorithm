package com.myra.design.pattern.chain_responsibility;

import java.util.ArrayList;

public class Myra implements Handler {
   private Handler handler;
   
   private ArrayList<String> list;
   
   Myra() {
	   list = new ArrayList<String>();
	   list.add("NewZeland.");
	   list.add("Come on, baby, give me!");
	   list.add("ChangSha.");
	   list.add("I love Myra!");
   }
   
   public void handleRequest(String str) {
	   if (list.contains(str)) {
		   System.out.println(str);
	   } else {
		   if (handler != null) {
			   handler.handleRequest(str);
		   }
	   }
   }
   
   public void setNextHandler(Handler handler) {
	   this.handler = handler;
   }
}

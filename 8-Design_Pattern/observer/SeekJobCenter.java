package com.myra.design.pattern.observer;

import java.util.ArrayList;

public class SeekJobCenter implements Subject {
   String message;
   
   boolean isChanged;
   
   ArrayList<Observer> personList;
   
   SeekJobCenter() {
	   personList = new ArrayList<>();
	   message = "";
	   isChanged = false;
   }
   
   public void addObserver(Observer observer) {
	   if (!(personList.contains(observer))) {
		   personList.add(observer);
	   }
   }
   
   public void deleteObserver(Observer observer) {
	   if (personList.contains(observer)) {
		   personList.remove(observer);
	   }
   }
   
   public void notifyObservers() {
	   if (isChanged) {
		   for (Observer o : personList) {
			   o.hearTelephone(message);
		   }
		   isChanged = false;
	   }
   }
   
   public void giveNewMessage(String newMessage) {
	   if (newMessage.equals(message)) {
		   isChanged = false;
	   } else {
		   message = newMessage;
		   isChanged = true;
	   }
   }
}

package com.myra.design.pattern.flyweight;

import java.util.HashMap;

public class FlyweightFactory {
   private HashMap<String, Flyweight> hashMap;
   
   static FlyweightFactory factory = new FlyweightFactory();
   
   private FlyweightFactory() {
	   hashMap = new HashMap<String, Flyweight>();
   }
   
   public static FlyweightFactory getFactory() {
	   return factory;
   }
   
   public synchronized Flyweight getFlyweight(String key) {
	   if (hashMap.containsKey(key)) {
		   return hashMap.get(key);
	   } else {
		  double width = 0;
		  double height = 0;
		  double length = 0;
		  String[] strArray = key.split("#");
		  width = Double.parseDouble(strArray[0]);
		  height = Double.parseDouble(strArray[1]);
		  length = Double.parseDouble(strArray[2]);
		  Flyweight flyweight = new ConcreteFlyweight(width, height, length);
		  hashMap.put(key, flyweight);
		  return flyweight;
	   }
   }
}

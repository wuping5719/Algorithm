package com.myra.design.pattern.facade;

public class CheckWord {
   public final int basicAmount = 85;
   
   String advertisement;
   
   int amount;
   
   public CheckWord(String advertisement) {
	   this.advertisement = advertisement;
   }
   
   public void setChargeAmount() {
	   this.amount = advertisement.length() + basicAmount;   // 计算出字符数目
   }
   
   public int getAmount() {
	   return amount;
   }
}

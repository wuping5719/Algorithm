package com.myra.design.pattern.chain_responsibility;

public interface Handler {
   public abstract void handleRequest(String str);
   
   public abstract void setNextHandler(Handler handler);
}

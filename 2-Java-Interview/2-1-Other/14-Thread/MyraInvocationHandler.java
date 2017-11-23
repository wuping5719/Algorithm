package com.myra.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyraInvocationHandler implements InvocationHandler {
    private Object concreteClass = null;
    
    public MyraInvocationHandler(Object concreteClass) {
    	this.concreteClass = concreteClass;
    }
    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    	System.out.println("Proxy: " + proxy.getClass().getName());
    	System.out.println("Method: " + method.getName());
    	System.out.println("Args: " + args[0].getClass().getName());
    	
    	doBefore();
    	// 普通的 Java 反射代码，通过反射执行某个类的某方法
    	Object object = method.invoke(concreteClass, args);
    	doAfter();
    	return object;
    }
    
    private void doBefore() {
    	System.out.println("Before invoke method...");
    }
    
    private void doAfter() {
    	System.out.println("After invoke method...");
    }
    
    public Object getProxy() {
    	if (null != concreteClass) {
    		return Proxy.newProxyInstance(concreteClass.getClass().getClassLoader(),  // 类加载器
    				concreteClass.getClass().getInterfaces(),   // 接口代理
    				this);   // 代理处理类
    	} else {
    		return null;
    	}
    }
}

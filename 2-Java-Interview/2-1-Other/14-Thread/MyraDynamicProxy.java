package com.myra.test;

public class MyraDynamicProxy {

	public static void main(String[] args) {
        // 元对象(被代理对象)
		ConcreteClass concreteClass = new ConcreteClass();
	    // 代理实例的调用处理程序
		MyraInvocationHandler myLove = new MyraInvocationHandler(concreteClass);
		
		TargetInterface targetInterface = (TargetInterface) myLove.getProxy();
		
		// 调用代理类的方法， Java 执行 InvocationHandler 接口的方法
		int n = targetInterface.targetMethodA(5);
		System.out.println(n);
		System.out.println();
		
		n = targetInterface.targetMethodB(16);
		System.out.println(n);
	}

}

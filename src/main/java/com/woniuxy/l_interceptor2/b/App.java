package com.woniuxy.l_interceptor2.b;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

class MyHandlr implements InvocationHandler {
	
	private Object target;
	
	public MyHandlr(Object target) {
		this.target = target;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("��ʼ");
		// ����Ŀ�귽��
		Object r = method.invoke(target, args);
		System.out.println("����");
		return r;
	}
	
}

public class App {
	@Test
	public void test() throws Exception {
		
		ICalc c = new CalcImpl();
		
		ClassLoader cl = App.class.getClassLoader();
		
		Class[] interfaces = {ICalc.class};  
		
		InvocationHandler handler = new MyHandlr(c);
		
		ICalc proxy = (ICalc) Proxy.newProxyInstance(cl, interfaces, handler);
		
		proxy.sub(1, 2);
		
	}
}

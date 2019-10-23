package com.woniuxy.l_interceptor2.c;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;


class MyProxy {
	public static Object getProxy(Object target) {
		
		
		ClassLoader cl = App.class.getClassLoader();
		
		Class[] interfaces = target.getClass().getInterfaces();  
		
		InvocationHandler handler = new MyHandlr(target);
		
		Object proxy = Proxy.newProxyInstance(cl, interfaces, handler);
		
		return proxy;
	}
}

class MyHandlr implements InvocationHandler {
	
	private Object target;
	
	public MyHandlr(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开始");
		// 调用目标方法
		Object r = method.invoke(target, args);
		System.out.println("结束");
		return r;
	}
	
}

// ===========================================================================================

public class App {
	@Test
	public void test() throws Exception {
		
		ICalc c = new CalcImpl();
		ICalc proxy = (ICalc) MyProxy.getProxy(c);
		proxy.add(1, 2);
		
		
		
	}
}

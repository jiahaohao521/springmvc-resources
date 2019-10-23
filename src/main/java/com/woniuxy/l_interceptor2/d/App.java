package com.woniuxy.l_interceptor2.d;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

interface Interceptor {
	boolean preHandle();
	void postHandle();
}

class MyProxy {
	public static Object getProxy(Object target, Interceptor i) {
		
		
		ClassLoader cl = App.class.getClassLoader();
		
		Class[] interfaces = target.getClass().getInterfaces();    // ICalc.class
		
		InvocationHandler handler = new MyHandlr(target, i);
		
		Object proxy = Proxy.newProxyInstance(cl, interfaces, handler);
		
		return proxy;
	}
}

class MyHandlr implements InvocationHandler {
	
	private Object target;  // c
	private Interceptor i;  // new B();
	
	public MyHandlr(Object target, Interceptor i) {
		this.target = target;
		this.i = i;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		boolean bb = i.preHandle();
		if(!bb) {
			return 0;
		}
		// 调用目标方法
		Object r = method.invoke(target, args);
		i.postHandle();
		return r;
	}
}

// ===========================================================================================

class A implements Interceptor {
	@Override
	public boolean preHandle() {
		System.out.println("AAAAAAAAAAAAA");
		return true;
	}

	@Override
	public void postHandle() {
		System.out.println("BBBBBBBBBBBBBB");
	}
}

class B implements Interceptor {

	@Override
	public boolean preHandle() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
		return true;
	}

	@Override
	public void postHandle() {
		System.out.println("#########################");
	}
	
}

public class App {
	@Test
	public void test() throws Exception {
		// 目标对象
		ICalc c = new CalcImpl();
		// 代理对象
		ICalc proxy = (ICalc) MyProxy.getProxy(c, new A());
		proxy.add(1, 2);
	}
}

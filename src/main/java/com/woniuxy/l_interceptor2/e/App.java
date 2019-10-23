package com.woniuxy.l_interceptor2.e;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

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
		// µ÷ÓÃÄ¿±ê·½·¨
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


class C implements Interceptor {

	@Override
	public boolean preHandle() {
		System.out.println("¹þ¹þ¹þ¹þ¹þ°¡¹þ¹þ¹þ¹þ");
		return true;
	}

	@Override
	public void postHandle() {
		System.out.println("ºÇºÇºÇºÇºÇºÇºÇºÇºÇºÇºÇºÇ");
	}
	
}

public class App {
	@Test
	public void test() throws Exception {
		List<Interceptor> list = new ArrayList<>();
		list.add(new A());
		list.add(new B());
		list.add(new C());
		
		// Ä¿±ê¶ÔÏó
		ICalc target = new CalcImpl();
		for(int i = list.size() - 1; i >= 0; i--) {
			target = (ICalc) MyProxy.getProxy(target, list.get(i));
		}
		target.add(11,22);
	}
}

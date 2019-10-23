package com.woniuxy.l_interceptor2.f;

import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
	
	
	public static Object getProxy2(Object target) {
		try {
			List<Interceptor> list = new ArrayList<>();
			
			InputStream in = App.class.getResourceAsStream("myconfig.properties");
			Properties prop = new Properties();
			prop.load(in);
			
			String str = prop.getProperty("interceptors");
			String[] strs = str.split(",");
			
			for (String ss : strs) {
				Class clazz = Class.forName(ss);
				list.add((Interceptor) clazz.newInstance());
			}
			
			// Ä¿±ê¶ÔÏó
			for(int i = list.size() - 1; i >= 0; i--) {
				target =  MyProxy.getProxy(target, list.get(i));
			}
			return target;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
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

class D implements Interceptor {

	@Override
	public boolean preHandle() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		return true;
	}

	@Override
	public void postHandle() {
		System.out.println("*********************");
	}
	
}

public class App {
	@Test
	public void test() throws Exception {
		ICalc proxy = (ICalc) MyProxy.getProxy2(new CalcImpl());
		proxy.add(1, 2);
		
	}
}


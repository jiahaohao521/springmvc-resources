package com.woniuxy.m_exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		String path = null;
		if(ex instanceof ArithmeticException) {
			path = "m2";
		} else if(ex instanceof NullPointerException) {
			path = "m3";
		}
		
		// 打印异常信息到控制台上
		ex.printStackTrace();
		return new ModelAndView(path);
	}

}

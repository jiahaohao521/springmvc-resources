package com.woniuxy.b_replace;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserController implements Controller {

//	@Override
//	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("123321");
//	}
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Springmvc ������������");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		
		return mav;
	}
}

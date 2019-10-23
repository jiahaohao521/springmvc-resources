package com.woniuxy.m_exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {
	@RequestMapping("save")
	public String save() {
		System.out.println("UserController.save() £¡£¡£¡");
//		System.out.println(8 / 0);
		String str = null;
		str.charAt(0);
		return "m";
	}
}

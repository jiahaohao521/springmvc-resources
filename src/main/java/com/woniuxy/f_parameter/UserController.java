package com.woniuxy.f_parameter;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {
	
	
	@RequestMapping("save")
	public ModelAndView save(byte b, short s, int i, long l, float f, double d, boolean bb, char c) {
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
		System.out.println(bb);
		System.out.println(c);
		return new ModelAndView("f");
	}
	
	@RequestMapping("save2")
	public ModelAndView save2(User user) {
		System.out.println(user);
		return new ModelAndView("f");
	}
	
	/*
	 控制器方法中，并不是所有参数都能直接接受请求参数的，比如下面的List类型的参数，
	 默认无法接收请求参数，为了让List也能接请求参数，需要在List前面加上一个注解：@RequestParam
	*/
	@RequestMapping("save3")
	public ModelAndView save3(@RequestParam List<String> hobby) {
		System.out.println(hobby);
		System.out.println(hobby.getClass());
		return new ModelAndView("f");
	}
	
	@RequestMapping("save4")
	public ModelAndView save4(@RequestParam Set<String> hobby) {
		System.out.println(hobby);
		System.out.println(hobby.getClass());
		return new ModelAndView("f");
	}
	
	/*
	 Map类型的参数，与List和Set类型的参数一样，如果不在前面加@RequestParam，则map也无法接受请求参数！
	 不一样的是，Map类型的参数，在前面加上了@RequestParam以后，参数的名字可以与请求参数中的名字不一致！
	*/
	@RequestMapping("save5")
	public ModelAndView save5(@RequestParam Map<String, String> map) {
		System.out.println(map);
		System.out.println(map.getClass());
		return new ModelAndView("f");
	}
	
	
	/*
	 	类类型的参数，在客户端没有传递对应的请求参数时，可以默认为null；
	 	而简单类型不行！
	*/
	@RequestMapping("save6")
	public ModelAndView save6(Integer a, int b) {
		System.out.println(a + " " + b);
		return new ModelAndView("f");
	}
	
	
}
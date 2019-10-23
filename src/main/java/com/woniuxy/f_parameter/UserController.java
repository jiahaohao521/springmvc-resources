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
	 �����������У����������в�������ֱ�ӽ�����������ģ����������List���͵Ĳ�����
	 Ĭ���޷��������������Ϊ����ListҲ�ܽ������������Ҫ��Listǰ�����һ��ע�⣺@RequestParam
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
	 Map���͵Ĳ�������List��Set���͵Ĳ���һ�����������ǰ���@RequestParam����mapҲ�޷��������������
	 ��һ�����ǣ�Map���͵Ĳ�������ǰ�������@RequestParam�Ժ󣬲��������ֿ�������������е����ֲ�һ�£�
	*/
	@RequestMapping("save5")
	public ModelAndView save5(@RequestParam Map<String, String> map) {
		System.out.println(map);
		System.out.println(map.getClass());
		return new ModelAndView("f");
	}
	
	
	/*
	 	�����͵Ĳ������ڿͻ���û�д��ݶ�Ӧ���������ʱ������Ĭ��Ϊnull��
	 	�������Ͳ��У�
	*/
	@RequestMapping("save6")
	public ModelAndView save6(Integer a, int b) {
		System.out.println(a + " " + b);
		return new ModelAndView("f");
	}
	
	
}
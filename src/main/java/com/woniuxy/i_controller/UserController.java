package com.woniuxy.i_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("user")
public class UserController {
	
	/*
	 	目前为止，每一个控制器方法的返回值都是ModelAndView
	 	ModelAndView顾名思义，其中封装了 模型 和 逻辑视图名
	 	下面演示一下如何封装模型：
	 */
	@RequestMapping("save")
	public ModelAndView save() {
		// 重定向
		// ModelAndView mav = new ModelAndView("redirect:/i.jsp"); 
		// 转发
		ModelAndView mav = new ModelAndView("i");
		
		mav.addObject("x", "东方不败"); 
		
		User user = new User();
		user.setId(12);
		user.setName("天山童姥");
		user.setBirthday(new Date());
		user.setMoney(330d);

		// 在reuqest范围中，添加一个键值对，键值是“智能”生成的，值是user对象
		// 键值默认就是类名首字母小写： user
		mav.addObject(user);
		// 在reuqest范围中，添加一个键值对，键值是user2，值是user对象
		mav.addObject("user2", user);
		
		
		mav.addObject("飞雪连天射白鹿");
		
		List<User> list = new ArrayList<>();
		list.add(new User(11,"韦小宝", new Date(), 1000d));
		list.add(new User(12,"令狐冲", new Date(), 2000d));
		list.add(new User(13,"张无忌", new Date(), 3000d));
		
		// 在reuqest范围中，添加一个键值对，键值是userList，值是list对象
		mav.addObject(list);
		
		return mav;
	}
	
	
	/*
	 控制器的方法，返回类型除了可以是ModelAndView以外，也可以是String类型
	 此时String返回值的内容，表示的是“逻辑视图名”
	 
	 此时，如果还想给跳转的目标页面传递参数，就要为控制器添加一个Model类型的参数
	 但凡要给页面传递什么参数，都是通过model的addAttribute方法实现的
	*/
	@RequestMapping("save2")
	public String save2(Model model) {
		System.out.println("UserController.save2()");
		model.addAttribute("aa", "笑书神侠倚碧鸳");
		model.addAttribute(new Date());
		return "i";
	}
	/*
	 	默认的跳转方式是转发，那么如何才能重定向呢？
	 	注意，重定向时，前后缀必须自己手动添加
	*/
	@RequestMapping("save3")
	public String save3() {
		System.out.println("UserController.save3()");
		return "redirect:/i.jsp";
	}
	
	
	/*
	 	SpringMVC的控制器方法中，如何获取web元素， 只能获取后面的这3个web元素：request,session,response
	*/
	@RequestMapping("save4")
	public String save4(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException {
		// 获取发起当前请求的客户端的ip地址！
		String ip = request.getRemoteAddr();
		System.out.println("客户端ip地址：" + ip);
		
		request.setAttribute("abc", "好好学习，天天向上，别浪！" + ip);
		session.setAttribute("xyz", "日积月累，是一件很恐怖的事情！");
		request.getServletContext().setAttribute("aaa", "哈哈哈");
		
		// response.sendRedirect("http://www.163.com");
		return "i";
	}
}

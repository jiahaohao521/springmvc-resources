package com.woniuxy.j_httpmessageconverter.b;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

	
	// 该方法演示了， 服务器端 与 客户端请求发来的Accept搭配使用的场景。
	@RequestMapping("save")
	public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		String Accept = request.getHeader("Accept");
		String msg = null;
		if("application/json".equals(Accept)) {
			msg = "{\"id\":1,\"name\":\"andy\"}";
		} else if("text/html".equals(Accept)) {
			msg = "破剑式, 我是字符串！！";
		}
		// 获取输出流，起点： 服务器   终点：客户端
		PrintWriter out = response.getWriter();
		out.println(msg);
		out.close();
	}
	
	
	
	// 只要控制方法的参数前面有@RequestBody这个注解， 那么SpringMVC框架就会立即读取请求头中的 Content-Type 的值！
	// Content-Type:  text/user (这个格式，说人话，就是“自定义”格式)
	// SpringMVC框架，此时就会根据text/user这个值，找出能处理该格式的 HttpMessageConverter: StringHttpMessageConverter

	
	// 此时，框架会调用StringHttpMessageConverter的canRead(), 而canRead又回调了supports方法
	/*
	 	StringHttpMessageConverter的supports方法如下：
		@Override
		public boolean supports(Class<?> clazz) {
			return String.class == clazz;
		}
		问题是，该supports方法的参数clazz是哪来的，是什么值！？ 这个clazz参数的值，恰恰就是@RequestBody注解所注解的参数的字节码！
		
		如果supports方法返回true，则继续，否则直接抛出异常！
		
		如果supports确实返回ture，SpringMVC框架，才会使用StringHttpMessageConverter来处理客户端发来的请求参数：id::200##name::eason
		
		StringHttpMessageConverter的read方法，恰恰就是把请求参数，原封不动地封装到@RequestBody注解所注解的参数中！
		
	*/
	@RequestMapping("save2")
	public void save2(@RequestBody String str) throws IOException {
		System.out.println(str);
	}
	
	// 有@RequestBody -> Content-Type: text/user
	// text/user: UserHttpMessageConverter, StringHttpMessageConverter
	// supports:     true                        false
	// 最终确定了一个消息转换器： UserHttpMessageConverter， 就调用该转换器的read方法，该read方法返回什么，适配器就把什么放入参数中！
	@RequestMapping("save3")
	public void save3(@RequestBody User u) throws IOException {
		System.out.println(u);
	}
	
	// 有@RequestBody -> Content-Type: application/json
	// application/json:  StringHttpMessageConverter    MappingJackson2HttpMessageConverter
	// supports: 			false							supports无条件返回true
	// 调用 MappingJackson2HttpMessageConverter的read方法：
	@RequestMapping("save4")
	public void save4(@RequestBody User u) throws IOException {
		System.out.println(u);
	}
	
	
	// 在方法执行完毕后，框架会检测方法上是否有@ResponseBody注解，如果有，有不会使用视图解析器来做响应，而会使用HttpMessageConverter来做响应.
	// 有@ResponseBody --> 读取Accept请求头：text/user --> StringHttpMessageConverter， UserHttpMessageConverter
	// supports:     										false						true
	// 最终找到了UserHttpMessageConverter，就会调用UserHttpMessageConverter的write方法
	// 最终，该write方法中的输出流写出什么， 就会给客户端浏览器响应什么内容
	@RequestMapping("save5")		
	@ResponseBody
	public User save5() throws IOException {
		System.out.println("save5555");
		User user = new User();
		user.setId(222);
		user.setName("东方不败");
		user.setBirthday(new Date());
		user.setMoney(345d);
		return user;  
	}
	
	// @ResponseBody --> application/json --> StringConverter , MappingJackson2
	// supports									false				true
	// MappingJackson2.write()
	@RequestMapping("save6")		
	@ResponseBody
	public User save6() throws IOException {
		System.out.println("save6666");
		User user = new User();
		user.setId(333);
		user.setName("任我行");
		user.setBirthday(new Date());
		user.setMoney(456d);
		return user;  
	}
	
	
	
}

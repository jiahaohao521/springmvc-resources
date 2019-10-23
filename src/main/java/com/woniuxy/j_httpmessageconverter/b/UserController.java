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

	
	// �÷�����ʾ�ˣ� �������� �� �ͻ�����������Accept����ʹ�õĳ�����
	@RequestMapping("save")
	public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		String Accept = request.getHeader("Accept");
		String msg = null;
		if("application/json".equals(Accept)) {
			msg = "{\"id\":1,\"name\":\"andy\"}";
		} else if("text/html".equals(Accept)) {
			msg = "�ƽ�ʽ, �����ַ�������";
		}
		// ��ȡ���������㣺 ������   �յ㣺�ͻ���
		PrintWriter out = response.getWriter();
		out.println(msg);
		out.close();
	}
	
	
	
	// ֻҪ���Ʒ����Ĳ���ǰ����@RequestBody���ע�⣬ ��ôSpringMVC��ܾͻ�������ȡ����ͷ�е� Content-Type ��ֵ��
	// Content-Type:  text/user (�����ʽ��˵�˻������ǡ��Զ��塱��ʽ)
	// SpringMVC��ܣ���ʱ�ͻ����text/user���ֵ���ҳ��ܴ���ø�ʽ�� HttpMessageConverter: StringHttpMessageConverter

	
	// ��ʱ����ܻ����StringHttpMessageConverter��canRead(), ��canRead�ֻص���supports����
	/*
	 	StringHttpMessageConverter��supports�������£�
		@Override
		public boolean supports(Class<?> clazz) {
			return String.class == clazz;
		}
		�����ǣ���supports�����Ĳ���clazz�������ģ���ʲôֵ���� ���clazz������ֵ��ǡǡ����@RequestBodyע����ע��Ĳ������ֽ��룡
		
		���supports��������true�������������ֱ���׳��쳣��
		
		���supportsȷʵ����ture��SpringMVC��ܣ��Ż�ʹ��StringHttpMessageConverter������ͻ��˷��������������id::200##name::eason
		
		StringHttpMessageConverter��read������ǡǡ���ǰ����������ԭ�ⲻ���ط�װ��@RequestBodyע����ע��Ĳ����У�
		
	*/
	@RequestMapping("save2")
	public void save2(@RequestBody String str) throws IOException {
		System.out.println(str);
	}
	
	// ��@RequestBody -> Content-Type: text/user
	// text/user: UserHttpMessageConverter, StringHttpMessageConverter
	// supports:     true                        false
	// ����ȷ����һ����Ϣת������ UserHttpMessageConverter�� �͵��ø�ת������read��������read��������ʲô���������Ͱ�ʲô��������У�
	@RequestMapping("save3")
	public void save3(@RequestBody User u) throws IOException {
		System.out.println(u);
	}
	
	// ��@RequestBody -> Content-Type: application/json
	// application/json:  StringHttpMessageConverter    MappingJackson2HttpMessageConverter
	// supports: 			false							supports����������true
	// ���� MappingJackson2HttpMessageConverter��read������
	@RequestMapping("save4")
	public void save4(@RequestBody User u) throws IOException {
		System.out.println(u);
	}
	
	
	// �ڷ���ִ����Ϻ󣬿�ܻ��ⷽ�����Ƿ���@ResponseBodyע�⣬����У��в���ʹ����ͼ������������Ӧ������ʹ��HttpMessageConverter������Ӧ.
	// ��@ResponseBody --> ��ȡAccept����ͷ��text/user --> StringHttpMessageConverter�� UserHttpMessageConverter
	// supports:     										false						true
	// �����ҵ���UserHttpMessageConverter���ͻ����UserHttpMessageConverter��write����
	// ���գ���write�����е������д��ʲô�� �ͻ���ͻ����������Ӧʲô����
	@RequestMapping("save5")		
	@ResponseBody
	public User save5() throws IOException {
		System.out.println("save5555");
		User user = new User();
		user.setId(222);
		user.setName("��������");
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
		user.setName("������");
		user.setBirthday(new Date());
		user.setMoney(456d);
		return user;  
	}
	
	
	
}

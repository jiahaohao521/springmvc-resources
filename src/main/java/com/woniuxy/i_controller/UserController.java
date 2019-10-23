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
	 	ĿǰΪֹ��ÿһ�������������ķ���ֵ����ModelAndView
	 	ModelAndView����˼�壬���з�װ�� ģ�� �� �߼���ͼ��
	 	������ʾһ����η�װģ�ͣ�
	 */
	@RequestMapping("save")
	public ModelAndView save() {
		// �ض���
		// ModelAndView mav = new ModelAndView("redirect:/i.jsp"); 
		// ת��
		ModelAndView mav = new ModelAndView("i");
		
		mav.addObject("x", "��������"); 
		
		User user = new User();
		user.setId(12);
		user.setName("��ɽͯ��");
		user.setBirthday(new Date());
		user.setMoney(330d);

		// ��reuqest��Χ�У����һ����ֵ�ԣ���ֵ�ǡ����ܡ����ɵģ�ֵ��user����
		// ��ֵĬ�Ͼ�����������ĸСд�� user
		mav.addObject(user);
		// ��reuqest��Χ�У����һ����ֵ�ԣ���ֵ��user2��ֵ��user����
		mav.addObject("user2", user);
		
		
		mav.addObject("��ѩ�������¹");
		
		List<User> list = new ArrayList<>();
		list.add(new User(11,"ΤС��", new Date(), 1000d));
		list.add(new User(12,"�����", new Date(), 2000d));
		list.add(new User(13,"���޼�", new Date(), 3000d));
		
		// ��reuqest��Χ�У����һ����ֵ�ԣ���ֵ��userList��ֵ��list����
		mav.addObject(list);
		
		return mav;
	}
	
	
	/*
	 �������ķ������������ͳ��˿�����ModelAndView���⣬Ҳ������String����
	 ��ʱString����ֵ�����ݣ���ʾ���ǡ��߼���ͼ����
	 
	 ��ʱ������������ת��Ŀ��ҳ�洫�ݲ�������ҪΪ���������һ��Model���͵Ĳ���
	 ����Ҫ��ҳ�洫��ʲô����������ͨ��model��addAttribute����ʵ�ֵ�
	*/
	@RequestMapping("save2")
	public String save2(Model model) {
		System.out.println("UserController.save2()");
		model.addAttribute("aa", "Ц�������б�ԧ");
		model.addAttribute(new Date());
		return "i";
	}
	/*
	 	Ĭ�ϵ���ת��ʽ��ת������ô��β����ض����أ�
	 	ע�⣬�ض���ʱ��ǰ��׺�����Լ��ֶ����
	*/
	@RequestMapping("save3")
	public String save3() {
		System.out.println("UserController.save3()");
		return "redirect:/i.jsp";
	}
	
	
	/*
	 	SpringMVC�Ŀ����������У���λ�ȡwebԪ�أ� ֻ�ܻ�ȡ�������3��webԪ�أ�request,session,response
	*/
	@RequestMapping("save4")
	public String save4(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException {
		// ��ȡ����ǰ����Ŀͻ��˵�ip��ַ��
		String ip = request.getRemoteAddr();
		System.out.println("�ͻ���ip��ַ��" + ip);
		
		request.setAttribute("abc", "�ú�ѧϰ���������ϣ����ˣ�" + ip);
		session.setAttribute("xyz", "�ջ����ۣ���һ���ֲܿ������飡");
		request.getServletContext().setAttribute("aaa", "������");
		
		// response.sendRedirect("http://www.163.com");
		return "i";
	}
}

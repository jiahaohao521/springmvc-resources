package com.woniuxy.n_validate;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
	
	/*
		1. ��springmvc������hibernateУ����֮�󣬾Ϳ����ڲ���ǰ���@Validatedע��
		2. ����ǰһ��������@Validated�� springmvc��ܾ�֪�����������Ҫ��У�飡
		3. ��ô��ôУ���أ� ����ɲ������������У��ֶ��ϵ�ע����ָ���ˣ�
	 	4. ע�⣬�����ڼ���@Validated�Ĳ���֮�󣬽�����һ�������� Errors����Errors������ר���������У�����ģ�
	 	   (���û����@Validated�Ĳ���֮�󣬽�����һ�������� Errors����������ʱ������Ӧ400���󣡣�)
	 	5. ������@Validated�Ĳ����������ᱻspringmvc��ܽ����Զ�У�飬���һ��ᱻ��ܴ�������Χ�У���ֵ������������ĸд��
	*/
	
	// saveҪ��username������2��4��
	@RequestMapping("save")
	public String save(@Validated(A.class) User user, Errors errors, Model model) {
		
		String path = null;
		if(errors.hasErrors()) {
			
			// �������ߵ����˵����У�����У����������1��������������µ�api��ȡ�ľ���У������д���
			List<FieldError> list = errors.getFieldErrors();
			for (FieldError fe : list) {
				// ���´��룬�ȼ��ڰѴ�����Ϣ�ӵ�request��Χ�С�
				model.addAttribute(fe.getField()+"Error", fe.getDefaultMessage()); 
			}
			
			// ����ת���������
			path = "n";
			
		} else {
			// �ͷ���ȥִ���ض���ҵ�񣬸ø���͸��
			System.out.println("�û�������⣺" + user);
			path = "n3";
		}
		
		return path;
		
	}
	
	
	
	// updateҪ��username������3��6��
	@RequestMapping("update")
	public String update(@Validated(B.class) User user, Errors errors, Model model) {
		String path = null;
		if(errors.hasErrors()) {
			
			// �������ߵ����˵����У�����У����������1��������������µ�api��ȡ�ľ���У������д���
			List<FieldError> list = errors.getFieldErrors();
			for (FieldError fe : list) {
				// ���´��룬�ȼ��ڰѴ�����Ϣ�ӵ�request��Χ�С�
				model.addAttribute(fe.getField()+"Error", fe.getDefaultMessage()); 
			}
			// ����ת���������
			path = "n2";
			
		} else {
			// �ͷ���ȥִ���ض���ҵ�񣬸ø���͸��
			System.out.println("�û�������⣺" + user);
			path = "n3";
		}
		
		return path;
		
	}

}
 
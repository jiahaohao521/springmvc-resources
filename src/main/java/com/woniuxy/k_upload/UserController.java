package com.woniuxy.k_upload;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("user")
public class UserController {
	
	// springmvc�������ļ��ϴ�ʱ�����뵼������������
	// fileupload.
	
	// �÷��������ֽ���upload�����Ǹ÷��������������ļ��ϴ����Ĺ�����
	//	���ǰ��Ѿ��ϴ����������ڴ��е�ͼƬ��2���ƣ����д��̣���
	
	// ����ʹ��CommonsMultipartFile�����ܿͻ��˴�����ͼƬ����Ϣ�����ֺ�2���ƣ�,���ڸò���ǰҲ�����@RequestParam 
	
	// ��������spring-servlet�У�����һ���ļ��ϴ�����������
	@RequestMapping("upload")
	public String upload(@RequestParam CommonsMultipartFile photo, HttpServletRequest request) throws IllegalStateException, IOException {
	
		// ��ϰ���÷�����ֻ����ͼƬ
		
		// ��3���ط�����д����
		// 1.��׺
		String oldName = photo.getOriginalFilename();
		int lastDot = oldName.lastIndexOf(".");
		String ext = oldName.substring(lastDot);
		// 2. �ļ���
		String newName = UUID.randomUUID().toString().replaceAll("-", "") + ext;
		// 3.�ϴ�·������д��, ��ȡwebӦ���ڷ����������ڵ���ʵĿ¼��
		String path = request.getServletContext().getRealPath("/images");
		
		System.out.println("path:" + path);
		
		// ����
		photo.transferTo(new File(path, newName));
		
		return "k";
	}
}

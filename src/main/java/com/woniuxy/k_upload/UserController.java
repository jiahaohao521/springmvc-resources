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
	
	// springmvc在制作文件上传时，必须导入以下依赖：
	// fileupload.
	
	// 该方法，名字叫做upload，但是该方法并不会做“文件上传”的工作，
	//	而是把已经上传到服务器内存中的图片的2进制，进行存盘！！
	
	// 必须使用CommonsMultipartFile来接受客户端传来的图片的信息（名字和2进制）,且在该参数前也必须加@RequestParam 
	
	// 还必须在spring-servlet中，配置一个文件上传解析器！！
	@RequestMapping("upload")
	public String upload(@RequestParam CommonsMultipartFile photo, HttpServletRequest request) throws IllegalStateException, IOException {
	
		// 练习，让服务器只存盘图片
		
		// 有3个地方不能写死：
		// 1.后缀
		String oldName = photo.getOriginalFilename();
		int lastDot = oldName.lastIndexOf(".");
		String ext = oldName.substring(lastDot);
		// 2. 文件名
		String newName = UUID.randomUUID().toString().replaceAll("-", "") + ext;
		// 3.上传路径不能写死, 获取web应用在服务器中所在的真实目录！
		String path = request.getServletContext().getRealPath("/images");
		
		System.out.println("path:" + path);
		
		// 存盘
		photo.transferTo(new File(path, newName));
		
		return "k";
	}
}

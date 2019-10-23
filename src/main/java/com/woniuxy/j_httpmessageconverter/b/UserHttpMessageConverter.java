package com.woniuxy.j_httpmessageconverter.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class UserHttpMessageConverter extends AbstractHttpMessageConverter<User>{

	@Override
	protected boolean supports(Class<?> clazz) {
		return User.class == clazz;
	}

	@Override
	protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		// 这里应该根据请求中所传递的请求参数，来生成User对象。
		// 首要问题就是，从哪获取请求中的请求参数？？ 答：从当前方法的第二个参数：inputMessage中获取！！
		
		InputStream in = inputMessage.getBody();
		
		StringBuilder sb  = new StringBuilder();
		while(in.available() > 0) {
			int n = in.read();
			sb.append((char)n);
		}
		
		// sb是：id::300##name::ella
		String str = sb.toString();
		// strs[0] id::300     strs[1]   name::ella
		String[] strs = str.split("##");  // 字符串的split天生支持“正则式”， 所以如果split的参数是正则式的特殊字符，需要转义
		
		User user = new User();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for (String ss : strs) {
			String fieldName = ss.split("::")[0];
			if("id".equals(fieldName)) {
				user.setId(Integer.parseInt(ss.split("::")[1]));
			}else if("name".equals(fieldName)) {
				user.setName(ss.split("::")[1]);
			}else if("birthday".equals(fieldName)) {
				try {
					Date dd = sdf.parse(ss.split("::")[1]);
					user.setBirthday(dd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else if("money".equals(fieldName)) {
				user.setMoney(Double.parseDouble(ss.split("::")[1]));
			}
		}
		
		return user;  // 这里不能直接返回null，否则会报错，为什么？ 框架就是这个样子的！
	}
	

	@Override
	protected void writeInternal(User t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		// 通过输出流给客户端响应数据：
		OutputStream out = outputMessage.getBody();
		
		String str = "id::" + t.getId() + "##name::" + t.getName() + "##birthday::" + sdf.format(t.getBirthday()) +"##money::" + t.getMoney(); 
		
		out.write(str.getBytes("utf-8"));
		
		out.close();
	}

}

package com.woniuxy.j_httpmessageconverter.b;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	public static void main(String[] args) throws IOException {
		// jackson-databind
		ObjectMapper om = new ObjectMapper();
		
		// 1. 把对象格式化为json字符串
		User user = new User();
		user.setId(333);
		user.setName("任我行");
		user.setBirthday(new Date());
		user.setMoney(456d);
		
		String json = om.writeValueAsString(user);
		System.out.println(json);
		
		
		// 2. 把json解析为对象
//		String json = "{\"id\":334,\"name\":\"嘤嘤嘤\",\"birthday\":1571646854611,\"money\":456.0}";
//		User user = om.readValue(json,User.class);
//		System.out.println(user);
		
		
	}
}

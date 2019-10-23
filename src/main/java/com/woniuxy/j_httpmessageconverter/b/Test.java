package com.woniuxy.j_httpmessageconverter.b;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	public static void main(String[] args) throws IOException {
		// jackson-databind
		ObjectMapper om = new ObjectMapper();
		
		// 1. �Ѷ����ʽ��Ϊjson�ַ���
		User user = new User();
		user.setId(333);
		user.setName("������");
		user.setBirthday(new Date());
		user.setMoney(456d);
		
		String json = om.writeValueAsString(user);
		System.out.println(json);
		
		
		// 2. ��json����Ϊ����
//		String json = "{\"id\":334,\"name\":\"������\",\"birthday\":1571646854611,\"money\":456.0}";
//		User user = om.readValue(json,User.class);
//		System.out.println(user);
		
		
	}
}

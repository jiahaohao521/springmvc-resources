package com.woniuxy.f_parameter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class MyDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		System.out.println("原始数据：" + source); // 2011-11-12
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// 专门把字符串解析成日期格式，
			// 此时要求，传入parse方法的参数格式，必须与构造SimpleDateFormat时，传入的格式一致。
			Date dd = sdf.parse(source);
			return dd;
		} catch (ParseException e) {
			
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
			try {
				Date dd = sdf2.parse(source);
				return dd;
			} catch (ParseException e1) {
				e1.printStackTrace();
				return null;
			}
		}
	
	}

}

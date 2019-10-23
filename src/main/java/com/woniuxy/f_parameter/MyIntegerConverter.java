package com.woniuxy.f_parameter;

import org.springframework.core.convert.converter.Converter;

public class MyIntegerConverter implements Converter<String, Integer> {

	@Override
	public Integer convert(String source) {
		System.out.println("原始数据：" + source);
		int i = Integer.parseInt(source);
		return i*10;
	}

}

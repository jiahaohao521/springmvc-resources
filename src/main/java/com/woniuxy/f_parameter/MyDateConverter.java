package com.woniuxy.f_parameter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class MyDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		System.out.println("ԭʼ���ݣ�" + source); // 2011-11-12
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// ר�Ű��ַ������������ڸ�ʽ��
			// ��ʱҪ�󣬴���parse�����Ĳ�����ʽ�������빹��SimpleDateFormatʱ������ĸ�ʽһ�¡�
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

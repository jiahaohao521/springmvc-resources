package com.woniuxy.d_annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("car")
public class CarController {
	
	@RequestMapping("save")
	public void save() {
		System.out.println("CarController.save()");
	}
	
	@RequestMapping("delete")
	public void delete() {
		System.out.println("CarController.delete()");
	}


}

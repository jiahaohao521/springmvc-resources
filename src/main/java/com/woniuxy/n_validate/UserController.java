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
		1. 在springmvc集成了hibernate校验框架之后，就可以在参数前面加@Validated注解
		2. 参数前一旦加上了@Validated， springmvc框架就知道，这个参数要被校验！
		3. 那么怎么校验呢？ 这就由参数所属的类中，字段上的注解来指定了！
	 	4. 注意，必须在加了@Validated的参数之后，紧跟另一个参数： Errors，该Errors对象，是专门用来存放校验结果的！
	 	   (如果没有在@Validated的参数之后，紧跟另一个参数： Errors，则发起请求时，会响应400错误！！)
	 	5. 被加上@Validated的参数，不但会被springmvc框架进行自动校验，而且还会被框架存入请求范围中，键值就是类名首字母写。
	*/
	
	// save要求username必须是2到4列
	@RequestMapping("save")
	public String save(@Validated(A.class) User user, Errors errors, Model model) {
		
		String path = null;
		if(errors.hasErrors()) {
			
			// 流程能走到这里，说明有校验错误，校验错误可能有1到多个。所以以下的api获取的就是校验的所有错误！
			List<FieldError> list = errors.getFieldErrors();
			for (FieldError fe : list) {
				// 以下代码，等价于把错误信息加到request范围中。
				model.addAttribute(fe.getField()+"Error", fe.getDefaultMessage()); 
			}
			
			// 就跳转到错误界面
			path = "n";
			
		} else {
			// 就放行去执行特定的业务，该干嘛就干嘛，
			System.out.println("用户数据入库：" + user);
			path = "n3";
		}
		
		return path;
		
	}
	
	
	
	// update要求username必须是3到6列
	@RequestMapping("update")
	public String update(@Validated(B.class) User user, Errors errors, Model model) {
		String path = null;
		if(errors.hasErrors()) {
			
			// 流程能走到这里，说明有校验错误，校验错误可能有1到多个。所以以下的api获取的就是校验的所有错误！
			List<FieldError> list = errors.getFieldErrors();
			for (FieldError fe : list) {
				// 以下代码，等价于把错误信息加到request范围中。
				model.addAttribute(fe.getField()+"Error", fe.getDefaultMessage()); 
			}
			// 就跳转到错误界面
			path = "n2";
			
		} else {
			// 就放行去执行特定的业务，该干嘛就干嘛，
			System.out.println("用户数据入库：" + user);
			path = "n3";
		}
		
		return path;
		
	}

}
 
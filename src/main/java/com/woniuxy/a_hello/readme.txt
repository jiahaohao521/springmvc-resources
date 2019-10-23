1. MVC是什么？
	M model			模型
	V view			视图
	C controller	控制器
	
2. Springmvc是一个MVC框架。   我们学习Springmvc的目的就是为了提高web层开发的速度！！

3. 先把自行车骑起来

	a. 导入依赖
		spring-webmvc
		servlet
		
	b. 打开web.xml， 配置springmvc框架的前端控制器
	        前端控制器负责拦截所有do结尾的请求，然后对这些请求进行分发
		<?xml version="1.0" encoding="UTF-8"?>
		<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xmlns="http://java.sun.com/xml/ns/javaee"
			xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
			version="2.5">
			<display-name>springmvc</display-name>
		
			<servlet>
				<servlet-name>DispatcherServlet</servlet-name>
				<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
				<init-param>
					<param-name>contextConfigLocation</param-name>
					<param-value>classpath:com/woniuxy/a_hello/spring-servlet.xml</param-value>
				</init-param>
			</servlet>
			
			<servlet-mapping>
				<servlet-name>DispatcherServlet</servlet-name>
				<url-pattern>*.do</url-pattern>
			</servlet-mapping>
		
			
		</web-app>
		
	c. 创建一个Springmvc中的控制器
	
		package com.woniuxy.a_hello;

		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;
		
		import org.springframework.web.servlet.ModelAndView;
		import org.springframework.web.servlet.mvc.Controller;
		
		// 目前而言， 作为Springmvc中的控制器，必须实现Controller接口
		public class UserController implements Controller {
			@Override
			public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
				System.out.println("问候springmvc它大爷！！！");
				return null;
			}
		}
		
	d. 创建spring的配置文件，这个文件以前叫做applictionContext，现在在springmvc环境下，应该叫做： spring-servlet.xml
	
		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
		
			<!-- 
				映射器处理器 
				1. 接受请求地址：  /user.do
				2. 返回控制器：	UserController
			-->
			<bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"></bean>
			
			<!-- 
				适配器处理器 
				1. 接受控制器，并且执行控制器  ：  UserController
				2.返回ModelAndView：   index
			-->
			<bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"></bean>
		
			<!-- 配置控制器 -->
			<bean id="/user.do" class="com.woniuxy.a_hello.UserController"></bean>
			
			<!-- 
				视图解析器
				1. 接受ModelAndView： index， 在“逻辑视图名”前后添加 前缀和后缀： /index.jsp （这就是物理视图）
				2.返回物理视图
			 -->
			<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
				<property name="prefix" value="/"></property>
				<property name="suffix" value=".jsp"></property>
			</bean>
		
		</beans>

		
	e. 部署当前web应用到tomcat下，并且访问控制器：  localhost/springmvc/user.do
		
		
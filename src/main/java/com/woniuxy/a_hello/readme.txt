1. MVC��ʲô��
	M model			ģ��
	V view			��ͼ
	C controller	������
	
2. Springmvc��һ��MVC��ܡ�   ����ѧϰSpringmvc��Ŀ�ľ���Ϊ�����web�㿪�����ٶȣ���

3. �Ȱ����г�������

	a. ��������
		spring-webmvc
		servlet
		
	b. ��web.xml�� ����springmvc��ܵ�ǰ�˿�����
	        ǰ�˿�����������������do��β������Ȼ�����Щ������зַ�
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
		
	c. ����һ��Springmvc�еĿ�����
	
		package com.woniuxy.a_hello;

		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;
		
		import org.springframework.web.servlet.ModelAndView;
		import org.springframework.web.servlet.mvc.Controller;
		
		// Ŀǰ���ԣ� ��ΪSpringmvc�еĿ�����������ʵ��Controller�ӿ�
		public class UserController implements Controller {
			@Override
			public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
				System.out.println("�ʺ�springmvc����ү������");
				return null;
			}
		}
		
	d. ����spring�������ļ�������ļ���ǰ����applictionContext��������springmvc�����£�Ӧ�ý����� spring-servlet.xml
	
		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
		
			<!-- 
				ӳ���������� 
				1. ���������ַ��  /user.do
				2. ���ؿ�������	UserController
			-->
			<bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"></bean>
			
			<!-- 
				������������ 
				1. ���ܿ�����������ִ�п�����  ��  UserController
				2.����ModelAndView��   index
			-->
			<bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"></bean>
		
			<!-- ���ÿ����� -->
			<bean id="/user.do" class="com.woniuxy.a_hello.UserController"></bean>
			
			<!-- 
				��ͼ������
				1. ����ModelAndView�� index�� �ڡ��߼���ͼ����ǰ����� ǰ׺�ͺ�׺�� /index.jsp �������������ͼ��
				2.����������ͼ
			 -->
			<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
				<property name="prefix" value="/"></property>
				<property name="suffix" value=".jsp"></property>
			</bean>
		
		</beans>

		
	e. ����ǰwebӦ�õ�tomcat�£����ҷ��ʿ�������  localhost/springmvc/user.do
		
		
rest��һ����Ʒ�񣬶�����Э�飬Ҳ���Ǳ�׼��

��˼�ǣ���ͬ��˾�У�ʹ��rest��д��������һ������



Ԥ��֪ʶ��
1. Ĭ��servlet
	ר�Ÿ�����Ӧ��̬��Դ��ͼƬ����Ƶ��html��
	Ҳ������Դ�Ҳ���ʱ����Ӧ404����
	
2. /��/*������
	/ 	������������
	/*  ������������
	
	�����ǣ�/ʲô�����أ����ǲ�����jsp   /* ʲô�����أ�����jsp
	���գ���������Ҫ��ʽѧϰ��rest��Ҫ��ǰ�˿�����������·��Ϊ / 
	
=============================================================================

rest��ȫ��Representational State Transfer,  ������������� ������״̬ת����

rest��̷����ص㣺
1. rest����У���������Դ��̵ġ�
	��ν��Դ�����������ϣ������ü�ֵ�Ķ�����  һ�׸裬 һ�������� һƪ���£� һ��ͼƬ�� �û�����Ӱ�� ��Ʒ�������Գ�֮Ϊ��Դ�� 

2. rest���Ҫ�󣬶���Դ�Ĳ���������Ӱ��url��ַ��


3. ��ǰ������ʹ�õĿ�����ʽ����ʵ�ǲ�����rest���ģ�Ϊʲô�������أ�

	http://localhost:8080/test/user/save.do		����
	http://localhost:8080/test/user/delete.do	ɾ��
	http://localhost:8080/test/user/update.do	�޸�
	http://localhost:8080/test/user/findAll.do	��ѯ
	
	�����ǣ�httpЭ���У��Ѿ��涨��8������ʽ�� ����֪����ֻ�У�get��post
	
	��8������ʽ�ֱ��ǣ� get post delete put  patch head options track
	
	���У� 
		get����ʽ�������� ��ѯ
		post����ʽ������������
		delete����ʽ��������ɾ��
		put����ʽ���������޸�
		
	���Կ�����http��ͬ������ʽ���Ѿ��ܱ�ʾCRUD�Ĳ�ͬ�����ˣ� �Ͳ���Ҫ����url�ϣ�ͨ��������ָ����������Ҫ��ʲô��
	��ǰ��url��ַ��Ϊ�˱�ʾ���ӣ���Ҫ�ڵ�ַ�����Ե�д��save�� Ϊ�˱�ʾɾ������Ҫд��delete�� ��ʵ�ⰲȫ�Ƕ���ģ�
	
	ֻҪ���ǰ�����ʽ�ı��ˣ� ����������֪�������������Ŀ����ʲô�� �����Ƿ���rest���������ַ��
	
	http://localhost:8080/test/users				post
	http://localhost:8080/test/users				delete
	http://localhost:8080/test/users				put
	http://localhost:8080/test/users				get
	http://localhost:8080/test/users/1			get

============================================================================================================

��springmvc��ʹ��rest ����������Ҳ��֧��rest�� rest������springmvc�����еģ� ����springmvc��rest������֧�֣���

1. rest����У�Ҫ����Դ���Ǹ�����ʽ��
2. rest����У�Ҫ�������ַ�������к�׺��Ҳ���ǲ��ܼ�.do .action ���Ҫ�޸�ǰ�˿�����
	<servlet>
		<servlet-name>DispatcherServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath:com/woniuxy/o_rest/spring-servlet.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>DispatcherServlet</servlet-name>
		<url-pattern>/</url-pattern>		��==	�������������������������������
	</servlet-mapping>


3. �����ǣ���ֻ֧��get��post����ʽ����֧��put��delete��
   ��β����ñ�Ҳ֧��put��delete�أ���
   
   ֻ��Ҫ����web.xml�У�����һ����������
   	<filter>
		<filter-name>HiddenHttpMethodFilter</filter-name>
		<filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
	</filter>
	
	<filter-mapping>
		<filter-name>HiddenHttpMethodFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	
��Ҫ�ڱ��У�����һ�������򣬸�����������ֱ������"_method"�� ȡֵΪ delete��put��
	<form action="/springmvc/users" method="post">
		<input type="hidden" name="_method" value="delete" />
		<button type="submit">Go</button>
	</form>
	
����restful����ajax CURD����μ�o2.jsp


���⣬����rest����url�����������������? ���紫��ҳ�룬��ÿҳ��ʾ����

get����  http://localhost:8080/test/users?page=1&size=10

 
�����Ѿ�֪���� ��ʱ��ǰ�˿������� ӳ��·����/ 	�� �����ǣ���/һ�ģ�����Ҳ������Ӧ���е�ͼƬ�ˣ�ԭ���㶮�ã�

Ϊ�˽��������⣬��Ҫ����spring-serlvet.xml�У�������ã�


		



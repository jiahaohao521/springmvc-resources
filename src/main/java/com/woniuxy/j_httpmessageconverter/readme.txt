0.http�����ɼ�������ɣ�
	a. ������
	b. ����ͷ
	c. ������

1. httpЭ���е�����ͷ��
    content-type���ͻ��˸��߷��������ҿͻ��˸��㷢�͵���ʲô��ʽ�����ݡ�
    accept���ͻ��˸��߷��������ҿͻ�����Ҫʲô��ʽ�����ݡ�

2. �ͻ���Ҫʲô��ʽ�����ݣ�������δ�ؾͻ��ʲô��ʽ�����ݣ���Ϊ��ֻ��һ��http�淶���ѣ�
   ���������շ���ʲô��ʽ�����ݣ�ȡ����������д�Ĵ��롣
   
3. ���Ƕ�֪����springmvc��������Ϊ�������Ĳ���ע��ֵ�ģ���������ע��ֵ��Ҳ��������������������֣���Ŀ�귽���Ĳ�����ƥ�䣩��

4. �������ڿ������ķ��������������@RequestBodyע�⣬springmvc��ܾͲ��ٰ��������Զ�ע�������ֵ��
    ����ʹ��HttpMessageConverter��Ϊ����ע��ֵ��

5. SpringMVC��HttpMessageConverter�Ĺ���ԭ��
    a. �ͻ��˷������󣬲�Я���������
    b. SpringMVC����ӳ�����ҵ���Ӧ��handler���ٰ�handler����������
    c. ��������ⷽ���Ĳ������Ƿ���@RequestBody 
        ���û�У���������ע�������ֵ��Ȼ�����̾�ֱ�ӽ����ˡ�
        ����У���ʹ��HttpMessageConverterע�������ֵ�������4��
    d. SpringMVC��ܶ�ȡ������ͷ�е�content-type��ֵ������Ϊtext/html��Ҳ���ǿͻ��˸��߷������Ҹ��㷢����html��ʽ�����ݣ�
       SpringMVC���ݻ�ȡ����content-type��ֵ��ȥ�ҳ��������content-type��ֵƥ���HttpMessageConverter����
       
        ���һ�����Ҳ��������׳��쳣��HttpMediaTypeNotSupportedException
        ����ҵ�һ����һ�����ϣ�������5�� (���HttpMessageConveter��˳��������õ�˳��)
        
    e. SpringMVC�����Ѿ��ҵ���һ������HttpMessageConverter����һһ������canRead������canRead�����ֻص���supports��������
       canRead�������ж�Ŀ������������Ƿ�鵱ǰHttpMessageConverter����
       
       
        ������ǣ�������ж���һ����
        ����ǣ����ȷ������Ψһ��һ��HttpMessageConverter����Ȼ������6��������һƥ�������ȣ�
        �������һ�����Ҳ��������׳��쳣: HttpMediaTypeNotSupportedException
        
    f. SpringMVC����HttpMessageConverter��read������   StringHttpMessageConverter
        // ����clazz��Ҫ���صĶ�������ͣ�Ҳ����Ŀ�����������
        // ����inputMessage�з�װ���������������ͨ����inputMessage��ȡ�������еĲ�����Ϣ
        public final T read(Class<? extends T> clazz, HttpInputMessage inputMessage) throws IOException
        
    g. HttpMessageConverter��read����ִ����ϣ��ѷ��صĶ���ע���Ŀ�������
        ��ɣ�

    h. �Զ���HttpMessageConverter�� ��Ҫ�̳�AbstractHttpMessageConverter����ʵ����ط�����
       Ȼ����Ҫ��spring�����ļ��У������������:
       <mvc:message-converters register-defaults="true">
           <bean class="com.gao.g_httpmessageconverter.MyHttpMessageConverter">
               <property name="supportedMediaTypes">
                   <list>
                       <value>text/user</value>
                   </list>
               </property>
           </bean>
       </mvc:message-converters>
        ����register-defaults���ڸ���springmvc����Ƿ����Ĭ�ϵ�HttpMessageConverter������StringHttpMessageConverter��

    i. ���Բ鿴AnnotationDrivenBeanDefinitionParserԴ��������HttpMessageConveter�ĵײ�ԭ��

    j. ͨ���Ķ�AnnotationDrivenBeanDefinitionParserԴ��,���ǵ�֪,���register-defaults��ȡֵΪture���ҵ�ǰ��Ŀ��classpath����
            com.fasterxml.jackson.databind.ObjectMapper
            com.fasterxml.jackson.core.JsonGenerator
       ��������Ļ���springmvc�ͻ��Զ��������ڴ���json��ʽ��HttpMessageConverter�� ֻ��Ҫ����jackson-databind jar������

     k. �������ô�������:
        <mvc:annotation-driven>
            <mvc:message-converters register-defaults="true">
                <bean class="com.gao.g_httpmessageconverter.MyHttpMessageConverter">
                    <property name="supportedMediaTypes">
                        <list>
                            <value>text/user</value>
                        </list>
                    </property>
                </bean>
                <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
                    <property name="objectMapper">
                        <bean class="com.fasterxml.jackson.databind.ObjectMapper">
                            <property name="dateFormat">
                                <bean class="java.text.SimpleDateFormat">
                                    <constructor-arg type="java.lang.String" value="yyyy/MM/dd" />
                                </bean>
                            </property>
                            <!-- ָ��ʱ�� -->
                            <property name="timeZone" value="GMT+8" />
                        </bean>
                    </property>
                </bean>
            </mvc:message-converters>
        </mvc:annotation-driven>

============================================================================================================================

1. �����Ѿ�֪�����������ķ���ֵ��String��ʱ����ͼ����������������ֵ�����߼���ͼ��Ȼ���ٰ��߼���ͼ����Ϊ������ͼ��

2. �������ڿ������ķ��������@ResponseBody��ʱ����ͼ�������Ͳ�����������ˡ�Ҳ����˵��ʱ��û����ͼ��������ʲô�����ˡ�

3. �������ڿ������ķ��������@ResponseBody��ʱ��SpringMVC��ܻ��ȸ��ݿͻ�������ͷ�е� "����ֵ����"���ٸ��� "Accept��ֵ" ��Ѱ��һ������ʵ�HttpMessageConverter����!

	accept: "a/b": StringHttpMessageConverter
	
	supports: String.class = c  
	
	write, ����write�����е�������д��ʲô���ͻ���ͻ�����Ӧʲô
	

4. SpringMVC���������ʵ�HttpMessageConverter�����write����:
    public final void write(final T t, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException

    ��ɡ�

============================================================================================================================

ע��
    1.������ʹ����ĳһ��HttpMessageConverter�����read�����󣬾�һ����ʹ��ͬһ��HttpMessageConverter�����write������
    2.ע�Ȿ����Jackson-databind��ʹ�ã��Լ����е�ObjectMapper��ʹ�ã���Test��������ʾ��
package com.woniuxy.j_httpmessageconverter.a;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/*
 	����Http�������ɲ��֣��ص㣩
*/

// ��������
public class App {
	public static void main(String[] args) throws IOException, InterruptedException {
		// ����Socket�������ˣ�����ָ��������Ҫ�����Ķ˿�Ϊ8888������һ���ֻ������˸�����
		ServerSocket server = new ServerSocket(8888);
		System.out.println("�������Ѿ�����...");
		// ��Socket��������ȥ��ʼ����8888�˿�(�ֻ������ˣ����Ҵ��ڴ���״̬)
		// ��ʱ���̻�������ֻҪû�пͻ��������ӱ�����ˣ����̾Ͳ����������ִ�У����û���˸�����ֻ����ţ����ֻ�һֱ������
		
		// һ���пͻ������ӵ���ǰ�������������
		//	1.���̻��������ִ�У� 
		//	2. accept�������᷵��һ���׽��ִ��������ӵĿͻ���  (���з�װ�ſͻ��˵�ip��ַ)
		Socket client = server.accept(); 
		System.out.println("������Զ�����������ֺ�!");
		
		// ͨ��client�׽��֣���ȡ������, ������������㣺�ͻ��������    �յ㣺�������� ����Ͳ��
		InputStream in = client.getInputStream();
		
		// ��֤�ͻ�������������ݷ��꣬���ܼ�������ִ�У�
		while(in.available() == 0);
		
		while(in.available() > 0) {
			int n = in.read();
			System.out.print((char)n);
		}
		
		
		// �رձ������ӣ��ȼ��ڹҵ绰��
		client.close();
		// �رշ�����
		server.close();
	}
}

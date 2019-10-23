package com.woniuxy.j_httpmessageconverter.a;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/*
 	讲解Http请求的组成部分（重点）
*/

// 服务器端
public class App {
	public static void main(String[] args) throws IOException, InterruptedException {
		// 创建Socket服务器端，并且指定服务器要监听的端口为8888（买了一个手机，办了个卡）
		ServerSocket server = new ServerSocket(8888);
		System.out.println("服务器已经创建...");
		// 让Socket服务器，去开始监听8888端口(手机开机了，并且处于待机状态)
		// 此时流程会阻塞，只要没有客户端来连接本服务端，流程就不会继续向下执行（如果没有人给这个手机拨号，则手机一直待机）
		
		// 一旦有客户端连接到当前这个服务器，则：
		//	1.流程会继续向下执行； 
		//	2. accept方法还会返回一个套接字代表本次连接的客户端  (其中封装着客户端的ip地址)
		Socket client = server.accept(); 
		System.out.println("有朋自远方来，不亦乐乎!");
		
		// 通过client套接字，获取输入流, 该输入流的起点：客户端浏览器    终点：服务器端 （听筒）
		InputStream in = client.getInputStream();
		
		// 保证客户端浏览器把数据发完，才能继续向下执行！
		while(in.available() == 0);
		
		while(in.available() > 0) {
			int n = in.read();
			System.out.print((char)n);
		}
		
		
		// 关闭本次连接（等价于挂电话）
		client.close();
		// 关闭服务器
		server.close();
	}
}

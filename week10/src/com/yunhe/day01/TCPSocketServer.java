package com.yunhe.day01;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketServer {
	// 使用TCP进行对数据的接收
	public static void main(String[] args) throws IOException {
		Server(11110);
		// 创建服务socket对象
//		ServerSocket ss = new ServerSocket(11110);
//		// 使用SeverSocket对象获取 客户端对象
//		Socket accept = ss.accept();
//		//可以获取当前对象的地址   pc名字
//		String hostAddress = accept.getInetAddress().getHostAddress();
//		System.out.println(hostAddress);
//		// 获取输入流对象（打印在控制台上了）
//		InputStream is = accept.getInputStream();
//		// 封装成字符型输入流
//		InputStreamReader isr = new InputStreamReader(is);
//		// 创建字符型数组
//		char[] c = new char[1];
//		// 读取字符数组
//		int read =0;
//		while ((read=isr.read(c))!=-1) {
//			System.out.print(new String(c, 0, read));
//		}
//		
//		accept.close();
//		ss.close();
	}
	public static void Server(int port){
		ServerSocket ss;
		Socket accept;
		InputStream is;
		InputStreamReader isr;
		//while(true){
		try {
			ss = new ServerSocket(11110);
			accept = ss.accept();
			is = accept.getInputStream();
			isr = new InputStreamReader(is);
			String hostAddress = accept.getInetAddress().getHostAddress();
			System.out.println(hostAddress);
			char[] c = new char[1];
			int read=isr.read(c);

			while ((read)!=-1) {
				System.out.print(new String(c, 0, read));
			}
			
			accept.close();
			ss.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}
	//}

}

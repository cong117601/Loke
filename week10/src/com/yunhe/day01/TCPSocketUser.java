package com.yunhe.day01;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//tcp协议  发送
public class TCPSocketUser {

	public static void main(String[] args) throws UnknownHostException, IOException {
		user("172.16.5.157", 11110);
		// 创建连接
		// InetAddress byName = InetAddress.getLocalHost();
		// Socket s = new Socket(byName, 11110);
		// // 使用连接获取输出流
		// OutputStream os = s.getOutputStream();
		// Scanner sc = new Scanner(System.in);
		// byte[] b = new byte[1024];
		// os.write(sc.nextLine().getBytes());
		// // OutputStreamWriter osw = new OutputStreamWriter(os);
		// os.flush();
		// s.close();
	}

	public static void user(String url, int port) {
		Scanner sc = new Scanner(System.in);
		Socket s;
		
		try {
			System.out.println("客户请输入你想要打印的信息：");
			 s = new Socket(url, port);
			// 使用连接获取输出流
			OutputStream os = s.getOutputStream();
			os.write(sc.nextLine().getBytes());
			
		    s.close();
		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		}
		
	
}

package com.yunhe.day01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerFile {
	// 服务器接收客户数据
	public static void main(String[] args) throws IOException {
		// 创建文件对象
		File f = new File("D:/3.zip");
		if (f.exists()) {
			f.delete();
		} else {
			f.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(f);
		// 创建服务Socket对象
		ServerSocket ss = new ServerSocket(11000);
		// 使用Socket对象创建接收对象
		Socket s = ss.accept();
		// 使用接收对象 获取 输入流对象
		InputStream is = s.getInputStream();
		
		// 封装成字符型输入流
		// InputStreamReader isr = new InputStreamReader(is);
		// char[] c = new char[1];
		byte[] b = new byte[1024];
		// 读取字节数组
		int read = 0;
		// String string=null;
		while ((read = is.read(b)) != -1) {
			fos.write(b,0,read);//边读边写
		}
		//fos.write(read);
		fos.close();
		s.close();
		ss.close();

		// System.out.println(string);

	}

}

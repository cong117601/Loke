package com.yunhe.day01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPUserFile {
	// 客户端 上传指定文件
	public static void main(String[] args) throws UnknownHostException, IOException {
		// 创建文件类
		File f = new File("D:/1.zip");
		// 创建文件字节流对象
		// 使用文件读取，得到里面的数据，再用TCP服务 获取连接流对象 ，把读取的数据写入；
		FileInputStream fis = new FileInputStream(f);
		// 创建tcp服务
		//Socket s = new Socket(InetAddress.getLocalHost(), 11000);
		Socket s = new Socket(InetAddress.getByName("172.16.5.157"), 11000);
		// 使用连接获取文件输出流
		OutputStream os = s.getOutputStream();
		byte[] b = new byte[1024];
		int read = 0;
		while ((read = fis.read(b)) != -1) {
			os.write(b,0,read); //边读边写
		}
		//os.write(read);
		s.close();

	}

}

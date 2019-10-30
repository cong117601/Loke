package com.yunhe.day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketForService {
	// 使用Socket手写简单服务器(访问f:/1/1.txt)
	public static void main(String[] args) throws IOException {
		// 创建Socket服务对象
		ServerSocket ss = new ServerSocket(11111);
		// 接收客户 对象
		Socket s = ss.accept();
		// 获取客户端输入流对象 (输入的是地址：端口号)
		InputStream in = s.getInputStream();
		// 创建读取字节数组
		byte[] b = new byte[1024];
		// 只读取前1024字节的信息
		int read = in.read(b);
		// 把读取出的信息转换为字符串(读出的是7行 响应代码)
		String string = new String(b, 0, read);
		System.out.println(string);
		// 对string以空格进行截取
		String[] split = string.split(" ");
		System.out.println(split[1]);// /1/1.txt
		// 拼接访问路径
		String pathName = "f:" + split[1];
		// 进行读取文件内容
		// 创建文件读取字符流
		FileReader fr = new FileReader(pathName);
		// 创建带缓冲区的字符流
		BufferedReader br = new BufferedReader(fr);
		// 要按什么大小读取 这里使用按行读取的字符串变量
		String readLine = "";
		// 要把文件内容读取到 浏览器
		// 获取客户端输出流
		OutputStream os = s.getOutputStream();
		// 使用客户端的输出流创建打印流
		PrintStream ps = new PrintStream(os);
		StringBuffer sb = new StringBuffer();
		// 拼凑响应头信息
		sb.append("HTTP/1.1 200 OK\n");
		sb.append("Content-Type: text/html;charset=UTF-8\n");
		sb.append("\r\n");

		// 响应业务,
		os.write(sb.toString().getBytes());
		// 使用打印流进行读取
		while ((readLine = br.readLine()) != null) {
			ps.println(readLine);
			// System.out.println(readLine);
		}
		// // 使用客户端输入流写入信息
		// os.write("sadasd".getBytes());
		os.flush();
		s.close();
		ss.close();
	}

}

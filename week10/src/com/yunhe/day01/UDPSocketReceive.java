package com.yunhe.day01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSocketReceive {

	public static void main(String[] args) throws Exception {
		// 创建udp服务，指定端口号 用于接收发送方 发送的数据
		DatagramSocket d2 = new DatagramSocket(11111);
		// 接收数据
		while (true) {
			// 创建接收数据 字节数组
			byte[] bytes = new byte[1024];
			// 准备接收数据 数据包
			DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
			// 使用udp服务接收数据包
			d2.receive(dp);
			// 解析数据包
			String string = new String(bytes, 0, dp.getLength());
			if (string.equals("88")) {
				break;
			}
			System.out.println(dp.getAddress().getHostAddress());
			System.out.println(string);
			
		}
	d2.close();
	}

}

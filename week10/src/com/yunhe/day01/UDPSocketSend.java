package com.yunhe.day01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPSocketSend {

	public static void main(String[] args) throws Exception {
		// 创建udp服务
		DatagramSocket ds = new DatagramSocket();
		// 准备要发送的数据包 ，准备数据字节数组
		Scanner sc = new Scanner(System.in);
		while(true){
			String next = sc.next();
			byte[] bs = next.getBytes();
			if("见".equals(next)){
				break;
			}
			// 创建数据包对象
			// 1.数据字节数组 2.数据输出长度 3.接收方inetAdress 对象 4.接收方端口号
			
		 DatagramPacket datagramPacket = new DatagramPacket(bs,
		 bs.length,InetAddress.getByName("172.16.5.123"),11111);
			//DatagramPacket datagramPacket = new DatagramPacket(bs, bs.length, InetAddress.getLocalHost(), 11101);
			// 发送数据包
			ds.send(datagramPacket);
		}
			ds.close();
	}


}

package com.yunhe.day01;

import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class UDPSeedAndReceive {
	// 使用UDP 发送和接收
	public static void main(String[] args) throws IOException {
		// 创建udp 服务
		DatagramSocket GetDs = new DatagramSocket(11110);
		DatagramSocket SetDs = new DatagramSocket();
		// 创建保存 InetAddress对象的hashSet 集合
		HashSet<InetAddress> id = new HashSet<>();

		// 创建用来保存禁言的id的集合
		HashSet<InetAddress> idnot = new HashSet<>();
		// 获取要发送的数据
		Scanner sc = new Scanner(System.in);
		String next = sc.next();
		// 使用获取的数据创建字节型数组
		byte[] bytes = next.getBytes();
		// 创建数据包对象
		// 里面有获取数据的字节型数组，长度，ip地址和端口号
		DatagramPacket SetDp = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 11110);
		// 发送使用服务对象发送 数据包
		 
		// ds.close();

		// 接收方
		// 创建服务
		// 创建接收 数据的字节型数组
		byte[] b = new byte[1024];

		// 创建接收包对象
		DatagramPacket GetDp = new DatagramPacket(b, b.length);
		// 使用udp服务接收
		GetDs.receive(GetDp);
		// 把接收包对象的地址添加到集合
		id.add(GetDp.getAddress());
		// 解析数据包 增加输出时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String format = sdf.format(new Date());
		String hostAddress = GetDp.getAddress().getHostAddress();

		String string = new String(b, 0, GetDp.getLength());
		InetAddress inet = null;
		for (InetAddress inetAddress : id) {
			inet = inetAddress;
		}
		InetAddress notinet = null;
		for (InetAddress inetAddress : idnot) {
			notinet = inetAddress;
		}
		// 如果接受的字符中 出现 草 傻比 cnm 等字符时 把这个id 禁言
		if ("cao".equals(string) || "sb".equals(string) || "cnm".equals(string)) {
			System.out.println(format + "id为" + hostAddress + "的同学已被禁言");
			idnot.add(GetDp.getAddress());
		} else if (string.equals("再见")) {
			System.out.println(hostAddress + "同学已离开");
			id.remove(GetDp.getAddress());
		} else if (hostAddress.equals(inet.getHostAddress())&&hostAddress.equals(notinet.getHostAddress())) {
			System.out.println("欢迎" + hostAddress + "来到聊天室");

			System.out.println(format + "发送方" + hostAddress + ":" + string);

		}

	}

}

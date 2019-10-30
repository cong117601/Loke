package com.yunhe.day01;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class socketTest {
public static void main(String[] args) {
	String s="郑州市/@中原区$挖刘新成";
	String[] split = s.split("$|/@");
	System.out.println(split[0]+"     "+split[1]);
	String s1="172.16.5.123";
	String[] split2 = s1.split("\\.");
	for (String string : split2) {
		System.out.println(string);
	}
	String a="172.16.5.123:11111/FileTest/is.html";
	String[] split3 = a.split(" ");
	System.out.println(split3[1]);
}
}

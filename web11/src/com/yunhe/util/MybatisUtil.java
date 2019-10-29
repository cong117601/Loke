package com.yunhe.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory sqlSessionFactory = null;
	// 使用Resources流的形式加载mybatis配置文件
	static {
		InputStream is = null;
		String fileName = "Mybatis-config.xml";
		try {
			is = Resources.getResourceAsStream(fileName);
		} catch (IOException e) {
			System.err.println("加载配置文件" + fileName + "出错");
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}

	public static SqlSessionFactory getSessionFactory() {
		return sqlSessionFactory;

	}
}

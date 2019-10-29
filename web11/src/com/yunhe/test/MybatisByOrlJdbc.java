package com.yunhe.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yunhe.javabean.cTestStudent;
import com.yunhe.mapper.cTestStudentMapper;
import com.yunhe.util.MybatisUtil;

public class MybatisByOrlJdbc {
	SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
	SqlSession os = sessionFactory.openSession();
	cTestStudentMapper mapper = os.getMapper(cTestStudentMapper.class);
	@Test
public void Test(){
	
	SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
	SqlSession os = sessionFactory.openSession();
	cTestStudentMapper mapper = os.getMapper(cTestStudentMapper.class);
	ArrayList<cTestStudent> selectAll = mapper.selectAll();
	for (cTestStudent ctestStudent : selectAll) {
		System.out.println(ctestStudent);
	}
}
	
	@Test
	public void insertcTestStudent(){
		List<cTestStudent> list =new ArrayList<>();
		list.add(new cTestStudent(BigDecimal.valueOf((int)5),"369",BigDecimal.valueOf((int)22),"男"));
		list.add(new cTestStudent(BigDecimal.valueOf((int)6),"doinb",BigDecimal.valueOf((int)20),"女"));
		list.add(new cTestStudent(BigDecimal.valueOf((int)7),"clid",BigDecimal.valueOf((int)30),"男"));
		int insertcTestStudent = mapper.insertcTestStudent(list);
		System.out.println(insertcTestStudent);
		os.commit();
	}
	
	@Test
	public void deletecTestStudent(){
	List<BigDecimal> list =new ArrayList<>();
	list.add(new BigDecimal(2));
	//list.add(BigDecimal.valueOf((int)5));
	int deletecTestStudent = mapper.deletecTestStudent(list);
	System.out.println(deletecTestStudent);
	os.commit();
		
	}
	@Test
	public void updatecTestStudent(){
		
		cTestStudent c =new cTestStudent();
		c.setAGE(new BigDecimal(3));
		c.setSEX("不男不女");
		c.setID(new BigDecimal(7));
		int updatecTestStudent = mapper.updatecTestStudent(c);
		System.out.println(updatecTestStudent);
		os.commit();
	}
	
	
}

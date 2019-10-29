package com.yunhe.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.yunhe.javabean.cTestStudent;

public interface cTestStudentMapper {

	public ArrayList<cTestStudent> selectAll();

	public int insertcTestStudent(List<cTestStudent> list);

	public int deletecTestStudent(List<BigDecimal> list);

	public int updatecTestStudent(cTestStudent c);

	public int update(List<cTestStudent> list);
}

package com.chinasoft.service;

import java.io.IOException;
import java.util.List;

import com.chinasoft.pojo.Admin;
import com.chinasoft.pojo.Student;

/**
 * 服务层接口
 * @author liangdonglin
 *
 */
public interface StudentService {

	
	////由性别查看学生的数量
	int  countSexNumber(String sex);
	
	//查询所有的学生
	List<Student> findAllStudent();
	
	
	//人脸登录
	Student  face_login();
		
	//手机登录
	
}

package com.chinasoft.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.mapper.StudentMapper;
import com.chinasoft.pojo.Admin;
import com.chinasoft.pojo.Student;
import com.chinasoft.pojo.Teacher;
import com.chinasoft.pojo.Course;
import com.chinasoft.pojo.Select;
import com.chinasoft.service.StudentService;
/**
 * 服务层的实现类
 * @author liangdonglin
 *
 */
@Service
public class StudentServiceImpl implements StudentService {
	
	//把这个mapper对象自动注入spring容器
	@Autowired
	StudentMapper mapper;
	
	@Override
	public int countSexNumber(String sex) {
		int countSexNumber = mapper.countSexNumber(sex);
		return countSexNumber;
	}

	@Override
	public List<Student> findAllStudent() {
		return mapper.findAllStudent();
	}

	@Override
	public Student face_login() {
		// TODO Auto-generated method stub
		return null;
	}
	public void changeIcon(Student user) {
		// TODO Auto-generated method stub
		mapper.changeIcon(user);
	}

	

	public List<Admin> admin_login(Admin a) {
		// TODO Auto-generated method stub
		return mapper.admin_login(a);
	}

	

	public void deleteStudent(Student s) {
		// TODO Auto-generated method stub
		mapper.deleteStudent(s);
	}


	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		mapper.addStudent(s);
	}

	public List<Student> login(Student s) {
		// TODO Auto-generated method stub
		return mapper.login(s);
	}

	public List<Teacher> teacher_login(Teacher a) {
		// TODO Auto-generated method stub
		return mapper.teacher_login(a);
	}

	public void addTeacher(Teacher t) {
		// TODO Auto-generated method stub
		mapper.addTeacher(t);
	}

	

	public void change01(Student student) {
		
		// TODO Auto-generated method stub
		mapper.change01(student);
		
	}

	public Student findMyself(int parseInt) {
		// TODO Auto-generated method stub
		return mapper.findMyself();
	}

	public List<Course> findAllCourse(String t_id) {
		// TODO Auto-generated method stub
		return mapper.findAllCourse(t_id);
	}

	public void addCourse(Course c) {
		// TODO Auto-generated method stub
		mapper.addCourse(c);
	}

	public List<Course> studentfindAllCourse() {
		// TODO Auto-generated method stub
		return mapper.studentfindAllCourse();
	}

	public void deleteCourse(Course c1) {
		mapper.deleteCourse(c1);
		// TODO Auto-generated method stub
		
	}

	public List<Select> teacherfindAllSelect(Teacher t) {
		// TODO Auto-generated method stub
		return mapper.teacherfindAllSelect(t);
	}

	public void deleteSelect(Select s) {
		mapper.deleteSelect(s);
		// TODO Auto-generated method stub
		
	}

	public Course findCourseById(Course c) {
		// TODO Auto-generated method stub
		return mapper.findCourseById(c);
	}

	public List<Select> StudentfindCourse(Student s) {
		// TODO Auto-generated method stub
		return mapper.StudentfindCourse(s);
	}

	public void addSelect(Select s0) {
		mapper.addSelect(s0);
		// TODO Auto-generated method stub
		
	}

	public void updateScore(Select s) {
		mapper.updateScore(s);
		// TODO Auto-generated method stub
		
	}

	public void changeunipassword(Student student) {
		// TODO Auto-generated method stub
		mapper.changeunipassword(student);
	}

	

	
	


	

	
	

	

	

	

}

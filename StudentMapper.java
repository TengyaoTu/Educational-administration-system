package com.chinasoft.mapper;



import java.util.List;



import com.chinasoft.pojo.Admin;
import com.chinasoft.pojo.Student;
import com.chinasoft.pojo.Teacher;
import com.chinasoft.pojo.Course;
import com.chinasoft.pojo.Select;

/**
 * 接口设计
 * @author 
 *
 */
public interface StudentMapper {
	//添加学生
	//// 抽象方法  需要去实现这个方法  现在有mybatid的mapper代理对象帮我们去实现
	void addStudent(Student s);
	
	//查询所有的学生
	List<Student> findAllStudent();
	
	
	
	
	void get_sex();
	int countSexNumber(String sex);

	
	void deleteStudent(Student s);

	

	void changeIcon(Student user);

	List<Admin> admin_login(Admin a);

	List<Student> login(Student s);

	List<Teacher> teacher_login(Teacher a);

	void addTeacher(Teacher t);

	

	void change01(Student student);

	Student findMyself();

	

	List<Course> findAllCourse(String t_id);

	void addCourse(Course c);

	List<Course> studentfindAllCourse();

	void deleteCourse(Course c1);

	List<Select> teacherfindAllSelect(Teacher t);

	void deleteSelect(Select s);

	Course findCourseById(Course c);

	List<Select> StudentfindCourse(Student s);

	void addSelect(Select s0);

	void updateScore(Select s);

	void changeunipassword(Student student);

	
	

	

	

	

	

	
	
	
	
	
	
	
}
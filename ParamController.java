package com.chinasoft.controller.re_para;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chinasoft.pojo.Admin;
import com.chinasoft.pojo.Course;
import com.chinasoft.pojo.Select;
import com.chinasoft.pojo.Student;
import com.chinasoft.pojo.Teacher;
import com.chinasoft.service.impl.StudentServiceImpl;
@Controller
public class ParamController {
	@Autowired
	StudentServiceImpl  service;
	public  String uniaccount0;
	public  String unipassword0;
	public HttpSession session0;
	
   @RequestMapping("register")
   public String register(Student student) throws IOException{
       System.out.println("欢迎进入注册的方法");
       System.out.println(student.getId());
        addStudent(student);
        System.out.println("addStudent（）已经调用");
        return "login.html";
    }
   
   
   @RequestMapping("register_t")
   public String register_t(Teacher teacher) throws IOException{
       System.out.println("欢迎进入注册的方法");
       System.out.println(teacher.getT_id());
       addTeacher(teacher);
       System.out.println("addTeacher（）已经调用");
       return "login.html";
    }
   @RequestMapping("register_course")
   public String register_course(Course c,HttpSession session,Model model) throws IOException{
	   System.out.println("欢迎进入注册新课程方法");
       System.out.println(c.getT_id()+"正在注册新课程");
       System.out.println("测试session的id："+session.getId());
       String T_id=((Teacher) session.getAttribute("teacher")).getT_id();
       c.setT_id(T_id);
       addCourse(c);
       List<Course> c1=service.findAllCourse(T_id);
       session.setAttribute("findAllCourse",c1);
       session0=session;
       return "resources/templates/teacher/addcourse.html";
    }
   

   
   
   @RequestMapping("deleteCourse") 
   public String deleteCourse(String id)throws IOException{
	  
	System.out.println("测试session的id："+session0.getId());
   	System.out.println("调用到了这个函数！");
   	Course c1=new Course();
   	Select s=new Select();
   	s.setC_id(id);
   	c1.setC_id(id);
   	service.deleteCourse(c1);
   	service.deleteSelect(s);
   	String T_id=((Teacher) session0.getAttribute("teacher")).getT_id();
    session0.setAttribute("findAllCourse",service.findAllCourse(T_id));
    session0.setAttribute("teacherfindAllSelect",service.teacherfindAllSelect((Teacher) session0.getAttribute("teacher")));
   	System.out.println(id);
   	return "resources/templates/teacher/operate_success.html";
   }
   @RequestMapping("deleteSelect") 
   public String deleteSelect(String id,HttpSession session)throws IOException{
   	System.out.println("调用到了这个函数！");
   	
   	Select s=new Select();
   	s.setC_id(id);
   	service.deleteSelect(s);
   	//刷新操作
   	session0.setAttribute("sum_point", sum_point(findCourseBySelect(service.StudentfindCourse((Student)session0.getAttribute("student")))));
   	session0.setAttribute("studentfindCourse",findCourseBySelect(service.StudentfindCourse((Student)session0.getAttribute("student"))));
   	System.out.println(id);
   	return "resources/templates/teacher/operate_success.html";
   }
   public int sum_point(List<Course> c_get)
   {
	   int sum=0;
	   for(Course c:c_get)
	   {
		   sum=sum+Integer.parseInt(c.getC_point());
	   }
	   return sum;
   }
   

//修改密码
   @RequestMapping("change")
   @ResponseBody
   public void change(Student s)throws IOException
   {
	   System.out.println("欢迎进入change方法");
	   System.out.println(s);
	   
	   
	   service.change01(s);
	   session0.setAttribute("findAllStudent", service.findAllStudent());
	   System.out.println(s);
   }
   @RequestMapping("changeunipassword")
   @ResponseBody
   public void changeunipassword(Student s)throws IOException
   {
	   System.out.println("欢迎进入changeunipassword方法");
	   System.out.println(s);
	   Student student = (Student) session0.getAttribute("student");
	   student.setUnipassword(s.getUnipassword());
	   service.changeunipassword(student);
	   
	   
	   
	   
	   
   }
   

    /**
     * 
     * @param uniaccount
     * @param unipassword
     * @return  返回页面是
     * @throws IOException
     */
   public Course findCourseById(String id)
   {
	   System.out.println("id="+id);
	   Course c=new Course();
	   c.setC_id(id);
	   return service.findCourseById(c);
   }
   public List<Course> findCourseBySelect(List<Select> s)
   {
	   System.out.println("欢迎进入法");
	   List<Course> courses=new ArrayList<Course>();
	   for(Select t:s)
	   {
		   courses.add(findCourseById(t.getC_id()));
	   }
	   return courses;
   }
    @RequestMapping("login") 
    public String login_in(String uniaccount,String unipassword,String operator,HttpSession session) throws IOException {
    	System.out.println("欢迎进入登录的方法");
    	System.out.println(uniaccount);
    	System.out.println(unipassword);
    	System.out.println(operator);
    	if(operator.equals("student")) { 
    		if(login(uniaccount,unipassword).isEmpty()) {
    			
    			return "fail_login.html";
        	}
    		Student s=login(uniaccount,unipassword).get(0);
    		List<Course> c=service.studentfindAllCourse();
    		session.setAttribute("studentfindAllCourse",c);
    		session.setAttribute("student",s);
    		List<Select> c_byselect=service.StudentfindCourse(s);
    		List<Course> c_get=findCourseBySelect(c_byselect);
    		System.out.println(c_byselect);
    		System.out.println(111);
    		System.out.println(c_get);
    		int sum=sum_point(c_get);
    		session.setAttribute("sum_point", sum);
    		session.setAttribute("studentfindCourse",c_get);
    		session0=session;
        	uniaccount0=uniaccount;
        	unipassword0=unipassword;
        	System.out.println("登录成功");
        	return "navigation_s.html";
    		
    	}//学生登录操作
    		else if(operator.equals("admin")){ 
    		
    		if(admin_login(uniaccount,unipassword).isEmpty()) {
        	return "fail_login.html";
        	}
    		List<Student> s = service.findAllStudent();
    		session.setAttribute("findAllStudent",s);
    		System.out.println("赋值成功");
    		session0=session;//赋值成功
        	uniaccount0=uniaccount;
        	unipassword0=unipassword;
        	System.out.println("登录成功");
        	return "navigation_ad.html";
    		
    	}//管理员登录操作

    	
    	else {
    		if(teacher_login(uniaccount,unipassword).isEmpty()) {;
        	return "fail_login.html";
        	}
    		Teacher t=teacher_login(uniaccount,unipassword).get(0);
    		List<Course> c=service.findAllCourse(t.getT_id());
    		
    		
    		List<Select> s = service.teacherfindAllSelect(t);
    		
    		//List<Select> s0=null;
    		
    		//for(Course c0:c) {
    			//s0=service.teacherfindAllSelect(c0.getC_id());
    			//s.addAll(s0);
    		//}
    		System.out.println("测试session的id："+session.getId());
    		
    		session.setAttribute("teacher",t);
    		session.setAttribute("findAllCourse",c);
    		session.setAttribute("teacherfindAllSelect",s);
    		session0=session;
    
        	uniaccount0=uniaccount;
        	unipassword0=unipassword;
        	System.out.println("登录成功");
        	return "navigation_t.html";
    	}//教师登录操作
    }
   
    @RequestMapping("delete") 
    public String delete(Student s) throws IOException {
    	System.out.println("欢迎进入删除的方法");
    	System.out.println(s.getId());
    	deleteStudent(s.getId());
    	 
    	System.out.println("删除成功");
    	session0.setAttribute("findAllStudent", service.findAllStudent());
    	System.out.println("刷新完成");
    	
    	return "delete_suc.html";
    	
    }

    @RequestMapping("updateScore")
    @ResponseBody
    public String updateScore(String point,String s_id)throws IOException{
    	System.out.println("欢迎进入更新分数的方法");
    	Select s=new Select();
    	System.out.println(point);
    	System.out.println(s_id);
    	s.setS_point(point);
    	s.setS_id(s_id);
    	service.updateScore(s);
    	session0.setAttribute("teacherfindAllSelect",service.teacherfindAllSelect((Teacher)session0.getAttribute("teacher")));
		return null;
    }
    
    
    
    
    
    
    
    @RequestMapping("findAllStudent01")
    @ResponseBody
    public  List<Student> findAllStudent01() {
    	
		return service.findAllStudent();
	}
    
    public  List<Admin> admin_login(String uniaccount,String unipassword) throws IOException{
    	List<Admin> admins;
    	Admin a=new Admin();
    	a.setUniaccount(uniaccount);
    	a.setUnipassword(unipassword);
		admins=service.admin_login(a);
		if(admins.isEmpty())
		{
			System.out.println("查无此人");
		}
		for(Admin admin:admins) {
			System.out.println(admin);
		}
		
		return admins;
    }//管理员登录的控制器函数
    public  List<Teacher> teacher_login(String id,String password) throws IOException{
    	List<Teacher> teachers;
    	Teacher a=new Teacher();
    	a.setT_id(id);
    	a.setT_password(password);
		teachers=service.teacher_login(a);
		if(teachers.isEmpty())
		{
			System.out.println("查无此人");
		}
		for(Teacher teacher:teachers) {
			System.out.println(teacher);
		}
		
		return teachers;
    }//教师登录的控制器函数
    public  void deleteStudent(int id) throws IOException
   	{
   		Student s = new Student();
   		s.setId(id);
   		service.deleteStudent(s);
   		System.out.println(id);
   		
   	}//管理员专属功能，可以实现对学生库的删除
    
   
    /*
     * 
     * 
     * 在登录之后  将该用户的id存入到session中，
     * 突破，session 和cookie的区别 和简单使用
     * 
     * 
     * 
     */
  //添加学生功能
    public  void addCourse(Course c1) throws IOException
	{
		Course c=new Course(c1);
		service.addCourse(c);
		System.out.println(c);	
	}
    @RequestMapping("addSelect")
    
    public String addSelect(Select s)throws IOException{
    	System.out.println("进入addSelect方法");
    	Select s0=new Select(s);
    	System.out.println(Integer.toString(((Student)session0.getAttribute("student")).getId()));
    	String id_s=Integer.toString(((Student)session0.getAttribute("student")).getId());
    	s0.setS_id(id_s);
    	service.addSelect(s0);
    	
       	//刷新操作
		session0.setAttribute("sum_point", sum_point(findCourseBySelect(service.StudentfindCourse((Student)session0.getAttribute("student")))));
       	session0.setAttribute("studentfindCourse",findCourseBySelect(service.StudentfindCourse((Student)session0.getAttribute("student"))));
    	System.out.println(s0);
    	return "resources/templates/teacher/operate_success.html";
    	
    }
	public  void addStudent(Student s1) throws IOException
	{
		Student s = new Student(s1);
		service.addStudent(s);
		System.out.println(s);	
	}
	public  void addTeacher(Teacher t1) throws IOException
	{
		Teacher t = new Teacher(t1);
		service.addTeacher(t);
		System.out.println(t);	
	}
	
	
	public  List<Student> login(String uniaccount,String unipassword) throws IOException {
		Student s=new Student();
		s.setUniaccount(uniaccount);
		s.setUnipassword(unipassword);
		List<Student> students;
		students=service.login(s);
		if(students.isEmpty())
		{
			System.out.println("查无此人");
		}
		for(Student student:students) {
			System.out.println(student);
		}
		return students;
	}
	
	
	
	@RequestMapping("Count")
	@ResponseBody
	public  ArrayList<List<Integer>> Count() throws IOException
	{
//		统计男女和总人数  地区 专业 兴趣 生活费 爱好 防御方式
		List<Student> students=service.findAllStudent();
		List<Integer> sex=new ArrayList<>();
		int man=0,woman=0;
		List<Integer> interest=new ArrayList<>();
		int sportnum=0,reading=0,sing_dance=0,play=0,else_interest=0;
		List<Integer> colleges=new ArrayList<>();
		int electrical=0,mathematics=0,enviroment=0,energy=0,chemical=0,attorney=0,literature=0;
		List<Integer> living=new ArrayList<>();
		int lv_1=0,lv_2=0,lv_3=0,lv_4=0,lv_5=0;
		List<Integer> commute=new ArrayList<>();
		int train=0,plane=0,subway=0,car=0,bus=0,rail=0;
		List<Integer> area=new ArrayList<>();
		int hebei=0,liaoning=0,shanxi01=0,neimenggu=0,xizang=0;
		int shanghai=0,fujian=0,guangxi=0,guangdong=0,yunnan=0;
		int hunan=0,jilin=0,ningxia=0,jiangxi=0,sichuan=0,shanxi02=0;
		int chongqing=0,jiangsu=0,guizhou=0,beijing=0,xinjiang=0,zhejiang=0;
		int hainan=0,qinghai=0,shandong=0,gansu=0,henan=0,heilongjiang=0,tianjin=0,anhui=0;
		int hubei=0,taiwan=0,xianggang=0,aomen=0;
		List<Integer> graph=new ArrayList<>();
		for(Student student:students) {
			if(student.getSex().equals("男"))
			{
				man++;
			}
			else if(student.getSex().equals("女"))
			{
				woman++;
			}
			switch(student.getInterest())
			{
			case "体育运动":
				sportnum++;
				break;
				
			case "阅读学习":
				reading++;
				break;
			
			case "唱歌跳舞":
				sing_dance++;
				break;
				
			case "游山玩水":
				play++;
				break;
				
			case "其他":
				else_interest++;
				break;
			}
			switch(student.getColleges())
			{
			//'电气信息类', '数学物理类', '环境类', '工程能源类','生化类','法学新闻类','博雅类'
			case "电气信息类":
				electrical++;
				break;
			case "数学物理类":
				mathematics++;
				break;
			case "环境类":
				enviroment++;
				break;
			case "工程能源类":
				energy++;
				break;
			case "生化类":
				chemical++;
				break;
			case "法学新闻类":
				attorney++;
				break;
			case "博雅类":
				literature++;
				break;
			}
			switch(student.getLiving())
			{
			case 1:
				lv_1++;
				break;
			case 2:
				lv_2++;
				break;
			case 3:
				lv_3++;
				break;
			case 4:
				lv_4++;
				break;
			case 5:
				lv_5++;
				break;
			}
			switch(student.getCommute())
			{
			case "私家车":
				car++;
				break;
			case "火车":
				train++;
				break;
			case "地铁":
				subway++;
				break;
			case "公共汽车":
				bus++;
				break;
			case "飞机":
				plane++;
				break;
			case "高铁":
				rail++;
				break;
			}
			switch(student.getArea())
			{
			case "河北省":
				hebei++;
				break;
			case "辽宁省":
				liaoning++;
				break;
			case "山西省":
				shanxi01++;
				break;
			case "内蒙古自治区":
				neimenggu++;
				break;
			case "西藏自治区":
				xizang++;
				break;
			case "上海市":
				shanghai++;
				break;
			case "福建省":
				fujian++;
				break;
			case "广西壮族自治区":
				guangxi++;
				break;
			case "广东省":
				guangdong++;
				break;
			case "云南省":
				yunnan++;
				break;
			case "湖南省":
				hunan++;
				break;
			case "吉林省":
				jilin++;
				break;
			case "宁夏回族自治区":
				ningxia++;
				break;
			case "江西省":
				jiangxi++;
				break;
			case "四川省":
				sichuan++;
				break;
			case "陕西省":
				shanxi02++;
				break;
			case "重庆市":
				chongqing++;
				break;
			case "江苏省":
				jiangsu++;
				break;
			case "贵州省":
				guizhou++;
				break;
			case "北京市":
				beijing++;
				break;
			case "新疆维吾尔族自治区":
				xinjiang++;
				break;
			case "浙江省":
				zhejiang++;
				break;
			case "海南省":
				hainan++;
				break;
			case "青海省":
				qinghai++;
				break;
			case "山东省":
				shandong++;
				break;
			case "甘肃省":
				gansu++;
				break;
			case "河南省":
				henan++;
				break;
			case "黑龙江省":
				heilongjiang++;
				break;
			case "天津市":
				tianjin++;
				break;
			case "安徽省":
				anhui++;
				break;
			case "湖北省":
				hubei++;
				break;
			case "中国台湾":
				taiwan++;
				break;
			case "香港特别行政区":
				xianggang++;
				break;
			case "澳门特别行政区":
				aomen++;
				break;
			}	
		}
		area.add(hebei);//0
		area.add(liaoning);
		area.add(shanxi01);
		area.add(neimenggu);
		area.add(xizang);
		area.add(shanghai);
		area.add(fujian);
		area.add(guangxi);
		area.add(guangdong);
		area.add(yunnan);
		area.add(hunan);//10
		area.add(jilin);
		area.add(ningxia);
		area.add(jiangxi);
		area.add(sichuan);
		area.add(shanxi02);
		area.add(chongqing);
		area.add(jiangsu);
		area.add(guizhou);
		area.add(beijing);
		area.add(xinjiang);//20
		area.add(zhejiang);
		area.add(hainan);
		area.add(qinghai);
		area.add(shandong);
		area.add(gansu);
		area.add(henan);
		area.add(heilongjiang);
		area.add(tianjin);
		area.add(anhui);
		area.add(hubei);//30
		area.add(taiwan);
		area.add(xianggang);
		area.add(aomen);
		graph.add(beijing);
		graph.add(shanghai);
		graph.add(guangdong);
		graph.add(chongqing);
		graph.add(sichuan);
		graph.add(henan);
		graph.add(hebei);
		graph.add(gansu);
		graph.add(shanxi02);
		graph.add(jiangsu);
		graph.add(fujian);
		graph.add(yunnan);
		graph.add(guizhou);
		sex.add(man+woman);
		sex.add(man);
		sex.add(woman);
		interest.add(sportnum);
		interest.add(reading);
		interest.add(sing_dance);
		interest.add(play);
		interest.add(else_interest);
		colleges.add(electrical);
		colleges.add(mathematics);
		colleges.add(enviroment);
		colleges.add(energy);
		colleges.add(chemical);
		colleges.add(attorney);
		colleges.add(literature);
		living.add(lv_1);
		living.add(lv_2);
		living.add(lv_3);
		living.add(lv_4);
		living.add(lv_5);
		commute.add(bus);
		commute.add(train);
		commute.add(plane);
		commute.add(rail);
		commute.add(car);
		commute.add(subway);
		System.out.println("男生的人数有:"+man);
		System.out.println("女生的人数有:"+woman);
		ArrayList<List<Integer>> list=new ArrayList<>();
		list.add(sex);
		list.add(interest);
		list.add(colleges);
		list.add(living);
		list.add(commute);
		list.add(area);
		list.add(graph);
		System.out.println(list);
		return list;
		// TODO Auto-generated method stub
	}
	@RequestMapping("show_student")
	@ResponseBody
	public  ArrayList<Student> show_student() throws IOException{
		ArrayList<Student> students=new ArrayList<>();
		students=(ArrayList<Student>) login(uniaccount0,unipassword0);
		return students;
		
	}
	@PostMapping("/upload")  //上传头像
    public String upload(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {
        
        ArrayList<Student> students=new ArrayList<>();
		students=(ArrayList<Student>) login(uniaccount0,unipassword0);
        Student user=students.get(0);
        int begin = file.getOriginalFilename().indexOf(".");
        int last = file.getOriginalFilename().length();
        //获得文件后缀名: a
        String a = file.getOriginalFilename().substring(begin, last);
        String fileName=user.getId()+a;  //我存储的文件名是该用户的账号加文件后缀名，比如201521.jpg
        String filePath = "E:\\shixun_beifen_day19_origin\\src\\main\\webapp\\img\\";
        //这个是你的存储路径，为了方便，我用的是绝对路径，直接把文件放在项目的资源文件夹里
        System.out.println(file.getOriginalFilename());
        System.out.println(service);
        user.setIcon("./img/"+fileName);
        service.changeIcon(user);
        File dest = new File(filePath + fileName);
        try {
        	
            file.transferTo(dest); //存储！
            System.out.println("储存成功,路径在"+dest);
            
            //数据库存放的地址，存的是项目相对路径，这个看你们自己
             
            //userService.updateUserHeadImage(user1);
        } catch (IOException e) {
        }
        return "login.html";
    }
}

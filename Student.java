package com.chinasoft.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * 
 *
 */
public class Student implements Serializable{
	/**
	 * 
	 */
	public Student() {
		//无参构造
	}
	private static final long serialVersionUID = 1L;
	
	//name,sex,area,living,commute,nickname,interest,icon,classes,uniaccount,unipassword,colleges,timer,welcomed
	//封装实体类
	private  int id;
	private  String name;
	private  String sex;
	private  String area;
	private  int living;
	private String commute;
	private String nickname;
	private String interest;
	private String icon;
	private int classes;
	private String uniaccount;
	private String unipassword;
	private String colleges;
	private String timer;
	private String welcomed;
	private int point=0;//表示已经选择的学分
	/**
	 * @return the welcomed
	 */
	public Student(int id, String name, String sex, String area, int living, String commute, String nickname,
			String interest, String icon, int classes, String uniaccount, String unipassword, String colleges,
			String timer, String welcomed) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.area = area;
		this.living = living;
		this.commute = commute;
		this.nickname = nickname;
		this.interest = interest;
		this.icon = icon;
		this.classes = classes;
		this.uniaccount = uniaccount;
		this.unipassword = unipassword;
		this.colleges = colleges;
		this.timer = timer;
		this.welcomed = welcomed;
	}
	public Student(Student s) {
		// TODO Auto-generated constructor stub
		this.id = s.id;
		this.name =s.name;
		this.sex = s.sex;
		this.area =s.area;
		this.living = s.living;
		this.commute = s.commute;
		this.nickname = s.nickname;
		this.interest = s.interest;
		this.icon = s.icon;
		this.classes = s.classes;
		this.uniaccount = s.uniaccount;
		this.unipassword = s.unipassword;
		this.colleges = s.colleges;
		this.timer = s.timer;
		this.welcomed =s. welcomed;
	}
	public String getWelcomed() {
		return welcomed;
	}
	/**
	 * @param welcomed the welcomed to set
	 */
	public void setWelcomed(String welcomed) {
		this.welcomed = welcomed;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @return the living
	 */
	public int getLiving() {
		return living;
	}
	/**
	 * @param living the living to set
	 */
	public void setLiving(int living) {
		this.living = living;
	}
	/**
	 * @return the commute
	 */
	public String getCommute() {
		return commute;
	}
	/**
	 * @param commute the commute to set
	 */
	public void setCommute(String commute) {
		this.commute = commute;
	}
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @return the interest
	 */
	public String getInterest() {
		return interest;
	}
	/**
	 * @param interest the interest to set
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}
	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * @return the classes
	 */
	public int getClasses() {
		return classes;
	}
	/**
	 * @param classes the classes to set
	 */
	public void setClasses(int classes) {
		this.classes = classes;
	}
	/**
	 * @return the uniaccount
	 */
	public String getUniaccount() {
		return uniaccount;
	}
	/**
	 * @param uniaccount the uniaccount to set
	 */
	public void setUniaccount(String uniaccount) {
		this.uniaccount = uniaccount;
	}
	/**
	 * @return the unipassword
	 */
	public String getUnipassword() {
		return unipassword;
	}
	/**
	 * @param unipassword the unipassword to set
	 */
	public void setUnipassword(String unipassword) {
		this.unipassword = unipassword;
	}
	/**
	 * @return the colleges
	 */
	public String getColleges() {
		return colleges;
	}
	/**
	 * @param colleges the colleges to set
	 */
	public void setColleges(String colleges) {
		this.colleges = colleges;
	}
	/**
	 * @return the timer
	 */
	public String getTimer() {
		return timer;
	}
	/**
	 * @param timer the timer to set
	 */
	public void setTimer(String timer) {
		this.timer = timer;
	}
	
	
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", area=" + area + ", living=" + living
				+ ", commute=" + commute + ", nickname=" + nickname + ", interest=" + interest + ", icon=" + icon
				+ ", classes=" + classes + ", uniaccount=" + uniaccount + ", unipassword=" + unipassword + ", colleges="
				+ colleges + ", timer=" + timer + ", welcomed=" + welcomed + "]";
	}
//	public String get(String change) {
//		// TODO Auto-generated method stub
//		switch(change) {
//		case "name":
//			return this.getName();
//			
//		case "sex":
//			return this.getSex();
//		case "unipassword":
//			return this.getUnipassword();
//		case "colleges":
//			return this.getColleges();
//		case "class":
//			return this.getClasses().toString();
//		case "name":
//			return this.getName();
//		case "name":
//			return this.getName();
//			
//		}
	/**
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}
	/**
	 * @param point the point to set
	 */
	public void setPoint(int point) {
		this.point = point;
	}
		
			
		
	}
	
	



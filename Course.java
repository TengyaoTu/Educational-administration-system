package com.chinasoft.pojo;

public class Course {
	private String c_id;
	private String c_name;
	private String c_room;
	private String c_time;
	private String c_point;
	private String t_id;
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_room() {
		return c_room;
	}
	public void setC_room(String c_room) {
		this.c_room = c_room;
	}
	public String getC_time() {
		return c_time;
	}
	public void setC_time(String c_time) {
		this.c_time = c_time;
	}
	public String getC_point() {
		return c_point;
	}
	public void setC_point(String c_point) {
		this.c_point = c_point;
	}
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	@Override
	public String toString() {
		return "course [c_id=" + c_id + ", c_name=" + c_name + ", c_room=" + c_room + ", c_time=" + c_time
				+ ", c_point=" + c_point + ", t_id=" + t_id + "]";
	}
	public Course(String c_id, String c_name, String c_room, String c_time, String c_point, String t_id) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_room = c_room;
		this.c_time = c_time;
		this.c_point = c_point;
		this.t_id = t_id;
	}
	public Course() {
		
	}
	public Course(Course c1) {
		this.c_id = c1.c_id;
		this.c_name = c1.c_name;
		this.c_room =c1. c_room;
		this.c_time = c1.c_time;
		this.c_point = c1.c_point;
		this.t_id = c1.t_id;
		
		
	}

}

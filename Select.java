package com.chinasoft.pojo;

public class Select {
	private String s_id;
	private String c_id;
	private String s_point;
	private String t_id;
	public Select(String s_id, String c_id, String s_point, String t_id) {
		super();
		this.s_id = s_id;
		this.c_id = c_id;
		this.s_point = s_point;
		this.t_id = t_id;
	}
	public Select() {
		
	}
	public Select(Select s) {
		this.s_id = s.s_id;
		this.c_id = s.c_id;
		this.s_point = s.s_point;
		this.t_id = s.t_id;
		// TODO Auto-generated constructor stub
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getS_point() {
		return s_point;
	}
	public void setS_point(String s_point) {
		this.s_point = s_point;
	}
	
	/**
	 * @return the t_id
	 */
	public String getT_id() {
		return t_id;
	}
	/**
	 * @param t_id the t_id to set
	 */
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	
	@Override
	public String toString() {
		return "Select [s_id=" + s_id + ", c_id=" + c_id + ", s_point=" + s_point + ", t_id=" + t_id + "]";
	}
	

}

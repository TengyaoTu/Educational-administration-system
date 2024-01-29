package com.chinasoft.pojo;

import java.io.Serializable;

public class Admin implements Serializable{
	private String name;
	
	private String uniaccount;
	private String unipassword;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUniaccount() {
		return uniaccount;
	}
	public void setUniaccount(String uniaccount) {
		this.uniaccount = uniaccount;
	}
	public String getUnipassword() {
		return unipassword;
	}
	public void setUnipassword(String unipassword) {
		this.unipassword = unipassword;
	}
	public Admin(String name, String uniaccount, String unipassword) {
		super();
		this.name = name;
		this.uniaccount = uniaccount;
		this.unipassword = unipassword;
	}
	public Admin() {
	}
	@Override
	public String toString() {
		return "Admin [name=" + name + ", uniaccount=" + uniaccount + ", unipassword=" + unipassword + "]";
	}

}

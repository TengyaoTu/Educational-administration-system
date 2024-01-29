package com.chinasoft.pojo;

import java.io.Serializable;

public class Teacher implements Serializable {
    private String t_id;//教师学工号
    private String t_name;//教师姓名
    private String t_password;//教师密码
    private String t_sex;//教师性别
    private String t_major;//教师所属专业

    public Teacher(){}

    public Teacher(String t_id, String t_name, String t_password, String t_sex, String t_major) {
        this.t_id = t_id;
        this.t_name = t_name;
        this.t_password = t_password;
        this.t_sex = t_sex;
        this.t_major = t_major;
    }
    public Teacher(Teacher t1) {
        this.t_id =t1.t_id;
        this.t_name =t1. t_name;
        this.t_password = t1.t_password;
        this.t_sex = t1.t_sex;
        this.t_major =t1.t_major;
    }
    

    

	public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_password() {
        return t_password;
    }

    public void setT_password(String t_password) {
        this.t_password = t_password;
    }

    public String getT_sex() {
        return t_sex;
    }

    public void setT_sex(String t_sex) {
        this.t_sex = t_sex;
    }

    public String getT_major() {
        return t_major;
    }

    public void setT_major(String t_major) {
        this.t_major = t_major;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "t_id='" + t_id + '\'' +
                ", t_name='" + t_name + '\'' +
                ", t_password='" + t_password + '\'' +
                ", t_sex='" + t_sex + '\'' +
                ", t_major='" + t_major + '\'' +
                '}';
    }
   
}
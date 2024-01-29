package com.chinasoft.controller;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasoft.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService service;
	
	//@RequestMapping("sexCount")
	//@ResponseBody
	public ArrayList<Integer> countSexNum(Model model) {
		int men = service.countSexNumber("男");
		int women = service.countSexNumber("女");
		ArrayList<Integer> list = new ArrayList<>();
		list.add(men);
		list.add(women);
		return list;
		
	}
}

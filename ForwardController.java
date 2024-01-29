package com.chinasoft.controller.forword_data;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("forward")
public class ForwardController {

	@RequestMapping("method01")
	public  String method01( Model model) {
		System.out.println("欢迎进入转发的第一种方式！");
		model.addAttribute("name", "admin2022");
		return "../index.jsp";
	}
	
	@RequestMapping("method02")
	public  ModelAndView method01( ) {
		System.out.println("欢迎进入转发的第二种方式！");
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "admin2023");
		mav.setViewName("../index.jsp");
		return mav;
	}
}

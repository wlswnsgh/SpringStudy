package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnController1 {
	
	// ModelAndView: 뷰에 데이터를 전달하는 객체. 뷰이름과 데이터를 담을 수 있음
	@GetMapping("/return/ex1")
	public ModelAndView ex1() {
		
		ModelAndView modelAndView = new ModelAndView("return/sample")
											.addObject("data","banana");
		
		return modelAndView;
	}
	
	// Model: 뷰에 데이터를 보내는 객체, 데이터를 담을 수 있음
	@GetMapping("/return/ex2")
	public String ex2(Model model) {
		
		model.addAttribute("data", "banana"); // data는 "banana"를 뜻한다.
		
		return "return/sample"; // 뷰이름
	}
	
	// 리턴타임 String: html 파일 경로를 직접 지정
	// 리턴타입 void: url 주소가 자동으로 파일의 경로가 됨
	
	@GetMapping("/return/sample")
	public void ex3(Model model) {
		
		model.addAttribute("data", "banana");
	}
	
	
	
}

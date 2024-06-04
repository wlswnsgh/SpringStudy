package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReturnQuiz2 {

	@GetMapping("/return/q21")
	public void q1(Model model) {
		model.addAttribute("q21", "두번째퀴즈입니다.");
	}
	
}

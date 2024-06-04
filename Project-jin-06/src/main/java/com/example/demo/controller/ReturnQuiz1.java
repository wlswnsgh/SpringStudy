package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReturnQuiz1 {
	
	@GetMapping("/return/q1")
	public void q1(Model model) {
		model.addAttribute("q1", "첫번째퀴즈입니다.");
	}
	
}

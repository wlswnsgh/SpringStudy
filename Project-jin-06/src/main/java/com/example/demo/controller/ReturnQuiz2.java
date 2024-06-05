package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/return")
public class ReturnQuiz2 {

	@GetMapping("/test")
	public void q1(Model model) {
		model.addAttribute("q2", "두번째퀴즈입니다.");
	}

}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.ControllerRepository;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	ControllerRepository Qcon = new ControllerRepository();
	
	@GetMapping("/QController")
	public String method1() {
		return "/quiz/QController";
	}
	
	@PostMapping("/QuizController")
	public String method2(@RequestParam(name = "name") String name, @RequestParam(name = "age")int age, @RequestParam(name = "address")String address, Model list) {
		
		QController Q = new QController(name, age, address);
		Qcon.save(Q);
		
		list.addAttribute("Q", Q);
		return "/quiz/QController";
	}
	
	
}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/method")
public class Quiz1 {
	
	@ResponseBody
	@GetMapping("/q")
	public String q1() {
		System.out.println("q1이 정상처리되었습니다.");
		return "q1";
	}
	
	@ResponseBody
	@PostMapping("/q")
	public String q2() {
		System.out.println("q2이 정상처리되었습니다.");
		return "q2";
	}
	
	@ResponseBody
	@PutMapping("/q")
	public String q3() {
		System.out.println("q3이 정상처리되었습니다.");
		return "q3";
	}
	
	@ResponseBody
	@DeleteMapping("/q")
	public String q4() {
		System.out.println("q4이 정상처리되었습니다.");
		return "q4";
	}	
}
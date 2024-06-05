package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping("/return3")
public class ReturnController3 {
	
	 // @ResponseBody가 자동으로 적용됨
	@GetMapping("/ex1")
	public String ex1() {
		return "Hi~";
	}
	
	
	
}

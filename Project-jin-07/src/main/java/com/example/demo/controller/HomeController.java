package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	// localhost:8080/
	@GetMapping("/")
	public String main() {
		return "/home/main";
	}
	
}

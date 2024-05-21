package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/hello") // @GetMapping("상세주소"): 상세주소를 추가해줄 수 있다. 
	public String hello() {
		return "안녕하세요!";
	}
	
	
}
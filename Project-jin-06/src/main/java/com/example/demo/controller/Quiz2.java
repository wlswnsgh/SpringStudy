package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CarDTO;
import com.example.demo.dto.Quiz2_1;
import com.example.demo.dto.StudentDTO;


@Controller
@RequestMapping("/param")
public class Quiz2 {

	@ResponseBody
	@GetMapping("/q1")
	public String q1(@RequestParam(name = "str")String str) {
		System.out.println("String타입 파라미터 수집: " + str);
		return "ok";
	}
	
	@ResponseBody
	@GetMapping("/q2")
	public String q2(Quiz2_1 str) {
		System.out.println("float타입 파라미터 수집: " + str.getFl()
						+ " boolean타입 파라미터 수집: " + str.isBo());
		return "ok";
	}
	
	@ResponseBody
	@GetMapping("/q3")
	public String q3(@RequestParam(name = "i") char[] i) {
		System.out.println("char형 배열 수집: " + Arrays.toString(i));
		
		for(Character j : i) {
			System.out.println(j);
		}
		
		System.out.println("배열의 개수: " + i.length);
		return "ok";
	}
	
	@ResponseBody
	@PostMapping("/q4")
	public String q4(@RequestBody StudentDTO q4) {
		System.out.println("객체 수집: " + q4);
		return "ok";
	}
	
	@ResponseBody
	@PostMapping("/q5")
	public String q5(@RequestBody ArrayList<StudentDTO> q5) {
		System.out.println("객체 수집: " + q5);
		
		for(StudentDTO j : q5) {
			System.out.println(j);
		}
		
		System.out.println("리스트의 개수: "+q5.size());
		
		return "ok";
	}
	
	@ResponseBody
	@PostMapping("/q6")
	public String q6(@RequestBody CarDTO[] q6) {
		System.out.println("객체 수집: " + Arrays.toString(q6));
		
		for(CarDTO j : q6) {
			System.out.println(j);
		}
		
		System.out.println();
		
		int lastIndex = q6.length - 1;
		CarDTO lastElement = q6[lastIndex];
		System.out.println("리스트 마지막 요소: " + lastElement);
		
		return "ok";
	}
	
}

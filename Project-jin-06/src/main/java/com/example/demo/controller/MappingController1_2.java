package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.service.annotation.PutExchange;

// 브라우저(클) -> dis -> handler -> dis -> con -> vi -> 브라우저
// 중복되는 부분을 중간경로로 적용
@RequestMapping("/board")
@Controller
public class MappingController1_2 {
	
	// GET + localhost:8080/board
	@ResponseBody
	@GetMapping
	public String list() {
		System.out.println("게시물 조회");
		return "ok";
	}
	
	// POST + localhost:8080/board
	@ResponseBody
	@PostMapping
	public String save() {
		System.out.println("게시물 등록");
		return "ok";
	}
	
	// Put + localhost:8080/board
	@ResponseBody
	@PutExchange
	public String modify() {
		System.out.println("게시물 수정..");
		return "ok";
	}
	
	// Delete + localhost:8080/board
	@ResponseBody
	@DeleteMapping
	public String remove() {
		System.out.println("게시물 삭제");
		return "ok";
	}
	
	
}
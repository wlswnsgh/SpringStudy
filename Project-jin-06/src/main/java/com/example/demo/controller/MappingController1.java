//package com.example.demo.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.service.annotation.PutExchange;
//
//@Controller // 컨트롤러로 지정 + 빈 생성해서 담기
//public class MappingController1 {
//	
//	//HTML문서 없이 메세지 바디에 데이터를 직접 담는 기능
//	@ResponseBody
//	
//	// Get + localhost:8080/board
//	// @RequestMapping(value = "/board", method = RequestMethod.GET)
//	@GetMapping("/board") // 의미가 위와 같음 차이는 버전 차이임	
//	public String list() {
//		System.out.println("게시물 조회");
//		return "ok";
//	}
//	
//	// POST + localhost:8080/board
//	@ResponseBody
//	@PostMapping("/board")
//	public String save() {
//		System.out.println("게시물 등록");
//		return "ok";
//	}
//	
//	// Put + localhost:8080/board
//	@ResponseBody
//	@PutExchange("/board")
//	public String modify() {
//		System.out.println("게시물 수정..");
//		return "ok";
//	}
//	
//	// Delete + localhost:8080/board
//	@ResponseBody
//	@DeleteMapping("/board")
//	public String remove() {
//		System.out.println("게시물 삭제");
//		return "ok";
//	}
//	
//	
//}
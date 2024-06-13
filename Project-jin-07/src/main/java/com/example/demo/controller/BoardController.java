package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	// 메인화면을 반환하는 메소드
	@GetMapping("/main")
	public void main() {
	
	}
	
	// 목록화면
	// @GetMapping("/list")
	// public void list(Model model) {
		
		// 서비스를 상요해서 게시물 목록 조회
		// List<BoardDTO> list = service.getList();
		
		// 화면에 게시물 목록 전달
		// model.addAttribute("list", list);
		
		
	// }
	
	// 목록화면
	@GetMapping("/list")
	public void list(@RequestParam(defaultValue = "0", name = "page")int page, Model model) {
		
		Page<BoardDTO> list = service.getList(page);
		
		model.addAttribute("list",list);
		
		System.out.println("전체 페이지 수: " + list.getTotalPages());
		System.out.println("전체 게시물 수: " + list.getTotalElements());
		System.out.println("현재 페이지 번호: " + (list.getNumber() + 1));
		System.out.println("페이지에 표시할 게시물 수: " + list.getNumberOfElements());
		
	}
	
	// 등록화면을 반환하는 메소드
	@GetMapping("/register")
	public void register() {
		
	}
	
	// 1.dto: 폼에서 전달받은 게시물정보
	// 2.RedirectAttributes: 다른 주소로 리다이렉트할때 화면에 데이터를 전달하는 객체
	// 등록을 처리하는 메소드
	@PostMapping("/register")
	public String registerPost(BoardDTO dto
								, RedirectAttributes redirectAttributes) {
		
		// 게시물 등록하고 새로운 게시물 번호 반환
		int no = service.register(dto);
		
		// 리다이렉트된 페이지(목록화면)에 새로운 게시물 번호 전달
		redirectAttributes.addFlashAttribute("msg", no);
		
		// 게시물 목록 화면으로 리다이렉트 하기
		// 리다이렉트? 새로운 URL을 다시 호출하는 것
		return "redirect:/board/list"; // HTML파일X URL주소O
	}
	
	// localhost:8080?no = 1
	@GetMapping("/read")
	public void read(@RequestParam(name = "no")int no, Model model) {		
		BoardDTO dto = service.read(no);
		model.addAttribute("dto", dto);
	}
	
	// 주소: localhost:8080/board/modify?no=1
	// 수정화면을 반환하는 메소드
	@GetMapping("/modify")
	public void modify(@RequestParam(name = "no") int no, Model model) {
		
		BoardDTO dto = service.read(no);
		model.addAttribute("dto",dto); // 화면에 특정 게시물 정보를 전달
	}
	
	// 수정처리 메소드
	@PostMapping("/modify")
	public String modifyPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
		
		service.modify(dto); // 게시물 수정
		
		// addFlashAttribute(): 리다이렉트할 화면에 데이터를 보내는 함수
		// addAttribute(): 리다이렉트 주소에 파라미터를 추가하는 함수(/board/read?no=1)
		redirectAttributes.addAttribute("no",dto.getNo());
		
		// 상세화면으로 이동
		return "redirect:/board/read";
	}
	
	// 삭제처리
	@PostMapping("/remove")
	public String removePost(@RequestParam(name = "no") int no) {
		service.remove(no);
		return "redirect:/board/list";
	}
	
}
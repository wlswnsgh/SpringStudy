package com.example.demo.controller;

import java.security.Principal;

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
							  ,RedirectAttributes redirectAttributes
							  ,Principal principal) {
		
		// 인증 객체에서 아이디를 꺼내서, 게시물의 작성자로 입력
		String id = principal.getName(); // id를 꺼낸다.
		dto.setWriter(id); // id를 저장한다.
		int no = service.register(dto); 
		redirectAttributes.addFlashAttribute("msg", no);
		
		return "redirect:/board/list";
		
	}
	
	// localhost:8080?no = 1
	@GetMapping("/read")
	public void read(@RequestParam(name = "no")int no,
					 @RequestParam(defaultValue = "0", name = "page")int page,
					 Model model) {		
		BoardDTO dto = service.read(no);
		model.addAttribute("dto", dto);
		
		model.addAttribute("page", page); // 화면에 페이지 번호 전달
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
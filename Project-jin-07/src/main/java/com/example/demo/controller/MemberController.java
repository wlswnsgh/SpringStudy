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

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	// /member/list?page=1 OK
	// /member/list OK
	@GetMapping("/list")
	public void list(@RequestParam(defaultValue = "0", name = "page")int page, Model model) {
		
		Page<MemberDTO> list = service.getList(page);
		model.addAttribute("list",list);
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register") // dto: 파라미터, redirectAttributes: 모델 객체
	public String registerPost(MemberDTO dto, RedirectAttributes redirectAttributes) {
		
		boolean isSuccess = service.register(dto);
		
		if(isSuccess) {
			return "redirect:/member/list"; // 성공시 목록화면으로 이동
		} else {
			redirectAttributes.addFlashAttribute("msg", "아이디가 중복되어 등록에 실패하였습니다.");
			return "redirect:/member/register"; // 실패시 회원가입폼으로 이동
		}
	
		
	}
	
	// /member/read?id=user1&page=1
	// 상세화면을 반환하는 메소드
	@GetMapping("/read")
	public void read(@RequestParam(name = "id") String id,
					 @RequestParam(name = "page", defaultValue = "0")int page,
					 Model model) {
		
		MemberDTO dto = service.read(id);
		model.addAttribute("dto", dto); // 사용자 정보
		model.addAttribute("page", page); // 사용자 정보
	}
	
}

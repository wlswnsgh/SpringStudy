package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.PersonDTO;
import com.example.demo.dto.SampleDTO;

@Controller
@RequestMapping("/quiz")
public class Quiz {
	
	@GetMapping("/q1")
	public void q1(Model model) {
		model.addAttribute("msg1", "둘리");
		model.addAttribute("msg2", "20");
		model.addAttribute("msg3", "인천 구월동");
	}
	
	@GetMapping("/q2")
	public void q2(Model model) {
		model.addAttribute("msg1", "스프링부트웹프로젝트");
		model.addAttribute("msg2", "구멍가게 코딩단");
		model.addAttribute("msg3", "2022-12-25");
	}
	
	@GetMapping("/q3")
	public void q3(Model model) {
		PersonDTO perspn = new PersonDTO("둘리", 20, "인천 구월동");
		model.addAttribute("lt", perspn);
	}
	
	@GetMapping("/q4")
	public void q4(Model model) {
//		List<BookDTO> book = new BookDTO("스프링부트웹프로젝트", "구멍가게코딩단",LocalDate.now());
	}
	
	@GetMapping("/q5")
	public void q5(Model model) {
		
		ArrayList<Integer> i = new ArrayList<>();
		i.add(1);
		i.add(2);
		i.add(3);
		i.add(4);
		i.add(5);
		i.add(6);
		i.add(7);
		i.add(8);
		i.add(9);
		i.add(10);
		
		model.addAttribute("i", i);
	}
	
	@GetMapping("/q6")
	public void q6(Model model) {
		model.addAttribute("msg1", "이름");
		model.addAttribute("msg2", "나이");
		model.addAttribute("msg3", "주소");
		
		model.addAttribute("msg4", "둘리");
		model.addAttribute("msg5", "또치");
		model.addAttribute("msg6", "도우너");
		
		model.addAttribute("msg7", "20");
		model.addAttribute("msg8", "30");
		model.addAttribute("msg9", "40");
		
		model.addAttribute("msg10", "인천 구월동");
		model.addAttribute("msg11", "서울 신림동");
		model.addAttribute("msg12", "부산 문래동");
	}
	
	@GetMapping("/q7")
	public void q7(Model model) {
		
		List<SampleDTO> list = new ArrayList();
    	for(int i=1; i<=20;i++) {
    		list.add(new SampleDTO(i, i+"번", LocalDate.now()));
    	}
    	model.addAttribute("list", list);
		
	}
	
	@GetMapping("/q8")
	public void q8(Model model) {
		List<PersonDTO> list = new ArrayList<>();
		
		list.add(new PersonDTO("박하나", 25, "인천 구월동"));
		list.add(new PersonDTO("홍재범", 17, "서울 신림동"));
		list.add(new PersonDTO("문유리", 31, "부산 문래동"));
		list.add(new PersonDTO("김재민", 8, "인천 연수동"));
		list.add(new PersonDTO("장유라", 33, "부산 문래동"));
		
		model.addAttribute("list",list);
		
	}
	
	@GetMapping("/q9")
	public void q9(Model model) {
		List<PersonDTO> list = new ArrayList<>();
		
		list.add(new PersonDTO("박하나", 25, "인천 구월동"));
		list.add(new PersonDTO("홍재범", 17, "서울 신림동"));
		list.add(new PersonDTO("문유리", 31, "부산 문래동"));
		list.add(new PersonDTO("김재민", 8, "인천 연수동"));
		list.add(new PersonDTO("장유라", 33, "부산 문래동"));
		
		model.addAttribute("list",list);
		
	}
	
}
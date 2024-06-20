package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.dto.MemberDTO;

@SpringBootTest
public class MemberServiceTest {
	
	@Autowired
	MemberService service;
	
	@Test
	public void 회원등록() {
		MemberDTO dto = MemberDTO.builder()
				.id("1")
				.password("gh123")
				.name("gh")
				.build();
		boolean isSuccess = service.register(dto);
		
		if(isSuccess) {
			System.out.println("회원이 등록되었습니다.");
		}else {
			System.out.println("중복된 회원 입니다.");
		}
	}
	
	@Test
	public void 회원목록조회() {
		
		Page<MemberDTO> page = service.getList(1);
		
		List<MemberDTO> list = page.getContent();
		
		System.out.println(list);
		
	}
	
	@Test
	public void 회원단건조회() {
		MemberDTO dto = service.read("1");
		System.out.println(dto);
	}
	
}

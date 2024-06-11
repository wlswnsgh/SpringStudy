package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.BoardDTO;

@SpringBootTest
public class BoardServiceTest {
	
	@Autowired
	BoardService service;
	
	@Test
	public void 게시물등록() {
		
		BoardDTO dto = BoardDTO.builder()
							   .title("2번글")
							   .content("내용입니다")
							   .writer("또치")
							   .build();
		
		int no = service.register(dto);
		
		System.out.println("새로운 게시물 번호: " + no);
		
	}
	
	@Test
	public void 게시물목록조회() {
		for(BoardDTO lt : service.getList()) {
			System.out.println(lt.toString());
		}
	}
	
	
	
}

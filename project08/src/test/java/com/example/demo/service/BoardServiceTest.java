package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.dto.BoardDTO;

@SpringBootTest
public class BoardServiceTest {

	@Autowired
	BoardService service;

	@Test
	public void 게시물등록() {
		// 회원 객체 생성
		BoardDTO dto = BoardDTO.builder().title("1번글").content("내용입니다").writer("user1").build();
		service.register(dto);
	}

	@Test
	public void 게시물조회() {
		BoardDTO dto = service.read(1);
		System.out.println(dto);
	}

	@Test
	public void 게시물목록조회() {
		Page<BoardDTO> page = service.getList(1); //첫번째 페이지 조회
		List<BoardDTO> list = page.getContent(); //게시물 목록 꺼내기
		for(BoardDTO dto : list) {
			System.out.println(dto);
		}
	}

}

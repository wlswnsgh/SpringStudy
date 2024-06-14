package com.example.demo.service;

import java.util.List;

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
		
		BoardDTO dto = BoardDTO.builder()
							   .title("2번글")
							   .content("내용입니다")
							   .writer("또치")
							   .build();
		
		int no = service.register(dto);
		
		System.out.println("새로운 게시물 번호: " + no);
			
	}
	
//	@Test
//	public void 게시물목록조회() {
//		for(BoardDTO lt : service.getList()) {
//			System.out.println(lt.toString());
//		}
//	}
	
	@Test
	public void 게시물목록조회() {
		Page<BoardDTO> page = service.getList(2);
		
		List<BoardDTO> list = page.getContent();
		
		for(BoardDTO lt : list) {
			System.out.println(lt);
		}
	}
	
	
	
	@Test
	public void 게시물단건조회() {
		BoardDTO list = service.read(5);
		System.out.println(list);
	}
	
	@Test
	public void 게시물수정() {
		BoardDTO result = service.read(3);
		result.setContent("내용이 수정되었습니다.");
		service.modify(result);
	}
	
	@Test
	public void 게시물삭제() {
		BoardDTO result = service.read(14);
	    service.remove(result.getNo());
	}
	
}

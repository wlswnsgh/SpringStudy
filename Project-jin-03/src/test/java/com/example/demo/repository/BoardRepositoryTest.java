package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.board;

// 등록 -> 조회 -> 수정 -> 삭제

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	BoardRepository boardRepository;
	
	@Test
	public void 리피지토리객체를가져왔는지확인() {
		System.out.println("boardRepository = " + boardRepository);
	}
	
	@Test
	public void 데이터등록() {
		
		// 등록일과 수정일은 빈값 입력 가능
		board board1 = new board(0, "1번글", "내용입니다", null, null);
		boardRepository.save(board1);
		
		// 생성자는 빈값이라도 입력을 해야하지만, build는 값을 생략할 수 있음.
		board board2 = board.builder()
							.title("2번글")
							.content("내용입니다")
							.build();
		
		boardRepository.save(board2);
	}
	
	@Test
	public void 데이터단건조회() {
		
		// 조회결과를 optional로 반환
		Optional<board> result = boardRepository.findById(1); // .findById()의 ID는 진짜 아이디가 아닌 PK이다.
		
		// 값이 있는지 확인하고 꺼내기
//		if(result.isPresent()) {
//			
//			board board = result.get();
//			System.out.println(board);
//		}
		
	}
	
	@Test
	public void 데이터전체조회or목록조회() {
		
		List<board> list = boardRepository.findAll();
		
		for(board board : list) {
			System.out.println(board);
		}
		
	}
	
	@Test
	public void 데이터수정() {
		
		// 옳은 수정 방법
		// 게시물 조회하고 값을 일부 변경한 후에 수정하기
//		Optional<board> result = boardRepository.findById(1);
//		board board = result.get();
//		board.setContent("내용이수정되었습니다~");
//		boardRepository.save(board);
		
		// 잘못된 수정 방법
		// 게시물을 생성해서 수정하기
		board board1 = new board(1, "1번글", "글이수정되었습니다", null, null);
		boardRepository.save(board1);
		
	}
	
	@Test
	public void 데이터삭제() {
		boardRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		boardRepository.deleteAll();
	}
	
}

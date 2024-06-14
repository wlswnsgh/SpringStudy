package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

public interface BoardService {
	
	// 추상메소드의 목적: 자식 클래스들이 각자 구현해서 사용하는 기능
	// 일반메소드의 목적: 자식 클래스들이 공통으로 사용하는 기능
	
	// 추상메소드 (게시물과 관련된 기능)

	// 게시물 등록 메소드 (추상 메소드)
	int register(BoardDTO dto); // 1. 선언부
	
	// 게시물 목록조회 메소드
//	List<BoardDTO> getList();
	Page<BoardDTO> getList(int pageNumber);
	
	// 게시물 상세조회 메소드
	BoardDTO read(int no);
	
	// 게시물 수정 메소드
	void modify(BoardDTO dto);
	
	// 게시물 삭제 메소드
	int remove(int no);
	
	// dto를 엔티티로 변환하는 메소드 (일반메소드)
//	default Board dtoToEntity(BoardDTO dto) { // 1. 선언부
//		
//		// 구현부
//		Board entity = Board.builder()  
//							.no(dto.getNo())
//							.title(dto.getTitle())
//							.content(dto.getContent())
//							.writer(dto.getWriter())
//							.build();
//		
//		return entity;
//		
//	}
	
		// 엔티티를 dto로 변환하는 메소드
		// 매개변수: 엔티티, 리턴타입: DTO
//		default BoardDTO entityToDto(Board entity) { 
//		
//		BoardDTO dto = BoardDTO.builder()  
//							.no(entity.getNo())
//							.title(entity.getTitle())
//							.content(entity.getContent())
//							.writer(entity.getWriter())
//							.regDate(entity.getRegDate())
//							.modDate(entity.getModDate())
//							.build();
//		
//		return dto;
//	}
	
	// 엔티티를 dto로 변환하는 메소드
	default Board dtoToEntity(BoardDTO dto) { 
		
		// Member 엔티티 객체 생성
		Member member = Member.builder()
							  .id(dto.getWriter())
							  .build();
		
		Board entity = Board.builder()  
							.no(dto.getNo())
							.title(dto.getTitle())
							.content(dto.getContent())
							.writer(member)
							.build();
		
		return entity;
		
	}
	
		// 엔티티를 dto로 변환하는 메소드
		// 매개변수: 엔티티, 리턴타입: DTO
		default BoardDTO entityToDto(Board entity) { 
		
		BoardDTO dto = BoardDTO.builder()  
							.no(entity.getNo())
							.title(entity.getTitle())
							.content(entity.getContent())
							.writer(entity.getWriter().getId())
							.regDate(entity.getRegDate())
							.modDate(entity.getModDate())
							.build();
		
		return dto;
	}
	
}

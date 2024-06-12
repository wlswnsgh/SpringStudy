package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

@Service // @Service 어노테이션은 하나밖에 가지질 못한다.
public class BoardServicelmpl implements BoardService{

	@Autowired
	BoardRepository repository;
	
	@Override
	public int register(BoardDTO dto) {
		
		Board entity = dtoToEntity(dto); // dto -> entity 변환
		
		repository.save(entity); // 변환한 엔티티를 저장
		
		int newNo = entity.getNo();
		
		return newNo; // 새로운 글의 번호 반환
	
	}

	@Override
	public List<BoardDTO> getList() {

		List<Board> result = repository.findAll();
		
		List<BoardDTO> list = new ArrayList<>();
		
		list = result.stream()
					 .map(entity -> entityToDto(entity))
					 .collect(Collectors.toList());
		
		return list; // DTO 리스트 변환
	}

	@Override
	public BoardDTO read(int no) {
		
		Optional<Board> result = repository.findById(no);
		
		if (result.isPresent()) {
			Board board = result.get();
			BoardDTO boardDTO = entityToDto(board);
			return boardDTO;
		} else {
			return null;
		}
	}

	@Override
	public void modify(BoardDTO dto) {
		
		// 해당 게시물이 존재하는지 확인
		Optional<Board> result = repository.findById(dto.getNo());
		
		if(result.isPresent()) {
			
			// 제목과 내용만 변경
			Board entity = result.get();
			entity.setTitle(dto.getTitle());
			entity.setContent(dto.getContent());
			
			// 게시물 교체하기
			repository.save(entity);
		}
		
	}
	
}

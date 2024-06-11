package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
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

	
}
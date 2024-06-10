package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;

@Service // @Service 어노테이션은 하나밖에 가지질 못한다.
public class BoardServicelmpl implements BoardService{

	@Override
	public int register(BoardDTO dto) {
		return 0;
	}
	
}

package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public Page<BoardDTO> getList(int pageNumber) {
		
		// 1. 이 코드는 int자료형을 이용한 삼항 연산자이고 변수값은 pageNum이다.
		// 2. pageNumber인 매개변수가 0일때 값은 0이고 그렇지 않으면 사용자가 입력한 페이지에서 1를 빼준다.
		int pageNum = (pageNumber == 0) ? 0 :pageNumber - 1;
		
		// 1. Sort 객체를 이용해 정렬를 해준다.
		// 2. .by("no")는 데이터 모델에 필드를 정해준 것이다. (Board의 no를 말한 것이다.)
		
		// Sort sort = Sort.by("no").descending(); // 3. descending()는 정렬 방향을 내림차순으로 해준다.
		Sort sort = Sort.by("no").ascending(); // 3. .ascending()는 정렬 방향을 오름차순을 해준다.
		
		Pageable pageable = PageRequest.of(pageNum, 10, sort);
		
		Page<Board> entityPage = repository.findAll(pageable);
		
		Page<BoardDTO> dtoPage = entityPage
									.map( entity -> entityToDto(entity));
		
		return dtoPage;
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

	@Override
	public int remove(int no) {
		
		Optional<Board> result = repository.findById(no);
		
		if(result.isPresent()) { // .isPresent(): 메서드 값이 존재여부를 확인
			repository.deleteById(no);
			return 1; // 성공
		} else {
			return 0;
		}
	}
	
}

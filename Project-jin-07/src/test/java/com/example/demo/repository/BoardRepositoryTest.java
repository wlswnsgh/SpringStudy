package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

// 단위테스트 목적: 리파지토리가 가지고 있는 기능을 단독으로 테스트하기 위함
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	BoardRepository repository;
	
	@Test
	void 빈을가지고왔는지확인() {
		System.out.println("repository의 주소: " + repository);
	}
	
	@Test
	void 게시물등록() {
		
		//회원 엔티티 생성
		Member member = Member.builder().id("1").build();
		
		//회원테이블에 없는 아이디를 사용하면 에러남
		Board board = new Board(0,"4번글","내용입니다", member);
		repository.save(board);	

	}
	
	@Test
	void 게시물목록조회() {
		List<Board> list = repository.findAll();
		
		for(Board lt : list) {
			System.out.println(lt);
		}
		
	}
	
	@Test
	public void 여러게시물일괄등록() {
		
		//회원 엔티티 생성
		Member member = Member.builder().id("user1").build();
		
		//아이디 하나로 여러 게시물 등록
		List<Board> list = new ArrayList<>();
		
		//작성자는 현재 존재하는 사용자아이디를 사용해야함
		list.add(new Board(0,"1번글","내용입니다", member));
		list.add(new Board(0,"2번글","내용입니다", member));
		
		repository.saveAll(list);
	}

	@Test
	public void 게시물조회() {
		Optional<Board> optional = repository.findById(1);  //쿼리가 내부적으로 join 처리됨
		Board board = optional.get();
		System.out.println(board); //회원정보가 함께 출력됨
	}

	
}

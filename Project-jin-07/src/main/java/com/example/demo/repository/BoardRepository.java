package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	
	// 특정 회원이 작성한 모든 게시물을 삭제하는 메소드
	// @Modifying: 조회를 제외한 수정, 삭제 sql를 작성할때 사용
	
//	@Modifying
//	@Query("delete from Board b where b.writer = :member") // JPQL 문법
//	public void deletWriter(@Param("member") Member member);
	
	

}

package com.example.demo.Repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemberRepository;

@SpringBootTest
public class MemberRepositoryTest {
	
	
	MemberRepository repository = new MemberRepository();
	
	@Test
	public void 테스트() {
		
		//회원등록
		Member mem1 = new Member(1, "jin", "ho");
		Member mem2 = new Member(2, "jun", "jun");
		Member mem3 = new Member(3, "ho", "jin");
		repository.save(mem1);
		repository.save(mem2);
		repository.save(mem3);
		
		//1번째 회원 조회
		repository.findById(1);
		System.out.println(repository.findById(1));
		
		System.out.println();
		
		//학원 목록 조회
		List<Member> list = repository.findAll();
		for(Member lt : list) {
			System.out.println(lt);
		}
		
		//회원 전체 삭제
//		repository.clearStore();
	}
}

//package com.example.demo.repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.demo.entity.Member;
//
//@SpringBootTest
//public class MeberRepositoryTest {
//	
//	@Autowired
//	MemberRepository member;
//	
//	@Test
//	public void 회원등록() {
//		
//		List<Member> list = new ArrayList<>();
//		
//		Member mem1 = new Member("1", "passwd1", "jin");
//		Member mem2 = new Member("2", "passwd2", "jun");
//		Member mem3 = new Member("3", "passwd3", "ho");
//		
//		list.add(mem1);
//		list.add(mem2);
//		list.add(mem3);
//		
//		member.saveAll(list);
//		
//	}
//	
//	
//	@Test
//	public void 회원목록조회() {
//		List<Member> list = member.findAll();
//		
//		for(Member member : list) {
//			System.out.println(member);
//		}
//	}
//	
//	@Test
//	public void 회원단건조회() {
//		Optional<Member> mem = member.findById("1");
//		
//		if(mem.isPresent()) {
//			Member ber = mem.get();
//			System.out.println(ber);
//		}
//	}
//	
//	@Test
//	public void 회원수정() {
//		Optional<Member> result = member.findById("1");
//		Member member2 = result.get();
//		
//		member2.setPassword("wls123");
//		member2.setName("wnsgh");
//		member2.getModDate();
//		member2.getRegDate();
//		
//		member.save(member2);
//	}
//	
//	@Test
//	public void 모든회원삭제() {
//		member.deleteById("1");
//	}
//	
//}

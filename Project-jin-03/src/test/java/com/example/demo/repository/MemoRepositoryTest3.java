package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;
// 컨테이너 임시 환영
@SpringBootTest
public class MemoRepositoryTest3 {
	
	@Autowired // 객체 꺼내오기
	MemoRepository3 memoRepository3;
	
	@Test // 단원 테스트
	public void 번호가3보다작은_메모검색() {
		
		List<Memo> list = memoRepository3.get1(10);
		
		for (Memo ls : list) {
			System.out.println(ls);
		}
	}
	
	@Test // 단원 테스트
	public void 번호가10와20사이인_메모검색() {
		
		List<Memo> list = memoRepository3.get3(10, 20);
		
		for (Memo ls : list) {
			System.out.println(ls);
		}
	}
		
	@Test
	public void 번호를기준으로역정렬한_메모검색() {
		
		List<Memo> list = memoRepository3.get4();
		
		for(Memo memo: list) {
			System.out.println(memo);
		}
	}
	
}
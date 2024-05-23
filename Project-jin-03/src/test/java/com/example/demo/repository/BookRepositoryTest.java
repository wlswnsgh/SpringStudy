package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest
public class BookRepositoryTest {
	
	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void 책리피지토리객체가져왔는지확인() {
		System.out.println("bookRepository = " + bookRepository);
	}
	
	@Test
	public void 책데이터등록() {
		Book b1 = new Book(1, 20000, "한빚출판사", "자바스프링입문");
		Book b2 = new Book(2, 25000, "남가람북스", "스프링부트프로젝트");
		Book b3 = new Book(3, 40000, "남가람북스", "실무로 끝내는 PHP");
		Book b4 = new Book(4, 35000, "이지스퍼블리싱", "알고리즘코딩테스트");
		
		bookRepository.save(b1);
		bookRepository.save(b2);
		bookRepository.save(b3);
		bookRepository.save(b4);
		
	}
	
	
}

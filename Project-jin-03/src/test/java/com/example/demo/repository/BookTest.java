package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest
public class BookTest {
	
	@Autowired
	BookRepository book;
	
	@Test
	public void 자바프로그래밍입문() {
		
		List<Book> list = book.get1("자바스프링입문");
		
		for(Book ls : list) {
			System.out.println(ls);
		}
	}
	
	@Test
	public void 삼만원이상이고출판사가남가람북스() {
		
		List<Book> list = book.get2("남가람북스", 30000);
		
		for(Book ls : list) {
			System.out.println(ls);
		}
	}
	
	@Test
	public void 출판사_한빛출판사_또는_이지스퍼블리싱() {
		
		List<Book> list = book.get3("한빚출판사", "이지스퍼블리싱");
		
		for(Book ls : list) {
			System.out.println(ls);
		}
	}
	
	
	
	
}

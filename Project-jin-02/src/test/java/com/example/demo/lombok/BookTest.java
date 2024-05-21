package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTest {
	
	@Test
	void 책테스트() {
		
		Book book1 = new Book();
		book1.set가격(12000);
		book1.set제목("안내견 탄실이");
		book1.set출판사("홍길동");
		book1.set페이지수(325);
		
		System.out.println(book1.get제목());
		System.out.println(book1.get출판사());
		System.out.println(book1.get페이지수());
		System.out.println(book1.get가격());
		
		Book book2 = new Book("안내견 탄실이", 12000, "홍길동", 325);
		System.out.println(book2.toString());
		
		Book book3 = Book.builder()
			    .가격(13000)
			    .제목("처세술")
			    .출판사("홍길동")
			    .페이지수(220)
			    .build();

		System.out.println(book3.toString());
	}
}

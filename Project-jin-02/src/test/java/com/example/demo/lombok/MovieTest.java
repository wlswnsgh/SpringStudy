package com.example.demo.lombok;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieTest {

	@Test 
	void 영화테스트() {
		
		Movie movie1 = new Movie();
		movie1.set제목("기생충");
		movie1.set감독("봉준호");
		movie1.set개봉일(LocalDate.of(2023,02,02));
		
		System.out.println(movie1.get제목());
		System.out.println(movie1.get감독());
		System.out.println(movie1.get개봉일());
		
		Movie movie2 = new Movie("날씨의 아이", "센카이 마코토", LocalDate.of(2020,01,01));
		System.out.println(movie2.toString());
		
		Movie movie3 = Movie.builder()
							.제목("너의 이름은")
							.감독("센카이 마코토")
							.개봉일(LocalDate.of(2020,01,01))
							.build();
		System.out.println(movie3.toString());
		
	}
	
}

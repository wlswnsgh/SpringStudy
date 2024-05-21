package com.example.demo.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor 
@Builder
public class Book {
	
		String 제목;
		int 가격;
		String 출판사;
		int 페이지수;
}

package com.example.demo.lombok;

import java.time.LocalDate;

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

public class Movie {
	String 제목;
	String 감독;
	LocalDate 개봉일;
}

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
@NoArgsConstructor // 생성자
@AllArgsConstructor // 생성자
@Builder // 생성자

public class Student {
	
	int 학번;
	String 이름;
	int 나이;
}

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

public class Car {
	
	String 모델명;
	String 제조사;
	String 색;
}

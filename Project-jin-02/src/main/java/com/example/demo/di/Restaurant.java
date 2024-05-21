package com.example.demo.di;

import org.springframework.beans.factory.annotation.Autowired;


public class Restaurant {
	// 1. 직접 필요한 객체를 생성하는 방식
	Chef chef1 = new Chef();
	
	// 2. 필요한 객체를 컨테이너에서 꺼내서 사용하는 방식 (의존성주입)
	@Autowired
	Chef chef2;
	
	public Chef getChef() {
		return chef2;
	}
}

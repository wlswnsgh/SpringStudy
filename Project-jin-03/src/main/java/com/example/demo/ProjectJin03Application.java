package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// JSA의 리스너 기능을 활성화
// 데이터가 생성 및 수정되는 것을 추적
@EnableJpaAuditing
@SpringBootApplication
public class ProjectJin03Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectJin03Application.class, args);
	}

}

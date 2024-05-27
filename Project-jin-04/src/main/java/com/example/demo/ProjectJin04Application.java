package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 서블릿 자동 등록하기
@SpringBootApplication
public class ProjectJin04Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectJin04Application.class, args);
	}

}

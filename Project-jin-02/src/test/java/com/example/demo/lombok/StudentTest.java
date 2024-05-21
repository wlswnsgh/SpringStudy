package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {

	@Test
	void 학생테스트() {
		
		Student std1 = new Student();
		std1.set이름("진준호");
		std1.set학번(21);
		std1.set나이(24);

		Student std2 = new Student(22, "홍길동", 26);
		System.out.println(std2.toString());

		Student std3 = Student.builder()
							  .이름("김길동")
							  .학번(23)
							  .나이(27)
							  .build();
		System.out.println(std3.toString());
		
	}
}

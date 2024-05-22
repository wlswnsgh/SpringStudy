package com.example.demo.Optionals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OptionalTest {
	
	// Optional: 값을 감싸고 있는 Wrapper 클래스
	// 객체에 값이 있는지 없는지를 확인하기 위해 사용
	
	@Test
	void Optional사용하기() {
		
		String str = "apple";
		Optional<String> opt = Optional.of(str);
		
		System.out.println("Optional에서 값 꺼내기: " + opt.get());
		System.out.println("Optional 안에 값이 없는지? " + opt.isEmpty());
		System.out.println("Optional 안에 값이 있는지?" + opt.isPresent());
		
		// Optional에 값이 없으면, 바나나로 대체
		String str2 = null;
		System.out.println(Optional.ofNullable(str2).orElse("banana"));
	}
	
	 @Test
	void of와ofNullable의차이() {
		
		// of: Optional을 생성하는 함수. null 입력 불가
		// ofNullable: Optional을 생성하는 함수. null 입력 가능
		
		String str = null;
		
//		Optional<String> opt1 = Optional.of(str);
//		Optional<String> opt2 = Optional.ofNullable(str);
		
	}
	
	// if를사용하여null값체크하기
	 @Test
	void if를사용하여null값체크하기() {
		String str = "banana";
		if(str != null) {
			System.out.println("값이 존재합니다.");
		}
	}
	
	 @Test
	void optinal를사용하여null값체크하기() {
		String str = "banana";
		Optional<String> opt = Optional.ofNullable(str);
		opt.ifPresent(name -> System.out.println("값이 존재합니다." + name)); // 람다식 사용
		//위의 if null 체크 방식을 더 간결하게 표현할 수 있다
	}
	
}

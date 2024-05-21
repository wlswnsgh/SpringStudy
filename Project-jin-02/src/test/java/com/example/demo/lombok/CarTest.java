package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarTest {
	
	@Test 
	void 차테스트() {
		
		Car car1 = new Car();
		car1.set제조사("기아");
		car1.set모델명("MS-000");
		car1.set색("Blue");
		
		System.out.println(car1.get제조사());
		System.out.println(car1.get모델명());
		System.out.println(car1.get색());
		
		Car car2 = new Car("현대", "MS-111", "Red");
		System.out.println(car2.toString());
		
		Car car3 = Car.builder()
				      .제조사("BMW")
				      .모델명("MS-222")
				      .색("green")
				      .build();
		
		System.out.println(car3.toString());
	}
}

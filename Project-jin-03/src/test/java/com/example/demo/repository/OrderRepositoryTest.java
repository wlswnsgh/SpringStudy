package com.example.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class OrderRepositoryTest {
	
	@Autowired
	OrderRepository orderRepositorys;
	
	@Test
	public void 주문리피지토리객체생성() {
		System.out.println("orderRepository = " + orderRepositorys);
	}
	
	@Test
	public void 주문데이터생성() {
		List<Order> list = new ArrayList<>();
		
		//of함수: 생성자 대신 LocalDate의 객체를 생성하는 함수
		LocalDate date1 = LocalDate.of(2023, 7, 1);
		LocalDate date2 = LocalDate.of(2023, 7, 2);
		LocalDate date3 = LocalDate.of(2023, 7, 3);
		
		Order or1 = new Order(1, "둘리", date1, "인천 구월동");
		Order or2 = new Order(2, "또치", date2, "인천 연수동");
		Order or3 = new Order(3, "도우너", date3, "부산 동래동");
		
		list.add(or1);
		list.add(or2);
		list.add(or3);
		
		orderRepositorys.saveAll(list);
		
	}
	
}

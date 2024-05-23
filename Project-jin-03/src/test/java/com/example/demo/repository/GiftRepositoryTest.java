package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;

@SpringBootTest
public class GiftRepositoryTest {
	
	@Autowired
	GiftRepository giftRepository;
	
	@Test
	public void 선물리피지토리객첵가져왔는지확인() {
		System.out.println("giftRepository = " + giftRepository);
	}
	
	@Test
	public void 선물데이터등록() {
		Gift gf1 = new Gift(1, "참치세트", 10000, "식품");
		Gift gf2 = new Gift(2, "햄세트", 20000, "식품");
		Gift gf3 = new Gift(3, "샴푸세트", 30000, "생활용품");
		Gift gf4 = new Gift(4, "세차용품", 40000, "생활용품");
		Gift gf5 = new Gift(5, "주방용품", 50000, "생활용품");
		Gift gf6 = new Gift(6, "노트북", 60000, "가전제품");
		Gift gf7 = new Gift(7, "벽걸이TV", 70000, "가전제품");
		
		giftRepository.save(gf1);
		giftRepository.save(gf2);
		giftRepository.save(gf3);
		giftRepository.save(gf4);
		giftRepository.save(gf5);
		giftRepository.save(gf6);
		giftRepository.save(gf7);
	}
}

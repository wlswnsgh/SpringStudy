package com.example.demo.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "book") // book 테이블을 생성
@EntityListeners(AuditingEntityListener.class)

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int book_No;
	
	@Column(length = 11)
	int price;
	
	@Column(length = 100)
	String publisher;
	
	@Column(length = 30, nullable = false)
	String title;
	
	
}

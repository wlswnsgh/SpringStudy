package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "a_rder")
@EntityListeners(AuditingEntityListener.class)

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11)
	int oder_no;
	
	@Column(length = 30)
	String customer_name;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = true)
	LocalDate order_date;
	
	@Column(length = 100)
	String ship_address;
	
}
